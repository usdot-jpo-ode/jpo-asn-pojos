package us.dot.its.jpo.asn.runtime.examples;

import us.dot.its.jpo.asn.runtime.types.IA5String;

public class AString extends IA5String {

  public AString() {
    super(1, 255);
  }

  public AString(String value) {
    this();
    this.setValue(value);
  }
}
