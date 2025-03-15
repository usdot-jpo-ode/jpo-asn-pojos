package us.dot.its.jpo.asn.runtime.examples;

import us.dot.its.jpo.asn.runtime.types.IA5String;


public class BString extends IA5String {

  public BString() {
    super(1, 63);
  }

  public BString(String value) {
    this();
    this.value = value;
  }
}
