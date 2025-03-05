package j2735.SignalStatusMessage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.xmlunit.matchers.CompareMatcher.isIdenticalTo;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import j2735.BaseSerializeTest;

/**
 * Unit tests for the SignalStatusMessageMessageFrame class.
 */
public class SignalStatusMessageMessageFrameTest extends BaseSerializeTest<SignalStatusMessageMessageFrame> {

  public SignalStatusMessageMessageFrameTest() {
    super(SignalStatusMessageMessageFrame.class);
  }

  @Test
  public void xmlDeserialize_generatedXml() throws IOException {
    final String xml = loadResource("/j2735/SignalStatusMessage/xml/message_frame/ssm_mf.xml");
    SignalStatusMessageMessageFrame ssmmf = fromXml(xml);
    assertThat(ssmmf, notNullValue());
    final String roundTripXml = toXml(ssmmf);
    assertThat(roundTripXml, isIdenticalTo(xml).ignoreWhitespace().ignoreElementContentWhitespace());
  }
}
