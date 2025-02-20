package j2735.SPAT;

import j2735.BaseSerializeTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import j2735.Common.RestrictionClassID;
import j2735.Common.SpeedConfidence;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class MovementEventTest extends BaseSerializeTest<MovementEvent> {

    private static final Logger logger = LoggerFactory.getLogger(MovementEventTest.class);


    public MovementEventTest() {
        super(MovementEvent.class);
    }

    @Test
    public void xmlSerialize() throws IOException {
        MovementEvent me = createPojo();
        String xml = toXml(me);
        assertThat(xml, notNullValue());
    }

    @Test
    public void jsonSerialize() throws JsonProcessingException {
        MovementEvent me = createPojo();
        String json = toJson(me);
        assertThat(json, notNullValue());
    }

    @Test
    public void xmlDeserialize() throws IOException {
        MovementEvent me = fromXml(XML);
        assertThat(me, notNullValue());
        test(me);
    }



    @Test
    public void jsonDeserialize() throws IOException {
        MovementEvent me = fromJson(JSON);
        assertThat(me, notNullValue());
        test(me);
    }

    private void test(MovementEvent me) {
        assertThat(me.getEventState(), equalTo(MovementPhaseState.PROTECTED_MOVEMENT_ALLOWED));
        var timing = me.getTiming();
        assertThat(timing, notNullValue());
        assertThat(timing, hasProperty("startTime", equalTo(new TimeMark(22120L))));
        assertThat(timing, hasProperty("minEndTime", equalTo(new TimeMark(22120L))));
        assertThat(timing, hasProperty("maxEndTime", equalTo(new TimeMark(22120L))));
        assertThat(timing, hasProperty("likelyTime", equalTo(new TimeMark(22120L))));
        assertThat(timing, hasProperty("nextTime", equalTo(new TimeMark(22220L))));
        assertThat(timing, hasProperty("confidence", equalTo(new TimeIntervalConfidence(14L))));
        var speeds = me.getSpeeds();
        assertThat(speeds, hasSize(equalTo(2)));
        var firstSpeed = speeds.get(0);
        testSpeed(firstSpeed, AdvisorySpeedType.TRANSIT, SpeedConfidence.PREC1MS,250L,100L,1L);
        var secondSpeed = speeds.get(1);
        testSpeed(secondSpeed, AdvisorySpeedType.GREENWAVE, SpeedConfidence.PREC100MS,250L, 50L, 1L);
    }

    private void testSpeed(AdvisorySpeed speed, AdvisorySpeedType expectType, SpeedConfidence expectConfidence,
                           long expectSpeed, long expectDistance, long expectClass) {
        assertThat(speed.getType(), equalTo(expectType));
        assertThat(speed.getConfidence(), equalTo(expectConfidence));
        assertThat(speed.getSpeed(), equalTo(new SpeedAdvice(expectSpeed)));
        assertThat(speed.getDistance(), equalTo(new ZoneLength(expectDistance)));
        assertThat(speed.getClass_(), equalTo(new RestrictionClassID(expectClass)));
    }

    public static MovementEvent createPojo() {
        var me = new MovementEvent();
        var phaseState = MovementPhaseState.PROTECTED_MOVEMENT_ALLOWED;
        var timing = new TimeChangeDetails();
        var speeds = new AdvisorySpeedList();
        var speed1 = new AdvisorySpeed();
        var speed2 = new AdvisorySpeed();
        var minEndTime = new TimeMark();
        var maxEndTime = new TimeMark();
        var startTime = new TimeMark();
        var likelyTime = new TimeMark();
        var nextTime = new TimeMark();
        var confidence = new TimeIntervalConfidence();
        confidence.setValue((byte)14);
        minEndTime.setValue(22120);
        maxEndTime.setValue(22120);
        startTime.setValue(22120);
        likelyTime.setValue(22120);
        nextTime.setValue(22220);
        timing.setConfidence(confidence);
        timing.setMinEndTime(minEndTime);
        timing.setMaxEndTime(maxEndTime);
        timing.setStartTime(startTime);
        timing.setLikelyTime(likelyTime);
        timing.setNextTime(nextTime);

        speed1.setType(AdvisorySpeedType.TRANSIT);
        var speedAdvice1 = new SpeedAdvice();
        speedAdvice1.setValue((short)250);
        speed1.setSpeed(speedAdvice1);
        speed1.setConfidence(SpeedConfidence.PREC1MS);
        var distance = new ZoneLength();
        distance.setValue((short)100);
        speed1.setDistance(distance);
        var theClass1 = new RestrictionClassID();
        theClass1.setValue((short)1);
        speed1.setClass_(theClass1);

        speed2.setType(AdvisorySpeedType.GREENWAVE);
        var speedAdvice2 = new SpeedAdvice();
        speedAdvice2.setValue((short)250);
        speed2.setSpeed(speedAdvice2);
        speed2.setConfidence(SpeedConfidence.PREC100MS);
        var distance2 = new ZoneLength();
        distance2.setValue((short)50);
        speed2.setDistance(distance2);
        speed2.setClass_(theClass1);

        speeds.add(speed1);
        speeds.add(speed2);

        me.setEventState(phaseState);
        me.setTiming(timing);
        me.setSpeeds(speeds);

        return me;
    }

    private static final String XML = """
            <MovementEvent>
                    <eventState>
                        <protected-Movement-Allowed/>
                    </eventState>
                    <timing>
                        <startTime>22120</startTime>
                        <minEndTime>22120</minEndTime>
                        <maxEndTime>22120</maxEndTime>
                        <likelyTime>22120</likelyTime>
                        <confidence>14</confidence>
                        <nextTime>22220</nextTime>
                    </timing>
                    <speeds>
                        <AdvisorySpeed>
                            <type>
                                <transit/>
                            </type>
                            <speed>250</speed>
                            <confidence>
                                <prec1ms/>
                            </confidence>
                            <distance>100</distance>
                            <class>1</class>
                        </AdvisorySpeed>
                        <AdvisorySpeed>
                            <type>
                                <greenwave/>
                            </type>
                            <speed>250</speed>
                            <confidence>
                                <prec100ms/>
                            </confidence>
                            <distance>50</distance>
                            <class>1</class>
                        </AdvisorySpeed>
                    </speeds>
                </MovementEvent>
            """;

    private static final String JSON =
            """
            {
                "eventState": "protected-Movement-Allowed",
                "timing": {
                    "startTime": 22120,
                    "minEndTime": 22120,
                    "maxEndTime": 22120,
                    "likelyTime": 22120,
                    "confidence": 14,
                    "nextTime": 22220
                },
                "speeds": [
                    {
                        "type": "transit",
                        "speed": 250,
                        "confidence": "prec1ms",
                        "distance": 100,
                        "class": 1
                    },
                    {
                        "type": "greenwave",
                        "speed": 250,
                        "confidence": "prec100ms",
                        "distance": 50,
                        "class": 1
                    }
                ]
            }
            """;
}
