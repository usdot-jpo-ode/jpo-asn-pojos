package j2735.RoadSafetyMessage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;

public class RoadSafetyMessage_HeadingDegTest {

  @Test
  public void constructorTest() {
    var ho = new HeadingDeg(2000L);
    assertThat(ho.getValue(), equalTo(2000L));
  }

}
