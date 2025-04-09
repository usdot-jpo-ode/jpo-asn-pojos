package us.dot.its.jpo.asn.runtime.serialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;

@Getter
public class OdeCustomJsonMapper extends ObjectMapper {

  private final boolean humanReadableJsonBitstrings;

  public OdeCustomJsonMapper(boolean humanReadableJsonBitstrings) {
    this.humanReadableJsonBitstrings = humanReadableJsonBitstrings;
  }

}
