package asn2pojo.runtime.examples;

import asn2pojo.runtime.annotations.Asn1Property;
import asn2pojo.runtime.types.Asn1Sequence;
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
public class ASequence extends Asn1Sequence {

  @Asn1Property(tag = 0, name = "a-int")
  @JsonProperty("a-int")
  private AInteger aInt;
  @Asn1Property(tag = 1, name = "a-str")
  @JsonProperty("a-str")
  private AString aStr;

  public ASequence() {
    super(false);
  }
}
