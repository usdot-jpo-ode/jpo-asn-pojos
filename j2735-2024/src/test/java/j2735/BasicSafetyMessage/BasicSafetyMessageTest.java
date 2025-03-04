package j2735.BasicSafetyMessage;

import j2735.Common.BSMcoreData;

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
import static net.javacrumbs.jsonunit.JsonMatchers.jsonEquals;

public class BasicSafetyMessageTest extends BaseSerializeTest<BasicSafetyMessage> {

  public BasicSafetyMessageTest() {
    super(BasicSafetyMessage.class);
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
  @MethodSource("getXmlResourcesSafetyExtensions")
  public void canRoundTripXml_SafetyExtensionsTest(String resourcePath) throws IOException {
    String xml = loadResource(resourcePath);
    BasicSafetyMessage bsm = fromXml(xml);
    assertThat(bsm, notNullValue());
    String roundTripXml = toXml(bsm);
    assertThat(roundTripXml, isIdenticalTo(xml).ignoreComments().ignoreWhitespace());
  }

  @ParameterizedTest
  @MethodSource("getXmlResourcesSpecialExtensions")
  public void canRoundTripXml_SpecialExtensionsTest(String resourcePath) throws IOException {
    String xml = loadResource(resourcePath);
    BasicSafetyMessage bsm = fromXml(xml);
    assertThat(bsm, notNullValue());
    String roundTripXml = toXml(bsm);
    assertThat(roundTripXml, isIdenticalTo(xml).ignoreComments().ignoreWhitespace());
  }

  @ParameterizedTest
  @MethodSource("getXmlResourcesSupplementalExtensions")
  public void canRoundTripXml_SupplementalExtensionsTest(String resourcePath) throws IOException {
    String xml = loadResource(resourcePath);
    BasicSafetyMessage bsm = fromXml(xml);
    assertThat(bsm, notNullValue());
    String roundTripXml = toXml(bsm);
    assertThat(roundTripXml, isIdenticalTo(xml).ignoreComments().ignoreWhitespace());
  }

  @ParameterizedTest
  @MethodSource("getXmlResourcesMultipleExtensions")
  public void canRoundTripXml_MultipleExtensionsTest(String resourcePath) throws IOException {
    String xml = loadResource(resourcePath);
    BasicSafetyMessage bsm = fromXml(xml);
    assertThat(bsm, notNullValue());
    String roundTripXml = toXml(bsm);
    assertThat(roundTripXml, isIdenticalTo(xml).ignoreComments().ignoreWhitespace());
  }


  @ParameterizedTest
  @MethodSource("getJsonResourcesNoExtensions")
  public void canRoundTripJson_NoExtensionsTest(String resourcePath) throws IOException {
    String json = loadResource(resourcePath);
    BasicSafetyMessage bsm = fromJson(json);
    assertThat(bsm, notNullValue());
    String roundTripJson = toJson(bsm);
    assertThat(roundTripJson, jsonEquals(json));
  }

  @ParameterizedTest
  @MethodSource("getJsonResourcesSafetyExtensions")
  public void canRoundTripJson_SafetyExtensionsTest(String resourcePath) throws IOException {
    String json = loadResource(resourcePath);
    BasicSafetyMessage bsm = fromJson(json);
    assertThat(bsm, notNullValue());
    String roundTripJson = toJson(bsm);
    System.out.printf("roundTripJson: %s%n", roundTripJson);
    assertThat(roundTripJson, jsonEquals(json));
  }

  @ParameterizedTest
  @MethodSource("getJsonResourcesSpecialExtensions")
  public void canRoundTripJson_SpecialExtensionsTest(String resourcePath) throws IOException {
    String json = loadResource(resourcePath);
    BasicSafetyMessage bsm = fromJson(json);
    assertThat(bsm, notNullValue());
    String roundTripJson = toJson(bsm);
    System.out.printf("roundTripJson: %s%n", roundTripJson);
    assertThat(roundTripJson, jsonEquals(json));
  }

  @ParameterizedTest
  @MethodSource("getJsonResourcesSupplementalExtensions")
  public void canRoundTripJson_SupplementalExtensionsTest(String resourcePath) throws IOException {
    String json = loadResource(resourcePath);
    BasicSafetyMessage bsm = fromJson(json);
    assertThat(bsm, notNullValue());
    String roundTripJson = toJson(bsm);
    System.out.printf("roundTripJson: %s%n", roundTripJson);
    assertThat(roundTripJson, jsonEquals(json));
  }

  @ParameterizedTest
  @MethodSource("getJsonResourcesMultipleExtensions")
  public void canRoundTripJson_MultipleExtensionsTest(String resourcePath) throws IOException {
    String json = loadResource(resourcePath);
    BasicSafetyMessage bsm = fromJson(json);
    assertThat(bsm, notNullValue());
    String roundTripJson = toJson(bsm);
    System.out.printf("roundTripJson: %s%n", roundTripJson);
    assertThat(roundTripJson, jsonEquals(json));
  }

  private static Stream<Arguments> getXmlResourcesNoExtensions() {
    return getXmlResources("no_extensions");
  }

  private static Stream<Arguments> getJsonResourcesNoExtensions() {
    return getJsonResources("no_extensions");
  }

  private static Stream<Arguments> getXmlResourcesSafetyExtensions() {
    return getXmlResources("safety_extensions");
  }

  private static Stream<Arguments> getXmlResourcesSpecialExtensions() {
    return getXmlResources("special_extensions");
  }

  private static Stream<Arguments> getXmlResourcesSupplementalExtensions() {
    return getXmlResources("supplemental_extensions");
  }

  private static Stream<Arguments> getXmlResourcesMultipleExtensions() {
    return getXmlResources("multiple_extensions");
  }

  private static Stream<Arguments> getJsonResourcesSafetyExtensions() {
    return getJsonResources("safety_extensions");
  }

  private static Stream<Arguments> getJsonResourcesSpecialExtensions() {
    return getJsonResources("special_extensions");
  }

  private static Stream<Arguments> getJsonResourcesSupplementalExtensions() {
    return getJsonResources("supplemental_extensions");
  }

  private static Stream<Arguments> getJsonResourcesMultipleExtensions() {
    return getJsonResources("multiple_extensions");
  }

  private static Stream<Arguments> getXmlResources(String subdirectory)  {
    return getResources("/j2735/BasicSafetyMessage/xml/" + subdirectory);
  }

  private static Stream<Arguments> getJsonResources(String subdirectory) {
    return getResources("/j2735/BasicSafetyMessage/json/" + subdirectory);
  }

  private static Stream<Arguments> getResources(String directory) {
    List<String> resources = listAllResourcesInDirectory(directory);
    var streamBuilder = Stream.<Arguments>builder();
    resources.forEach(resource -> streamBuilder.add(Arguments.of(resource)));
    return streamBuilder.build();
  }
}
