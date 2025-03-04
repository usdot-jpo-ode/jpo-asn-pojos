package j2735.MapData;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.typeCompatibleWith;

import j2735.REGION.Reg_RoadSegment;
import org.junit.jupiter.api.Test;

public class RoadSegment_SequenceOfRegionalTest {

  @Test
  public void constructorTest() {
    var sor = new RoadSegment.SequenceOfRegional();
    assertThat(sor.getItemClass(), typeCompatibleWith(Reg_RoadSegment.class));
  }
}
