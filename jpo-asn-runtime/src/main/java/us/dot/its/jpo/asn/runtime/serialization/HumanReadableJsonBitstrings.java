package us.dot.its.jpo.asn.runtime.serialization;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.deser.BeanDeserializerModifier;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;
import java.util.List;
import us.dot.its.jpo.asn.runtime.types.Asn1Bitstring;

public class HumanReadableJsonBitstrings extends SimpleModule {

  @Override
  public void setupModule(SetupContext context) {

    super.setupModule(context);

    context.addBeanSerializerModifier(new BeanSerializerModifier() {

      @Override
      public JsonSerializer<?> modifySerializer(SerializationConfig config,
          BeanDescription beanDesc, JsonSerializer<?> serializer) {

        if (Asn1Bitstring.class.isAssignableFrom(beanDesc.getBeanClass())) {
          // Replace the default bitstring serializer with a human-readable JSON serializr
          return new BitstringSerializer(true);
        }

        return serializer;
      }

    });

    context.addBeanDeserializerModifier(new BeanDeserializerModifier() {

      @Override
      public JsonDeserializer<?> modifyDeserializer(DeserializationConfig config,
          BeanDescription beanDesc, JsonDeserializer<?> deserializer) {
        if (BitStringDeserializer.class.isAssignableFrom(deserializer.getClass())) {
          return ((BitStringDeserializer<?>)deserializer).humanReadableJson();
        }
        return deserializer;
      }

    });
  }
}
