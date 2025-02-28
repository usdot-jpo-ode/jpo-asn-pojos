package j2735.BasicSafetyMessage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import j2735.REGION.Reg_SupplementalVehicleExtensions;
import org.junit.jupiter.api.Test;

public class SupplementalVehicleExtensions_SequenceOfRegionalTest {

  @Test
  public void constructorTest() {
    var seqReg = new SupplementalVehicleExtensions.SequenceOfRegional();
    assertThat(seqReg.getSizeLowerBound(), equalTo(1L));
    assertThat(seqReg.getSizeUpperBound(), equalTo(4L));
    assertThat(seqReg.getItemClass(), equalTo(Reg_SupplementalVehicleExtensions.class));
  }

}
