package us.dot.its.jpo.asn.testgenerator;

import us.dot.its.jpo.asn.runtime.types.Asn1Bitstring;

import java.util.Random;

public class BitstringGenerator extends RandomGenerator<Asn1Bitstring> {

  public BitstringGenerator(GeneratorOptions options) {
    super(options);
  }

  @Override
  protected Asn1Bitstring populateRandom(Asn1Bitstring instance) {
    Random r = new Random();
    for (int i = 0; i < instance.size(); i++) {
      instance.set(i, r.nextBoolean());
    }
    return instance;
  }
}
