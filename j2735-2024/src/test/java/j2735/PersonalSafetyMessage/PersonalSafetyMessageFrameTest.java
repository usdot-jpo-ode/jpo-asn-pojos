package j2735.PersonalSafetyMessage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.notNullValue;

import j2735.BaseSerializeTest;
import j2735.MessageFrame.DSRCmsgID;
import java.io.IOException;
import org.junit.jupiter.api.Test;

public class PersonalSafetyMessageFrameTest extends BaseSerializeTest<PersonalSafetyMessageMessageFrame> {

  public PersonalSafetyMessageFrameTest() {
    super(PersonalSafetyMessageMessageFrame.class);
  }

  @Test
  public void xmlDeserialize_generatedXml() throws IOException {
    PersonalSafetyMessageMessageFrame pmf = fromXml(loadResource("/j2735/PersonalSafetyMessage/xml/GeneratedPsmMessageFrame.xml"));
    assertThat(pmf, notNullValue());
    assertThat(pmf, hasProperty("messageId", equalTo(new DSRCmsgID(32))));
  }
}
