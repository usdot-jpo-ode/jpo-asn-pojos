package j2735.PersonalSafetyMessage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;

public class AttachmentRadiusTest {

  @Test
  public void constructorTest() {
    var ar = new AttachmentRadius(2000L);
    assertThat(ar.getValue(), equalTo(2000L));
  }

}
