package us.dot.its.jpo.asn.j2735.r2024.Common;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.xmlunit.matchers.CompareMatcher.isIdenticalTo;

import java.io.IOException;
import org.junit.jupiter.api.Test;
import us.dot.its.jpo.asn.j2735.r2024.BaseSerializeTest;

public class VehicleIDTest extends BaseSerializeTest<VehicleID> {

  public VehicleIDTest() {
    super(VehicleID.class);
  }

  @Test
  public void testLargeStationID() throws IOException {
    var vid = fromXml(XML_LARGE_ID);
    assertThat(vid, notNullValue());
    final String roundTripXml = toXml(vid);
    assertThat(roundTripXml, isIdenticalTo(XML_LARGE_ID).ignoreWhitespace().ignoreElementContentWhitespace());
  }

  static final String XML_LARGE_ID = "<VehicleID><stationID>4294967295</stationID></VehicleID>";



}


