package asn2pojo.runtime.utils;

import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser;
import com.fasterxml.jackson.dataformat.xml.deser.XmlReadContext;
import java.io.IOException;
import java.util.Objects;
import lombok.Data;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class XmlUtils {

  /**
   * Remove the outermost element from an XML string.
   *
   * @param xml - Input xml string
   * @return The unwrapped xml
   * @throws IllegalArgumentException If the XML is not well-formed (i.e. if it doesn't have a
   *                                  single root element).
   */
  public static String unwrap(final String xml) {

    if (xml == null) {
      return null;
    }
    if (xml.isBlank()) {
      return "";
    }
    final String trimmed = xml.trim();

    // Remove the first element and matching last element

    // Get the first element
    final int startFirst = trimmed.indexOf('<') + 1;
    if (startFirst != 1) {
      throw notWellFormed(xml);
    }
    final int endFirst = trimmed.indexOf('>');
    if (endFirst <= 0) {
      throw notWellFormed(xml);
    }
    final String firstElement = trimmed.substring(startFirst, endFirst);
    log.trace("firstElement: {}", firstElement);

    // Get the last element
    final int startLast = trimmed.lastIndexOf("</") + 2;
    if (startLast < 2) {
      throw notWellFormed(xml);
    }
    final int endLast = trimmed.lastIndexOf('>');
    if (endLast != trimmed.length() - 1) {
      throw notWellFormed(xml);
    }
    final String lastElement = trimmed.substring(startLast, endLast);
    log.trace("lastElement: {}", lastElement);

    if (endFirst >= startLast) {
      throw notWellFormed(xml);
    }
    if (!firstElement.equals(lastElement)) {
      throw notWellFormed(xml);
    }

    final String unwrapped = trimmed.substring(endFirst + 1, startLast - 2);
    log.info("trace: {}", unwrapped);
    return unwrapped;
  }

  private static IllegalArgumentException notWellFormed(final String xml) {
    return new IllegalArgumentException(String.format("unwrap: XML is not well formed: %s", xml));
  }


  /**
   * Extract unwrapped items from the XML stream, in original order with duplicates
   *
   * @param xmlParser - The XML Parser from within a custom
   *                  {@link com.fasterxml.jackson.databind.deser.std.StdDeserializer#deserialize}
   *                  method.
   * @return List of XML strings
   * @throws IOException Parser exception
   */
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

  /**
   * Extract a single unwrapped xml item from the XML stream, preserving order of elements
   *
   * @param xmlParser - The XML Parser from within a custom
   *                  {@link com.fasterxml.jackson.databind.deser.std.StdDeserializer#deserialize}
   *                  method.
   * @return The reconstructed, unwrapped XML.
   * @throws IOException Parser exception
   */
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

  // Helper method for extracting an xml element from the XmlParser stream
  private static XmlElement extractXml(Formatter xml, FromXmlParser xmlParser,
      final XmlElement previous,
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
      if (pc.getNestingDepth() == startNesting && Objects.equals(pc.getCurrentName(), startName)) {
        element.setFinishedAll(true);
      } else if (pc.getNestingDepth() == startNesting + 1) {
        element.setFinishedItem(true);
      }
    }

    log.trace("current token: {} name: {} index: {}, nesting: {}",
        token, pc.getCurrentName(), pc.getCurrentIndex(), pc.getNestingDepth());

    return element;
  }


  // Helper class for extractXml method
  @Data
  private static class XmlElement {

    JsonToken token;
    String fieldName;
    boolean finishedAll;
    boolean finishedItem;
  }
}
