package us.dot.its.jpo.asn.runtime.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider;
import java.io.IOException;
import us.dot.its.jpo.asn.runtime.types.Asn1Enumerated;
import us.dot.its.jpo.asn.runtime.types.Asn1SequenceOf;

public class SequenceOfEnumeratedSerializer<S extends Asn1Enumerated, T extends Asn1SequenceOf<S>>
  extends StdSerializer<T> {

  protected final Class<S> enumClass;
  protected final Class<T> sequenceOfClass;

  protected SequenceOfEnumeratedSerializer(Class<S> enumClass, Class<T> sequenceOfClass) {
    super(sequenceOfClass);
    this.enumClass = enumClass;
    this.sequenceOfClass = sequenceOfClass;
  }

  @Override
  public void serialize(T sequenceOf, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
      throws IOException {
    if (serializerProvider instanceof XmlSerializerProvider xmlProvider) {
      // XER: write unwrapped
      jsonGenerator.writeStartArray();
      for (var enumItem : sequenceOf) {
        jsonGenerator.writeRaw(String.format("<%s/>", enumItem.getName()));
      }
      jsonGenerator.writeEndArray();
    } else {
      // JER: Normal, pass through
      jsonGenerator.writeObject(sequenceOf);
    }
  }
}
