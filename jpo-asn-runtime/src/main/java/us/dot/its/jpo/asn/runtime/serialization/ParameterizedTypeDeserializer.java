package us.dot.its.jpo.asn.runtime.serialization;

import static us.dot.its.jpo.asn.runtime.annotations.Asn1ParameterizedTypes.IdType.INTEGER;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import com.fasterxml.jackson.databind.exc.InvalidTypeIdException;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import us.dot.its.jpo.asn.runtime.annotations.Asn1ParameterizedTypes;
import us.dot.its.jpo.asn.runtime.types.Asn1Sequence;


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
@Slf4j
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
            // Jackson's InvalidDefinitionException seems appropriate for missing annotations
            // Ref. https://javadoc.io/static/com.fasterxml.jackson.core/jackson-databind/2.18.3/com/fasterxml/jackson/databind/exc/InvalidDefinitionException.html
            throw InvalidDefinitionException.from(jsonParser, "Missing Asn1ParameterizedTypes annotation.", getValueType());
        }
        final String idPropName = typeAnnot.idProperty();
        log.trace("idPropName: {}", idPropName);
        final Asn1ParameterizedTypes.IdType idType = typeAnnot.idType();
        log.trace("idType: {}", idType);
        final Asn1ParameterizedTypes.Type[] types = typeAnnot.value();
        if (types == null || types.length == 0) {
            throw InvalidDefinitionException.from(jsonParser, "No Types are defined in the Asn1ParameterizedTypes annotation.", getValueType());
        } else {
            for (var t : types) {
                log.trace("type: {}", t);
            }
        }
        if (jsonParser instanceof FromXmlParser xmlParser) {
            // XER
            XmlMapper xmlMapper = (XmlMapper)xmlParser.getCodec();
            TreeNode node = xmlMapper.readTree(xmlParser);

            if (node instanceof ObjectNode objectNode) {
                log.trace("ObjectNode: {}", objectNode);
                JsonNode idPropNode = objectNode.findValue(idPropName);
                String xml = xmlMapper.writeValueAsString(node);
                log.trace("node xml: {}", xml);
                if (idPropNode == null) {
                    // Ref. https://javadoc.io/static/com.fasterxml.jackson.core/jackson-databind/2.18.3/com/fasterxml/jackson/databind/exc/InvalidTypeIdException.html
                    throw InvalidTypeIdException.from(jsonParser, "idPropNode is null", getValueType(), "");
                }
                final Object id = (idType == INTEGER) ? idPropNode.asInt() : idPropNode.asText();
                log.trace("id: {}", id);
                Class<?> subType = getSubtypeForId(id, idType, types, jsonParser);
                log.trace("subtype: {}", subType.getName());
                return (T)SerializationUtil.xmlMapper().readValue(xml, subType);
            } else {
                // Ref. https://javadoc.io/static/com.fasterxml.jackson.core/jackson-databind/2.18.3/com/fasterxml/jackson/databind/exc/MismatchedInputException.html
                throw MismatchedInputException.from(jsonParser, thisClass, "Not instance of object");
            }
        } else {
            // JER
            TreeNode node = jsonParser.getCodec().readTree(jsonParser);
            if (node instanceof ObjectNode objectNode) {
                log.trace("ObjectNode: {}", objectNode);
                JsonNode idPropNode = objectNode.findValue(idPropName);
                String json = SerializationUtil.jsonMapper().writeValueAsString(objectNode);
                log.trace("node json: {}", json);
                if (idPropNode == null) {
                    throw InvalidTypeIdException.from(jsonParser, "idPropNode is null", getValueType(), "");
                }
                final Object id = (idType == INTEGER) ? idPropNode.asInt() : idPropNode.asText();
                log.trace("id: {}", id);
                Class<?> subType = getSubtypeForId(id, idType, types, jsonParser);
                log.trace("subtype: {}", subType.getName());
                T deserializedItem = (T)SerializationUtil.jsonMapper().readValue(json, subType);
                log.trace("deserializedItem: {}", deserializedItem);
                return deserializedItem;
            } else {
                throw MismatchedInputException.from(jsonParser, thisClass, "Not instance of object");
            }
        }
    }

    private Class<?> getSubtypeForId(final Object id, Asn1ParameterizedTypes.IdType idType, Asn1ParameterizedTypes.Type[] types, JsonParser jsonParser)
        throws InvalidDefinitionException {
        for (var theType : types) {
            Object idValue = (idType == INTEGER) ? theType.intId() : theType.stringId();
            if (id.equals(idValue)) {
                return theType.value();
            }
        }
        throw InvalidDefinitionException.from(jsonParser, String.format("Id %s not found in list of types", id), getValueType());
    }
}
