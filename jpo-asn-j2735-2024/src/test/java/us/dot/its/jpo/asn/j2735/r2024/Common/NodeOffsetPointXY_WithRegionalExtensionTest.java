package us.dot.its.jpo.asn.j2735.r2024.Common;

import static net.javacrumbs.jsonunit.JsonMatchers.jsonEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.xmlunit.matchers.CompareMatcher.isIdenticalTo;

import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.dot.its.jpo.asn.j2735.r2024.BaseSerializeTest;

public class NodeOffsetPointXY_WithRegionalExtensionTest
  extends BaseSerializeTest<NodeOffsetPointXY> {

  public NodeOffsetPointXY_WithRegionalExtensionTest() {
    super(NodeOffsetPointXY.class);
  }

  @ParameterizedTest
  @MethodSource("getXmlResources")
  public void canRoundTripXml(String resourcePath) throws IOException {
    final String xml = loadResource(resourcePath);
    NodeOffsetPointXY msg = fromXml(xml);
    assertThat("null", msg, notNullValue());
    assertThat("regional choice is null", msg.getRegional(), notNullValue());
    final String roundTripXml = toXml(msg);
    assertThat(roundTripXml, isIdenticalTo(xml).ignoreWhitespace().ignoreElementContentWhitespace());
  }

  @ParameterizedTest
  @MethodSource("getJsonResources")
  public void canRoundTripJson(String resourcePath) throws IOException {
    final String json = loadResource(resourcePath);
    NodeOffsetPointXY msg = fromJson(json);
    assertThat("null", msg, notNullValue());
    assertThat("regional field null", msg.getRegional(), notNullValue());
    final String  roundTripJson = toJson(msg);
    assertThat(roundTripJson, jsonEquals(json));
  }

  private static Stream<Arguments> getXmlResources() {
    return getResources("/us/dot/its/jpo/asn/j2735/r2024/Common/NodeOffsetPointXY/xml");
  }

  private static Stream<Arguments> getJsonResources() {
    return getResources("/us/dot/its/jpo/asn/j2735/r2024/Common/NodeOffsetPointXY/json");
  }
}
