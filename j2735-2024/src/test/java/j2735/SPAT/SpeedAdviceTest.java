package j2735.SPAT;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for the SpeedAdvice class.
 */
public class SpeedAdviceTest {
  
  @Test
  public void constructorTest() {
    var speedAdvice = new SpeedAdvice(50L);
    assertThat(speedAdvice, notNullValue());
    assertThat(speedAdvice.getValue(), equalTo(50L));
  }
}
