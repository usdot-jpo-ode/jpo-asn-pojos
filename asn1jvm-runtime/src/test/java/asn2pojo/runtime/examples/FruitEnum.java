package asn2pojo.runtime.examples;

import asn2pojo.runtime.serialization.EnumeratedDeserializer;
import asn2pojo.runtime.serialization.EnumeratedSerializer;
import asn2pojo.runtime.types.Asn1Enumerated;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;

@Getter
@JsonSerialize(using = FruitEnum.FruitSerializer.class)
@JsonDeserialize(using = FruitEnum.FruitDeserializer.class)
public enum FruitEnum implements Asn1Enumerated {
  APPLE(0, "apple"),
  ORANGE(1, "orange"),
  BANANA(2, "banana");

  private final int index;
  private final String name;

  private FruitEnum(int index, String name) {
    this.index = index;
    this.name = name;
  }

  public static class FruitSerializer extends EnumeratedSerializer<FruitEnum> {

    protected FruitSerializer() {
      super(FruitEnum.class);
    }
  }

  public static class FruitDeserializer extends EnumeratedDeserializer<FruitEnum> {

    protected FruitDeserializer() {
      super(FruitEnum.class);
    }

    @Override
    protected FruitEnum[] listEnumValues() {
      return FruitEnum.values();
    }
  }
}
