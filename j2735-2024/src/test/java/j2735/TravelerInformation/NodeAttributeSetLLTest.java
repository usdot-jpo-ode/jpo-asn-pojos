package j2735.TravelerInformation;

import j2735.BaseSerializeTest;
import j2735.Common.DeltaAngle;
import j2735.Common.LaneDataAttribute;
import j2735.Common.LaneDataAttributeList;
import j2735.Common.MergeDivergeNodeAngle;
import j2735.Common.RoadwayCrownAngle;
import org.junit.jupiter.api.Test;


import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class NodeAttributeSetLLTest extends BaseSerializeTest<NodeAttributeSetLL> {

    public NodeAttributeSetLLTest() {
        super(NodeAttributeSetLL.class);
    }

    @Test
    public void xmlDeserialize() throws IOException {
        NodeAttributeSetLL obj = fromXml(xml);
        assertThat(obj, notNullValue());
        var data = obj.getData();
        assertThat(data, allOf(notNullValue(), hasSize(greaterThan(0))));
    }

    @Test
    public void xmlDeserialize_integerProperties() throws IOException {
        NodeAttributeSetLL obj = fromXml(xml_IntegersOnly);
        assertThat(obj, notNullValue());
        assertThat(obj.getDWidth(), notNullValue());
        assertThat(obj.getDWidth().getValue(), equalTo(162L));
        assertThat(obj.getDElevation(), notNullValue());
        assertThat(obj.getDElevation().getValue(), equalTo(424L));
    }

    @Test
    public void xmlDeserialize_enumListsOnly() throws IOException {
        NodeAttributeSetLL obj = fromXml(xml_enumListsOnly);
        assertThat(obj, notNullValue());
        assertThat(obj.getLocalNode(), hasSize(2));
        assertThat(obj.getDisabled(), hasSize(5));
        assertThat(obj.getEnabled(), hasSize(4));
    }

    @Test
    public void xmlDeserialize_laneAttributeIntData() throws IOException {
        NodeAttributeSetLL obj = fromXml(xml_laneAttributeIntData);
        assertThat(obj, notNullValue());
        LaneDataAttributeList data = obj.getData();
        assertThat(data, notNullValue());
        assertThat(data, hasSize(2));
        var item1 = data.get(0);
        assertThat(item1.getLaneCrownPointRight(), equalTo(new RoadwayCrownAngle(-87)));
        var item2 = data.get(1);
        assertThat(item2.getLaneAngle(), equalTo(new MergeDivergeNodeAngle(-167)));
    }

    @Test
    public void xmlSerialize() throws IOException {
        NodeAttributeSetLL nasll = new NodeAttributeSetLL();
        LaneDataAttributeList ldal = new LaneDataAttributeList();
        LaneDataAttribute lda1 = new LaneDataAttribute();
        lda1.setLaneAngle(new MergeDivergeNodeAngle(101L));
        ldal.add(lda1);
        LaneDataAttribute lda2 = new LaneDataAttribute();
        lda2.setPathEndPointAngle(new DeltaAngle(-8L));
        ldal.add(lda2);
        nasll.setData(ldal);
        String xml = toXml(nasll);
        assertThat(xml, notNullValue());
        assertThat("Should not have more than one data element",
                xml, not(containsString("</data><data>")));
        assertThat("Should not have nested data elements",
                xml, not(containsString("<data><data>")));
        assertThat("Choice items should not be wrapped with class name",
                xml, not(containsString("<LaneDataAttribute>")));
    }

    @Test
    public void jsonSerialize() throws IOException {
        NodeAttributeSetLL nasll = new NodeAttributeSetLL();
        LaneDataAttributeList ldal = new LaneDataAttributeList();
        LaneDataAttribute lda1 = new LaneDataAttribute();
        lda1.setLaneAngle(new MergeDivergeNodeAngle(101L));
        ldal.add(lda1);
        LaneDataAttribute lda2 = new LaneDataAttribute();
        lda2.setPathEndPointAngle(new DeltaAngle(-8L));
        ldal.add(lda2);
        LaneDataAttribute lda3 = new LaneDataAttribute();
        lda3.setLaneCrownPointRight(new RoadwayCrownAngle(-87L));
        ldal.add(lda3);
        nasll.setData(ldal);
        String json = toJson(nasll);
        System.out.println(json);
        assertThat(json, notNullValue());
        assertThat(json, equalTo(json_laneAttributeIntData));
    }

    @Test
    public void jsonDeserialize_laneAttributeIntData() throws IOException {
        NodeAttributeSetLL nasll = fromJson(json_laneAttributeIntData);
        assertThat(nasll, notNullValue());
        var data = nasll.getData();
        assertThat(data, allOf(notNullValue(), hasSize(3)));
        var item1 = data.get(0);
        assertThat(item1.getLaneAngle(), equalTo(new MergeDivergeNodeAngle(101)));
        var item2 = data.get(1);
        assertThat(item2.getPathEndPointAngle(), equalTo(new DeltaAngle(-8)));
        var item3 = data.get(2);
        assertThat(item3.getLaneCrownPointRight(), equalTo(new RoadwayCrownAngle(-87)));
    }

    @Test
    public void jsonDeserialize_laneAttributeData() throws IOException {
        NodeAttributeSetLL nasll = fromJson(json);
        assertThat(nasll, notNullValue());
    }

    public static final String json = """
            {
                "data": [
                    {
                        "laneAngle": 101
                    },
                    {
                        "speedLimits": [
                            {
                                "type": "truckMaxSpeed",
                                "speed": 5822
                            },
                            {
                                "type": "truckNightMaxSpeed",
                                "speed": 3017
                            }
                        ]
                    },
                    {
                        "pathEndPointAngle": -8
                    },
                    {
                        "laneAngle": 62
                    },
                    {
                        "laneCrownPointLeft": 35
                    }
                ]
            }
            """;

    public static final String json_laneAttributeIntData = """
            {"data":[{"laneAngle":101},{"pathEndPointAngle":-8},{"laneCrownPointRight":-87}]}""";

    public static final String xml = """
        <NodeAttributeSetLL>
            <localNode>
                <downstreamStopLine/>
                <closedToTraffic/>
            </localNode>
            <disabled>
                <adjacentParkingOnLeft/>
                <transitStopOnLeft/>
                <parallelParking/>
                <mergingLaneLeft/>
                <curbOnLeft/>
            </disabled>
            <enabled>
                <midBlockCurbPresent/>
                <transitStopInLane/>
                <taperToCenterLine/>
                <lowCurbsPresent/>
            </enabled>
            <data>
                <laneAngle>101</laneAngle>
                <speedLimits>
                    <RegulatorySpeedLimit>
                        <type>
                            <truckMaxSpeed/>
                        </type>
                        <speed>5822</speed>
                    </RegulatorySpeedLimit>
                    <RegulatorySpeedLimit>
                        <type>
                            <truckNightMaxSpeed/>
                        </type>
                        <speed>3017</speed>
                    </RegulatorySpeedLimit>
                </speedLimits>
                <pathEndPointAngle>-8</pathEndPointAngle>
                <laneAngle>62</laneAngle>
                <laneCrownPointLeft>35</laneCrownPointLeft>
            </data>
            <dWidth>162</dWidth>
            <dElevation>424</dElevation>
        </NodeAttributeSetLL>
        """;

    public static final String xml_laneAttributeIntData = """
        <NodeAttributeSetLL>
            <data>
                <laneCrownPointRight>-87</laneCrownPointRight>
                <laneAngle>-167</laneAngle>
            </data>
        </NodeAttributeSetLL>
        """;



    public static final String xml_enumListsOnly = """
        <NodeAttributeSetLL>
            <localNode>
                <downstreamStopLine/>
                <closedToTraffic/>
            </localNode>
            <disabled>
                <adjacentParkingOnLeft/>
                <transitStopOnLeft/>
                <parallelParking/>
                <mergingLaneLeft/>
                <curbOnLeft/>
            </disabled>
            <enabled>
                <midBlockCurbPresent/>
                <transitStopInLane/>
                <taperToCenterLine/>
                <lowCurbsPresent/>
            </enabled>
        </NodeAttributeSetLL>
        """;

    public static final String xml_IntegersOnly = """
        <NodeAttributeSetLL>
            <dWidth>162</dWidth>
            <dElevation>424</dElevation>
        </NodeAttributeSetLL>
        """;

}


