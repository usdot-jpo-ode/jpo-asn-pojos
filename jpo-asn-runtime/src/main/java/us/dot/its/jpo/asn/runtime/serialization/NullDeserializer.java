package us.dot.its.jpo.asn.runtime.serialization;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.IOException;
import us.dot.its.jpo.asn.runtime.types.Asn1Null;

public class NullDeserializer extends StdDeserializer<Asn1Null> {

  protected NullDeserializer() {
    super(Asn1Null.class);
  }

  @Override
  public Asn1Null deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
      throws IOException, JacksonException {
    if (!(jsonParser.getCodec() instanceof XmlMapper)) {
      // JSON: Rad the null value
      TreeNode node = jsonParser.getCodec().readTree(jsonParser);
      System.out.printf("node: %s\n", node);
    }
    // XML: Nothing to read
    return new Asn1Null();
  }
}
