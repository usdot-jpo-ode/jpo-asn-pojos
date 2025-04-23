package us.dot.its.jpo.asn.runtime.examples;

import com.fasterxml.jackson.annotation.JsonCreator;
import us.dot.its.jpo.asn.runtime.types.Asn1Integer;

public class AInteger extends Asn1Integer {

  public AInteger() {
    super(0L, 100L);
  }

  @JsonCreator
  public AInteger(long value) {
    this();
    this.value = value;
  }
}
