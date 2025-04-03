package us.dot.its.jpo.asn.runtime.serialization;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.NumericNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser;
import us.dot.its.jpo.asn.runtime.types.Asn1Integer;

import java.io.IOException;
import java.lang.reflect.Constructor;

public final class IntegerDeserializer<T extends Asn1Integer> extends StdDeserializer<T> {
    private final Class<T> thisClass;

    public IntegerDeserializer(Class<T> vc) {
        super(vc);
        this.thisClass = vc;
    }

    @Override
    public T deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        long value;
        T instance;
        try {
            // Get the default constructor for the class
            Constructor<T> constructor = thisClass.getDeclaredConstructor();
            constructor.setAccessible(true);
            instance = constructor.newInstance();
        } catch (Exception e) {
            throw new IOException("Failed to create instance of " + thisClass.getName(), e);
        }

        if (jsonParser instanceof FromXmlParser xmlParser) {
            TreeNode node = xmlParser.getCodec().readTree(xmlParser);
            if (node instanceof NumericNode numNode) {
                value = numNode.longValue();
            } else if (node instanceof TextNode textNode) {
                // Sometimes happens, since XML values are ambiguous between text and numbers
                String textValue = textNode.textValue();
                value = Long.parseLong(textValue);
            } else {
                throw new IOException("Unable to parse integer value from XML");
            }
        } else {
            value = jsonParser.readValueAs(Long.class);
        }

        instance.setValue(value);
        return instance;
    }
}
