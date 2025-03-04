package j2735.MapData;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.typeCompatibleWith;

import j2735.REGION.Reg_RestrictionUserType;
import org.junit.jupiter.api.Test;

public class RestrictionUserType_SequenceOfRegional {

  @Test
  public void constructorTest() {
    var sor = new RestrictionUserType.SequenceOfRegional();
    assertThat(sor.getItemClass(), typeCompatibleWith(Reg_RestrictionUserType.class));
  }
}
