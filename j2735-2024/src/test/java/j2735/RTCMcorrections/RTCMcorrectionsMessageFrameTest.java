package j2735.RTCMcorrections;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.xmlunit.matchers.CompareMatcher.isIdenticalTo;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import j2735.BaseSerializeTest;

/**
 * Unit tests for the RTCMcorrectionsMessageFrame class.
 */
public class RTCMcorrectionsMessageFrameTest extends BaseSerializeTest<RTCMcorrectionsMessageFrame> {
  
  public RTCMcorrectionsMessageFrameTest() {
    super(RTCMcorrectionsMessageFrame.class);
  }

  @Test
  public void xmlDeserialize_generatedXml() throws IOException {
    final String xml = loadResource("/j2735/RTCMcorrections/xml/message_frame/rtcm_mf.xml");
    RTCMcorrectionsMessageFrame rtcmmf = fromXml(xml);
    assertThat(rtcmmf, notNullValue());
    final String roundTripXml = toXml(rtcmmf);
    assertThat(roundTripXml, isIdenticalTo(xml).ignoreWhitespace().ignoreElementContentWhitespace());
  }
}
