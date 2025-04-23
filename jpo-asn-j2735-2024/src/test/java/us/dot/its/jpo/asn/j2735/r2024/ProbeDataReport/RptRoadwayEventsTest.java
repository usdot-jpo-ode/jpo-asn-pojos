package us.dot.its.jpo.asn.j2735.r2024.ProbeDataReport;

import static net.javacrumbs.jsonunit.JsonMatchers.jsonEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.xmlunit.matchers.CompareMatcher.isIdenticalTo;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.dot.its.jpo.asn.j2735.r2024.BaseSerializeTest;

// RptRoadwayEvents uses Asn1Nulls for CHOICEs
@Slf4j
public class RptRoadwayEventsTest extends BaseSerializeTest<RptRoadwayEvents> {

  public RptRoadwayEventsTest() {
    super(RptRoadwayEvents.class);
  }

  @ParameterizedTest
  @MethodSource("xmlValues")
  public void canRoundTripXml(final String xer) throws IOException {
    log.debug("canRoundTripXml {}", xer);
    RptRoadwayEvents msg = fromXml(xer);
    assertThat(msg, notNullValue());
    final String roundTripXml = toXml(msg);
    assertThat(roundTripXml,
        isIdenticalTo(xer).ignoreWhitespace().ignoreElementContentWhitespace());
  }

  @ParameterizedTest
  @MethodSource("jsonValues")
  public void canRoundTripJson(final String jer) throws IOException {
    log.debug("canRoundTripJson {}", jer);
    RptRoadwayEvents msg = fromJson(jer);
    assertThat(msg, notNullValue());
    final String roundTripJson = toJson(msg);
    assertThat(roundTripJson, jsonEquals(jer));
  }

  static Stream<Arguments> xmlValues() {
    var nullChoiceStream = Arrays.stream(nullChoices())
        .map(choice -> Arguments.of(wrapXml(choice)));
    return Stream.concat(nullChoiceStream,
        Stream.of(
            Arguments.of("""
                <RptRoadwayEvents>
                  <adverseRoadSurface>
                    <meanVerticalVariation>4968</meanVerticalVariation>
                    <verticalVariationStdDev>4493</verticalVariationStdDev>
                    <meanHorizontalVariation>13712</meanHorizontalVariation>
                    <horizontalVariationStdDev>4731</horizontalVariationStdDev>
                  </adverseRoadSurface>
                </RptRoadwayEvents>
                """),
            Arguments.of("""
                <RptRoadwayEvents>
                  <trfsigEncounters>
                    <intersectionID>48835</intersectionID>
                    <trafficMetrics><trfsigApproachDelay></trfsigApproachDelay></trafficMetrics>
                  </trfsigEncounters>
                </RptRoadwayEvents>
                """)
        )
    );
  }

  static Stream<Arguments> jsonValues() {
    var nullChoiceStream = Arrays.stream(nullChoices())
        .map(choice -> Arguments.of(wrapJson(choice)));
    return Stream.concat(nullChoiceStream,
        Stream.of(
            Arguments.of("""
                {
                  "adverseRoadSurface": {
                    "meanVerticalVariation": 4968,
                    "verticalVariationStdDev": 4493,
                    "meanHorizontalVariation": 13712,
                    "horizontalVariationStdDev": 4731
                  }
                }
                """),
            Arguments.of("""
                {
                  "trfsigEncounters": {
                    "intersectionID": 48835,
                    "trafficMetrics": {
                      "trfsigApproachDelay": null
                    }
                  }
                }
                """)
        ));
  }

  static String[] nullChoices() {
    return new String[]{
        "obstacleDetected",
        "trfsigLightOut",
        "trfsigRoadGeoMismatch",
        "roadsignDetection",
        "lowRoadsignReflect",
        "lowLaneMarkReflect",
        "roadsignIncnstncy",
        "laneGeoIncnstncy",
        "incidentDetect",
        "workZoneCharDetect",
        "inclWeatherDetect",
        "railrdCrossActiv",
        "drawBridgeActiv"
    };
  }

  static String wrapXml(String name) {
    return String.format("<RptRoadwayEvents><%s></%s></RptRoadwayEvents>", name, name);
  }

  static String wrapJson(String name) {
    return String.format("""
        {"%s": null}
        """, name);
  }
}
