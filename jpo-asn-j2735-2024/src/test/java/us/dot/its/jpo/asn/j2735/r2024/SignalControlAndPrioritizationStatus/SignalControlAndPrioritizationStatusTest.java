package us.dot.its.jpo.asn.j2735.r2024.SignalControlAndPrioritizationStatus;

import static net.javacrumbs.jsonunit.JsonMatchers.jsonEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.xmlunit.matchers.CompareMatcher.isIdenticalTo;

import java.io.IOException;
import org.junit.jupiter.api.Test;
import us.dot.its.jpo.asn.j2735.r2024.BaseSerializeTest;

public class SignalControlAndPrioritizationStatusTest
  extends BaseSerializeTest<SignalControlAndPrioritizationStatus> {

  public SignalControlAndPrioritizationStatusTest() {
    super(SignalControlAndPrioritizationStatus.class);
  }

  @Test
  public void canRoundTripXml() throws IOException {
    SignalControlAndPrioritizationStatus msg = fromXml(XER);
    assertThat(msg, notNullValue());
    final String roundTripXml = toXml(msg);
    assertThat(roundTripXml, isIdenticalTo(XER).ignoreWhitespace().ignoreWhitespace());
  }

  @Test
  public void canRoundTripJson() throws IOException {
    SignalControlAndPrioritizationStatus msg = fromJson(JER);
    assertThat(msg, notNullValue());
    final String roundTripJson = toJson(msg);
    assertThat(roundTripJson, jsonEquals(JER));
  }

  final static String XER = "<SignalControlAndPrioritizationStatus></SignalControlAndPrioritizationStatus>";
  final static String JER = "null";
}
