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
import lombok.extern.slf4j.Slf4j;

import static asn2pojo.runtime.utils.XmlUtils.*;

/**
 * See description in {@link OpenTypeSerializer}
 * @author Ivan Yourshaw
 */
@Slf4j
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
        log.debug("deserialize open type");
        if (jsonParser instanceof FromXmlParser xmlParser) {
            // XML: Unwrap
            log.debug("deserialize open type: xml");
            XmlMapper xmlMapper = (XmlMapper)xmlParser.getCodec();
            String xml = extractXmlElement(xmlParser);
            log.debug("extracted xml: {}", xml);
            result = xmlMapper.readValue(xml, thisClass);
        } else {
            // JSON:
            log.debug("deserialize open type: json");
            TreeNode node = jsonParser.getCodec().readTree(jsonParser);
            if (node instanceof ObjectNode objectNode) {
                // Try unwrapping
                JsonNode innerNode = objectNode.findValue(wrapped);
                if (innerNode != null) {
                    log.debug("deserialize open type json unwrapped {}", wrapped);
                }
                JsonNode useNode = innerNode != null ? innerNode : objectNode;
                String json = SerializationUtil.jsonMapper().writeValueAsString(useNode);
                log.debug("deserialize open type: json value: {}", json);
                result = SerializationUtil.jsonMapper().readValue(json, thisClass);
            }
        }
        return result;
    }
}
