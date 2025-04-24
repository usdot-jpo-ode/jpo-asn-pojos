package us.dot.its.jpo.asn.j2735.r2024.J2540ITIS;

import org.junit.jupiter.api.Test;
import us.dot.its.jpo.asn.j2735.r2024.BaseNamedIntegerTest;

public class SmallNumbersTest extends BaseNamedIntegerTest<SmallNumbers> {

  final long value = 12545L;
  final String name = "n1";

  protected SmallNumbersTest() {
    super(SmallNumbers.class);
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
