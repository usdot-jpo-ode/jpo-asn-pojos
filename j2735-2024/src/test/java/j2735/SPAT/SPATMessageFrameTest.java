package j2735.SPAT;

import j2735.BaseSerializeTest;
import j2735.MessageFrame.DSRCmsgID;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SPATMessageFrameTest extends BaseSerializeTest<SPATMessageFrame> {

    public SPATMessageFrameTest() {
        super(SPATMessageFrame.class);
    }

    @Test
    public void xmlSerialize() throws IOException {
        SPATMessageFrame smf = createSPATMessageFrame();
        String xml = toXml(smf);
        assertThat(xml, notNullValue());
    }

    @Test
    public void xmlDeserialize() throws IOException {
        SPATMessageFrame smf = fromXml(expectedXml);
        assertThat(smf, notNullValue());
        assertThat(smf, hasProperty("messageId", equalTo(new DSRCmsgID(19))));

    }

    @Test
    public void jsonSerialize() throws IOException {
        SPATMessageFrame smf = createSPATMessageFrame();
        String json = toJson(smf);
        assertThat(json, notNullValue());
    }

    public static SPATMessageFrame createSPATMessageFrame() {
        var smf = new SPATMessageFrame();
        var spat = SpatTest.createSPAT();
        smf.setValue(spat);
        return smf;
    }

    public final static String expectedXml = """
            <MessageFrame>
                <messageId>19</messageId>
                <value>
                    <SPAT>
                        <timeStamp>400000</timeStamp>
                        <name>Example Name</name>
                        <intersections>
                            <IntersectionState>
                                <id>
                                    <region>0</region>
                                    <id>12111</id>
                                </id>
                                <revision>0</revision>
                                <status>1111111111111111</status>
                                <moy>400000</moy>
                                <timeStamp>35176</timeStamp>
                                <enabledLanes>
                                    <LaneID>1</LaneID>
                                </enabledLanes>
                                <states>
                                    <MovementState>
                                        <signalGroup>2</signalGroup>
                                        <state-time-speed>
                                            <MovementEvent>
                                                <eventState>
                                                    <protected-Movement-Allowed/>
                                                </eventState>
                                                <timing>
                                                    <startTime>22120</startTime>
                                                    <minEndTime>22120</minEndTime>
                                                    <maxEndTime>22121</maxEndTime>
                                                    <likelyTime>22120</likelyTime>
                                                    <confidence>15</confidence>
                                                    <nextTime>22220</nextTime>
                                                </timing>
                                                <speeds>
                                                    <AdvisorySpeed>
                                                        <type>3</type>
                                                        <speed>250</speed>
                                                        <confidence>4</confidence>
                                                        <distance>100</distance>
                                                        <class>1</class>
                                                    </AdvisorySpeed>
                                                    <AdvisorySpeed>
                                                        <type>1</type>
                                                        <speed>250</speed>
                                                        <confidence>1</confidence>
                                                        <distance>50</distance>
                                                        <class>1</class>
                                                    </AdvisorySpeed>
                                                </speeds>
                                            </MovementEvent>
                                        </state-time-speed>
                                        <maneuverAssistList>
                                            <ConnectionManeuverAssist>
                                                <connectionID>1</connectionID>
                                                <queueLength>0</queueLength>
                                                <availableStorageLength>0</availableStorageLength>
                                                <waitOnStop>
                                                    <true/>
                                                </waitOnStop>
                                                <pedBicycleDetect>
                                                    <true/>
                                                </pedBicycleDetect>
                                            </ConnectionManeuverAssist>
                                            <ConnectionManeuverAssist>
                                                <connectionID>2</connectionID>
                                                <queueLength>0</queueLength>
                                                <availableStorageLength>0</availableStorageLength>
                                                <waitOnStop>
                                                    <true/>
                                                </waitOnStop>
                                                <pedBicycleDetect>
                                                    <true/>
                                                </pedBicycleDetect>
                                            </ConnectionManeuverAssist>
                                        </maneuverAssistList>
                                    </MovementState>
                                </states>
                                <maneuverAssistList>
                                    <ConnectionManeuverAssist>
                                        <connectionID>1</connectionID>
                                        <queueLength>0</queueLength>
                                        <availableStorageLength>0</availableStorageLength>
                                        <waitOnStop>
                                            <true/>
                                        </waitOnStop>
                                        <pedBicycleDetect>
                                            <true/>
                                        </pedBicycleDetect>
                                    </ConnectionManeuverAssist>
                                    <ConnectionManeuverAssist>
                                        <connectionID>2</connectionID>
                                        <queueLength>0</queueLength>
                                        <availableStorageLength>0</availableStorageLength>
                                        <waitOnStop>
                                            <true/>
                                        </waitOnStop>
                                        <pedBicycleDetect>
                                            <true/>
                                        </pedBicycleDetect>
                                    </ConnectionManeuverAssist>
                                </maneuverAssistList>
                            </IntersectionState>
                        </intersections>
                    </SPAT>
                </value>
            </MessageFrame>
            """;
}
