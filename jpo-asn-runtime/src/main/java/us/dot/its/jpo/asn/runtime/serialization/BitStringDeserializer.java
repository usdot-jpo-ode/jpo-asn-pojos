package us.dot.its.jpo.asn.runtime.serialization;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import us.dot.its.jpo.asn.runtime.types.Asn1Bitstring;

/**
 * Deserialize an ASN.1 Bitstring from XER or JER
 * @param <T> The bitstring type
 * @author Ivan Yourshaw
 */
public abstract class BitStringDeserializer<T extends Asn1Bitstring> extends StdDeserializer<T> {

    protected abstract T construct();

    protected final boolean humanReadableJson;

    protected BitStringDeserializer(Class<?> valueClass) {
        super(valueClass);
        this.humanReadableJson = false;
    }

    public BitStringDeserializer(Class<?> valueClass, boolean humanReadableJson) {
        super(valueClass);
        this.humanReadableJson = humanReadableJson;
    }

    @Override
    public T deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        T bitstring = construct();
        if (jsonParser.getCodec() instanceof XmlMapper) {
            // XML: binary
            String str = jsonParser.getText();
            bitstring.fromBinaryString(str);
        } else {
            if (humanReadableJson) {
                // ODE JSON dialect: read verbose map
                TypeReference<Map<String, Boolean>> boolMapType = new TypeReference<>() {};
                Map<String, Boolean> map = jsonParser.readValueAs(boolMapType);
                for (Entry<String, Boolean> keyValue : map.entrySet()) {
                    bitstring.set(keyValue.getKey(), keyValue.getValue());
                }
            } else {
                // JSON: hex
                String str = jsonParser.getText();
                bitstring.fromHexString(str);
            }
        }
        return bitstring;
    }

}
