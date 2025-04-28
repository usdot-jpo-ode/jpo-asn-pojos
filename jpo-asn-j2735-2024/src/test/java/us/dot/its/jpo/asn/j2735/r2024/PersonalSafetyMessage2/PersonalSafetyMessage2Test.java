package us.dot.its.jpo.asn.j2735.r2024.PersonalSafetyMessage2;

import static net.javacrumbs.jsonunit.JsonMatchers.jsonEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.xmlunit.matchers.CompareMatcher.isIdenticalTo;

import java.io.IOException;
import org.junit.jupiter.api.Test;
import us.dot.its.jpo.asn.j2735.r2024.BaseSerializeTest;

public class PersonalSafetyMessage2Test extends BaseSerializeTest<PersonalSafetyMessage2> {

  public PersonalSafetyMessage2Test() {
    super(PersonalSafetyMessage2.class);
  }

  @Test
  public void canRoundTripXml() throws IOException {
    PersonalSafetyMessage2 msg = fromXml(XER);
    assertThat(msg, notNullValue());
    final String roundTripXml = toXml(msg);
    assertThat(roundTripXml, isIdenticalTo(XER).ignoreWhitespace().ignoreWhitespace());
  }

  @Test
  public void canRoundTripJson() throws IOException {
    PersonalSafetyMessage2 msg = fromJson(JER);
    assertThat(msg, notNullValue());
    final String roundTripJson = toJson(msg);
    assertThat(roundTripJson, jsonEquals(JER));
  }

  final static String XER = "<PersonalSafetyMessage2></PersonalSafetyMessage2>";
  final static String JER = "null";

}
