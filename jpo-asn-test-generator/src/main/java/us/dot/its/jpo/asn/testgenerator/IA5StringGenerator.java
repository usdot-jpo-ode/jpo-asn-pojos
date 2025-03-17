package us.dot.its.jpo.asn.testgenerator;

import java.util.Random;
import us.dot.its.jpo.asn.runtime.types.IA5String;

public class IA5StringGenerator extends RandomGenerator<IA5String> {

  public IA5StringGenerator(String pdu, int sequenceOfLimit) {
    super(pdu, sequenceOfLimit);
  }


  @Override
  protected void populateRandom(IA5String instance) {
    final int lower = instance.getMinLength();
    final int upper = instance.getMaxLength();
    Random r = new Random();
    int strLength = r.nextInt(upper - lower) + lower;
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < strLength; i++) {
      final int letter = r.nextInt('Z' - 'A') + 'A';
      sb.append(Character.valueOf((char)letter));
    }
    instance.setValue(sb.toString());
  }
}
