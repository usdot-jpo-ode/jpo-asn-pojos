package us.dot.its.jpo.asn.j2735.r2024.SPAT;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for the TimeMark class.
 */
public class TimeMarkTest {
  
  @Test
  public void constructorTest() {
    var timeMark = new TimeMark(20L);
    assertThat(timeMark, notNullValue());
    assertThat(timeMark.getValue(), equalTo(20L));
  }
}
