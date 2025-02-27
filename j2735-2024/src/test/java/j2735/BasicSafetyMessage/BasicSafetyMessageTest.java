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
import static org.xmlunit.matchers.CompareMatcher.isIdenticalTo;

public class BasicSafetyMessageTest extends BaseSerializeTest<BasicSafetyMessage> {

  public BasicSafetyMessageTest() {
    super(BasicSafetyMessage.class);
  }

  @ParameterizedTest
  @MethodSource("getXmlResourcesNoExtensions")
  public void canDeserializeXml_NoExtensionsTest(String resourcePath) throws IOException {
    String xml = loadResource(resourcePath);
    BasicSafetyMessage bsm = fromXml(xml);
    assertThat(bsm, notNullValue());
  }

  @ParameterizedTest
  @MethodSource("getXmlResourcesNoExtensions")
  public void canRoundTripXml_NoExtensionsTest(String resourcePath) throws IOException {
    String xml = loadResource(resourcePath);
    BasicSafetyMessage bsm = fromXml(xml);
    assertThat(bsm, notNullValue());
    String roundTripXml = toXml(bsm);
    assertThat(roundTripXml, isIdenticalTo(xml).ignoreComments().ignoreWhitespace());
  }

  @ParameterizedTest
  @MethodSource("getJsonResourcesNoExtensions")
  public void jsonDeserializeNoExtensionsTest(String resourcePath) throws IOException {
    String json = loadResource(resourcePath);
    BasicSafetyMessage bsm = fromJson(json);
    assertThat(bsm, notNullValue());
  }

  private static Stream<Arguments> getXmlResourcesNoExtensions() {
    return getXmlResources("no_extensions");
  }

  private static Stream<Arguments> getJsonResourcesNoExtensions() {
    return getJsonResources("no_extensions");
  }

  private static Stream<Arguments> getXmlResources(String subdirectory)  {
    return getResources("/BasicSafetyMessage/xml/" + subdirectory);
  }

  private static Stream<Arguments> getJsonResources(String subdirectory) {
    return getResources("/BasicSafetyMessage/json/" + subdirectory);
  }

  private static Stream<Arguments> getResources(String directory) {
    List<String> resources = listAllResourcesInDirectory(directory);
    var streamBuilder = Stream.<Arguments>builder();
    resources.forEach(resource -> streamBuilder.add(Arguments.of(resource)));
    return streamBuilder.build();
  }
}
