package us.dot.its.jpo.asn.runtime.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Represents an ASN.1 ObjectIdentifier type.
 */
public class Asn1ObjectIdentifier implements Asn1Type {

  public Asn1ObjectIdentifier() {
    // No-arg constructor
  }

  @JsonCreator
  public Asn1ObjectIdentifier(String value) {
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
