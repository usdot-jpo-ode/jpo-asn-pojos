package j2735.MessageFrame;

import j2735.SPAT.SPAT;
import j2735.SPAT.SPATMessageFrame;
import j2735.SPAT.SPATMessageFrameTest;
import j2735.BaseSerializeTest;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

// Deserialization tests for Generic MessageFrame
public class MessageFrameTest extends BaseSerializeTest<MessageFrame> {

    public MessageFrameTest() {
        super(MessageFrame.class);
    }

    @Test
    public void xmlDeserialize_SPAT() throws IOException {
        MessageFrame<?> smf = fromXml(SPATMessageFrameTest.expectedXml);
        assertThat(smf, notNullValue());
        assertThat(smf, instanceOf(SPATMessageFrame.class));
        assertThat(smf, hasProperty("messageId", equalTo(new DSRCmsgID(19))));
        assertThat(smf.getValue(), notNullValue());
        assertThat(smf.getValue(), instanceOf(SPAT.class));
    }

}
