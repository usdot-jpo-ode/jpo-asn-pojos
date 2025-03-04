package j2735.MapData;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import j2735.BaseSerializeTest;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.xmlunit.matchers.CompareMatcher.isIdenticalTo;
import static net.javacrumbs.jsonunit.JsonMatchers.jsonEquals;

public class MapDataTest extends BaseSerializeTest<MapData> {

  public MapDataTest() {
    super(MapData.class);
  }

  @ParameterizedTest
  @MethodSource("getXmlResources")
  public void canRoundTripXml(String resourcePath) throws IOException {
    String xml = loadResource(resourcePath);
    MapData map = fromXml(xml);
    assertThat(map, notNullValue());
    String roundTripXml = toXml(map);
    assertThat(roundTripXml, isIdenticalTo(xml).ignoreWhitespace().ignoreElementContentWhitespace());
  }

  @ParameterizedTest
  @MethodSource("getJsonResources")
  public void canRoundTripJson(String resourcePath) throws IOException {
    String json = loadResource(resourcePath);
    MapData map = fromJson(json);
    assertThat(map, notNullValue());
    String roundTripJson = toJson(map);
    assertThat(roundTripJson, jsonEquals(json));
  }

  private static Stream<Arguments> getXmlResources() {
    return getResources("/MapData/xml");
  }

  private static Stream<Arguments> getJsonResources() {
    return getResources("/MapData/json");
  }
}
