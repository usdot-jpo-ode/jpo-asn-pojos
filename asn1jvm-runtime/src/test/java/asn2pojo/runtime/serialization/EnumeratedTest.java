package asn2pojo.runtime.serialization;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import asn2pojo.runtime.BaseSerializeTest;
import asn2pojo.runtime.examples.FruitEnum;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class EnumeratedTest extends BaseSerializeTest<FruitEnum> {

  public EnumeratedTest() {
    super(FruitEnum.class);
  }

  @Test
  public void canDeserializeXml() throws IOException {
    FruitEnum fe = fromXml(XML);
    assertThat(fe, allOf(notNullValue(), equalTo(FruitEnum.APPLE)));
  }

  @Test
  public void canDeserializeJson() throws IOException {
    FruitEnum fe = fromJson(JSON);
    assertThat(fe, allOf(notNullValue(), equalTo(FruitEnum.APPLE)));
  }

  // Note the deserializer can't read an enum as unwrapped xml
  public static final String XML = "<FruitEnum><apple/></FruitEnum>";

  public static final String JSON = """
      "apple"
      """;

}
