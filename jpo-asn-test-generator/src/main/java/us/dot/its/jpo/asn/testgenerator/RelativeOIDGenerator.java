package us.dot.its.jpo.asn.testgenerator;

import java.util.Random;
import us.dot.its.jpo.asn.runtime.types.Asn1RelativeOID;

public class RelativeOIDGenerator extends RandomGenerator<Asn1RelativeOID> {

  public RelativeOIDGenerator(GeneratorOptions options) {
    super(options);
  }

  @Override
  protected Asn1RelativeOID populateRandom(Asn1RelativeOID instance) {
    Random r = new Random();
    String str = String.format("%s", r.nextInt(Short.MAX_VALUE));
    return new Asn1RelativeOID(str);
  }
}
