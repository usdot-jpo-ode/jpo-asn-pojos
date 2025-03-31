package us.dot.its.jpo.asn.j2735.r2024.SPAT;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for the IntersectionStatusObject class.
 */
public class IntersectionStatusObjectTest {

  @Test
  public void testDefaultState() {
    var status = new IntersectionStatusObject();
    status.fromBinaryString("0000000000000000");
    
    assertThat(status.isManualControlIsEnabled(), equalTo(false));
    assertThat(status.isStopTimeIsActivated(), equalTo(false));
    assertThat(status.isFailureFlash(), equalTo(false));
    assertThat(status.isPreemptIsActive(), equalTo(false));
    assertThat(status.isSignalPriorityIsActive(), equalTo(false));
    assertThat(status.isFixedTimeOperation(), equalTo(false));
    assertThat(status.isTrafficDependentOperation(), equalTo(false));
    assertThat(status.isStandbyOperation(), equalTo(false));
    assertThat(status.isFailureMode(), equalTo(false));
    assertThat(status.isOff(), equalTo(false));
    assertThat(status.isRecentMAPmessageUpdate(), equalTo(false));
    assertThat(status.isRecentChangeInMAPassignedLanesIDsUsed(), equalTo(false));
    assertThat(status.isNoValidMAPisAvailableAtThisTime(), equalTo(false));
    assertThat(status.isNoValidSPATisAvailableAtThisTime(), equalTo(false));
  }

  @Test
  public void testAllFlagsSet() {
    var status = new IntersectionStatusObject();
    status.fromBinaryString("1111111111111111");
    
    assertThat(status.isManualControlIsEnabled(), equalTo(true));
    assertThat(status.isStopTimeIsActivated(), equalTo(true));
    assertThat(status.isFailureFlash(), equalTo(true));
    assertThat(status.isPreemptIsActive(), equalTo(true));
    assertThat(status.isSignalPriorityIsActive(), equalTo(true));
    assertThat(status.isFixedTimeOperation(), equalTo(true));
    assertThat(status.isTrafficDependentOperation(), equalTo(true));
    assertThat(status.isStandbyOperation(), equalTo(true));
    assertThat(status.isFailureMode(), equalTo(true));
    assertThat(status.isOff(), equalTo(true));
    assertThat(status.isRecentMAPmessageUpdate(), equalTo(true));
    assertThat(status.isRecentChangeInMAPassignedLanesIDsUsed(), equalTo(true));
    assertThat(status.isNoValidMAPisAvailableAtThisTime(), equalTo(true));
    assertThat(status.isNoValidSPATisAvailableAtThisTime(), equalTo(true));
  }

  @Test
  public void testMixedStates() {
    var status = new IntersectionStatusObject();
    status.fromBinaryString("1010101010101010");
    
    assertThat(status.isManualControlIsEnabled(), equalTo(true));
    assertThat(status.isStopTimeIsActivated(), equalTo(false));
    assertThat(status.isFailureFlash(), equalTo(true));
    assertThat(status.isPreemptIsActive(), equalTo(false));
    assertThat(status.isSignalPriorityIsActive(), equalTo(true));
    assertThat(status.isFixedTimeOperation(), equalTo(false));
    assertThat(status.isTrafficDependentOperation(), equalTo(true));
    assertThat(status.isStandbyOperation(), equalTo(false));
    assertThat(status.isFailureMode(), equalTo(true));
    assertThat(status.isOff(), equalTo(false));
    assertThat(status.isRecentMAPmessageUpdate(), equalTo(true));
    assertThat(status.isRecentChangeInMAPassignedLanesIDsUsed(), equalTo(false));
    assertThat(status.isNoValidMAPisAvailableAtThisTime(), equalTo(true));
    assertThat(status.isNoValidSPATisAvailableAtThisTime(), equalTo(false));
  }

  @Test
  public void testSetters() {
    var status = new IntersectionStatusObject();

    status.setManualControlIsEnabled(true);
    assertThat(status.isManualControlIsEnabled(), equalTo(true));

    status.setStopTimeIsActivated(true);
    assertThat(status.isStopTimeIsActivated(), equalTo(true));
    
    status.setFailureFlash(true);
    assertThat(status.isFailureFlash(), equalTo(true));
    
    status.setPreemptIsActive(true);
    assertThat(status.isPreemptIsActive(), equalTo(true));
    
    status.setSignalPriorityIsActive(true);
    assertThat(status.isSignalPriorityIsActive(), equalTo(true));
    
    status.setFixedTimeOperation(true);
    assertThat(status.isFixedTimeOperation(), equalTo(true));
    
    status.setTrafficDependentOperation(true);
    assertThat(status.isTrafficDependentOperation(), equalTo(true));
    
    status.setStandbyOperation(true);
    assertThat(status.isStandbyOperation(), equalTo(true));
    
    status.setFailureMode(true);
    assertThat(status.isFailureMode(), equalTo(true));

    status.setOff(true);
    assertThat(status.isOff(), equalTo(true));

    status.setRecentMAPmessageUpdate(true);
    assertThat(status.isRecentMAPmessageUpdate(), equalTo(true));

    status.setRecentChangeInMAPassignedLanesIDsUsed(true);
    assertThat(status.isRecentChangeInMAPassignedLanesIDsUsed(), equalTo(true));

    status.setNoValidMAPisAvailableAtThisTime(true);
    assertThat(status.isNoValidMAPisAvailableAtThisTime(), equalTo(true));

    status.setNoValidSPATisAvailableAtThisTime(true);
    assertThat(status.isNoValidSPATisAvailableAtThisTime(), equalTo(true));
    
    // Verify final state matches all bits set
    var allSet = new IntersectionStatusObject();
    allSet.fromBinaryString("1111111111111100");
    assertThat(status.toString(), equalTo(allSet.toString()));
  }
}
