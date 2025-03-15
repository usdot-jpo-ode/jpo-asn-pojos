package us.dot.its.jpo.asn.runtime.examples;

import us.dot.its.jpo.asn.runtime.serialization.IntegerDeserializer;
import us.dot.its.jpo.asn.runtime.types.Asn1Integer;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = BInteger.BIntegerDeserializer.class)
public class BInteger extends Asn1Integer {

  public BInteger() {
    super(-10L, 10L);
  }

  @JsonCreator
  public BInteger(long value) {
    this();
    this.value = value;
  }

  public static class BIntegerDeserializer extends IntegerDeserializer<BInteger> {
    public BIntegerDeserializer() {
      super(BInteger.class);
    }

    @Override
    protected BInteger construct() {
      return new BInteger();
    }
  }

}
