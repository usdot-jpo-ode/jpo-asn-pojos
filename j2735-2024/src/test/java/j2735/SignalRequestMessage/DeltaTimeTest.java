package j2735.SignalRequestMessage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for the DeltaTime class.
 */
public class DeltaTimeTest {
  
  @Test
  public void constructorTest() {
    var deltaTime = new DeltaTime(10L);
    assertThat(deltaTime, notNullValue());
  }
}
