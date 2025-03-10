package j2735.SPAT;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import org.junit.jupiter.api.Test;

import j2735.REGION.Reg_IntersectionState;

/**
 * Unit tests for the IntersectionState_SequenceOfRegional class.
 */
public class IntersectionState_SequenceOfRegionalTest {
  
  @Test
  public void constructorTest() {
    var seqOfReg = new IntersectionState.SequenceOfRegional();
    assertThat(seqOfReg, notNullValue());
    assertThat(seqOfReg.getSizeLowerBound(), equalTo(1L));
    assertThat(seqOfReg.getSizeUpperBound(), equalTo(4L));
    assertThat(seqOfReg.getItemClass(), equalTo(Reg_IntersectionState.class));
  }

}
