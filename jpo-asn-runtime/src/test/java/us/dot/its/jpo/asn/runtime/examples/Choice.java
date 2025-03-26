package us.dot.its.jpo.asn.runtime.examples;

import lombok.ToString;
import us.dot.its.jpo.asn.runtime.annotations.Asn1Property;
import us.dot.its.jpo.asn.runtime.types.Asn1Choice;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(Include.NON_NULL)
@ToString(callSuper = true)
public class Choice extends Asn1Choice {

  @Asn1Property(tag = 0, name = "a")
  @JsonProperty("a")
  private ASequence a;

  @Asn1Property(tag = 1, name = "b")
  @JsonProperty("b")
  private BSequence b;

  public Choice() {
  }

  @Override
  public boolean isExtensible() {
    return false;
  }
}
