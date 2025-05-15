package us.dot.its.jpo.asn.j2735.r2024.RoadGeometryAndAttributes;

import static net.javacrumbs.jsonunit.JsonMatchers.jsonEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.xmlunit.matchers.CompareMatcher.isIdenticalTo;

import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import us.dot.its.jpo.asn.j2735.r2024.BaseSerializeTest;

@Slf4j
public class RoadGeometryAndAttributesMessageFrameTest
 extends BaseSerializeTest<RoadGeometryAndAttributesMessageFrame> {

  public RoadGeometryAndAttributesMessageFrameTest() {
    super(RoadGeometryAndAttributesMessageFrame.class);
  }

  @Test
  public void canRoundTripXml() throws IOException {
    RoadGeometryAndAttributesMessageFrame msg = fromXml(XER);
    assertThat(msg, notNullValue());
    final String roundTripXml = toXml(msg);
    assertThat(roundTripXml, isIdenticalTo(XER).ignoreWhitespace().ignoreWhitespace());
    log.debug(roundTripXml);
  }

  @Test
  public void canRoundTripJson() throws IOException {
    RoadGeometryAndAttributesMessageFrame msg = fromJson(JER);
    assertThat(msg, notNullValue());
    final String roundTripJson = toJson(msg);
    assertThat(roundTripJson, jsonEquals(JER));
    log.debug(roundTripJson);
  }

  final static String XER = """
      <MessageFrame>
        <messageId>43</messageId>
        <value>
          <RoadGeometryAndAttributes></RoadGeometryAndAttributes>
        </value>
      </MessageFrame>
      """;

  final static String JER = """
      {
        "messageId": 43,
        "value": {
          "RoadGeometryAndAttributes": null
        }
      }
      """;
}
