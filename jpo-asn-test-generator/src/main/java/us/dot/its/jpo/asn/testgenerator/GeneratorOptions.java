package us.dot.its.jpo.asn.testgenerator;

import java.util.Set;
import picocli.CommandLine.Model.CommandSpec;

public record GeneratorOptions(
    String pdu, int limit, boolean regional, Set<Class<?>> excludePdus, CommandSpec spec) {

  public GeneratorOptions withPdu(String newPdu) {
    return new GeneratorOptions(newPdu, limit, regional, excludePdus, spec);
  }
}
