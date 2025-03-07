package j2735.SPAT;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the IntersectionStatusObject class.
 * Generated using ChatGPT
 */
public class IntersectionStatusObjectTest {

  /**
   * Test that the default state of each flag is false.
   */
  @Test
  public void testDefaultState() {
      IntersectionStatusObject status = new IntersectionStatusObject();
      assertFalse(status.isManualControlIsEnabled(), "Default manualControlIsEnabled should be false.");
      assertFalse(status.isStopTimeIsActivated(), "Default stopTimeIsActivated should be false.");
      assertFalse(status.isFailureFlash(), "Default failureFlash should be false.");
      assertFalse(status.isPreemptIsActive(), "Default preemptIsActive should be false.");
      assertFalse(status.isSignalPriorityIsActive(), "Default signalPriorityIsActive should be false.");
      assertFalse(status.isFixedTimeOperation(), "Default fixedTimeOperation should be false.");
      assertFalse(status.isTrafficDependentOperation(), "Default trafficDependentOperation should be false.");
      assertFalse(status.isStandbyOperation(), "Default standbyOperation should be false.");
      assertFalse(status.isFailureMode(), "Default failureMode should be false.");
      assertFalse(status.isOff(), "Default off should be false.");
      assertFalse(status.isRecentMAPmessageUpdate(), "Default recentMAPmessageUpdate should be false.");
      assertFalse(status.isRecentChangeInMAPassignedLanesIDsUsed(), "Default recentChangeInMAPassignedLanesIDsUsed should be false.");
      assertFalse(status.isNoValidMAPisAvailableAtThisTime(), "Default noValidMAPisAvailableAtThisTime should be false.");
      assertFalse(status.isNoValidSPATisAvailableAtThisTime(), "Default noValidSPATisAvailableAtThisTime should be false.");
  }

  /**
   * Test the getter and setter for each flag.
   */
  @Test
  public void testSettersAndGetters() {
      IntersectionStatusObject status = new IntersectionStatusObject();
      
      status.setManualControlIsEnabled(true);
      assertTrue(status.isManualControlIsEnabled());
      status.setManualControlIsEnabled(false);
      assertFalse(status.isManualControlIsEnabled());
      
      status.setStopTimeIsActivated(true);
      assertTrue(status.isStopTimeIsActivated());
      status.setStopTimeIsActivated(false);
      assertFalse(status.isStopTimeIsActivated());
      
      status.setFailureFlash(true);
      assertTrue(status.isFailureFlash());
      status.setFailureFlash(false);
      assertFalse(status.isFailureFlash());
      
      status.setPreemptIsActive(true);
      assertTrue(status.isPreemptIsActive());
      status.setPreemptIsActive(false);
      assertFalse(status.isPreemptIsActive());
      
      status.setSignalPriorityIsActive(true);
      assertTrue(status.isSignalPriorityIsActive());
      status.setSignalPriorityIsActive(false);
      assertFalse(status.isSignalPriorityIsActive());
      
      status.setFixedTimeOperation(true);
      assertTrue(status.isFixedTimeOperation());
      status.setFixedTimeOperation(false);
      assertFalse(status.isFixedTimeOperation());
      
      status.setTrafficDependentOperation(true);
      assertTrue(status.isTrafficDependentOperation());
      status.setTrafficDependentOperation(false);
      assertFalse(status.isTrafficDependentOperation());
      
      status.setStandbyOperation(true);
      assertTrue(status.isStandbyOperation());
      status.setStandbyOperation(false);
      assertFalse(status.isStandbyOperation());
      
      status.setFailureMode(true);
      assertTrue(status.isFailureMode());
      status.setFailureMode(false);
      assertFalse(status.isFailureMode());
      
      status.setOff(true);
      assertTrue(status.isOff());
      status.setOff(false);
      assertFalse(status.isOff());
      
      status.setRecentMAPmessageUpdate(true);
      assertTrue(status.isRecentMAPmessageUpdate());
      status.setRecentMAPmessageUpdate(false);
      assertFalse(status.isRecentMAPmessageUpdate());
      
      status.setRecentChangeInMAPassignedLanesIDsUsed(true);
      assertTrue(status.isRecentChangeInMAPassignedLanesIDsUsed());
      status.setRecentChangeInMAPassignedLanesIDsUsed(false);
      assertFalse(status.isRecentChangeInMAPassignedLanesIDsUsed());
      
      status.setNoValidMAPisAvailableAtThisTime(true);
      assertTrue(status.isNoValidMAPisAvailableAtThisTime());
      status.setNoValidMAPisAvailableAtThisTime(false);
      assertFalse(status.isNoValidMAPisAvailableAtThisTime());
      
      status.setNoValidSPATisAvailableAtThisTime(true);
      assertTrue(status.isNoValidSPATisAvailableAtThisTime());
      status.setNoValidSPATisAvailableAtThisTime(false);
      assertFalse(status.isNoValidSPATisAvailableAtThisTime());
  }
}
