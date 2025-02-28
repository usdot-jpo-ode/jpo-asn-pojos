package asn2pojo.runtime.serialization;

import asn2pojo.runtime.annotations.Asn1ParameterizedTypes;
import asn2pojo.runtime.types.Asn1Sequence;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser;
import java.io.IOException;

import static asn2pojo.runtime.annotations.Asn1ParameterizedTypes.IdType.INTEGER;
import static asn2pojo.runtime.utils.XmlUtils.tokenize;

/**
 * Deserialize a parameterized SEQUENCE type.
 * Determines the subtype to deserialize to using the {@link Asn1ParameterizedTypes} annotation that
 * must be present.
 *
 * @param <T> The Sequence Type
 *
 * @author Ivan Yourshaw
 */
@SuppressWarnings({"unchecked", "rawtypes"})
public abstract class ParameterizedTypeDeserializer<T extends Asn1Sequence> extends StdDeserializer<T> {

    protected final Class<T> thisClass;

    protected ParameterizedTypeDeserializer(Class<T> vc) {
        super(vc);
        thisClass = vc;
    }

    @Override
    public T deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        final var typeAnnot = thisClass.getAnnotation(Asn1ParameterizedTypes.class);
        if (typeAnnot == null) {
            throw new RuntimeException("Missing Asn1ParameterizedTypes annotation.");
        }
        final String idPropName = typeAnnot.idProperty();
        System.out.printf("idPropName: %s%n", idPropName);
        final Asn1ParameterizedTypes.IdType idType = typeAnnot.idType();
        System.out.printf("idType: %s%n", idType);
        final Asn1ParameterizedTypes.Type[] types = typeAnnot.value();
        if (types == null || types.length == 0) {
            throw new RuntimeException("No Types are defined in the Asn1ParameterizedTypes annotation.");
        } else {
            for (var t : types) {
                System.out.printf("type: %s%n", t);
            }
        }
        if (jsonParser instanceof FromXmlParser xmlParser) {
            // XER
            XmlMapper xmlMapper = (XmlMapper)xmlParser.getCodec();
            TreeNode node = xmlMapper.readTree(xmlParser);

            if (node instanceof ObjectNode objectNode) {
                System.out.printf("ObjectNode: %s%n", objectNode);
                JsonNode idPropNode = objectNode.findValue(idPropName);
                String xml = xmlMapper.writeValueAsString(node);
                System.out.printf("node xml: %s%n", xml);
                if (idPropNode == null) {
                    throw new RuntimeException("idPropNode is null");
                }
                final Object id = (idType == INTEGER) ? idPropNode.asInt() : idPropNode.asText();
                System.out.printf("id: %s%n", id);
                Class<?> subType = getSubtypeForId(id, idType, types);
                System.out.printf("subtype: %s%n", subType.getName());
                return (T)SerializationUtil.xmlMapper().readValue(xml, subType);
            } else {
                throw new RuntimeException("Not instance of object");
            }
        } else {
            // JER
            TreeNode node = jsonParser.getCodec().readTree(jsonParser);
            if (node instanceof ObjectNode objectNode) {
                System.out.printf("ObjectNode: %s%n", objectNode);
                JsonNode idPropNode = objectNode.findValue(idPropName);
                String json = SerializationUtil.jsonMapper().writeValueAsString(objectNode);
                System.out.printf("node json: %s%n", json);
                if (idPropNode == null) {
                    throw new RuntimeException("idPropNode is null");
                }
                final Object id = (idType == INTEGER) ? idPropNode.asInt() : idPropNode.asText();
                System.out.printf("id: %s%n", id);
                Class<?> subType = getSubtypeForId(id, idType, types);
                System.out.printf("subtype: %s%n", subType.getName());
                T deserializedItem = (T)SerializationUtil.jsonMapper().readValue(json, subType);
                System.out.printf("deserializedItem: %s%n", deserializedItem);
                return deserializedItem;
            } else {
                throw new RuntimeException("Not instance of object");
            }
        }
    }

    private Class<?> getSubtypeForId(final Object id, Asn1ParameterizedTypes.IdType idType, Asn1ParameterizedTypes.Type[] types) {
        for (var theType : types) {
            Object idValue = (idType == INTEGER) ? theType.intId() : theType.stringId();
            if (id.equals(idValue)) {
                return theType.value();
            }
        }
        throw new RuntimeException(String.format("Id %s not found in list of types", id));
    }
}
