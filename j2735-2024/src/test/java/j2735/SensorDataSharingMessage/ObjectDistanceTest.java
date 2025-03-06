package j2735.SensorDataSharingMessage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for the ObjectDistance class.
 */
public class ObjectDistanceTest {
  
  @Test
  public void constructorTest() {
    var objectDistance = new ObjectDistance(25L);
    assertThat(objectDistance, notNullValue());
    assertThat(objectDistance.getValue(), equalTo(25L));
  }
}
