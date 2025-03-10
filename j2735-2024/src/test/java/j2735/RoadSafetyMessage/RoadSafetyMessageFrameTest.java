package j2735.RoadSafetyMessage;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.notNullValue;
import static org.xmlunit.matchers.CompareMatcher.isIdenticalTo;
import static org.xmlunit.matchers.CompareMatcher.isSimilarTo;

import j2735.BaseSerializeTest;
import j2735.BasicSafetyMessage.BasicSafetyMessageMessageFrame;
import j2735.MessageFrame.DSRCmsgID;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.xmlunit.diff.DefaultNodeMatcher;
import org.xmlunit.diff.ElementSelectors;


public class RoadSafetyMessageFrameTest extends BaseSerializeTest<RoadSafetyMessageMessageFrame> {

  public RoadSafetyMessageFrameTest() {
    super(RoadSafetyMessageMessageFrame.class);
  }

  @Test
  public void xmlDeserialize_LenientTest() throws IOException {
    final String xml = loadResource("/j2735/RoadSafetyMessage/xml/message_frame/rsmf_1.xml");
    RoadSafetyMessageMessageFrame rsmf = fromXml(xml);
    assertThat(rsmf, notNullValue());
    final String roundTripXml = toXml(rsmf);
    assertThat("Lenient test: Ignore order of sequence-of mixed types",
        roundTripXml,
        isSimilarTo(xml).ignoreWhitespace().normalizeWhitespace()
            .withNodeMatcher(new DefaultNodeMatcher(
                ElementSelectors.byNameAndText
            )));
  }

  @Test
  public void xmlDeserialize_StrictTest() throws IOException {
    final String xml = loadResource("/j2735/RoadSafetyMessage/xml/message_frame/rsmf_1.xml");
    RoadSafetyMessageMessageFrame rsmf = fromXml(xml);
    assertThat(rsmf, notNullValue());
    final String roundTripXml = toXml(rsmf);
    assertThat("strict test: exact element order", roundTripXml,
        isIdenticalTo(xml).ignoreComments().ignoreWhitespace());
  }
}
