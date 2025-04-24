package us.dot.its.jpo.asn.j2735.r2024.J2540ITIS;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ITIScodesTest {

  @Test
  public void testName() {
    var itis = new ITIScodes(257L);
    assertTrue(itis.name().isPresent());
    assertThat(itis.name().get(), equalTo("stopped-traffic"));
  }

  @Test
  public void testNamed() {
    var itis = ITIScodes.named("stopped-traffic");
    assertTrue(itis.isPresent());
    assertThat(itis.get().getValue(), equalTo(257L));
  }

  @Test
  public void testNames() {
    var names = ITIScodes.names();
    assertThat(names, hasSize(greaterThan(10)));
  }

  @Test
  public void testNamedValues() {
    var namedValues = ITIScodes.namedValues();
    assertThat(namedValues, hasSize(greaterThan(10)));
  }

}
