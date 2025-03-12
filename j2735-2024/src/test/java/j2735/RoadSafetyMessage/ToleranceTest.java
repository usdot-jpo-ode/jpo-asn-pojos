package j2735.RoadSafetyMessage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;

public class ToleranceTest {

  @Test
  public void constructorTest() {
    var tol = new Tolerance(2000L);
    assertThat(tol.getValue(), equalTo(2000L));
  }

}
