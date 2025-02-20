package j2735.SPAT;

import j2735.BaseSerializeTest;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TimeChangeDetailsTest extends BaseSerializeTest<TimeChangeDetails> {

    private static final Logger logger = LoggerFactory.getLogger(TimeChangeDetailsTest.class);

    public TimeChangeDetailsTest() {
        super(TimeChangeDetails.class);
    }

    @Test
    public void xmlSerialize() throws IOException {
        var tcd = createTimeChangeDetails();
        String xml = toXml(tcd);
        assertThat(xml, notNullValue());
    }

    @Test
    public void jsonSerialize() throws IOException {
        var tcd = createTimeChangeDetails();
        String json = toJson(tcd);
        assertThat(json, notNullValue());
    }

    @Test
    public void xmlDeserialize() throws IOException {
        TimeChangeDetails tcd = fromXml(XML);
        test(tcd);
    }

    @Test
    public void jsonDeserialize() throws IOException {
        TimeChangeDetails tcd = fromJson(JSON);
        test(tcd);
    }



    private void test(TimeChangeDetails tcd) {
        assertThat(tcd, hasProperty("minEndTime", equalTo(createTimeMark(12345L))));
        assertThat(tcd, hasProperty("maxEndTime", equalTo(createTimeMark(12355L))));
        assertThat(tcd, hasProperty("confidence", equalTo(createConfidence(14L))));
    }

    public static TimeMark createTimeMark(long value) {
        var tm = new TimeMark();
        tm.setValue(value);
        return tm;
    }

    public static TimeIntervalConfidence createConfidence(long value) {
        var confidence = new TimeIntervalConfidence();
        confidence.setValue(14);
        return confidence;
    }

    public static TimeChangeDetails createTimeChangeDetails() {
        var tcd = new TimeChangeDetails();
        tcd.setMinEndTime(createTimeMark(12345L));
        tcd.setMaxEndTime(createTimeMark(12355L));
        tcd.setConfidence(createConfidence(14L));
        return tcd;
    }

    private static final String XML =
        """
        <TimeChangeDetails>
            <minEndTime>12345</minEndTime>
            <maxEndTime>12355</maxEndTime>
            <confidence>14</confidence>
        </TimeChangeDetails>
        """;

    private static final String JSON =
        """
        {
            "minEndTime": 12345,
            "maxEndTime": 12355,
            "confidence": 14
        }
        """;


}
