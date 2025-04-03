package us.dot.its.jpo.asn.runtime.types;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.nullValue;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class Asn1OctetStringTest {

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

}
