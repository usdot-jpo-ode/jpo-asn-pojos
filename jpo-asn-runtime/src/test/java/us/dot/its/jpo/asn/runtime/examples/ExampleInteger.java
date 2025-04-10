package us.dot.its.jpo.asn.runtime.examples;

import com.fasterxml.jackson.annotation.JsonCreator;
import us.dot.its.jpo.asn.runtime.types.Asn1Integer;

public class ExampleInteger extends Asn1Integer {

  public ExampleInteger() {
    super(1L, 0x7FFFL);
  }

  @JsonCreator
  public ExampleInteger(long value) {
    this();
    this.value = value;
  }
}
