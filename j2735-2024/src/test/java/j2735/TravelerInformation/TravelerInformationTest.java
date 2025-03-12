package j2735.TravelerInformation;

import j2735.BaseSerializeTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

import static net.javacrumbs.jsonunit.JsonMatchers.jsonEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.xmlunit.matchers.CompareMatcher.isIdenticalTo;

/**
 * Unit tests for the TravelerInformation class.
 */
public class TravelerInformationTest extends BaseSerializeTest<TravelerInformation> {

  public TravelerInformationTest() {
    super(TravelerInformation.class);
  }

  @ParameterizedTest
  @MethodSource("getXmlResources")
  public void canRoundTripXml(String resourcePath) throws IOException {
    String xml = loadResource(resourcePath);
    TravelerInformation tim = fromXml(xml);
    assertThat(tim, notNullValue());
    String roundTripXml = toXml(tim);
    assertThat(roundTripXml, isIdenticalTo(xml).ignoreComments().ignoreWhitespace());
  }

  @ParameterizedTest
  @MethodSource("getJsonResources")
  public void canRoundTripJson(String resourcePath) throws IOException {
    String json = loadResource(resourcePath);
    TravelerInformation tim = fromJson(json);
    assertThat(tim, notNullValue());
    String roundTripJson = toJson(tim);
    assertThat(roundTripJson, jsonEquals(json));
  }

  private static Stream<Arguments> getXmlResources() {
    return getResources("/j2735/TravelerInformation/xml/data");
  }

  private static Stream<Arguments> getJsonResources() {
    return getResources("/j2735/TravelerInformation/json");
  }

  protected static Stream<Arguments> getResources(String directory) {
    List<String> resources = listAllResourcesInDirectory(directory);
    var streamBuilder = Stream.<Arguments>builder();
    resources.forEach(resource -> streamBuilder.add(Arguments.of(resource)));
    return streamBuilder.build();
  }
}
