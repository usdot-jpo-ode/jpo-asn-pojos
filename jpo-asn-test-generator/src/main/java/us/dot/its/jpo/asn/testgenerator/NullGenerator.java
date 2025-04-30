package us.dot.its.jpo.asn.testgenerator;

import us.dot.its.jpo.asn.runtime.types.Asn1Null;

public class NullGenerator extends RandomGenerator<Asn1Null> {

  public NullGenerator(GeneratorOptions options) {
    super(options);
  }

  @Override
  protected void populateRandom(Asn1Null instance) {
    // Nothing to do
  }
}
