package asn2pojo.runtime.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider;
import lombok.SneakyThrows;
import asn2pojo.runtime.types.Asn1Choice;
import asn2pojo.runtime.types.Asn1SequenceOf;

import java.io.IOException;

import static asn2pojo.runtime.utils.XmlUtils.*;

/**
 * Serializer for SEQUENCE-OF CHOICE types.
 * These are unwrapped in XER, but wrapped in JER.
 * @param <S> The Asn1Choice type
 * @param <T> The Asn1SequenceOf type
 */
public class SequenceOfChoiceSerializer<S extends Asn1Choice, T extends Asn1SequenceOf<S>>
    extends StdSerializer<T> {

    protected final Class<S> choiceClass;
    protected final Class<T> sequenceOfClass;

    protected SequenceOfChoiceSerializer(Class<S> choiceClass, Class<T> sequenceOfClass) {
        super(sequenceOfClass);
        this.choiceClass = choiceClass;
        this.sequenceOfClass = sequenceOfClass;
    }

    @Override
    public void serialize(T sequenceOf, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (serializerProvider instanceof XmlSerializerProvider xmlProvider) {
            // XER: Choice items not wrapped
            var xmlGen = (ToXmlGenerator)jsonGenerator;
            var mapper = SerializationUtil.xmlMapper();

            for (S choiceItem : sequenceOf) {
                System.out.printf("SequenceOfChoiceSerializer: ChoiceClass: %s, SequenceOfClass: %s, choiceItem: %s%n", choiceClass.getName(), sequenceOfClass.getName(),
                    choiceItem);

                String choiceXml = mapper.writeValueAsString(choiceItem);

                String unwrappedXml = stringifyTokens(unwrap(tokenize(choiceXml)));
                xmlGen.writeRaw(unwrappedXml);
            }

        } else {
            // JER: Normal, choice items are wrapped
            jsonGenerator.writeObject(sequenceOf);
        }
    }


}
