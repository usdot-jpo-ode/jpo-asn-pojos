package j2735.RoadSafetyMessage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;

public class RoadSafetyMessage_BankAngleTest {

  @Test
  public void constructorTest() {
    var ba = new BankAngle(2000L);
    assertThat(ba.getValue(), equalTo(2000L));
  }

}
