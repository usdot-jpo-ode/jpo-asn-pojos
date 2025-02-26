package j2735.PersonalSafetyMessage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

import j2735.BaseSerializeTest;
import java.io.IOException;
import org.junit.jupiter.api.Test;

public class PersonalSafetyMessageTest extends BaseSerializeTest<PersonalSafetyMessage> {

  public PersonalSafetyMessageTest() {
    super(PersonalSafetyMessage.class);
  }

  @Test
  public void xmlDeserialize_generatedXml() throws IOException {
    PersonalSafetyMessage psm = fromXml(loadResource("/j2735/PersonalSafetyMessage/xml/GeneratedPsm.xml"));
    assertThat(psm, notNullValue());

    String json = toJson(psm);
    System.out.println(json);
  }

  @Test
  public void xmlDeserialize_generatedXml_2() throws IOException {
    PersonalSafetyMessage psm = fromXml(loadResource("/j2735/PersonalSafetyMessage/xml/GeneratedPsm2.xml"));
    assertThat(psm, notNullValue());

    String json = toJson(psm);
    System.out.println(json);
  }

  @Test
  public void xmlDeserialize_generatedXml_erlang() throws IOException {
    PersonalSafetyMessage psm = fromXml(loadResource("/j2735/PersonalSafetyMessage/xml/GeneratedPsmErlang.xml"));
    assertThat(psm, notNullValue());

    String json = toJson(psm);
    System.out.println(json);
  }

  @Test
  public void xmlDeserialize_generatedXml_erlang_motor() throws IOException {
    PersonalSafetyMessage psm = fromXml(loadResource("/j2735/PersonalSafetyMessage/xml/GeneratedPsmErlangMotor.xml"));
    assertThat(psm, notNullValue());

    String json = toJson(psm);
    System.out.println(json);
  }

  @Test
  public void jsonDeserialize_generatedJson_erlang() throws IOException {
    PersonalSafetyMessage psm = fromJson(loadResource("/j2735/PersonalSafetyMessage/json/GeneratedPsmErlang.json"));
    assertThat(psm, notNullValue());

    String json = toJson(psm);
    System.out.println(json);
  }
}
