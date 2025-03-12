package j2735.TravelerInformation;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.xmlunit.matchers.CompareMatcher.isIdenticalTo;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import j2735.BaseSerializeTest;

/**
 * Unit tests for the TravelerInformationMessageFrame class.
 */
public class TravelerInformationMessageFrameTest extends BaseSerializeTest<TravelerInformationMessageFrame> {

  public TravelerInformationMessageFrameTest() {
    super(TravelerInformationMessageFrame.class);
  }

  @Test
  public void xmlDeserialize_generatedXml() throws IOException {
    final String xml = loadResource("/j2735/TravelerInformation/xml/message_frame/tim_mf.xml");
    TravelerInformationMessageFrame timmf = fromXml(xml);
    assertThat(timmf, notNullValue());
    final String roundTripXml = toXml(timmf);
    assertThat(roundTripXml, isIdenticalTo(xml).ignoreWhitespace().ignoreElementContentWhitespace());
  }
}
