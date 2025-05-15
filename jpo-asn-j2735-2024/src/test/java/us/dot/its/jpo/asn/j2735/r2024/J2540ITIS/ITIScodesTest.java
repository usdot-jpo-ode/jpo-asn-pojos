package us.dot.its.jpo.asn.j2735.r2024.J2540ITIS;

import org.junit.jupiter.api.Test;
import us.dot.its.jpo.asn.j2735.r2024.BaseNamedIntegerTest;

public class ITIScodesTest extends BaseNamedIntegerTest<ITIScodes> {

  final long value = 257L;
  final String name = "stopped-traffic";

  protected ITIScodesTest() {
    super(ITIScodes.class);
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
