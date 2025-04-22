package us.dot.its.jpo.asn.j2735.r2024.PersonalSafetyMessage2;

import static net.javacrumbs.jsonunit.JsonMatchers.jsonEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.xmlunit.matchers.CompareMatcher.isIdenticalTo;

import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import us.dot.its.jpo.asn.j2735.r2024.BaseSerializeTest;

@Slf4j
public class PersonalSafetyMessage2MessageFrameTest extends
    BaseSerializeTest<PersonalSafetyMessage2MessageFrame> {

  public PersonalSafetyMessage2MessageFrameTest() {
    super(PersonalSafetyMessage2MessageFrame.class);
  }

  @Test
  public void canRoundTripXml() throws IOException {
    PersonalSafetyMessage2MessageFrame msg = fromXml(XER);
    assertThat(msg, notNullValue());
    final String roundTripXml = toXml(msg);
    assertThat(roundTripXml, isIdenticalTo(XER).ignoreWhitespace().ignoreWhitespace());
    log.info(roundTripXml);
  }

  @Test
  public void canRoundTripJson() throws IOException {
    PersonalSafetyMessage2MessageFrame msg = fromJson(JER);
    assertThat(msg, notNullValue());
    final String roundTripJson = toJson(msg);
    assertThat(roundTripJson, jsonEquals(JER));
    log.info(roundTripJson);
  }

  final static String XER = """
      <MessageFrame>
        <messageId>44</messageId>
        <value>
          <PersonalSafetyMessage2></PersonalSafetyMessage2>
        </value>
      </MessageFrame>
      """;

  final static String JER = """
      {
        "messageId": 44,
        "value": {
          "PersonalSafetyMessage2": null
        }
      }
      """;


}
