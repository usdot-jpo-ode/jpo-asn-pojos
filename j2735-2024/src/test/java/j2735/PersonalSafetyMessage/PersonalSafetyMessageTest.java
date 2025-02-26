package j2735.PersonalSafetyMessage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.is;

import j2735.BaseSerializeTest;
import j2735.Common.DSecond;
import j2735.Common.MsgCount;
import j2735.Common.TemporaryID;

import java.io.IOException;
import org.junit.jupiter.api.Test;

public class PersonalSafetyMessageTest extends BaseSerializeTest<PersonalSafetyMessage> {

  public PersonalSafetyMessageTest() {
    super(PersonalSafetyMessage.class);
  }

  @Test
  public void xmlDeserialize_generatedXml_basicDeserialization() throws IOException {
    PersonalSafetyMessage psm = fromXml(loadResource("/j2735/PersonalSafetyMessage/xml/GeneratedPsm.xml"));
    assertThat(psm, notNullValue());
  }

  @Test
  public void serializeDeserialize_humanPropelledType() throws IOException {
    PersonalSafetyMessage psm = new PersonalSafetyMessage();
    
    HumanPropelledType humanType = HumanPropelledType.PUSHORKICKSCOOTER;
    PropelledInformation propelledInformation = new PropelledInformation();
    propelledInformation.setHuman(humanType);
    psm.setPropulsion(propelledInformation);

    // Test XML serialization
    String xml = toXml(psm);
    PersonalSafetyMessage deserializedFromXml = fromXml(xml);
    assertThat(deserializedFromXml.getPropulsion().getHuman(), is(humanType));

    // Test JSON serialization
    String json = toJson(psm);
    PersonalSafetyMessage deserializedFromJson = fromJson(json);
    assertThat(deserializedFromJson.getPropulsion().getHuman(), is(humanType));
  }

  @Test
  public void serializeDeserialize_motorizedPropelledType() throws IOException {
    PersonalSafetyMessage psm = new PersonalSafetyMessage();
    
    MotorizedPropelledType motorType = MotorizedPropelledType.SELFBALANCINGDEVICE;
    PropelledInformation propelledInformation = new PropelledInformation();
    propelledInformation.setMotor(motorType);
    psm.setPropulsion(propelledInformation);

    // Test XML serialization
    String xml = toXml(psm);
    PersonalSafetyMessage deserializedFromXml = fromXml(xml);
    assertThat(deserializedFromXml.getPropulsion().getMotor(), is(motorType));

    // Test JSON serialization
    String json = toJson(psm);
    PersonalSafetyMessage deserializedFromJson = fromJson(json);
    assertThat(deserializedFromJson.getPropulsion().getMotor(), is(motorType));
  }

  @Test
  public void serializeDeserialize_animalPropelledType() throws IOException {
    PersonalSafetyMessage psm = new PersonalSafetyMessage();
    
    AnimalPropelledType animalType = AnimalPropelledType.ANIMALDRAWNCARRIAGE;
    PropelledInformation propelledInformation = new PropelledInformation();
    propelledInformation.setAnimal(animalType);
    psm.setPropulsion(propelledInformation);

    // Test XML serialization
    String xml = toXml(psm);
    PersonalSafetyMessage deserializedFromXml = fromXml(xml);
    assertThat(deserializedFromXml.getPropulsion().getAnimal(), is(animalType));

    // Test JSON serialization
    String json = toJson(psm);
    PersonalSafetyMessage deserializedFromJson = fromJson(json);
    assertThat(deserializedFromJson.getPropulsion().getAnimal(), is(animalType));
  }

  @Test
  public void jsonDeserialize_generatedJson() throws IOException {
    PersonalSafetyMessage psm = fromJson(loadResource("/j2735/PersonalSafetyMessage/json/GeneratedPsm.json"));
    assertThat(psm, notNullValue());

    String json = toJson(psm);
    System.out.println(json);
  }

  @Test
  public void roundTripSerialization_withHumanPropulsion() throws IOException {
    PersonalSafetyMessage original = new PersonalSafetyMessage();
    PropelledInformation propInfo = new PropelledInformation();
    propInfo.setHuman(HumanPropelledType.PUSHORKICKSCOOTER);
    original.setPropulsion(propInfo);

    // Serialize to JSON and back
    String json = toJson(original);
    PersonalSafetyMessage deserialized = fromJson(json);

    // Verify
    assertThat(deserialized.getPropulsion().getHuman(), is(HumanPropelledType.PUSHORKICKSCOOTER));
    assertThat(deserialized.getPropulsion().getMotor(), is((MotorizedPropelledType) null));
    assertThat(deserialized.getPropulsion().getAnimal(), is((AnimalPropelledType) null));
  }

  @Test
  public void xmlSerialization_nullPropulsion() throws IOException {
    PersonalSafetyMessage psm = new PersonalSafetyMessage();
    psm.setPropulsion(null);

    String xml = toXml(psm);
    PersonalSafetyMessage deserialized = fromXml(xml);
    
    assertThat(deserialized.getPropulsion(), is((PropelledInformation) null));
  }

  @Test
  public void jsonSerialization_emptyPropelledInfo() throws IOException {
    PersonalSafetyMessage psm = new PersonalSafetyMessage();
    PropelledInformation emptyPropInfo = new PropelledInformation();
    psm.setPropulsion(emptyPropInfo);

    String json = toJson(psm);
    PersonalSafetyMessage deserialized = fromJson(json);
    
    assertThat(deserialized.getPropulsion(), notNullValue());
    assertThat(deserialized.getPropulsion().getHuman(), is((HumanPropelledType) null));
    assertThat(deserialized.getPropulsion().getMotor(), is((MotorizedPropelledType) null));
    assertThat(deserialized.getPropulsion().getAnimal(), is((AnimalPropelledType) null));
  }

  @Test
  public void roundTripSerialization_allFieldsPopulated() throws IOException {
    PersonalSafetyMessage original = new PersonalSafetyMessage();
    
    // Set all available fields
    original.setBasicType(PersonalDeviceUserType.APEDESTRIAN);
    original.setSecMark(new DSecond(1234));
    original.setMsgCnt(new MsgCount(99));
    original.setId(new TemporaryID("12341234"));
    
    PropelledInformation propInfo = new PropelledInformation();
    propInfo.setMotor(MotorizedPropelledType.WHEELCHAIR);
    original.setPropulsion(propInfo);

    // Serialize to XML and back
    String xml = toXml(original);
    PersonalSafetyMessage fromXml = fromXml(xml);

    // Verify all fields
    assertThat(fromXml.getBasicType(), is(PersonalDeviceUserType.APEDESTRIAN));
    assertThat(fromXml.getSecMark().getValue(), is(1234L));
    assertThat(fromXml.getMsgCnt().getValue(), is(99L));
    assertThat(fromXml.getId().getValue(), is("12341234"));
    assertThat(fromXml.getPropulsion().getMotor(), is(MotorizedPropelledType.WHEELCHAIR));
  }
}
