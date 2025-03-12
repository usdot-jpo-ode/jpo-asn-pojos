package asn2pojo.runtime.serialization;

import asn2pojo.runtime.types.Asn1SequenceOf;
import asn2pojo.runtime.types.Asn1Type;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SequenceOfOpenTypeSerializer<S extends Asn1Type, T extends Asn1SequenceOf<S>>
    extends StdSerializer<T> {

  protected final Class<S> itemClass;
  protected final Class<T> sequenceOfClass;

  protected SequenceOfOpenTypeSerializer(Class<S> itemClass, Class<T> sequenceOfClass) {
    super(sequenceOfClass);
    this.itemClass = itemClass;
    this.sequenceOfClass = sequenceOfClass;
  }

  @Override
  public void serialize(T sequenceOf, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
      throws IOException {
    if (serializerProvider instanceof XmlSerializerProvider) {
      // XER: Write each item sequentially without wrapping
      var xmlGen = (ToXmlGenerator)jsonGenerator;
      var mapper = SerializationUtil.xmlMapper();
      for (var item : sequenceOf) {
        String itemXml = mapper.writeValueAsString(item);
        log.trace("itemXml: {}", itemXml);
        xmlGen.writeRaw(itemXml);
      }
    } else {
      // JER: The default works
      jsonGenerator.writeObject(sequenceOf);
    }

  }
}
