package us.dot.its.jpo.asn.j2735.r2024.SignalRequestMessage;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for the TransitVehicleStatus class.
 */
public class TransitVehicleStatusTest {

  /**
   * Test that the default state of each flag is false.
   */
  @Test
  public void testDefaultState() {
    TransitVehicleStatus transitVehicleStatus = new TransitVehicleStatus();
    assertFalse(transitVehicleStatus.isLoading(), "Default loading should be false.");
    assertFalse(transitVehicleStatus.isAnADAuse(), "Default anADAuse should be false.");
    assertFalse(transitVehicleStatus.isABikeLoad(), "Default aBikeLoad should be false.");
    assertFalse(transitVehicleStatus.isDoorOpen(), "Default doorOpen should be false.");
    assertFalse(transitVehicleStatus.isCharging(), "Default charging should be false.");
    assertFalse(transitVehicleStatus.isAtStopLine(), "Default atStopLine should be false.");
  }

  /**
   * Test the getter and setter for the loading flag.
   */
  @Test
  public void testSetIsLoading() {
    TransitVehicleStatus transitVehicleStatus = new TransitVehicleStatus();
    transitVehicleStatus.setLoading(true);
    assertTrue(transitVehicleStatus.isLoading(), "loading should be true after setting to true.");
    transitVehicleStatus.setLoading(false);
    assertFalse(transitVehicleStatus.isLoading(), "loading should be false after setting to false.");
  }

  /**
   * Test the getter and setter for the anADAuse flag.
   */
  @Test
  public void testSetIsAnADAuse() {
    TransitVehicleStatus transitVehicleStatus = new TransitVehicleStatus();
    transitVehicleStatus.setAnADAuse(true);
    assertTrue(transitVehicleStatus.isAnADAuse(), "anADAuse should be true after setting to true.");
    transitVehicleStatus.setAnADAuse(false);
    assertFalse(transitVehicleStatus.isAnADAuse(), "anADAuse should be false after setting to false.");
  }

  /**
   * Test the getter and setter for the aBikeLoad flag.
   */
  @Test
  public void testSetIsABikeLoad() {
    TransitVehicleStatus transitVehicleStatus = new TransitVehicleStatus();
    transitVehicleStatus.setABikeLoad(true);
    assertTrue(transitVehicleStatus.isABikeLoad(), "aBikeLoad should be true after setting to true.");
    transitVehicleStatus.setABikeLoad(false);
    assertFalse(transitVehicleStatus.isABikeLoad(), "aBikeLoad should be false after setting to false.");
  }

  /**
   * Test the getter and setter for the doorOpen flag.
   */
  @Test
  public void testSetIsDoorOpen() {
    TransitVehicleStatus transitVehicleStatus = new TransitVehicleStatus();
    transitVehicleStatus.setDoorOpen(true);
    assertTrue(transitVehicleStatus.isDoorOpen(), "doorOpen should be true after setting to true.");
    transitVehicleStatus.setDoorOpen(false);
    assertFalse(transitVehicleStatus.isDoorOpen(), "doorOpen should be false after setting to false.");
  }

  /**
   * Test the getter and setter for the charging flag.
   */
  @Test
  public void testSetIsCharging() {
    TransitVehicleStatus transitVehicleStatus = new TransitVehicleStatus();
    transitVehicleStatus.setCharging(true);
    assertTrue(transitVehicleStatus.isCharging(), "charging should be true after setting to true.");
    transitVehicleStatus.setCharging(false);
    assertFalse(transitVehicleStatus.isCharging(), "charging should be false after setting to false.");
  }

  /**
   * Test the getter and setter for the atStopLine flag.
   */
  @Test
  public void testSetIsAtStopLine() {
    TransitVehicleStatus transitVehicleStatus = new TransitVehicleStatus();
    transitVehicleStatus.setAtStopLine(true);
    assertTrue(transitVehicleStatus.isAtStopLine(), "atStopLine should be true after setting to true.");
    transitVehicleStatus.setAtStopLine(false);
    assertFalse(transitVehicleStatus.isAtStopLine(), "atStopLine should be false after setting to false.");
  }

  /**
   * Test setting multiple flags simultaneously and verifying that each one retains its value.
   */
  @Test
  public void testMultipleFlags() {
    TransitVehicleStatus transitVehicleStatus = new TransitVehicleStatus();
    transitVehicleStatus.setLoading(false);
    transitVehicleStatus.setAnADAuse(true);
    transitVehicleStatus.setABikeLoad(true);
    transitVehicleStatus.setDoorOpen(true);
    transitVehicleStatus.setCharging(false);
    transitVehicleStatus.setAtStopLine(false);

    assertFalse(transitVehicleStatus.isLoading(), "loading should be false.");
    assertTrue(transitVehicleStatus.isAnADAuse(), "anADAuse should be true.");
    assertTrue(transitVehicleStatus.isABikeLoad(), "aBikeLoad should be true.");
    assertTrue(transitVehicleStatus.isDoorOpen(), "doorOpen should be true.");
    assertFalse(transitVehicleStatus.isCharging(), "charging should be false.");
    assertFalse(transitVehicleStatus.isAtStopLine(), "atStopLine should be false.");
  }
}
