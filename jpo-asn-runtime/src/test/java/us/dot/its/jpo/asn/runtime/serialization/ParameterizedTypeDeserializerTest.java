package us.dot.its.jpo.asn.runtime.serialization;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import com.fasterxml.jackson.databind.JsonDeserializer.None;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.jupiter.api.Test;
import us.dot.its.jpo.asn.runtime.annotations.Asn1ParameterizedTypes;
import us.dot.its.jpo.asn.runtime.annotations.Asn1ParameterizedTypes.IdType;
import us.dot.its.jpo.asn.runtime.types.Asn1Sequence;

class ParameterizedTypeDeserializerTest {

  @Test
  void xmlSubtypeUsesTheDirectRootIdInsteadOfAnEarlierNestedId() throws Exception {
    String xml = "<TestFrame><nested><kind>2</kind></nested><kind>1</kind></TestFrame>";

    TestFrame frame = new XmlMapper().readValue(xml, TestFrame.class);

    assertInstanceOf(FirstFrame.class, frame);
    assertEquals(1, frame.kind);
    assertEquals(2, frame.nested.kind);
  }

  @Asn1ParameterizedTypes(
      idProperty = "kind",
      idType = IdType.INTEGER,
      valueProperty = "value",
      value = {
        @Asn1ParameterizedTypes.Type(value = FirstFrame.class, intId = 1),
        @Asn1ParameterizedTypes.Type(value = SecondFrame.class, intId = 2)
      })
  @JsonDeserialize(using = TestFrameDeserializer.class)
  public abstract static class TestFrame extends Asn1Sequence {
    public int kind;
    public Nested nested;
  }

  @JsonDeserialize(using = None.class)
  public static class FirstFrame extends TestFrame {
  }

  @JsonDeserialize(using = None.class)
  public static class SecondFrame extends TestFrame {
  }

  public static class Nested {
    public int kind;
  }

  public static class TestFrameDeserializer extends ParameterizedTypeDeserializer<TestFrame> {
    public TestFrameDeserializer() {
      super(TestFrame.class);
    }
  }
}
