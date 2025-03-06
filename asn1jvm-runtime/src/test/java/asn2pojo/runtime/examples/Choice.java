package asn2pojo.runtime.examples;

import asn2pojo.runtime.annotations.Asn1Property;
import asn2pojo.runtime.types.Asn1Choice;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(Include.NON_NULL)
public class Choice extends Asn1Choice {

  @Asn1Property(tag = 0, name = "a")
  @JsonProperty("a")
  private ASequence a;

  @Asn1Property(tag = 1, name = "b")
  @JsonProperty("b")
  private BSequence b;

  public Choice() {
    super(false);
  }
}
