package j2735.PersonalSafetyMessage;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

// Unit test generated with ChatGPT - just tests getters and setters for line coverage

/**
 * Unit tests for the UserSizeAndBehaviour class.
 */
public class UserSizeAndBehaviourTest {

  /**
   * Test that the default state of each flag is false.
   */
  @Test
  public void testDefaultState() {
    UserSizeAndBehaviour user = new UserSizeAndBehaviour();
    assertFalse(user.isUnavailable(), "Default unavailable should be false.");
    assertFalse(user.isSmallStature(), "Default smallStature should be false.");
    assertFalse(user.isLargeStature(), "Default largeStature should be false.");
    assertFalse(user.isErraticMoving(), "Default erraticMoving should be false.");
    assertFalse(user.isSlowMoving(), "Default slowMoving should be false.");
  }

  /**
   * Test the getter and setter for the unavailable flag.
   */
  @Test
  public void testSetUnavailable() {
    UserSizeAndBehaviour user = new UserSizeAndBehaviour();
    user.setUnavailable(true);
    assertTrue(user.isUnavailable(), "Unavailable should be true after setting to true.");
    user.setUnavailable(false);
    assertFalse(user.isUnavailable(), "Unavailable should be false after setting to false.");
  }

  /**
   * Test the getter and setter for the smallStature flag.
   */
  @Test
  public void testSetSmallStature() {
    UserSizeAndBehaviour user = new UserSizeAndBehaviour();
    user.setSmallStature(true);
    assertTrue(user.isSmallStature(), "SmallStature should be true after setting to true.");
    user.setSmallStature(false);
    assertFalse(user.isSmallStature(), "SmallStature should be false after setting to false.");
  }

  /**
   * Test the getter and setter for the largeStature flag.
   */
  @Test
  public void testSetLargeStature() {
    UserSizeAndBehaviour user = new UserSizeAndBehaviour();
    user.setLargeStature(true);
    assertTrue(user.isLargeStature(), "LargeStature should be true after setting to true.");
    user.setLargeStature(false);
    assertFalse(user.isLargeStature(), "LargeStature should be false after setting to false.");
  }

  /**
   * Test the getter and setter for the erraticMoving flag.
   */
  @Test
  public void testSetErraticMoving() {
    UserSizeAndBehaviour user = new UserSizeAndBehaviour();
    user.setErraticMoving(true);
    assertTrue(user.isErraticMoving(), "ErraticMoving should be true after setting to true.");
    user.setErraticMoving(false);
    assertFalse(user.isErraticMoving(), "ErraticMoving should be false after setting to false.");
  }

  /**
   * Test the getter and setter for the slowMoving flag.
   */
  @Test
  public void testSetSlowMoving() {
    UserSizeAndBehaviour user = new UserSizeAndBehaviour();
    user.setSlowMoving(true);
    assertTrue(user.isSlowMoving(), "SlowMoving should be true after setting to true.");
    user.setSlowMoving(false);
    assertFalse(user.isSlowMoving(), "SlowMoving should be false after setting to false.");
  }

  /**
   * Test setting multiple flags simultaneously and verifying each flag independently.
   */
  @Test
  public void testMultipleFlags() {
    UserSizeAndBehaviour user = new UserSizeAndBehaviour();
    user.setUnavailable(true);
    user.setSmallStature(false);
    user.setLargeStature(true);
    user.setErraticMoving(true);
    user.setSlowMoving(false);

    assertTrue(user.isUnavailable(), "Unavailable should be true.");
    assertFalse(user.isSmallStature(), "SmallStature should be false.");
    assertTrue(user.isLargeStature(), "LargeStature should be true.");
    assertTrue(user.isErraticMoving(), "ErraticMoving should be true.");
    assertFalse(user.isSlowMoving(), "SlowMoving should be false.");
  }
}
