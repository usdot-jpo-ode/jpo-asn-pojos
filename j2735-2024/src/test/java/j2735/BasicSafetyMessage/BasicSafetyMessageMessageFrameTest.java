package j2735.BasicSafetyMessage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.xmlunit.matchers.CompareMatcher.isIdenticalTo;

import j2735.BaseSerializeTest;
import j2735.MessageFrame.MessageFrame;
import java.io.IOException;
import org.junit.jupiter.api.Test;

public class BasicSafetyMessageMessageFrameTest extends BaseSerializeTest<BasicSafetyMessageMessageFrame> {

  public BasicSafetyMessageMessageFrameTest() {
    super(BasicSafetyMessageMessageFrame.class);
  }

  @Test
  public void xmlRoundTripTest() throws IOException {
    final String xml = loadResource("/j2735/BasicSafetyMessage/xml/message_frame/bsm_noext_01.xml");
    BasicSafetyMessageMessageFrame bsmf = fromXml(xml);
    assertThat(bsmf, notNullValue());
    final String roundTripXml = toXml(bsmf);
    assertThat(roundTripXml, isIdenticalTo(xml).ignoreWhitespace().ignoreElementContentWhitespace());
  }
}
