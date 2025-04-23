package us.dot.its.jpo.asn.j2735.r2024.SignalControlAndPrioritizationRequest;

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
public class SignalControlAndPrioritizationRequestMessageFrameTest
  extends BaseSerializeTest<SignalControlAndPrioritizationRequestMessageFrame> {

  public SignalControlAndPrioritizationRequestMessageFrameTest() {
    super(SignalControlAndPrioritizationRequestMessageFrame.class);
  }

  @Test
  public void canRoundTripXml() throws IOException {
    SignalControlAndPrioritizationRequestMessageFrame msg = fromXml(XER);
    assertThat(msg, notNullValue());
    final String roundTripXml = toXml(msg);
    assertThat(roundTripXml, isIdenticalTo(XER).ignoreWhitespace().ignoreWhitespace());
    log.debug(roundTripXml);
  }

  @Test
  public void canRoundTripJson() throws IOException {
    SignalControlAndPrioritizationRequestMessageFrame msg = fromJson(JER);
    assertThat(msg, notNullValue());
    final String roundTripJson = toJson(msg);
    assertThat(roundTripJson, jsonEquals(JER));
    log.debug(roundTripJson);
  }

  final static String XER = """
      <MessageFrame>
        <messageId>46</messageId>
        <value>
          <SignalControlAndPrioritizationRequest></SignalControlAndPrioritizationRequest>
        </value>
      </MessageFrame>
      """;

  final static String JER = """
      {
        "messageId": 46,
        "value": {
          "SignalControlAndPrioritizationRequest": null
        }
      }
      """;
}
