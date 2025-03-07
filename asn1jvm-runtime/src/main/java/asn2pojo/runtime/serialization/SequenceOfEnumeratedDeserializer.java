package asn2pojo.runtime.serialization;

import asn2pojo.runtime.types.Asn1Enumerated;
import asn2pojo.runtime.types.Asn1SequenceOf;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.xml.stream.XMLStreamReader;

public abstract class SequenceOfEnumeratedDeserializer<S extends Enum<?> & Asn1Enumerated, T extends Asn1SequenceOf<S>>
    extends StdDeserializer<T> {

    protected final Class<T> thisClass;
    protected final Class<S> enumClass;
    protected abstract S[] listEnumValues();
    protected abstract T construct();

    protected SequenceOfEnumeratedDeserializer(Class<T> sequenceOfEnumType, Class<S> enumType) {
        super(sequenceOfEnumType);
        this.thisClass = sequenceOfEnumType;
        this.enumClass = enumType;
    }

    @Override
    public T deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        T result = null;
        if (jsonParser instanceof FromXmlParser xmlParser) {



            // Unwrapped enum items
            result = construct();
            TreeNode node = xmlParser.getCodec().readTree(xmlParser);

            var fieldNameIterator = node.fieldNames();

            while (fieldNameIterator.hasNext()) {
                String name = fieldNameIterator.next();

                // Check for duplicates and preserve them
                // If the value of the node is an array, then the size of the array is
                // the number of repeats of the same enum value.
                // For example the node
                //
                // {"county-police-units":["",""],"hAZMAT-units":["",""],"private-contractor-response-units":""}
                //
                // has 2 repeats of the "county-police-units" and "hAZMAT-units"
                // The original XML which is inaccessible from here would have looked like:
                //
                // <responderType>
                //   <county-police-units/>
                //   <county-police-units/>
                //   <hAZMAT-units/>
                //   <hAZMAT-units/>
                //   <private-contractor-response-units/>
                // </responderType>
                //
                TreeNode valueNode = node.get(name);
                if (valueNode instanceof ArrayNode arrayValue) {
                    // There are repeats
                    int numRepeats = arrayValue.size();
                    for (int i = 0; i < numRepeats; i++) {
                        addEnumValue(result, name);
                    }
                } else {
                    // No repeats
                    addEnumValue(result, name);
                }
            }
        } else {
            result = jsonParser.getCodec().readValue(jsonParser, thisClass);
        }
        return result;
    }

    private void addEnumValue(T result, String name) {
        for (S enumValue : listEnumValues()) {
            if (Objects.equals(enumValue.getName(), name)) {
                result.add(enumValue);
            }
        }
    }
}
