package us.dot.its.jpo.asn.j2735.r2024.J2540ITIS;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import us.dot.its.jpo.asn.j2735.r2024.BaseNamedIntegerTest;
import us.dot.its.jpo.asn.runtime.types.Asn1Integer;


public class J2540ITISNamedIntegerTests {

  @Test
  public void testLargeNumbers() {
    var test = new BaseNamedIntegerTest<>(LargeNumbers.class);
    test.nameTest(11531L, "n300");
  }

  @Test
  public void testQualifiers() {
    var test = new BaseNamedIntegerTest<>(Qualifiers.class);
    test.namesTest("above", "below");
  }

  @Test
  public void testRoadsideAssets() {
    var test = new BaseNamedIntegerTest<>(RoadsideAssets.class);
    test.namesTest("utility-pole", "cones");
  }

  @Test
  public void testIncidentResponseEquipment() {
    var test = new BaseNamedIntegerTest<>(IncidentResponseEquipment.class);
    test.namesTest("ground-fire-suppression");
  }

  @Test
  public void testMUTCDLocations() {
    var test = new BaseNamedIntegerTest<>(MUTCDLocations.class);
    test.namesTest("right-arrow");
  }

  @Test
  public void testRecreationalObjectsAndActivities() {
    var test = new BaseNamedIntegerTest<>(RecreationalObjectsAndActivities.class);
    test.nameTest(12055L, "rock-climbing");
  }

  @Test
  public void testUnits() {
    var test = new BaseNamedIntegerTest<>(Units.class);
    test.nameTest(8712L, "miles");
  }

  @Test
  public void testLaneRoadway() {
    var test = new BaseNamedIntegerTest<>(LaneRoadway.class);
    test.nameTest(8197L, "center-lane");
  }

  @Test
  public void testStatesAndTerritories() {
    var test = new BaseNamedIntegerTest<>(StatesAndTerritories.class);
    test.namesTest("colorado", "wyoming", "utah");
  }

  // For the remaining types, just test that they have some named values
  @ParameterizedTest
  @MethodSource("namedIntegerTypes")
  public <T extends Asn1Integer> void testType(Class<T> clazz) {
    var test = new BaseNamedIntegerTest<>(clazz);
    Set<String> names = test.names();
    assertThat(names, hasSize(greaterThan(0)));
    Set<Long> values = test.namedValues();
    assertThat(values, hasSize(greaterThan(0)));
    String firstName = names.iterator().next();
    Optional<T> named = test.named(firstName);
    assertTrue(named.isPresent());
    assertTrue(named.get().name().isPresent());
    assertThat(named.get().name().get(), equalTo(firstName));
  }

  public static Stream<Arguments> namedIntegerTypes() {
    Class<?>[] classes = {
        PavementConditions.class,
        Objects.class,
        TransitOperations.class,
        AccidentsAndIncidents.class,
        WarningAdvice.class,
        VehicleGroupAffected.class,
        Roadwork.class,
        RegulatoryAndWarningSigns.class,
        RestrictionClass.class,
        DeviceStatus.class,
        Obstruction.class,
        Disturbances.class,
        AdviceInstructionsRecommendations.class,
        DelayStatusCancellation.class,
        VisibilityAndAirQuality.class,
        ParkingInformation.class,
        Disasters.class,
        AdviceInstructionsMandatory.class,
        WeatherConditions.class,
        Structures.class,
        Precipitation.class,
        TransitMode.class,
        SportingEvents.class,
        NamedObjects.class,
        Temperature.class,
        AlternateRoute.class,
        SpecialEvents.class,
        SuggestionAdvice.class,
        MobileSituation.class,
        TrafficConditions.class,
        AssetStatus.class,
        Closures.class,
        IncidentResponseStatus.class,
        SystemInformation.class,
        Winds.class,
        TravelerGroupAffected.class,
        ResponderGroupAffected.class,
        WinterDrivingRestrictions.class,
        UnusualDriving.class,
        WinterDrivingIndex.class
    };
    return Arrays.stream(classes).map(Arguments::of);
  }


}
