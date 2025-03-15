package us.dot.its.jpo.asn.runtime.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public class Asn1RelativeOID implements Asn1Type {

  public Asn1RelativeOID() {
    // No-arg constructor
  }

  @JsonCreator
  public Asn1RelativeOID(String value) {
    setValue(value);
  }

  protected String value;

  @JsonValue
  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

}
