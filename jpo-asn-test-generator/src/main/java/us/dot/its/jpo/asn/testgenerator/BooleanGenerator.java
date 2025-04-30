package us.dot.its.jpo.asn.testgenerator;

import us.dot.its.jpo.asn.runtime.types.Asn1Boolean;

import java.util.Random;

public class BooleanGenerator extends RandomGenerator<Asn1Boolean> {

  public BooleanGenerator(GeneratorOptions options) {
    super(options);
  }

  @Override
  protected Asn1Boolean populateRandom(Asn1Boolean instance) {
    Random r = new Random();
    instance.setValue(r.nextBoolean());
    return instance;
  }
}
