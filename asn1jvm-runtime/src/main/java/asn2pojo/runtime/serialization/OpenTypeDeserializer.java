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
        if (jsonParser instanceof FromXmlParser xmlParser) {
            // XML: Unwrap
            XmlMapper xmlMapper = (XmlMapper)xmlParser.getCodec();
            TreeNode node = xmlParser.getCodec().readTree(xmlParser);
            String xml = xmlMapper.writeValueAsString(node);
            var tokens = tokenize(xml);
            var unwrapped = unwrap(tokens);
            result = xmlMapper.readValue(stringifyTokens(unwrapped), thisClass);
        } else {
            // JSON: pass through
            result = jsonParser.getCodec().readValue(jsonParser, thisClass);
        }
        return result;
    }
}
