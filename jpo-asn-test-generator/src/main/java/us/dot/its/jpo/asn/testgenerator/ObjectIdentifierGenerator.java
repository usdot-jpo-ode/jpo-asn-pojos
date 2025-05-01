package us.dot.its.jpo.asn.testgenerator;

import us.dot.its.jpo.asn.runtime.types.Asn1ObjectIdentifier;

import java.util.Random;

public class ObjectIdentifierGenerator extends RandomGenerator<Asn1ObjectIdentifier> {

  public ObjectIdentifierGenerator(GeneratorOptions options) {
    super(options);
  }

  @Override
  protected Asn1ObjectIdentifier populateRandom(Asn1ObjectIdentifier instance) {
    Random r = new Random();
    String str = String.format("1.0.%s.1", randomShort(r));
    instance.setValue(str);
    return instance;
  }

  private short randomShort(Random r) {
    return (short) r.nextInt(Short.MAX_VALUE);
  }
}
