package us.dot.its.jpo.asn.j2735.r2024.TrafficSignalPhaseAndTiming;

import static net.javacrumbs.jsonunit.JsonMatchers.jsonEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.xmlunit.matchers.CompareMatcher.isIdenticalTo;

import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import us.dot.its.jpo.asn.j2735.r2024.BaseSerializeTest;
import us.dot.its.jpo.asn.j2735.r2024.PersonalSafetyMessage2.PersonalSafetyMessage2MessageFrame;

@Slf4j
public class TrafficSignalPhaseAndTimingMessageFrameTest
  extends BaseSerializeTest<TrafficSignalPhaseAndTimingMessageFrame> {

  public TrafficSignalPhaseAndTimingMessageFrameTest() {
    super(TrafficSignalPhaseAndTimingMessageFrame.class);
  }

  @Test
  public void canRoundTripXml() throws IOException {
    TrafficSignalPhaseAndTimingMessageFrame msg = fromXml(XER);
    assertThat(msg, notNullValue());
    final String roundTripXml = toXml(msg);
    assertThat(roundTripXml, isIdenticalTo(XER).ignoreWhitespace().ignoreWhitespace());
    log.debug(roundTripXml);
  }

  @Test
  public void canRoundTripJson() throws IOException {
    TrafficSignalPhaseAndTimingMessageFrame msg = fromJson(JER);
    assertThat(msg, notNullValue());
    final String roundTripJson = toJson(msg);
    assertThat(roundTripJson, jsonEquals(JER));
    log.debug(roundTripJson);
  }

  final static String XER = """
      <MessageFrame>
        <messageId>45</messageId>
        <value>
          <TrafficSignalPhaseAndTiming></TrafficSignalPhaseAndTiming>
        </value>
      </MessageFrame>
      """;

  final static String JER = """
      {
        "messageId": 45,
        "value": {
          "TrafficSignalPhaseAndTiming": null
        }
      }
      """;
}
