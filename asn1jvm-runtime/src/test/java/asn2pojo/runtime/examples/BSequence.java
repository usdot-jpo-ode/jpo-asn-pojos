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
public class BSequence extends Asn1Sequence {

  @Asn1Property(tag = 0, name = "b-int")
  @JsonProperty("b-int")
  private BInteger bInt;
  @Asn1Property(tag = 1, name = "b-str")
  @JsonProperty("b-str")
  private BString bStr;

  public BSequence() {
    super(false);
  }
}
