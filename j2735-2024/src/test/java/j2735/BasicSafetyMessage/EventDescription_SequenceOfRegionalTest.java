package j2735.BasicSafetyMessage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import j2735.REGION.Reg_EventDescription;
import org.junit.jupiter.api.Test;

public class EventDescription_SequenceOfRegionalTest {

  @Test
  public void constrtuctorTest() {
    var seqReg = new EventDescription.SequenceOfRegional();
    assertThat(seqReg, notNullValue());
    assertThat(seqReg.getSizeLowerBound(), equalTo(1L));
    assertThat(seqReg.getSizeUpperBound(), equalTo(4L));
    assertThat(seqReg.getItemClass(), equalTo(Reg_EventDescription.class));
  }

}
