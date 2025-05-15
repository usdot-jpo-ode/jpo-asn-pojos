package us.dot.its.jpo.asn.j2735.r2024.SPAT;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for the ZoneLength class.
 */
public class ZoneLengthTest {
  
  @Test
  public void constructorTest() {
    var zoneLength = new ZoneLength(1000L);
    assertThat(zoneLength, notNullValue());
    assertThat(zoneLength.getValue(), equalTo(1000L));
  }
}
