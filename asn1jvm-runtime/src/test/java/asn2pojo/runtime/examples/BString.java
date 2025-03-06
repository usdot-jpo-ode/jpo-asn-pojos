package asn2pojo.runtime.examples;

import asn2pojo.runtime.types.IA5String;


public class BString extends IA5String {

  public BString() {
    super(1, 63);
  }

  public BString(String value) {
    this();
    this.value = value;
  }
}
