package us.dot.its.jpo.asn.runtime.examples;

import com.fasterxml.jackson.annotation.JsonCreator;
import us.dot.its.jpo.asn.runtime.types.Asn1OctetString;

public class UnboundedOctetString extends Asn1OctetString {

  public UnboundedOctetString() {
    super(1, Integer.MAX_VALUE);
  }

  @JsonCreator
  public UnboundedOctetString(String value) {
    this();
    setValue(value);
  }

}
