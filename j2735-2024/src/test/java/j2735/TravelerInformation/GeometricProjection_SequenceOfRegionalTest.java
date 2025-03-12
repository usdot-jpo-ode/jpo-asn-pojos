package j2735.TravelerInformation;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import org.junit.jupiter.api.Test;

import j2735.REGION.Reg_GeometricProjection;

/**
 * Unit tests for the GeometricProjection_SequenceOfRegional class.
 */
public class GeometricProjection_SequenceOfRegionalTest {
  
  @Test
  public void constructorTest() {
    var seqOfReg = new GeometricProjection.SequenceOfRegional();
    assertThat(seqOfReg, notNullValue());
    assertThat(seqOfReg.getSizeLowerBound(), equalTo(1L));
    assertThat(seqOfReg.getSizeUpperBound(), equalTo(4L));
    assertThat(seqOfReg.getItemClass(), equalTo(Reg_GeometricProjection.class));
  }

}
