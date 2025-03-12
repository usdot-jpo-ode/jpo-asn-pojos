package j2735.RoadSafetyMessage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;

public class RoadSafetyMessage_RadiusTest {

  @Test
  public void constructorTest() {
    var radius = new Radius(2000L);
    assertThat(radius.getValue(), equalTo(2000L));
  }

}
