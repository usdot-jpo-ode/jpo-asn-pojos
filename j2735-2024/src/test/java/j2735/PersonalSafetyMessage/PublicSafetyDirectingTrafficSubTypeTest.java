package j2735.PersonalSafetyMessage;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

// Unit test generated with ChatGPT - just tests getters and setters for line coverage

/**
 * Unit tests for the PublicSafetyDirectingTrafficSubType class.
 */
public class PublicSafetyDirectingTrafficSubTypeTest {

  /**
   * Test that the default state of each flag is false.
   */
  @Test
  public void testDefaultState() {
    PublicSafetyDirectingTrafficSubType state = new PublicSafetyDirectingTrafficSubType();
    assertFalse(state.isUnavailable(), "Unavailable should default to false.");
    assertFalse(state.isPoliceAndTrafficOfficers(), "PoliceAndTrafficOfficers should default to false.");
    assertFalse(state.isTrafficControlPersons(), "TrafficControlPersons should default to false.");
    assertFalse(state.isRailroadCrossingGuards(), "RailroadCrossingGuards should default to false.");
    assertFalse(state.isCivilDefenseNationalGuardMilitaryPolice(), "CivilDefenseNationalGuardMilitaryPolice should default to false.");
    assertFalse(state.isEmergencyOrganizationPersonnel(), "EmergencyOrganizationPersonnel should default to false.");
    assertFalse(state.isHighwayServiceVehiclePersonnel(), "HighwayServiceVehiclePersonnel should default to false.");
  }

  /**
   * Test the getter and setter for the unavailable flag.
   */
  @Test
  public void testSetUnavailable() {
    PublicSafetyDirectingTrafficSubType state = new PublicSafetyDirectingTrafficSubType();
    state.setUnavailable(true);
    assertTrue(state.isUnavailable(), "Unavailable should be true after setting to true.");
    state.setUnavailable(false);
    assertFalse(state.isUnavailable(), "Unavailable should be false after setting to false.");
  }

  /**
   * Test the getter and setter for the policeAndTrafficOfficers flag.
   */
  @Test
  public void testSetPoliceAndTrafficOfficers() {
    PublicSafetyDirectingTrafficSubType state = new PublicSafetyDirectingTrafficSubType();
    state.setPoliceAndTrafficOfficers(true);
    assertTrue(state.isPoliceAndTrafficOfficers(), "PoliceAndTrafficOfficers should be true after setting to true.");
    state.setPoliceAndTrafficOfficers(false);
    assertFalse(state.isPoliceAndTrafficOfficers(), "PoliceAndTrafficOfficers should be false after setting to false.");
  }

  /**
   * Test the getter and setter for the trafficControlPersons flag.
   */
  @Test
  public void testSetTrafficControlPersons() {
    PublicSafetyDirectingTrafficSubType state = new PublicSafetyDirectingTrafficSubType();
    state.setTrafficControlPersons(true);
    assertTrue(state.isTrafficControlPersons(), "TrafficControlPersons should be true after setting to true.");
    state.setTrafficControlPersons(false);
    assertFalse(state.isTrafficControlPersons(), "TrafficControlPersons should be false after setting to false.");
  }

  /**
   * Test the getter and setter for the railroadCrossingGuards flag.
   */
  @Test
  public void testSetRailroadCrossingGuards() {
    PublicSafetyDirectingTrafficSubType state = new PublicSafetyDirectingTrafficSubType();
    state.setRailroadCrossingGuards(true);
    assertTrue(state.isRailroadCrossingGuards(), "RailroadCrossingGuards should be true after setting to true.");
    state.setRailroadCrossingGuards(false);
    assertFalse(state.isRailroadCrossingGuards(), "RailroadCrossingGuards should be false after setting to false.");
  }

  /**
   * Test the getter and setter for the civilDefenseNationalGuardMilitaryPolice flag.
   */
  @Test
  public void testSetCivilDefenseNationalGuardMilitaryPolice() {
    PublicSafetyDirectingTrafficSubType state = new PublicSafetyDirectingTrafficSubType();
    state.setCivilDefenseNationalGuardMilitaryPolice(true);
    assertTrue(state.isCivilDefenseNationalGuardMilitaryPolice(), "CivilDefenseNationalGuardMilitaryPolice should be true after setting to true.");
    state.setCivilDefenseNationalGuardMilitaryPolice(false);
    assertFalse(state.isCivilDefenseNationalGuardMilitaryPolice(), "CivilDefenseNationalGuardMilitaryPolice should be false after setting to false.");
  }

  /**
   * Test the getter and setter for the emergencyOrganizationPersonnel flag.
   */
  @Test
  public void testSetEmergencyOrganizationPersonnel() {
    PublicSafetyDirectingTrafficSubType state = new PublicSafetyDirectingTrafficSubType();
    state.setEmergencyOrganizationPersonnel(true);
    assertTrue(state.isEmergencyOrganizationPersonnel(), "EmergencyOrganizationPersonnel should be true after setting to true.");
    state.setEmergencyOrganizationPersonnel(false);
    assertFalse(state.isEmergencyOrganizationPersonnel(), "EmergencyOrganizationPersonnel should be false after setting to false.");
  }

  /**
   * Test the getter and setter for the highwayServiceVehiclePersonnel flag.
   */
  @Test
  public void testSetHighwayServiceVehiclePersonnel() {
    PublicSafetyDirectingTrafficSubType state = new PublicSafetyDirectingTrafficSubType();
    state.setHighwayServiceVehiclePersonnel(true);
    assertTrue(state.isHighwayServiceVehiclePersonnel(), "HighwayServiceVehiclePersonnel should be true after setting to true.");
    state.setHighwayServiceVehiclePersonnel(false);
    assertFalse(state.isHighwayServiceVehiclePersonnel(), "HighwayServiceVehiclePersonnel should be false after setting to false.");
  }

  /**
   * Test setting multiple flags simultaneously and verifying each one.
   */
  @Test
  public void testMultipleFlags() {
    PublicSafetyDirectingTrafficSubType state = new PublicSafetyDirectingTrafficSubType();
    state.setUnavailable(true);
    state.setPoliceAndTrafficOfficers(true);
    state.setTrafficControlPersons(false);
    state.setRailroadCrossingGuards(true);
    state.setCivilDefenseNationalGuardMilitaryPolice(false);
    state.setEmergencyOrganizationPersonnel(true);
    state.setHighwayServiceVehiclePersonnel(false);

    assertTrue(state.isUnavailable(), "Unavailable should be true.");
    assertTrue(state.isPoliceAndTrafficOfficers(), "PoliceAndTrafficOfficers should be true.");
    assertFalse(state.isTrafficControlPersons(), "TrafficControlPersons should be false.");
    assertTrue(state.isRailroadCrossingGuards(), "RailroadCrossingGuards should be true.");
    assertFalse(state.isCivilDefenseNationalGuardMilitaryPolice(), "CivilDefenseNationalGuardMilitaryPolice should be false.");
    assertTrue(state.isEmergencyOrganizationPersonnel(), "EmergencyOrganizationPersonnel should be true.");
    assertFalse(state.isHighwayServiceVehiclePersonnel(), "HighwayServiceVehiclePersonnel should be false.");
  }
}
