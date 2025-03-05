package j2735.SignalRequestMessage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import org.junit.jupiter.api.Test;

import j2735.REGION.Reg_SignalRequestPackage;

/**
 * Unit tests for the SignalRequestPackage_SequenceOfRegional class.
 */
public class SignalRequestPackage_SequenceOfRegionalTest {
  
  @Test
  public void constructorTest() {
    var seqOfReg = new SignalRequestPackage.SequenceOfRegional();
    assertThat(seqOfReg, notNullValue());
    assertThat(seqOfReg.getSizeLowerBound(), equalTo(1L));
    assertThat(seqOfReg.getSizeUpperBound(), equalTo(4L));
    assertThat(seqOfReg.getItemClass(), equalTo(Reg_SignalRequestPackage.class));
  }

}
