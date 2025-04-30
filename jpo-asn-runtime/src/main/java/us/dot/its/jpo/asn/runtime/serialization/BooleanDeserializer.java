package us.dot.its.jpo.asn.runtime.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import us.dot.its.jpo.asn.runtime.types.Asn1Boolean;

import java.io.IOException;
import java.lang.reflect.Constructor;

@SuppressWarnings({"unchecked"})
public final class BooleanDeserializer<T extends Asn1Boolean> extends StdDeserializer<T> implements ContextualDeserializer {

    private final Class<T> valueType;

    public BooleanDeserializer() {
        super(Asn1Boolean.class);
        this.valueType = (Class<T>) Asn1Boolean.class;
    }

    public BooleanDeserializer(Class<T> valueType) {
        super(valueType);
        this.valueType = valueType;
    }

    private T construct() {
        try {
            if (valueType == Asn1Boolean.class) {
                return (T) new Asn1Boolean();
            }
            Constructor<T> constructor = valueType.getDeclaredConstructor();
            constructor.setAccessible(true);
            return constructor.newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Failed to create instance of " + valueType.getName(), e);
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
        if (type.isTypeOrSubTypeOf(Asn1Boolean.class)) {
            return new BooleanDeserializer<>((Class<T>) type.getRawClass());
        }
        return this;
    }

    @Override
    public T deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        T result = construct();
        if (jsonParser.getCodec() instanceof XmlMapper) {
            // XML: unwrap empty element
            TreeNode node = jsonParser.getCodec().readTree(jsonParser);
            var iterator = node.fieldNames();
            if (iterator.hasNext()) {
                String str = node.fieldNames().next();
                result.setValue(Boolean.parseBoolean(str));
            }
        } else {
            // JSON
            result.setValue(jsonParser.getBooleanValue());
        }
        return result;
    }
}
