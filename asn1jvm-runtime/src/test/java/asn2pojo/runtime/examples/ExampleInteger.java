package asn2pojo.runtime.examples;

import asn2pojo.runtime.serialization.IntegerDeserializer;
import asn2pojo.runtime.types.Asn1Integer;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = ExampleInteger.TestIntegerDeserializer.class)
public class ExampleInteger extends Asn1Integer {

  public ExampleInteger() {
    super(1L, 0x7FFFL);
  }

  @JsonCreator
  public ExampleInteger(long value) {
    this();
    this.value = value;
  }

  public static class TestIntegerDeserializer extends IntegerDeserializer<ExampleInteger> {
    public TestIntegerDeserializer() {
      super(ExampleInteger.class);
    }
    @Override
    protected ExampleInteger construct() {
      return new ExampleInteger();
    }
  }

}
