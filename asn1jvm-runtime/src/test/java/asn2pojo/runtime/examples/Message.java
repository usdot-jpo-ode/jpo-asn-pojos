package asn2pojo.runtime.examples;

import asn2pojo.runtime.annotations.Asn1Property;
import asn2pojo.runtime.types.Asn1Sequence;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class Message extends Asn1Sequence {

  @Asn1Property(tag = 0, name = "id")
  @JsonProperty("id")
  private ExampleInteger id;

  @Asn1Property(tag = 1, name = "choices")
  @JsonProperty("choices")
  @JsonSerialize(using = SequenceOfChoice.TestSequenceOfChoiceSerializer.class)
  @JsonDeserialize(using = SequenceOfChoice.TestSequenceOfChoiceDeserializer.class)
  private SequenceOfChoice choices;

  public Message() {
    super(true);
  }
}
