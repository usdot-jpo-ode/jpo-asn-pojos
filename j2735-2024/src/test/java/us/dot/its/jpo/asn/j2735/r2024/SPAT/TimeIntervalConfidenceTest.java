package us.dot.its.jpo.asn.j2735.r2024.SPAT;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for the TimeIntervalConfidence class.
 */
public class TimeIntervalConfidenceTest {
  
  @Test
  public void constructorTest() {
    var timeIntervalConfidence = new TimeIntervalConfidence(100L);
    assertThat(timeIntervalConfidence, notNullValue());
    assertThat(timeIntervalConfidence.getValue(), equalTo(100L));
  }
}
