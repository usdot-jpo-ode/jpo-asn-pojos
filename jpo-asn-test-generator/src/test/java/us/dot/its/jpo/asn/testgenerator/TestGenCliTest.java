package us.dot.its.jpo.asn.testgenerator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.Matchers.equalTo;

import java.io.PrintWriter;
import java.io.StringWriter;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
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

  @Test
  public void testGenerateSpat() {
    var cli = new TestGenCli();
    CommandLine cmd = new CommandLine(cli);
    var swErr = new StringWriter();
    var swOut = new StringWriter();
    cmd.setErr(new PrintWriter(swErr));
    cmd.setOut(new PrintWriter(swOut));

    int exitCode = cmd.execute("-m=SPAT", "-p=SPAT");

    final String stderr = swErr.toString();
    final String stdout = swOut.toString();

    log.debug("exit code: {}", exitCode);
    log.debug("stdout: {}", stdout);

    assertThat(exitCode, equalTo(CommandLine.ExitCode.OK));
    assertThat("expect nothing on stderr", stderr, emptyString());
    assertThat("expect XML fragment", stdout, containsString("<SPAT>"));
    assertThat("expect JSON fragment", stdout, containsString("\"intersections\""));
  }
}
