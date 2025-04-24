package us.dot.its.jpo.asn.j2735.r2024.MessageFrame;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import us.dot.its.jpo.asn.j2735.r2024.BaseNamedIntegerTest;

public class DSRCmsgIDTest extends BaseNamedIntegerTest<DSRCmsgID> {

  public DSRCmsgIDTest() {
    super(DSRCmsgID.class);
  }

  @ParameterizedTest
  @CsvSource({
      "mapData,18",
      "signalPhaseAndTimingMessage,19",
      "basicSafetyMessage,20",
      "travelerInformation,31",
      "personalSafetyMessage,32"
  })
  public void testName(final String name, final long value) {
    nameTest(value, name);
    namedValuesTest(value);
    namesTest(name);
    namedTest(name, value);
  }
}
