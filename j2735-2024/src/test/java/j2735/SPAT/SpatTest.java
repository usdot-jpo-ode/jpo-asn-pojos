package j2735.SPAT;

import j2735.BaseSerializeTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import j2735.Common.DescriptiveName;
import j2735.Common.MinuteOfTheYear;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SpatTest extends BaseSerializeTest<SPAT> {


    public SpatTest() {
        super(SPAT.class);
    }

    @Test
    public void xmlSerialize() throws IOException {
        SPAT spat = createSPAT();
        var mapper = new XmlMapper();
        String xml = mapper.writeValueAsString(spat);
        System.out.println(xml);
        assertThat(xml, notNullValue());
    }

    @Test
    public void xmlDeserialize() throws IOException {
        SPAT spat = fromXml(expectedXml);
        assertThat(spat, notNullValue());
    }

    @Test
    public void jsonSerialize() throws IOException {
        SPAT spat = createSPAT();
        var mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(spat);
        System.out.println(json);
        assertThat(json, notNullValue());
    }



    public static SPAT createSPAT() {
        var spat = new SPAT();
        var name = new DescriptiveName();
        name.setValue("Example Name");
        spat.setName(name);
        var moy = new MinuteOfTheYear();
        moy.setValue(400000L);
        spat.setTimeStamp(moy);
        var intersections = new IntersectionStateList();
        var intersection = IntersectionStateTest.createIntersectionState();
        intersections.add(intersection);
        spat.setIntersections(intersections);
        return spat;
    }

    final String expectedXml = """
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
            """;

    final String expectedJson = "";
}
