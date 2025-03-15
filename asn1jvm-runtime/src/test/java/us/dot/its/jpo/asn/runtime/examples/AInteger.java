package us.dot.its.jpo.asn.runtime.examples;

import us.dot.its.jpo.asn.runtime.serialization.IntegerDeserializer;
import us.dot.its.jpo.asn.runtime.types.Asn1Integer;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = AInteger.AIntegerDeserializer.class)
public class AInteger extends Asn1Integer {

  public AInteger() {
    super(0L, 100L);
  }

  @JsonCreator
  public AInteger(long value) {
    this();
    this.value = value;
  }

  public static class AIntegerDeserializer extends IntegerDeserializer<AInteger> {
    public AIntegerDeserializer() {
      super(AInteger.class);
    }

    @Override
    protected AInteger construct() {
      return new AInteger();
    }
  }

}
