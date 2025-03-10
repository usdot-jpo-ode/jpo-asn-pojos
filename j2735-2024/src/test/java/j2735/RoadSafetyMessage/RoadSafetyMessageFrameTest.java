package j2735.RoadSafetyMessage;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.notNullValue;
import static org.xmlunit.matchers.CompareMatcher.isIdenticalTo;

import j2735.BaseSerializeTest;
import j2735.BasicSafetyMessage.BasicSafetyMessageMessageFrame;
import j2735.MessageFrame.DSRCmsgID;
import java.io.IOException;
import org.junit.jupiter.api.Test;


public class RoadSafetyMessageFrameTest extends BaseSerializeTest<RoadSafetyMessageMessageFrame> {

  public RoadSafetyMessageFrameTest() {
    super(RoadSafetyMessageMessageFrame.class);
  }

  @Test
  public void xmlDeserialize_generatedXml() throws IOException {
    final String xml = loadResource("/j2735/RoadSafetyMessage/xml/message_frame/rsm_01.xml");
    RoadSafetyMessageMessageFrame rsmf = fromXml(xml);
    assertThat(rsmf, notNullValue());
    final String roundTripXml = toXml(rsmf);
    assertThat(roundTripXml, isIdenticalTo(xml).ignoreWhitespace().ignoreElementContentWhitespace());
  }
}
