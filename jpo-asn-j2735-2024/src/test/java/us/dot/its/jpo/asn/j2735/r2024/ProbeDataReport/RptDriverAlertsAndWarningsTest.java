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

public class RptDriverAlertsAndWarningsTest extends BaseSerializeTest<RptDriverAlertsAndWarnings> {

  public RptDriverAlertsAndWarningsTest() {
    super(RptDriverAlertsAndWarnings.class);
  }

  @ParameterizedTest
  @MethodSource("xmlValues")
  public void canRoundTripXml(final String xer) throws IOException {
    RptDriverAlertsAndWarnings msg = fromXml(xer);
    assertThat(msg, notNullValue());
    final String roundTripXml = toXml(msg);
    assertThat(roundTripXml,
        isIdenticalTo(xer).ignoreWhitespace().ignoreElementContentWhitespace());
  }

  @ParameterizedTest
  @MethodSource("jsonValues")
  public void canRoundTripJson(final String jer) throws IOException {
    RptDriverAlertsAndWarnings msg = fromJson(jer);
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
        "j2945Slash1Eebl",
        "j2945Slash1Fcw",
        "j2945Slash1BswLcw",
        "j2945Slash1Ima",
        "j2945Slash1Lta",
        "j2945Slash1Clw",
        "redLightViolationWarn",
        "emerVehAlert",
        "otherAlert",
        "otherWarning"
    };
  }

  static String wrapXml(String name) {
    return String.format("<RptDriverAlertsAndWarnings><%s></%s></RptDriverAlertsAndWarnings>", name, name);
  }

  static String wrapJson(String name) {
    return String.format("""
        {"%s": null}
        """, name);
  }
}
