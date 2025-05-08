package us.dot.its.jpo.asn.runtime.examples;

import us.dot.its.jpo.asn.runtime.serialization.SequenceOfChoiceDeserializer;
import us.dot.its.jpo.asn.runtime.serialization.SequenceOfChoiceSerializer;
import us.dot.its.jpo.asn.runtime.types.Asn1SequenceOf;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class SequenceOfChoice extends Asn1SequenceOf<Choice> {

  public SequenceOfChoice() {
    super(Choice.class, 1L, 5L);
  }

  public static class TestSequenceOfChoiceSerializer
      extends SequenceOfChoiceSerializer<Choice, SequenceOfChoice> {

    public TestSequenceOfChoiceSerializer() {
      super(Choice.class, SequenceOfChoice.class);
    }
  }

  public static class TestSequenceOfChoiceDeserializer extends
      SequenceOfChoiceDeserializer<Choice, SequenceOfChoice> {

    protected TestSequenceOfChoiceDeserializer() {
      super(Choice.class, SequenceOfChoice.class);
    }

    @Override
    protected SequenceOfChoice construct() {
      return new SequenceOfChoice();
    }
  }
}
