package us.dot.its.jpo.asn.j2735.r2024.SPAT;

import static net.javacrumbs.jsonunit.JsonMatchers.jsonEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.xmlunit.matchers.CompareMatcher.isIdenticalTo;

import java.io.IOException;
import org.junit.jupiter.api.Test;
import us.dot.its.jpo.asn.j2735.r2024.BaseSerializeTest;

public class ConnectionManeuverAssist_WithRegionalExtensionTest
  extends BaseSerializeTest<ConnectionManeuverAssist> {

  public ConnectionManeuverAssist_WithRegionalExtensionTest() {
    super(ConnectionManeuverAssist.class);
  }

  @Test
  public void canRoundTripXml() throws IOException {
    final String xml = loadResource("/us/dot/its/jpo/asn/j2735/r2024/SPAT/regional/ConnectionManeuverAssist_regional.xml");
    ConnectionManeuverAssist msg = fromXml(xml);
    assertThat("null", msg, notNullValue());
    assertThat("regional field null", msg.getRegional(), notNullValue());
    final String roundTripXml = toXml(msg);
    assertThat(roundTripXml, isIdenticalTo(xml).ignoreWhitespace().ignoreElementContentWhitespace());
  }

  @Test
  public void canRoundTripJson() throws IOException {
    final String json = loadResource("/us/dot/its/jpo/asn/j2735/r2024/SPAT/regional/ConnectionManeuverAssist_regional.json");
    ConnectionManeuverAssist msg = fromJson(json);
    assertThat("null", msg, notNullValue());
    assertThat("regional field null", msg.getRegional(), notNullValue());
    final String  roundTripJson = toJson(msg);
    assertThat(roundTripJson, jsonEquals(json));
  }
}
