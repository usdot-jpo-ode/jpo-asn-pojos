package asn2pojo.runtime.serialization;

import asn2pojo.runtime.types.Asn1Type;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.util.NameTransformer;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser;

import java.io.IOException;

import static asn2pojo.runtime.utils.XmlUtils.*;

/**
 * See description in {@link OpenTypeSerializer}
 * @author Ivan Yourshaw
 */
public abstract class OpenTypeDeserializer<T extends Asn1Type> extends StdDeserializer<T> {

    protected final Class<T> thisClass;
    protected final String wrapped;

    protected OpenTypeDeserializer(Class<T> vc, String wrapped) {
        super(vc);
        thisClass = vc;
        this.wrapped = wrapped;
    }


    @Override
    public T deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        T result = null;
        System.out.println("deserialize open type");
        if (jsonParser instanceof FromXmlParser xmlParser) {
            // XML: Unwrap
            System.out.println("deserialize open type: xml");
            XmlMapper xmlMapper = (XmlMapper)xmlParser.getCodec();
            TreeNode node = xmlParser.getCodec().readTree(xmlParser);
            String xml = xmlMapper.writeValueAsString(node);
            var tokens = tokenize(xml);
            var unwrapped = unwrap(tokens);
            result = xmlMapper.readValue(stringifyTokens(unwrapped), thisClass);
        } else {
            // JSON:
            System.out.println("deserialize open type: json");
            TreeNode node = jsonParser.getCodec().readTree(jsonParser);
            if (node instanceof ObjectNode objectNode) {
                // Try unwrapping
                JsonNode innerNode = objectNode.findValue(wrapped);
                if (innerNode != null) {
                    System.out.printf("deserialize open type json unwrapped %s%n", wrapped);
                }
                JsonNode useNode = innerNode != null ? innerNode : objectNode;
                String json = SerializationUtil.jsonMapper().writeValueAsString(useNode);
                System.out.printf("deserialize open type: json value: %s%n", json);
                result = SerializationUtil.jsonMapper().readValue(json, thisClass);
            }
        }
        return result;
    }
}
