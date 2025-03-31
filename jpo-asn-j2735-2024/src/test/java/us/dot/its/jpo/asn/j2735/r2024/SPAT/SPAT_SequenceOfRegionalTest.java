package us.dot.its.jpo.asn.j2735.r2024.SPAT;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import us.dot.its.jpo.asn.j2735.r2024.REGION.Reg_SPAT;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the SPAT_SequenceOfRegional class.
 */
public class SPAT_SequenceOfRegionalTest {
  
  @Test
  public void constructorTest() {
    var seqOfReg = new SPAT.SequenceOfRegional();
    assertThat(seqOfReg, notNullValue());
    assertThat(seqOfReg.getSizeLowerBound(), equalTo(1L));
    assertThat(seqOfReg.getSizeUpperBound(), equalTo(4L));
    assertThat(seqOfReg.getItemClass(), equalTo(Reg_SPAT.class));
  }

}
