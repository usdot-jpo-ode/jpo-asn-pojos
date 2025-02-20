package j2735.SPAT;

import j2735.BaseSerializeTest;

import j2735.Common.DSecond;
import j2735.Common.IntersectionID;
import j2735.Common.IntersectionReferenceID;
import j2735.Common.LaneConnectionID;
import j2735.Common.LaneID;
import j2735.Common.MinuteOfTheYear;
import j2735.Common.MsgCount;
import j2735.Common.RoadRegulatorID;
import j2735.Common.SignalGroupID;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IntersectionStateTest extends BaseSerializeTest<IntersectionState> {

    public IntersectionStateTest() {
        super(IntersectionState.class);
    }

    @Test
    public void xmlSerialize() throws IOException {
        IntersectionState me = createIntersectionState();
        String xml =toXml(me);
        assertThat(xml, notNullValue());
    }

    @Test
    public void jsonSerialize() throws IOException {
        IntersectionState me = createIntersectionState();
        String json = toJson(me);
        assertThat(json, notNullValue());
    }

    @Test
    public void xmlDeserialize() throws IOException {
        IntersectionState is = fromXml(XML);
        assertThat(is, notNullValue());
        assertThat(is, hasProperty("status", notNullValue()));
        test(is.getStatus());
    }

    @Test
    public void jsonDeserialize() throws IOException {
        IntersectionState is = fromJson(JSON);
        assertThat(is, notNullValue());
        assertThat(is, hasProperty("status", notNullValue()));
        test(is.getStatus());
    }

    private void test(IntersectionStatusObject iso) {
        for (int i = 0; i < 14; i++) {
            assertTrue(iso.get(i), "bit " + i);
        }
        assertFalse(iso.get(14));
        assertFalse(iso.get(15));
    }

    public static IntersectionState createIntersectionState() {
        var is = new IntersectionState();
        var id = new IntersectionReferenceID();
        var intersectionId = new IntersectionID();
        intersectionId.setValue(12111);
        id.setId(intersectionId);
        var roadRegulatorId = new RoadRegulatorID();
        roadRegulatorId.setValue(0);
        id.setRegion(roadRegulatorId);
        is.setId(id);
        var rev = new MsgCount();
        rev.setValue((byte)0);
        is.setRevision(rev);
        var statusObj = createIntersectionStatusObject();
        is.setStatus(statusObj);
        var moy = new MinuteOfTheYear();
        moy.setValue(400000);
        is.setMoy(moy);
        var ts = new DSecond();
        ts.setValue(35176);
        is.setTimeStamp(ts);
        var enabledLanes = new EnabledLaneList();
        var laneId = new LaneID();
        laneId.setValue((short)1);
        enabledLanes.add(laneId);
        is.setEnabledLanes(enabledLanes);
        var states = new MovementList();
        var ms = new MovementState();
        var signalGroup = new SignalGroupID();
        signalGroup.setValue((short)2);
        ms.setSignalGroup(signalGroup);
        var sts = new MovementEventList();
        var me = MovementEventTest.createPojo();
        sts.add(me);
        ms.setState_time_speed(sts);
        ms.setManeuverAssistList(maneuverAssistList());
        states.add(ms);
        is.setStates(states);
        is.setManeuverAssistList(maneuverAssistList());
        return is;
    }


    public static IntersectionStatusObject createIntersectionStatusObject() {
        var statusObj = new IntersectionStatusObject();
        statusObj.setFailureFlash(true);
        statusObj.setFailureMode(true);
        statusObj.setFixedTimeOperation(true);
        statusObj.setManualControlIsEnabled(true);
        statusObj.setNoValidMAPisAvailableAtThisTime(true);
        statusObj.setNoValidSPATisAvailableAtThisTime(true);
        statusObj.setOff(true);
        statusObj.setPreemptIsActive(true);
        statusObj.setRecentChangeInMAPassignedLanesIDsUsed(true);
        statusObj.setRecentMAPmessageUpdate(true);
        statusObj.setSignalPriorityIsActive(true);
        statusObj.setStandbyOperation(true);
        statusObj.setStopTimeIsActivated(true);
        statusObj.setTrafficDependentOperation(true);
        return statusObj;
    }

    public static ManeuverAssistList maneuverAssistList() {
        var mal = new ManeuverAssistList();
        var cma = new ConnectionManeuverAssist();
        var connId = new LaneConnectionID();
        connId.setValue((short)1);
        cma.setConnectionID(connId);
        mal.add(cma);
        var zl = new ZoneLength();
        zl.setValue((short)0);
        cma.setQueueLength(zl);
        cma.setAvailableStorageLength(zl);
        var wos = new WaitOnStopline();
        wos.setValue(true);
        cma.setWaitOnStop(wos);
        var pbd = new PedestrianBicycleDetect();
        pbd.setValue(true);
        cma.setPedBicycleDetect(pbd);
        return mal;
    }

    final String XML = """
            <IntersectionState>
                <id>
                    <region>0</region>
                    <id>12111</id>
                </id>
                <revision>0</revision>
                <status>1111111111111100</status>
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
                </maneuverAssistList>
            </IntersectionState>
            """;

    private final static String JSON = """
            {
                "id": {
                    "region": 0,
                    "id": 12111
                },
                "revision": 0,
                "status": "fffc",
                "moy": 400000,
                "timeStamp": 35176,
                "enabledLanes": [
                    1
                ],
                "states": [
                    {
                        "signalGroup": 2,
                        "maneuverAssistList": [
                            {
                                "connectionID": 1,
                                "queueLength": 0,
                                "availableStorageLength": 0,
                                "waitOnStop": true,
                                "pedBicycleDetect": true
                            }
                        ],
                        "state-time-speed": [
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
                        ]
                    }
                ],
                "maneuverAssistList": [
                    {
                        "connectionID": 1,
                        "queueLength": 0,
                        "availableStorageLength": 0,
                        "waitOnStop": true,
                        "pedBicycleDetect": true
                    }
                ]
            }
            """;
}
