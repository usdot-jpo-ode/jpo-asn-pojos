package j2735.BasicSafetyMessage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;

public class VertOffset_B07Test {

  @Test
  public void constructorTest() {
    var vo7 = new VertOffset_B07(10L);
    assertThat(vo7.getValue(), equalTo(10L));
  }
}
