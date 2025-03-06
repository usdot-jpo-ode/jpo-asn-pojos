package asn2pojo.runtime.examples;

import asn2pojo.runtime.types.IA5String;

public class AString extends IA5String {

  public AString() {
    super(1, 255);
  }

  public AString(String value) {
    this();
    this.value = value;
  }
}
