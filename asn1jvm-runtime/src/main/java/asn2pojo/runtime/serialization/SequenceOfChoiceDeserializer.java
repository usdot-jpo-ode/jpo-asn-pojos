package asn2pojo.runtime.serialization;

import static asn2pojo.runtime.utils.XmlUtils.extractXml;

import asn2pojo.runtime.utils.XmlUtils.XmlElement;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser;
import com.fasterxml.jackson.dataformat.xml.deser.XmlReadContext;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import asn2pojo.runtime.types.Asn1Choice;
import asn2pojo.runtime.types.Asn1SequenceOf;

import java.io.IOException;
import lombok.extern.slf4j.Slf4j;


/**
 * Deserializer for SEQUENCE-OF CHOICE types.
 * These are unwrapped in XER, but wrapped in JER.
 * @param <S> The Asn1Choice type
 * @param <T> The Asn1SequenceOf type
 */
@Slf4j
public abstract class SequenceOfChoiceDeserializer<S extends Asn1Choice, T extends Asn1SequenceOf<S>>
    extends StdDeserializer<T> {

    protected final Class<S> choiceClass;
    protected final Class<T> sequenceOfClass;

    protected abstract T construct();

    protected SequenceOfChoiceDeserializer(Class<S> choiceClass, Class<T> sequenceOfClass) {
        super(sequenceOfClass);
        this.choiceClass = choiceClass;
        this.sequenceOfClass = sequenceOfClass;
    }


    @Override
    public T deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException, JacksonException {
        T result = construct();
        if (jsonParser instanceof FromXmlParser xmlParser) {

            // XML: expects unwrapped choice items.
            // We need to do all this because simple xmlMapper.readTree doesn't preserve the
            // original order of sequence items.
            XmlMapper xmlMapper = (XmlMapper)xmlParser.getCodec();

            Formatter xml = new Formatter();
            List<String> choiceXmlList = new ArrayList<>();

            XmlReadContext pc = xmlParser.getParsingContext();
            XmlReadContext parent = pc.getParent();
            log.trace("parent name {}, value: {}, index: {}, nesting: {}", parent.getCurrentName(),
                parent.getCurrentValue(), parent.getCurrentIndex(), parent.getNestingDepth());

            XmlElement element = new XmlElement();
            final int startNesting = parent.getNestingDepth();
            final String startName = parent.getCurrentName();

            // Extract the unwrapped choice items from the XML stream, in original order
            while (!element.isFinishedAll()) {
                element = extractXml(xml, xmlParser, element, startNesting, startName);
                if (element.isFinishedChoice()) {
                    choiceXmlList.add(xml.toString());
                    xml = new Formatter();
                }
                if (!element.isFinishedAll()) {
                    xmlParser.nextToken();
                }
            }

            // Wrap and deserialize each choice item
            for (String choiceXml : choiceXmlList) {
                log.trace("SequenceOfChoiceDeserializer: choiceXml: {}", choiceXml);
                var wrapped = String.format("<%s>%s</%s>", choiceClass.getSimpleName(), choiceXml,
                    choiceClass.getSimpleName());
                S choice = xmlMapper.readValue(wrapped, choiceClass);
                result.add(choice);
            }
        } else {
            // JSON is easier! It expects wrapped choice items, pass through as normal
            result = jsonParser.getCodec().readValue(jsonParser, sequenceOfClass);
        }
        return result;
    }



}
