package us.dot.its.jpo.asn.runtime.examples;

import us.dot.its.jpo.asn.runtime.serialization.SequenceOfEnumeratedDeserializer;
import us.dot.its.jpo.asn.runtime.serialization.SequenceOfEnumeratedSerializer;
import us.dot.its.jpo.asn.runtime.types.Asn1SequenceOf;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class SequenceOfFruitEnum extends Asn1SequenceOf<FruitEnum> {

  public SequenceOfFruitEnum() {
    super(FruitEnum.class, 1L, 10L);
  }

  public static class SequenceOfFruitEnumSerializer
    extends SequenceOfEnumeratedSerializer<FruitEnum, SequenceOfFruitEnum> {

    protected SequenceOfFruitEnumSerializer() {
      super(FruitEnum.class, SequenceOfFruitEnum.class);
    }
  }

  public static class SequenceOfFruitEnumDeserializer
    extends SequenceOfEnumeratedDeserializer<FruitEnum, SequenceOfFruitEnum> {

    protected SequenceOfFruitEnumDeserializer() {
      super(SequenceOfFruitEnum.class, FruitEnum.class);
    }

    @Override
    protected FruitEnum[] listEnumValues() {
      return FruitEnum.values();
    }

    @Override
    protected SequenceOfFruitEnum construct() {
      return new SequenceOfFruitEnum();
    }
  }
}
