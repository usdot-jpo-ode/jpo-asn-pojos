package us.dot.its.jpo.asn.testgenerator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import picocli.CommandLine;

@Slf4j
public class TestGenCliTest {

  @Test
  public void testUsage() {
    var cli = new TestGenCli();
    CommandLine cmd = new CommandLine(cli);
    StringWriter swErr = new StringWriter();
    StringWriter swOut = new StringWriter();
    cmd.setErr(new PrintWriter(swErr));
    cmd.setOut(new PrintWriter(swOut));

    // Missing required options should return usage
    int exitCode = cmd.execute();

    final String stderr = swErr.toString();
    final String stdout = swOut.toString();

    log.debug("exit code: {}", exitCode);
    log.debug("stderr: {}", stderr);

    assertThat(exitCode, equalTo(CommandLine.ExitCode.USAGE));
    assertThat("expect usage on stderr", stderr, containsString("Usage"));
    assertThat("expect nothing on stdout", stdout, emptyString());
  }

  @ParameterizedTest
  @MethodSource("messageTypes")
  public void testGenerateMessage(
      final String module, final String pdu, final String expectXml, final String expectJson) {
    var cli = new TestGenCli();
    CommandLine cmd = new CommandLine(cli);
    var swErr = new StringWriter();
    var swOut = new StringWriter();
    cmd.setErr(new PrintWriter(swErr));
    cmd.setOut(new PrintWriter(swOut));

    int exitCode = cmd.execute(String.format("-m=%s", module), String.format("-p=%s", pdu));

    final String stderr = swErr.toString();
    final String stdout = swOut.toString();

    log.debug("exit code: {}", exitCode);
    log.debug("stdout: {}", stdout);

    assertThat(exitCode, equalTo(CommandLine.ExitCode.OK));
    assertThat("expect nothing on stderr", stderr, emptyString());
    assertThat("expect XML fragment", stdout, containsString(expectXml));
    assertThat("expect JSON fragment", stdout, containsString(expectJson));
  }

  @Test
  public void testExcludePdu() {
    var cli = new TestGenCli();
    CommandLine cmd = new CommandLine(cli);
    var swErr = new StringWriter();
    var swOut = new StringWriter();
    cmd.setErr(new PrintWriter(swErr));
    cmd.setOut(new PrintWriter(swOut));

    int exitCode =
        cmd.execute("-m=Common", "-p=NodeAttributeSetXY", "-xp=Common.LaneDataAttributeList");

    final String stderr = swErr.toString();
    final String stdout = swOut.toString();

    log.debug("exit code: {}", exitCode);
    log.debug("stdout: {}", stdout);

    assertThat(exitCode, equalTo(CommandLine.ExitCode.OK));
    assertThat("expect nothing on stderr", stderr, emptyString());
    assertThat("expect XML fragment", stdout, containsString("<NodeAttributeSetXY>"));
    assertThat("expect JSON fragment", stdout, containsString("\"localNode\""));
    assertThat("should exclude data element", stdout, not(containsString("<data>")));
    assertThat("should exclude data element", stdout, not(containsString("\"data\"")));
  }

  public static Stream<Arguments> messageTypes() {
    var args =
        new String[][] {
          {"SPAT", "SPAT", "<SPAT>", "\"intersections\""},
          {"BasicSafetyMessage", "BasicSafetyMessage", "<BasicSafetyMessage>", "coreData"},
          {"CommonSafetyRequest", "CommonSafetyRequest", "<CommonSafetyRequest>", "timeStamp"},
          {
            "CooperativeControlMessage",
            "CooperativeControlMessage",
            "<CooperativeControlMessage>",
            "coreData"
          },
          {"EmergencyVehicleAlert", "EmergencyVehicleAlert", "<EmergencyVehicleAlert>", "rsaMsg"},
          {"IntersectionCollision", "IntersectionCollision", "<IntersectionCollision>", "msgCnt"},
          {
            "ManeuverSharingAndCoordinatingMessage",
            "ManeuverSharingAndCoordinatingMessage",
            "<ManeuverSharingAndCoordinatingMessage>",
            "\"maneuver\""
          },
          {"MapData", "MapData", "<MapData>", "\"layerType\""},
          {"NMEAcorrections", "NMEAcorrections", "<NMEAcorrections>", "payload"},
          {
            "PersonalSafetyMessage", "PersonalSafetyMessage", "<PersonalSafetyMessage>", "basicType"
          },
          {"ProbeDataConfig", "ProbeDataConfigMessage", "<ProbeDataConfigMessage>", "descriptor"},
          {"ProbeDataManagement", "ProbeDataManagement", "<ProbeDataManagement>", "timeStamp"},
          // Test choice with null.
          {"ProbeDataReport", "RptDriverAlertsAndWarnings", "<RptDriverAlertsAndWarnings>", "null"},
          {"ProbeVehicleData", "ProbeVehicleData", "<ProbeVehicleData>", "probeID"},
          {"RoadSafetyMessage", "RoadSafetyMessage", "<RoadSafetyMessage>", "commonContainer"},
          {"RoadSideAlert", "RoadSideAlert", "<RoadSideAlert>", "msgCnt"},
          {
            "RoadUserChargingConfigMessage",
            "RoadUserChargingConfigMessage",
            "<RoadUserChargingConfigMessage>",
            "chargerInfoTable"
          },
          {
            "RoadUserChargingReportMessage",
            "RoadUserChargingReportMessage",
            "<RoadUserChargingReportMessage>",
            "usageReport"
          },
          // Top level choice, JSON is unpredictable
          {"RoadWeatherMessage", "RoadWeatherMessage", "<RoadWeatherMessage>", "{"},
          {"RTCMcorrections", "RTCMcorrections", "<RTCMcorrections>", "rtcmHeader"},
          {
            "SensorDataSharingMessage",
            "SensorDataSharingMessage",
            "<SensorDataSharingMessage>",
            "sourceID"
          },
          {"SignalRequestMessage", "SignalRequestMessage", "<SignalRequestMessage>", "timeStamp"},
          {"SignalStatusMessage", "SignalStatusMessage", "<SignalStatusMessage>", "timeStamp"},
          {"TestMessage01", "TestMessage01", "<TestMessage01>", "header"},
          {
            "TollAdvertisementMessage",
            "TollAdvertisementMessage",
            "<TollAdvertisementMessage>",
            "tollChargesTable"
          },
          {"TollUsageAckMessage", "TollUsageAckMessage", "<TollUsageAckMessage>", "tumAck"},
          {
            "TrafficLightStatusMessage",
            "TrafficLightStatusMessage",
            "<TrafficLightStatusMessage>",
            "trafficLightID"
          },
          {"TrafficLightStatusMessage", "TrafficLightID", "<TrafficLightID>", "id"},
          {"TravelerInformation", "TravelerInformation", "<TravelerInformation>", "dataFrames"},
          {"MessageFrame", "MessageFrame", "<MessageFrame>", "messageId"}
        };
    return Arrays.stream(args).map(Arguments::of);
  }
}
