package us.dot.its.jpo.asn.runtime.examples;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import us.dot.its.jpo.asn.runtime.annotations.Asn1Property;
import us.dot.its.jpo.asn.runtime.types.Asn1Sequence;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@ToString(callSuper = true)
public class SequenceWithUnboundedOctetString extends Asn1Sequence {

  @Asn1Property(tag = 0, name = "unboundedOctetString")
  @JsonProperty("unboundedOctetString")
  private UnboundedOctetString unboundedOctetString;

  public SequenceWithUnboundedOctetString() {
  }
}
