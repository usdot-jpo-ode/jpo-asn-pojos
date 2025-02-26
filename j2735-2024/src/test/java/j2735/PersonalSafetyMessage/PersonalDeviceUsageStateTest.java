package j2735.PersonalSafetyMessage;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

// Unit test generated with ChatGPT - just tests getters and setters for line coverage

/**
 * Unit tests for the PersonalDeviceUsageState class.
 */
public class PersonalDeviceUsageStateTest {

  /**
   * Test that the default state of each flag is false.
   */
  @Test
  public void testDefaultState() {
    PersonalDeviceUsageState state = new PersonalDeviceUsageState();
    // Verify default values for each property
    assertFalse(state.isUnavailable(), "Unavailable should default to false.");
    assertFalse(state.isOther(), "Other should default to false.");
    assertFalse(state.isIdle(), "Idle should default to false.");
    assertFalse(state.isListeningToAudio(), "ListeningToAudio should default to false.");
    assertFalse(state.isTyping(), "Typing should default to false.");
    assertFalse(state.isCalling(), "Calling should default to false.");
    assertFalse(state.isPlayingGames(), "PlayingGames should default to false.");
    assertFalse(state.isReading(), "Reading should default to false.");
    assertFalse(state.isViewing(), "Viewing should default to false.");
  }

  /**
   * Test the getter and setter for the unavailable flag.
   */
  @Test
  public void testSetUnavailable() {
    PersonalDeviceUsageState state = new PersonalDeviceUsageState();
    state.setUnavailable(true);
    assertTrue(state.isUnavailable(), "Unavailable should be true after setting to true.");
    state.setUnavailable(false);
    assertFalse(state.isUnavailable(), "Unavailable should be false after setting to false.");
  }

  /**
   * Test the getter and setter for the other flag.
   */
  @Test
  public void testSetOther() {
    PersonalDeviceUsageState state = new PersonalDeviceUsageState();
    state.setOther(true);
    assertTrue(state.isOther(), "Other should be true after setting to true.");
    state.setOther(false);
    assertFalse(state.isOther(), "Other should be false after setting to false.");
  }

  /**
   * Test the getter and setter for the idle flag.
   */
  @Test
  public void testSetIdle() {
    PersonalDeviceUsageState state = new PersonalDeviceUsageState();
    state.setIdle(true);
    assertTrue(state.isIdle(), "Idle should be true after setting to true.");
    state.setIdle(false);
    assertFalse(state.isIdle(), "Idle should be false after setting to false.");
  }

  /**
   * Test the getter and setter for the listeningToAudio flag.
   */
  @Test
  public void testSetListeningToAudio() {
    PersonalDeviceUsageState state = new PersonalDeviceUsageState();
    state.setListeningToAudio(true);
    assertTrue(state.isListeningToAudio(), "ListeningToAudio should be true after setting to true.");
    state.setListeningToAudio(false);
    assertFalse(state.isListeningToAudio(), "ListeningToAudio should be false after setting to false.");
  }

  /**
   * Test the getter and setter for the typing flag.
   */
  @Test
  public void testSetTyping() {
    PersonalDeviceUsageState state = new PersonalDeviceUsageState();
    state.setTyping(true);
    assertTrue(state.isTyping(), "Typing should be true after setting to true.");
    state.setTyping(false);
    assertFalse(state.isTyping(), "Typing should be false after setting to false.");
  }

  /**
   * Test the getter and setter for the calling flag.
   */
  @Test
  public void testSetCalling() {
    PersonalDeviceUsageState state = new PersonalDeviceUsageState();
    state.setCalling(true);
    assertTrue(state.isCalling(), "Calling should be true after setting to true.");
    state.setCalling(false);
    assertFalse(state.isCalling(), "Calling should be false after setting to false.");
  }

  /**
   * Test the getter and setter for the playingGames flag.
   */
  @Test
  public void testSetPlayingGames() {
    PersonalDeviceUsageState state = new PersonalDeviceUsageState();
    state.setPlayingGames(true);
    assertTrue(state.isPlayingGames(), "PlayingGames should be true after setting to true.");
    state.setPlayingGames(false);
    assertFalse(state.isPlayingGames(), "PlayingGames should be false after setting to false.");
  }

  /**
   * Test the getter and setter for the reading flag.
   */
  @Test
  public void testSetReading() {
    PersonalDeviceUsageState state = new PersonalDeviceUsageState();
    state.setReading(true);
    assertTrue(state.isReading(), "Reading should be true after setting to true.");
    state.setReading(false);
    assertFalse(state.isReading(), "Reading should be false after setting to false.");
  }

  /**
   * Test the getter and setter for the viewing flag.
   */
  @Test
  public void testSetViewing() {
    PersonalDeviceUsageState state = new PersonalDeviceUsageState();
    state.setViewing(true);
    assertTrue(state.isViewing(), "Viewing should be true after setting to true.");
    state.setViewing(false);
    assertFalse(state.isViewing(), "Viewing should be false after setting to false.");
  }

  /**
   * Test setting multiple flags simultaneously and verifying that each one retains its value.
   */
  @Test
  public void testMultipleFlags() {
    PersonalDeviceUsageState state = new PersonalDeviceUsageState();
    // Set multiple flags simultaneously
    state.setUnavailable(true);
    state.setOther(true);
    state.setIdle(true);
    state.setListeningToAudio(false);
    state.setTyping(true);
    state.setCalling(false);
    state.setPlayingGames(true);
    state.setReading(false);
    state.setViewing(true);

    // Verify each flag individually
    assertTrue(state.isUnavailable(), "Unavailable should be true.");
    assertTrue(state.isOther(), "Other should be true.");
    assertTrue(state.isIdle(), "Idle should be true.");
    assertFalse(state.isListeningToAudio(), "ListeningToAudio should be false.");
    assertTrue(state.isTyping(), "Typing should be true.");
    assertFalse(state.isCalling(), "Calling should be false.");
    assertTrue(state.isPlayingGames(), "PlayingGames should be true.");
    assertFalse(state.isReading(), "Reading should be false.");
    assertTrue(state.isViewing(), "Viewing should be true.");
  }
}
