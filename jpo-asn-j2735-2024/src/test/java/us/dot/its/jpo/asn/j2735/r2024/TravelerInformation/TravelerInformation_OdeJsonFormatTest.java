package us.dot.its.jpo.asn.j2735.r2024.TravelerInformation;

import static net.javacrumbs.jsonunit.JsonMatchers.jsonEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import us.dot.its.jpo.asn.j2735.r2024.BaseSerializeTest;
import us.dot.its.jpo.asn.runtime.serialization.OdeCustomJsonMapper;

public class TravelerInformation_OdeJsonFormatTest extends BaseSerializeTest<Void> {

  final static ObjectMapper customMapper = new OdeCustomJsonMapper(true);

  public TravelerInformation_OdeJsonFormatTest() {
    super(Void.class);  // Not actually using the fromJson method, just need loadResource
  }

  /**
   * Test if an ODE-style TIM message with human-readable bitstrings can be round tripped with
   * OdeCustomJsonMapper.
   */
  @Test
  public void odeJsonRoundTripTest() throws JsonProcessingException {
    final String json = loadResource("/us/dot/its/jpo/asn/j2735/r2024/TravelerInformation/ode_format_json/ode_tim.json");
    TravelerInformation tim = customMapper.readValue(json, TravelerInformation.class);
    assertThat(tim, notNullValue());
    final String roundTripJson = customMapper.writeValueAsString(tim);
    assertThat(roundTripJson, jsonEquals(json));
  }



}
