package j2735.TravelerInformation;

import j2735.BaseSerializeTest;

import j2735.ITIS.ITIScodes;
import j2735.ITIS.ITIScodesAndText;
import j2735.ITIS.ITIScodesAndTextSequence;
import j2735.MessageFrame.DSRCmsgID;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TIMMessageFrameTest extends BaseSerializeTest<TravelerInformationMessageFrame> {

    public TIMMessageFrameTest() {
        super(TravelerInformationMessageFrame.class);
    }

    @Test
    public void xmlDeserialize_MultiITISCode() throws IOException {
        TravelerInformationMessageFrame tim = fromXml(expectedXml);
        assertThat(tim, notNullValue());
        assertThat(tim, hasProperty("messageId", equalTo(new DSRCmsgID(31))));
        ITIScodesAndText itisArray =  tim.getValue().getDataFrames().get(0).getContent().getAdvisory();
        assertThat(itisArray, hasSize(greaterThan(0)));
        ITIScodesAndTextSequence itisSeq = itisArray.get(0);
        ITIScodes itisCodes = itisSeq.getItem().getItis();
        assertThat(itisCodes, notNullValue());
        assertThat(itisCodes.getValue(), equalTo(513L));
    }

    @Test
    public void xmlDeserialize_SingleITISCode() throws IOException {
        TravelerInformationMessageFrame tim = fromXml(xmlSingleITISCode);
        assertThat(tim, notNullValue());
        assertThat(tim, hasProperty("messageId", equalTo(new DSRCmsgID(31))));
        ITIScodesAndText itisArray =  tim.getValue().getDataFrames().get(0).getContent().getAdvisory();
        assertThat(itisArray, hasSize(greaterThan(0)));
        ITIScodesAndTextSequence itisSeq = itisArray.get(0);
        ITIScodes itisCodes = itisSeq.getItem().getItis();
        assertThat(itisCodes, notNullValue());
        assertThat(itisCodes.getValue(), equalTo(513L));
    }

    @Test
    public void xmlSerialize() throws IOException {
        // The xmlDeserialize test has to work for this to work
        TravelerInformationMessageFrame tim = fromXml(expectedXml);
        String xml = toXml(tim);
        assertThat(xml, notNullValue());
    }

    @Test
    public void xmlDeserialize_generatedXml() throws IOException {
        TravelerInformationMessageFrame tim = fromXml(loadResource(
            "/j2735/TravelerInformation/GeneratedTim.xml"));
        assertThat(tim, notNullValue());
        assertThat(tim, hasProperty("messageId", equalTo(new DSRCmsgID(31))));
    }

    @Test
    public void xmlDeserialize_generatedXmlWithComputedLanes() throws IOException {
        TravelerInformationMessageFrame tim = fromXml(loadResource(
            "/j2735/TravelerInformation/GeneratedTimWithComputedLanes.xml"));
        assertThat(tim, notNullValue());
        assertThat(tim, hasProperty("messageId", equalTo(new DSRCmsgID(31))));
    }

    public final static String expectedXml = """
<MessageFrame>
    <messageId>31</messageId>
    <value>
        <TravelerInformation>
            <msgCnt>1</msgCnt>
            <timeStamp>309505</timeStamp>
            <packetID>000000000000000000</packetID>
            <urlB>null</urlB>
            <dataFrames>
                <TravelerDataFrame>
                    <sspTimRights>0</sspTimRights>
                    <frameType>
                        <advisory/>
                    </frameType>
                    <msgId>
                        <roadSignID>
                            <position>
                                <lat>416784730</lat>
                                <long>-1087827750</long>
                                <elevation>9171</elevation>
                            </position>
                            <viewAngle>0101010101010100</viewAngle>
                            <mutcdCode>
                                <guide/>
                            </mutcdCode>
                            <crc>0000</crc>
                        </roadSignID>
                    </msgId>
                    <startYear>2017</startYear>
                    <startTime>308065</startTime>
                    <durationTime>1</durationTime>
                    <priority>0</priority>
                    <sspLocationRights>3</sspLocationRights>
                    <regions>
                        <GeographicalPath>
                            <name>Testing TIM</name>
                            <id>
                                <region>0</region>
                                <id>33</id>
                            </id>
                            <anchor>
                                <lat>412500807</lat>
                                <long>-1110093847</long>
                                <elevation>20206</elevation>
                            </anchor>
                            <laneWidth>700</laneWidth>
                            <directionality>
                                <both/>
                            </directionality>
                            <closedPath>
                                <false/>
                            </closedPath>
                            <direction>0000000000010100</direction>
                            <description>
                                <path>
                                    <scale>0</scale>
                                    <offset>
                                        <ll>
                                            <nodes>
                                                <NodeLL>
                                                    <delta>
                                                        <node-LL3>
                                                            <lon>14506</lon>
                                                            <lat>31024</lat>
                                                        </node-LL3>
                                                    </delta>
                                                </NodeLL>
                                                <NodeLL>
                                                    <delta>
                                                        <node-LL3>
                                                            <lon>14568</lon>
                                                            <lat>30974</lat>
                                                        </node-LL3>
                                                    </delta>
                                                </NodeLL>
                                                <NodeLL>
                                                    <delta>
                                                        <node-LL3>
                                                            <lon>14559</lon>
                                                            <lat>30983</lat>
                                                        </node-LL3>
                                                    </delta>
                                                </NodeLL>
                                                <NodeLL>
                                                    <delta>
                                                        <node-LL3>
                                                            <lon>14563</lon>
                                                            <lat>30980</lat>
                                                        </node-LL3>
                                                    </delta>
                                                </NodeLL>
                                                <NodeLL>
                                                    <delta>
                                                        <node-LL3>
                                                            <lon>14562</lon>
                                                            <lat>30982</lat>
                                                        </node-LL3>
                                                    </delta>
                                                </NodeLL>
                                            </nodes>
                                        </ll>
                                    </offset>
                                </path>
                            </description>
                        </GeographicalPath>
                    </regions>
                    <sspMsgRights1>2</sspMsgRights1>
                    <sspMsgRights2>3</sspMsgRights2>
                    <content>
                        <advisory>
                            <SEQUENCE>
                                <item>
                                    <itis>513</itis>
                                </item>
                            </SEQUENCE>
                            <SEQUENCE>
                                <item>
                                    <itis>620</itis>
                                </item>
                            </SEQUENCE>
                        </advisory>
                    </content>
                    <url>null</url>
                </TravelerDataFrame>
            </dataFrames>
        </TravelerInformation>
    </value>
</MessageFrame>
""";


    public final static String xmlSingleITISCode = """
<MessageFrame>
    <messageId>31</messageId>
    <value>
        <TravelerInformation>
            <msgCnt>1</msgCnt>
            <timeStamp>309505</timeStamp>
            <packetID>000000000000000000</packetID>
            <urlB>null</urlB>
            <dataFrames>
                <TravelerDataFrame>
                    <sspTimRights>0</sspTimRights>
                    <frameType>
                        <advisory/>
                    </frameType>
                    <msgId>
                        <roadSignID>
                            <position>
                                <lat>416784730</lat>
                                <long>-1087827750</long>
                                <elevation>9171</elevation>
                            </position>
                            <viewAngle>0101010101010100</viewAngle>
                            <mutcdCode>
                                <guide/>
                            </mutcdCode>
                            <crc>0000</crc>
                        </roadSignID>
                    </msgId>
                    <startYear>2017</startYear>
                    <startTime>308065</startTime>
                    <durationTime>1</durationTime>
                    <priority>0</priority>
                    <sspLocationRights>3</sspLocationRights>
                    <regions>
                        <GeographicalPath>
                            <name>Testing TIM</name>
                            <id>
                                <region>0</region>
                                <id>33</id>
                            </id>
                            <anchor>
                                <lat>412500807</lat>
                                <long>-1110093847</long>
                                <elevation>20206</elevation>
                            </anchor>
                            <laneWidth>700</laneWidth>
                            <directionality>
                                <both/>
                            </directionality>
                            <closedPath>
                                <false/>
                            </closedPath>
                            <direction>0000000000010100</direction>
                            <description>
                                <path>
                                    <scale>0</scale>
                                    <offset>
                                        <ll>
                                            <nodes>
                                                <NodeLL>
                                                    <delta>
                                                        <node-LL3>
                                                            <lon>14506</lon>
                                                            <lat>31024</lat>
                                                        </node-LL3>
                                                    </delta>
                                                </NodeLL>
                                                <NodeLL>
                                                    <delta>
                                                        <node-LL3>
                                                            <lon>14568</lon>
                                                            <lat>30974</lat>
                                                        </node-LL3>
                                                    </delta>
                                                </NodeLL>
                                                <NodeLL>
                                                    <delta>
                                                        <node-LL3>
                                                            <lon>14559</lon>
                                                            <lat>30983</lat>
                                                        </node-LL3>
                                                    </delta>
                                                </NodeLL>
                                                <NodeLL>
                                                    <delta>
                                                        <node-LL3>
                                                            <lon>14563</lon>
                                                            <lat>30980</lat>
                                                        </node-LL3>
                                                    </delta>
                                                </NodeLL>
                                                <NodeLL>
                                                    <delta>
                                                        <node-LL3>
                                                            <lon>14562</lon>
                                                            <lat>30982</lat>
                                                        </node-LL3>
                                                    </delta>
                                                </NodeLL>
                                            </nodes>
                                        </ll>
                                    </offset>
                                </path>
                            </description>
                        </GeographicalPath>
                    </regions>
                    <sspMsgRights1>2</sspMsgRights1>
                    <sspMsgRights2>3</sspMsgRights2>
                    <content>
                        <advisory>
                            <SEQUENCE>
                                <item>
                                    <itis>513</itis>
                                </item>
                            </SEQUENCE>
                        </advisory>
                    </content>
                    <url>null</url>
                </TravelerDataFrame>
            </dataFrames>
        </TravelerInformation>
    </value>
</MessageFrame>
""";




}
