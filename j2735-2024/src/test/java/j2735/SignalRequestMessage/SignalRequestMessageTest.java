package j2735.SignalRequestMessage;

import static net.javacrumbs.jsonunit.JsonMatchers.jsonEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.xmlunit.matchers.CompareMatcher.isIdenticalTo;

import j2735.BaseSerializeTest;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SignalRequestMessageTest extends BaseSerializeTest<SignalRequestMessage> {

  public SignalRequestMessageTest() {
    super(SignalRequestMessage.class);
  }

  @ParameterizedTest
  @MethodSource("getXmlResources")
  public void canRoundTripXml(String resourcePath) throws IOException {
    String xml = loadResource(resourcePath);
    SignalRequestMessage srm = fromXml(xml);
    assertThat(srm, notNullValue());
    String roundTripXml = toXml(srm);
    assertThat(roundTripXml, isIdenticalTo(xml).ignoreComments().ignoreWhitespace());
  }

  @ParameterizedTest
  @MethodSource("getJsonResources")
  public void canRoundTripJson(String resourcePath) throws IOException {
    String json = loadResource(resourcePath);
    SignalRequestMessage srm = fromJson(json);
    assertThat(srm, notNullValue());
    String roundTripJson = toJson(srm);
    assertThat(roundTripJson, jsonEquals(json));
  }

  private static Stream<Arguments> getXmlResources() {
    return getResources("/j2735/SignalRequestMessage/xml");
  }

  private static Stream<Arguments> getJsonResources() {
    return getResources("/j2735/SignalRequestMessage/json");
  }

  protected static Stream<Arguments> getResources(String directory) {
    List<String> resources = listAllResourcesInDirectory(directory);
    var streamBuilder = Stream.<Arguments>builder();
    resources.forEach(resource -> streamBuilder.add(Arguments.of(resource)));
    return streamBuilder.build();
  }
}
