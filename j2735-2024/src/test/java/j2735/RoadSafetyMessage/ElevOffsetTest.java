package j2735.RoadSafetyMessage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;

public class ElevOffsetTest {

  @Test
  public void constructorTest() {
    var eo = new ElevOffset(2000L);
    assertThat(eo.getValue(), equalTo(2000L));
  }

}
