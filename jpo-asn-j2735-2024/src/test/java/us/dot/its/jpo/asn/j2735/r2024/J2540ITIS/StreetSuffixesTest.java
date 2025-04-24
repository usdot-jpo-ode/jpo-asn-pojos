package us.dot.its.jpo.asn.j2735.r2024.J2540ITIS;

import org.junit.jupiter.api.Test;
import us.dot.its.jpo.asn.j2735.r2024.BaseNamedIntegerTest;

public class StreetSuffixesTest extends BaseNamedIntegerTest<StreetSuffixes> {

  final long value = 13436L;
  final String name = "street";

  protected StreetSuffixesTest() {
    super(StreetSuffixes.class);
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
