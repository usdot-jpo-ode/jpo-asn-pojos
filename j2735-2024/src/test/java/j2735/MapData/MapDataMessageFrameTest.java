package j2735.MapData;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.xmlunit.matchers.CompareMatcher.isIdenticalTo;

import j2735.BaseSerializeTest;
import java.io.IOException;
import org.junit.jupiter.api.Test;

public class MapDataMessageFrameTest extends BaseSerializeTest<MapDataMessageFrame> {

  public MapDataMessageFrameTest() {
    super(MapDataMessageFrame.class);
  }

  @Test
  public void xmlRoundTripTest() throws IOException {
    final String xml = loadResource("/j2735/MapData/xml_message_frame/map_01.xml");
    MapDataMessageFrame mdmf = fromXml(xml);
    assertThat(mdmf, notNullValue());
    final String roundTripXml = toXml(mdmf);
    assertThat(roundTripXml,
        isIdenticalTo(xml).ignoreWhitespace().ignoreElementContentWhitespace());
  }
}
