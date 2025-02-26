package j2735.PersonalSafetyMessage;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

// Unit test generated with ChatGPT - just tests getters and setters for line coverage

/**
 * Unit tests for the PublicSafetyAndRoadWorkerActivity class.
 */
public class PublicSafetyAndRoadWorkerActivityTest {

  /**
   * Test that the default state of each flag is false.
   */
  @Test
  public void testDefaultState() {
    PublicSafetyAndRoadWorkerActivity activity = new PublicSafetyAndRoadWorkerActivity();
    assertFalse(activity.isUnavailable(), "Unavailable should default to false.");
    assertFalse(activity.isWorkingOnRoad(), "WorkingOnRoad should default to false.");
    assertFalse(activity.isSettingUpClosures(), "SettingUpClosures should default to false.");
    assertFalse(activity.isRespondingToEvents(), "RespondingToEvents should default to false.");
    assertFalse(activity.isDirectingTraffic(), "DirectingTraffic should default to false.");
    assertFalse(activity.isOtherActivities(), "OtherActivities should default to false.");
  }

  /**
   * Test the getter and setter for the unavailable flag.
   */
  @Test
  public void testSetUnavailable() {
    PublicSafetyAndRoadWorkerActivity activity = new PublicSafetyAndRoadWorkerActivity();
    activity.setUnavailable(true);
    assertTrue(activity.isUnavailable(), "Unavailable should be true after setting to true.");
    activity.setUnavailable(false);
    assertFalse(activity.isUnavailable(), "Unavailable should be false after setting to false.");
  }

  /**
   * Test the getter and setter for the workingOnRoad flag.
   */
  @Test
  public void testSetWorkingOnRoad() {
    PublicSafetyAndRoadWorkerActivity activity = new PublicSafetyAndRoadWorkerActivity();
    activity.setWorkingOnRoad(true);
    assertTrue(activity.isWorkingOnRoad(), "WorkingOnRoad should be true after setting to true.");
    activity.setWorkingOnRoad(false);
    assertFalse(activity.isWorkingOnRoad(), "WorkingOnRoad should be false after setting to false.");
  }

  /**
   * Test the getter and setter for the settingUpClosures flag.
   */
  @Test
  public void testSetSettingUpClosures() {
    PublicSafetyAndRoadWorkerActivity activity = new PublicSafetyAndRoadWorkerActivity();
    activity.setSettingUpClosures(true);
    assertTrue(activity.isSettingUpClosures(), "SettingUpClosures should be true after setting to true.");
    activity.setSettingUpClosures(false);
    assertFalse(activity.isSettingUpClosures(), "SettingUpClosures should be false after setting to false.");
  }

  /**
   * Test the getter and setter for the respondingToEvents flag.
   */
  @Test
  public void testSetRespondingToEvents() {
    PublicSafetyAndRoadWorkerActivity activity = new PublicSafetyAndRoadWorkerActivity();
    activity.setRespondingToEvents(true);
    assertTrue(activity.isRespondingToEvents(), "RespondingToEvents should be true after setting to true.");
    activity.setRespondingToEvents(false);
    assertFalse(activity.isRespondingToEvents(), "RespondingToEvents should be false after setting to false.");
  }

  /**
   * Test the getter and setter for the directingTraffic flag.
   */
  @Test
  public void testSetDirectingTraffic() {
    PublicSafetyAndRoadWorkerActivity activity = new PublicSafetyAndRoadWorkerActivity();
    activity.setDirectingTraffic(true);
    assertTrue(activity.isDirectingTraffic(), "DirectingTraffic should be true after setting to true.");
    activity.setDirectingTraffic(false);
    assertFalse(activity.isDirectingTraffic(), "DirectingTraffic should be false after setting to false.");
  }

  /**
   * Test the getter and setter for the otherActivities flag.
   */
  @Test
  public void testSetOtherActivities() {
    PublicSafetyAndRoadWorkerActivity activity = new PublicSafetyAndRoadWorkerActivity();
    activity.setOtherActivities(true);
    assertTrue(activity.isOtherActivities(), "OtherActivities should be true after setting to true.");
    activity.setOtherActivities(false);
    assertFalse(activity.isOtherActivities(), "OtherActivities should be false after setting to false.");
  }

  /**
   * Test setting multiple flags simultaneously and verifying that each one retains its value.
   */
  @Test
  public void testMultipleFlags() {
    PublicSafetyAndRoadWorkerActivity activity = new PublicSafetyAndRoadWorkerActivity();
    activity.setUnavailable(true);
    activity.setWorkingOnRoad(false);
    activity.setSettingUpClosures(true);
    activity.setRespondingToEvents(true);
    activity.setDirectingTraffic(false);
    activity.setOtherActivities(true);

    assertTrue(activity.isUnavailable(), "Unavailable should be true.");
    assertFalse(activity.isWorkingOnRoad(), "WorkingOnRoad should be false.");
    assertTrue(activity.isSettingUpClosures(), "SettingUpClosures should be true.");
    assertTrue(activity.isRespondingToEvents(), "RespondingToEvents should be true.");
    assertFalse(activity.isDirectingTraffic(), "DirectingTraffic should be false.");
    assertTrue(activity.isOtherActivities(), "OtherActivities should be true.");
  }
}
