package us.dot.its.jpo.asn.j2735.r2024.J2540ITIS;

import org.junit.jupiter.api.Test;
import us.dot.its.jpo.asn.j2735.r2024.BaseNamedIntegerTest;

public class ValidManeuversTest extends BaseNamedIntegerTest<ValidManeuvers> {

  final long value = 11292L;
  final String name = "prohibit-L45-S-R45-Allowed-LU-LT-RT-RU";

  protected ValidManeuversTest() {
    super(ValidManeuvers.class);
  }

  @Test
  public void testName() {
    nameTest(value, name);
  }

  @Test
  public void testNamed() {
    namedTest(name, value);
  }

  @Test
  public void testNames() {
    namesTest(name);
  }

  @Test
  public void testNamedValues() {
    namedValuesTest(value);
  }

}
