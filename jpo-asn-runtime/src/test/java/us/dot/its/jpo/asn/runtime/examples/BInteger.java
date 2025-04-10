package us.dot.its.jpo.asn.runtime.examples;

import com.fasterxml.jackson.annotation.JsonCreator;
import us.dot.its.jpo.asn.runtime.types.Asn1Integer;

public class BInteger extends Asn1Integer {

  public BInteger() {
    super(-10L, 10L);
  }

  @JsonCreator
  public BInteger(long value) {
    this();
    this.value = value;
  }
}
