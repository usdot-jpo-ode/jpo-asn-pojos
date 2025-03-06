package j2735.SignalRequestMessage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import org.junit.jupiter.api.Test;

import j2735.REGION.Reg_SignalRequest;

/**
 * Unit tests for the SignalRequest_SequenceOfRegional class.
 */
public class SignalRequest_SequenceOfRegionalTest {
  
  @Test
  public void constructorTest() {
    var seqOfReg = new SignalRequest.SequenceOfRegional();
    assertThat(seqOfReg, notNullValue());
    assertThat(seqOfReg.getSizeLowerBound(), equalTo(1L));
    assertThat(seqOfReg.getSizeUpperBound(), equalTo(4L));
    assertThat(seqOfReg.getItemClass(), equalTo(Reg_SignalRequest.class));
  }

}
