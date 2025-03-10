package j2735.SPAT;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.xmlunit.matchers.CompareMatcher.isIdenticalTo;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import j2735.BaseSerializeTest;

/**
 * Unit tests for the SPATMessageFrame class.
 */
public class SPATMessageFrameTest extends BaseSerializeTest<SPATMessageFrame> {

    public SPATMessageFrameTest() {
        super(SPATMessageFrame.class);
    }

    @Test
    public void xmlDeserialize_generatedXml() throws IOException {
        final String xml = loadResource("/j2735/SPAT/xml/message_frame/spat_mf.xml");
        SPATMessageFrame spatmf = fromXml(xml);
        assertThat(spatmf, notNullValue());
        final String roundTripXml = toXml(spatmf);
        assertThat(roundTripXml, isIdenticalTo(xml).ignoreWhitespace().ignoreElementContentWhitespace());
    }
}
