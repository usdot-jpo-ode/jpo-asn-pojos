package asn2pojo.runtime.utils;

import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser;
import com.fasterxml.jackson.dataformat.xml.deser.XmlReadContext;
import java.io.IOException;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class XmlUtils {

    @SneakyThrows
    public static List<XmlToken> tokenize(String xml) {
        var factory = XMLInputFactory.newInstance();
        XMLStreamReader reader = factory.createXMLStreamReader(new StringReader(xml));
        return readTokens(reader);
    }

    public static List<XmlToken> readTokens(XMLStreamReader xmlReader) throws XMLStreamException {
        var tokens = new ArrayList<XmlToken>();
        var firstToken = addToken(xmlReader, tokens);
        while (xmlReader.hasNext()) {
            xmlReader.next();
            var thisToken = addToken(xmlReader, tokens);
            if (firstToken == null) {
                firstToken = thisToken;
            }
            if (thisToken != null && thisToken.isLast && thisToken.text.equals(firstToken.text)){
                break;
            }
        }
        return mergeEmptyElements(tokens);
    }


    private static XmlToken addToken(XMLStreamReader xmlReader, List<XmlToken> tokens) {
        XmlToken token = null;
        if (xmlReader.hasName()) {
            QName name = xmlReader.getName();
            if (xmlReader.isStartElement()) {
                token = new XmlToken(name.getLocalPart(), true, false);
                tokens.add(token);
            } else if (xmlReader.isEndElement()) {
                token = new XmlToken(name.getLocalPart(), false, true);
                tokens.add(token);
            }
        } else if (xmlReader.hasText() && !xmlReader.isWhiteSpace()) {
            token = new XmlToken(xmlReader.getText(), false, false);
            tokens.add(token);
        }
        return token;
    }

    // Merge adjacent elements with no text between into empty elements to
    // match the asn.1 style for enumerations and booleans.
    private static List<XmlToken> mergeEmptyElements(final List<XmlToken> xmlTokens) {
        final var mergedList = new ArrayList<XmlToken>();
        int i = 0;
        while (i < xmlTokens.size()) {
            XmlToken token1 = xmlTokens.get(i);
            if (i == xmlTokens.size() - 1) {
                mergedList.add(token1);
                break;
            }
            XmlToken token2 = xmlTokens.get(i + 1);
            if (token1.isFirst  && token2.isLast && token1.text.equals(token2.text)) {
                // Combine into empty element and skip 2
                mergedList.add(new XmlToken(token1.text, true, true));
                i += 2;
            } else {
                // Don't change
                mergedList.add(token1);
                i++;
            }
        }
        return mergedList;
    }

    public static String stringifyTokens(List<XmlToken> tokens) {
        var f = new Formatter();
        for (XmlToken token : tokens) {
            final String text = token.text;
            if (token.isFirst && token.isLast) {
                // Empty element
                f.format("<%s/>", text);
            } else if (token.isFirst) {
                // Start element
                f.format("<%s>", text);
            } else if (token.isLast) {
                // End element
                f.format("</%s>", text);
            } else {
                // Text value
                f.format(text);
            }
        }
        return f.toString();
    }


    public static List<XmlToken> unwrap(final List<XmlToken> tokens) {
        // Remove first and last
        if (tokens.size() > 2) {
            return tokens.subList(1, tokens.size() - 1);
        } else {
            return tokens;
        }
    }


    // Extract unwrapped items from the XML stream, in original order with duplicates
    public static List<String> extractXmlList(FromXmlParser xmlParser) throws IOException {
        Formatter xml = new Formatter();
        List<String> itemXmlList = new ArrayList<>();

        XmlReadContext pc = xmlParser.getParsingContext();
        XmlReadContext parent = pc.getParent();
        log.trace("extractXmlList: parent name {}, value: {}, index: {}, nesting: {}",
            parent.getCurrentName(),
            parent.getCurrentValue(), parent.getCurrentIndex(), parent.getNestingDepth());
        XmlElement element = new XmlElement();
        final int startNesting = parent.getNestingDepth();
        final String startName = parent.getCurrentName();

        while (!element.isFinishedAll()) {
            element = extractXml(xml, xmlParser, element, startNesting, startName);
            if (element.isFinishedItem()) {
                itemXmlList.add(xml.toString());
                xml = new Formatter();
            }
            if (!element.isFinishedAll()) {
                xmlParser.nextToken();
            }
        }
        return itemXmlList;
    }

    // Extract a single unwrapped xml item from the XML stream, preserving order of elements
    public static String extractXmlElement(FromXmlParser xmlParser) throws IOException {
        Formatter xml = new Formatter();
        XmlReadContext pc = xmlParser.getParsingContext();
        XmlReadContext parent = pc.getParent();
        log.debug("extractXmlElement: parent name {}, value: {}, index: {}, nesting: {}",
            parent.getCurrentName(),
            parent.getCurrentValue(), parent.getCurrentIndex(), parent.getNestingDepth());
        XmlElement element = new XmlElement();
        final int startNesting = parent.getNestingDepth();
        final String startName = parent.getCurrentName();
        while (!element.isFinishedItem()) {
            element = extractXml(xml, xmlParser, element, startNesting, startName);
            if (!element.isFinishedItem()) {
                xmlParser.nextToken();
            }
        }
        return xml.toString();
    }

    public static XmlElement extractXml(Formatter xml, FromXmlParser xmlParser, final XmlElement previous,
        final int startNesting, final String startName) throws IOException {
        XmlReadContext pc = xmlParser.getParsingContext();

        JsonToken token = xmlParser.getCurrentToken();
        XmlElement element = new XmlElement();
        element.setToken(token);

        if (token == JsonToken.START_OBJECT) {
            // Advance to field name
            token = xmlParser.nextToken();
            element.setToken(token);
        }

        if (token == JsonToken.FIELD_NAME && pc.getCurrentName() != null) {
            xml.format("<%s>", pc.getCurrentName());
            element.setFieldName(pc.getCurrentName());
        } else if (token == JsonToken.VALUE_STRING) {
            String val = xmlParser.getValueAsString();
            log.trace("Value String: {}", val);

            pc.setCurrentValue(val);
            xml.format("%s", val);
            // Wrap the value
            if (pc.getCurrentName() != null) {
                xml.format("</%s>", pc.getCurrentName());
            } else if (previous != null && previous.getFieldName() != null) {
                xml.format("</%s>", previous.getFieldName());
            }

            // For simple choice types there won't be an END_OBJECT
            if (pc.getNestingDepth() == startNesting + 1) {
                element.setFinishedItem(true);
            }
        } else if (token == JsonToken.END_OBJECT && pc.hasCurrentName()) {
            xml.format("</%s>", pc.getCurrentName());
            if ( pc.getNestingDepth() == startNesting && Objects.equals(pc.getCurrentName(), startName)) {
                element.setFinishedAll(true);
            } else if (pc.getNestingDepth() == startNesting + 1) {
                element.setFinishedItem(true);
            }
        }

        log.trace("current token: {} name: {} index: {}, nesting: {}",
            token, pc.getCurrentName(), pc.getCurrentIndex(), pc.getNestingDepth());

        return element;
    }

    @AllArgsConstructor
    @Data
    public static class XmlToken {
        String text;
        boolean isFirst;
        boolean isLast;
    }

    @Data
    public static class XmlElement {
        JsonToken token;
        String fieldName;
        boolean finishedAll;
        boolean finishedItem;
    }
}
