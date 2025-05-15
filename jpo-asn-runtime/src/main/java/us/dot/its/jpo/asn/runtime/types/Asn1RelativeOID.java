package us.dot.its.jpo.asn.runtime.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Represents an ASN.1 Relative-OID type.
 */
public class Asn1RelativeOID implements Asn1Type {

  private final String value;

  @JsonCreator
  public Asn1RelativeOID(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

}
