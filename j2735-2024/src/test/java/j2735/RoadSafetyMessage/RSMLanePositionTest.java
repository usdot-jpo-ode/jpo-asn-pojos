package j2735.RoadSafetyMessage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import j2735.PersonalSafetyMessage.AttachmentRadius;
import org.junit.jupiter.api.Test;

public class RSMLanePositionTest {

  @Test
  public void constructorTest() {
    var lp = new RSMLanePosition(2000L);
    assertThat(lp.getValue(), equalTo(2000L));
  }

}
