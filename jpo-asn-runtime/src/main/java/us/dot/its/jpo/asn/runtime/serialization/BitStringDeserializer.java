package us.dot.its.jpo.asn.runtime.serialization;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import lombok.extern.slf4j.Slf4j;
import us.dot.its.jpo.asn.runtime.types.Asn1Bitstring;

/**
 * Deserialize an ASN.1 Bitstring from XER or JER
 * @param <T> The bitstring type
 * @author Ivan Yourshaw
 */
@Slf4j
public abstract class BitStringDeserializer<T extends Asn1Bitstring> extends StdDeserializer<T> {

    protected abstract T construct();

    protected BitStringDeserializer(Class<?> valueClass) {
        super(valueClass);
    }

    @Override
    public T deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        T bitstring = construct();
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
