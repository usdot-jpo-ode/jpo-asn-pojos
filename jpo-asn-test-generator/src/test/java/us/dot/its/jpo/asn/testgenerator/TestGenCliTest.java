package us.dot.its.jpo.asn.testgenerator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

import java.io.PrintWriter;
import java.io.StringWriter;
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
    return Stream.of(
        Arguments.of("SPAT", "SPAT", "<SPAT>", "\"intersections\""),
        Arguments.of(
            "BasicSafetyMessage", "BasicSafetyMessage", "<BasicSafetyMessage>", "\"coreData\""),
        Arguments.of(
            "TravelerInformation",
            "TravelerInformation",
            "<TravelerInformation>",
            "\"dataFrames\""),
        Arguments.of(
            "PersonalSafetyMessage",
            "PersonalSafetyMessage",
            "<PersonalSafetyMessage>",
            "\"basicType\""),
        Arguments.of("MapData", "MapData", "<MapData>", "\"layerType\""),
        Arguments.of("ProbeDataConfig", "ProbeDataConfigMessage", "<ProbeDataConfigMessage>", "{"),
        // Test choice with null.
        Arguments.of(
            "ProbeDataReport",
            "RptDriverAlertsAndWarnings",
            "<RptDriverAlertsAndWarnings>",
            "null"),
        Arguments.of("MessageFrame", "MessageFrame", "<MessageFrame>", "\"messageId\""));
  }
}
