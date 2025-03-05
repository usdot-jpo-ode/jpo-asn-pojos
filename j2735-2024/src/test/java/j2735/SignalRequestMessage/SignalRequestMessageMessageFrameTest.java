package j2735.SignalRequestMessage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.xmlunit.matchers.CompareMatcher.isIdenticalTo;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import j2735.BaseSerializeTest;

/**
 * Unit tests for the SignalRequestMessageMessageFrame class.
 */
public class SignalRequestMessageMessageFrameTest extends BaseSerializeTest<SignalRequestMessageMessageFrame> {

  public SignalRequestMessageMessageFrameTest() {
    super(SignalRequestMessageMessageFrame.class);
  }

  @Test
  public void xmlDeserialize_generatedXml() throws IOException {
    final String xml = loadResource("/j2735/SignalRequestMessage/xml/message_frame/srm_mf.xml");
    SignalRequestMessageMessageFrame srmmf = fromXml(xml);
    assertThat(srmmf, notNullValue());
    final String roundTripXml = toXml(srmmf);
    assertThat(roundTripXml, isIdenticalTo(xml).ignoreWhitespace().ignoreElementContentWhitespace());
  }
}
