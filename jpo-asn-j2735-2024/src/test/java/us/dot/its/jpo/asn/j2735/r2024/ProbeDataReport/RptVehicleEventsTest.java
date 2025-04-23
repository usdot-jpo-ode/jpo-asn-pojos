package us.dot.its.jpo.asn.j2735.r2024.ProbeDataReport;

import static net.javacrumbs.jsonunit.JsonMatchers.jsonEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.xmlunit.matchers.CompareMatcher.isIdenticalTo;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.dot.its.jpo.asn.j2735.r2024.BaseSerializeTest;

public class RptVehicleEventsTest extends BaseSerializeTest<RptVehicleEvents> {

  public RptVehicleEventsTest() {
    super(RptVehicleEvents.class);
  }

  @ParameterizedTest
  @MethodSource("xmlValues")
  public void canRoundTripXml(final String xer) throws IOException {
    RptVehicleEvents msg = fromXml(xer);
    assertThat(msg, notNullValue());
    final String roundTripXml = toXml(msg);
    assertThat(roundTripXml,
        isIdenticalTo(xer).ignoreWhitespace().ignoreElementContentWhitespace());
  }

  @ParameterizedTest
  @MethodSource("jsonValues")
  public void canRoundTripJson(final String jer) throws IOException {
    RptVehicleEvents msg = fromJson(jer);
    assertThat(msg, notNullValue());
    final String roundTripJson = toJson(msg);
    assertThat(roundTripJson, jsonEquals(jer));
  }

  static Stream<Arguments> xmlValues() {
    return Arrays.stream(nullChoices()).map(choice -> Arguments.of(wrapXml(choice)));
  }

  static Stream<Arguments> jsonValues() {
    return Arrays.stream(nullChoices()).map(choice -> Arguments.of(wrapJson(choice)));
  }

  static String[] nullChoices() {
    return new String[]{
        "headLights",
        "fogLights",
        "hazardLights",
        "wiperStatusChange",
        "lowSpeed",
        "resumedSpeed",
        "vehEntrsExitsRegion",
        "emerVehDetect",
        "emerVehLightBar",
        "reqTspEvp",
        "transitVehPassCnt",
        "transitVehDoor",
        "v2xMsgRecption"
    };
  }

  static String wrapXml(String name) {
    return String.format("<RptVehicleEvents><%s></%s></RptVehicleEvents>", name, name);
  }

  static String wrapJson(String name) {
    return String.format("""
        {"%s": null}
        """, name);
  }
}
