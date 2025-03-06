package asn2pojo.runtime.examples;

import asn2pojo.runtime.annotations.Asn1Property;
import asn2pojo.runtime.serialization.SequenceOfEnumeratedDeserializer;
import asn2pojo.runtime.types.Asn1Sequence;
import asn2pojo.runtime.types.Asn1SequenceOf;
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
public class MessageContainsSequenceOfEnumerated extends Asn1Sequence {

  @Asn1Property(tag = 0, name = "id")
  @JsonProperty("id")
  private ExampleInteger id;

  @Asn1Property(tag = 1, name = "fruits")
  @JsonProperty("fruits")
  @JsonSerialize(using = SequenceOfFruitEnum.SequenceOfFruitEnumSerializer.class)
  @JsonDeserialize(using = SequenceOfFruitEnum.SequenceOfFruitEnumDeserializer.class)
  private SequenceOfFruitEnum fruits;

  public MessageContainsSequenceOfEnumerated() {
    super(true);
  }
}
