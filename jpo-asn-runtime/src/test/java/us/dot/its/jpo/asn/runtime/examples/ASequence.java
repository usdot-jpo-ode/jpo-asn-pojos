package us.dot.its.jpo.asn.runtime.examples;

import lombok.ToString;
import us.dot.its.jpo.asn.runtime.annotations.Asn1Property;
import us.dot.its.jpo.asn.runtime.types.Asn1Sequence;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@ToString(callSuper = true)
public class ASequence implements Asn1Sequence {

  @Asn1Property(tag = 0, name = "a-int")
  @JsonProperty("a-int")
  private AInteger aInt;
  @Asn1Property(tag = 1, name = "a-str")
  @JsonProperty("a-str")
  private AString aStr;

  public ASequence() {
  }

  @Override
  public boolean isExtensible() {
    return false;
  }
}
