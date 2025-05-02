package us.dot.its.jpo.asn.runtime.serialization;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.fasterxml.jackson.databind.exc.ValueInstantiationException;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.extern.slf4j.Slf4j;
import us.dot.its.jpo.asn.runtime.types.Asn1Bitstring;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Deserialize an ASN.1 Bitstring from XER or JER
 * @param <T> The bitstring type
 * @author Ivan Yourshaw
 */
@SuppressWarnings({"unchecked"})
@Slf4j
public final class BitStringDeserializer<T extends Asn1Bitstring> extends StdDeserializer<T> implements ContextualDeserializer {

    private final Class<T> valueType;

    /**
     * Default constructor for Jackson deserialization.
     * Note: This constructor should not be used directly as Asn1Bitstring is abstract.
     * Jackson will use the contextual deserializer to get the correct concrete type.
     */
    public BitStringDeserializer() {
        super(Asn1Bitstring.class);
        this.valueType = (Class<T>) Asn1Bitstring.class;
    }

    public BitStringDeserializer(Class<T> valueType) {
        super(valueType);
        this.valueType = valueType;
    }

    private T construct(JsonParser jsonParser) throws ValueInstantiationException {
        if (valueType == Asn1Bitstring.class) {
                throw ValueInstantiationException.from(jsonParser,
                    "Cannot instantiate abstract class Asn1Bitstring directly. Use a concrete subclass instead.",
                    getValueType());
        }
        try {
            Constructor<T> constructor = valueType.getDeclaredConstructor();
            constructor.setAccessible(true);
            return constructor.newInstance();
        } catch (Exception e) {
            throw ValueInstantiationException.from(jsonParser,
                "Failed to create instance of " + valueType.getName(), getValueType(), e);
        }
    }

    @Override
    public JsonDeserializer<?> createContextual(DeserializationContext ctxt, BeanProperty property) {
        JavaType type;
        if (property != null) {
            type = property.getType();
        } else {
            type = ctxt.getContextualType();
        }
        if (type.isTypeOrSubTypeOf(Asn1Bitstring.class)) {
            return new BitStringDeserializer<>((Class<T>) type.getRawClass());
        }
        return this;
    }

    @Override
    public T deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        T bitstring = construct(jsonParser);
        if (jsonParser.getCodec() instanceof XmlMapper) {
            // XML: binary
            String str = jsonParser.getText();
            bitstring.fromBinaryString(str);
        } else {
            deserializeFromJson(bitstring, jsonParser);
        }
        return bitstring;
    }

    private void deserializeFromJson(T bitstring, JsonParser jsonParser) throws IOException {
        if (jsonParser.getCodec() instanceof OdeCustomJsonMapper customMapper && customMapper.isHumanReadableJsonBitstrings()) {
            deserializeFromJsonMap(bitstring, jsonParser);
        } else {
            deserializeFromJer(bitstring, jsonParser);
        }
    }

    private void deserializeFromJsonMap(T bitstring, JsonParser jsonParser) throws IOException {
        // ODE JSON dialect: read verbose map
        TypeReference<Map<String, Boolean>> boolMapType = new TypeReference<>() {};
        Map<String, Boolean> map = jsonParser.readValueAs(boolMapType);
        for (Entry<String, Boolean> keyValue : map.entrySet()) {
            bitstring.set(keyValue.getKey(), keyValue.getValue());
        }
    }

    private void deserializeFromJer(T bitstring, JsonParser jsonParser) throws IOException {
        // JER is hex encoded
        // The bitstring may be encoded as a simple hex string if it is fixed length, or if
        // variable length it may be encoded as:
        // {
        //   "value": "0800",
        //   "length": 9
        // }
        // Check for both.
        TreeNode node = jsonParser.getCodec().readTree(jsonParser);
        if (node instanceof ObjectNode objectNode) {
            log.trace("Bitstring encoded as objectNode {}", objectNode);
            if (objectNode.has("value") && objectNode.has("length")) {
                String hexValue = objectNode.get("value").asText();
                int bitLength = objectNode.get("length").asInt();
                bitstring.fromHexString(hexValue, bitLength);
            } else {
                throw MismatchedInputException.from(jsonParser, getValueType(),
                    String.format("Object node missing 'value' or 'length' field in JSON encoding for bitstring: %s",
                        objectNode));
            }
        } else if (node instanceof TextNode textNode) {
            log.trace("Bitstring encoded as textNode {}", textNode);
            bitstring.fromHexString(textNode.asText());
        }
    }

}
