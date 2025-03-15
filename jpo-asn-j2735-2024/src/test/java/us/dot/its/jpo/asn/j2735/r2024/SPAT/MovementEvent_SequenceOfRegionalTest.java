package us.dot.its.jpo.asn.j2735.r2024.SPAT;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import us.dot.its.jpo.asn.j2735.r2024.REGION.Reg_MovementEvent;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the MovementEvent_SequenceOfRegional class.
 */
public class MovementEvent_SequenceOfRegionalTest {
  
  @Test
  public void constructorTest() {
    var seqOfReg = new MovementEvent.SequenceOfRegional();
    assertThat(seqOfReg, notNullValue());
    assertThat(seqOfReg.getSizeLowerBound(), equalTo(1L));
    assertThat(seqOfReg.getSizeUpperBound(), equalTo(4L));
    assertThat(seqOfReg.getItemClass(), equalTo(Reg_MovementEvent.class));
  }

}
