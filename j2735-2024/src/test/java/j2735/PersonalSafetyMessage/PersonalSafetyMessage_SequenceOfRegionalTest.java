package j2735.PersonalSafetyMessage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import j2735.PersonalSafetyMessage.PersonalSafetyMessage;
import j2735.REGION.Reg_PersonalSafetyMessage;
import org.junit.jupiter.api.Test;

public class PersonalSafetyMessage_SequenceOfRegionalTest {

  @Test
  public void constructorTest() {
    var seqOfReg = new PersonalSafetyMessage.SequenceOfRegional();
    assertThat(seqOfReg, notNullValue());
    assertThat(seqOfReg.getSizeLowerBound(), equalTo(1L));
    assertThat(seqOfReg.getSizeUpperBound(), equalTo(4L));
    assertThat(seqOfReg.getItemClass(), equalTo(Reg_PersonalSafetyMessage.class));
  }

}
