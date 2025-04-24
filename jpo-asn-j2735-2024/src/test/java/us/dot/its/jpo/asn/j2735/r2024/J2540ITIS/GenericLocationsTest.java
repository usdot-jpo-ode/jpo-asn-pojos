package us.dot.its.jpo.asn.j2735.r2024.J2540ITIS;

import org.junit.jupiter.api.Test;
import us.dot.its.jpo.asn.j2735.r2024.BaseNamedIntegerTest;

public class GenericLocationsTest extends BaseNamedIntegerTest<GenericLocations> {

  final long value = 8011L;
  final String name = "traffic-circle";

  protected GenericLocationsTest() {
    super(GenericLocations.class);
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
