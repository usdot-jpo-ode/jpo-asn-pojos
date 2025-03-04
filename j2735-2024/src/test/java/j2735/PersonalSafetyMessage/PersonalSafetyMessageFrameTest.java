package j2735.PersonalSafetyMessage;

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

public class PersonalSafetyMessageFrameTest extends BaseSerializeTest<PersonalSafetyMessageMessageFrame> {

  public PersonalSafetyMessageFrameTest() {
    super(PersonalSafetyMessageMessageFrame.class);
  }

  @Test
  public void xmlDeserialize_generatedXml() throws IOException {
    final String xml = loadResource("/j2735/PersonalSafetyMessage/xml/message_frame/psm_01.xml");
    PersonalSafetyMessageMessageFrame psmf = fromXml(xml);
    assertThat(psmf, notNullValue());
    final String roundTripXml = toXml(psmf);
    assertThat(roundTripXml, isIdenticalTo(xml).ignoreWhitespace().ignoreElementContentWhitespace());
  }
}
