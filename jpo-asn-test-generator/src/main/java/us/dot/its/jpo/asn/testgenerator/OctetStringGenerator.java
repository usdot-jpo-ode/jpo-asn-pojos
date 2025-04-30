package us.dot.its.jpo.asn.testgenerator;

import us.dot.its.jpo.asn.runtime.types.Asn1OctetString;

import java.util.Random;

public class OctetStringGenerator extends RandomGenerator<Asn1OctetString> {

  public OctetStringGenerator(GeneratorOptions options) {
    super(options);
  }

  @Override
  protected Asn1OctetString populateRandom(Asn1OctetString instance) {
    final int lower = instance.getMinLength();
    final int upper =
        (instance.getMaxLength() == instance.getMinLength())
            ? instance.getMaxLength()
            : Math.min(instance.getMaxLength(), 255); // Prevent excessively large if unbounded
    Random r = new Random();
    int len;
    if (lower == upper) {
      len = lower;
    } else {
      len = r.nextInt(upper - lower) + lower;
    }
    byte[] bytes = new byte[len];
    for (int i = 0; i < len; i++) {
      bytes[i] = (byte) r.nextInt(256);
    }
    instance.setOctets(bytes);
    return instance;
  }
}
