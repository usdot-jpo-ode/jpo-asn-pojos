package j2735.RoadSafetyMessage;

import j2735.BaseSerializeTest;
import j2735.RoadSafetyMessage.RoadSafetyMessage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;
import org.xmlunit.diff.DefaultNodeMatcher;
import org.xmlunit.diff.ElementSelectors;

import static net.javacrumbs.jsonunit.JsonMatchers.jsonEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.xmlunit.matchers.CompareMatcher.isIdenticalTo;
import static org.xmlunit.matchers.CompareMatcher.isSimilarTo;

public class RoadSafetyMessageTest extends BaseSerializeTest<RoadSafetyMessage> {

  public RoadSafetyMessageTest() {
    super(RoadSafetyMessage.class);
  }

  @ParameterizedTest
  @MethodSource("getXmlResourcesRoot")
  public void canRoundTripXml_LenientTest(String resourcePath) throws IOException {
    String xml = loadResource(resourcePath);
    RoadSafetyMessage rsm = fromXml(xml);
    assertThat(rsm, notNullValue());
    String roundTripXml = toXml(rsm);

    assertThat("Lenient test: Ignore order of sequence-of mixed types",
        roundTripXml,
        isSimilarTo(xml).ignoreWhitespace().normalizeWhitespace()
            .withNodeMatcher(new DefaultNodeMatcher(
                ElementSelectors.byNameAndText
            )));
  }

  @ParameterizedTest
  @MethodSource("getXmlResourcesRoot")
  public void canRoundTripXml_StrictTest(String resourcePath) throws IOException {
    String xml = loadResource(resourcePath);
    RoadSafetyMessage rsm = fromXml(xml);
    assertThat(rsm, notNullValue());
    String roundTripXml = toXml(rsm);

    assertThat("strict test: exact element order", roundTripXml,
        isIdenticalTo(xml).ignoreComments().ignoreWhitespace());
  }

//  @ParameterizedTest
//  @MethodSource("getJsonResources")
//  public void canRoundTripJson_PropulsionTypesTest(String resourcePath) throws IOException {
//    String json = loadResource(resourcePath);
//    RoadSafetyMessage rsm = fromJson(json);
//    assertThat(rsm, notNullValue());
//    String roundTripJson = toJson(rsm);
//    assertThat(roundTripJson, jsonEquals(json));
//  }

  private static Stream<Arguments> getXmlResourcesRoot() {
    return getXmlResources("");
  }

  private static Stream<Arguments> getJsonResourcesPropulsionTypes() {
    return getJsonResources("propulsion_types");
  }

  private static Stream<Arguments> getXmlResources(String subdirectory) {
    return getResources("/j2735/RoadSafetyMessage/xml/" + subdirectory);
  }

  private static Stream<Arguments> getJsonResources(String subdirectory) {
    return getResources("/j2735/RoadSafetyMessage/json/" + subdirectory);
  }

}
