package j2735.BasicSafetyMessage;



import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import j2735.BaseSerializeTest;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class BasicSafetyMessageTest extends BaseSerializeTest<BasicSafetyMessage> {

  public BasicSafetyMessageTest() {
    super(BasicSafetyMessage.class);
  }

  @ParameterizedTest
  @MethodSource("getXmlResources")
  public void xmlDeserializeTest(String resourcePath) throws IOException {
    String xml = loadResource(resourcePath);
    BasicSafetyMessage bsm = fromXml(xml);
    assertThat(bsm, notNullValue());
  }

  @ParameterizedTest
  @MethodSource("getJsonResources")
  public void jsonDeserializeTest(String resourcePath) throws IOException {
    String json = loadResource(resourcePath);
    BasicSafetyMessage bsm = fromJson(json);
    assertThat(bsm, notNullValue());
  }

  private static Stream<Arguments> getXmlResources()  {
    return getResources("/BasicSafetyMessage/xml");
  }

  private static Stream<Arguments> getJsonResources() {
    return getResources("/BasicSafetyMessage/json");
  }

  private static Stream<Arguments> getResources(String directory) {
    List<String> resources = listAllResourcesInDirectory(directory);
    var streamBuilder = Stream.<Arguments>builder();
    resources.forEach(resource -> streamBuilder.add(Arguments.of(resource)));
    return streamBuilder.build();
  }
}
