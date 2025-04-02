package us.dot.its.jpo.asn.runtime.types;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;

import java.io.IOException;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.dot.its.jpo.asn.runtime.BaseSerializeTest;
import us.dot.its.jpo.asn.runtime.examples.SequenceWithUnboundedOctetString;
import us.dot.its.jpo.asn.runtime.examples.UnboundedOctetString;

@Slf4j
public class UnboundedAsn1OctetStringTest extends BaseSerializeTest<SequenceWithUnboundedOctetString> {


  public UnboundedAsn1OctetStringTest() {
    super(SequenceWithUnboundedOctetString.class);
  }

  @Test
  public void testValidateUnboundedLengthOctetString() {
    Asn1OctetString aos = new Asn1OctetString();
    Exception ex = null;
    try {
      aos.setValue("FF");
    } catch (IllegalArgumentException iae) {
      log.error("Validation error", iae);
      ex = iae;
    }
    assertThat(ex, nullValue());
  }

  @ParameterizedTest
  @MethodSource("getXmlExamples")
  public void testDeserializeUnboundedXML(final String xml, String description) throws IOException {
    SequenceWithUnboundedOctetString osSeq = fromXml(xml);
    assertThat(osSeq, notNullValue());
    UnboundedOctetString os = osSeq.getUnboundedOctetString();
    assertThat(os, notNullValue());
    final String actualHex = os.getValue();
    assertThat(description, actualHex, equalTo(hexValue));
  }

  static final String hexValue = "E2959E0EA303D5B4376DFDF9781E706BCE5602BD75A6072E37194A996C";

  static final String XML1 = "<SequenceWithUnboundedOctetString><unboundedOctetString>%s</unboundedOctetString></SequenceWithUnboundedOctetString>";
  static final String XML2 = """
      <SequenceWithUnboundedOctetString>
        <unboundedOctetString>
          %s
        </unboundedOctetString>
      </SequenceWithUnboundedOctetString>
      """;
  static final String XML3 = """
      <SequenceWithUnboundedOctetString>
        <unboundedOctetString>%s
        </unboundedOctetString>
      </SequenceWithUnboundedOctetString>
      """;

  static Stream<Arguments> getXmlExamples() {
    return Stream.of(
        Arguments.of(String.format(XML1, hexValue), "canonical whitespace"),
        Arguments.of(String.format(XML2, hexValue), "basic whitespace"),
        Arguments.of(String.format(XML3, hexValue), "asymmetric whitespace"));
  }



}
