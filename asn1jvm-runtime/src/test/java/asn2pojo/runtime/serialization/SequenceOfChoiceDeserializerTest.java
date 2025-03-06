package asn2pojo.runtime.serialization;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.xmlunit.matchers.CompareMatcher.isIdenticalTo;

import asn2pojo.runtime.BaseSerializeTest;
import asn2pojo.runtime.examples.MessageContainsSequenceOfChoice;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SequenceOfChoiceDeserializerTest extends BaseSerializeTest<MessageContainsSequenceOfChoice> {

  public SequenceOfChoiceDeserializerTest() {
    super(MessageContainsSequenceOfChoice.class);
  }

  @ParameterizedTest
  @MethodSource("xmlValues")
  public void canRoundTripXml(final String description, final String xml) throws IOException {
    MessageContainsSequenceOfChoice m = fromXml(xml);
    assertThat(description, m, notNullValue());
    String roundTripXml = toXml(m);
    assertThat(description, roundTripXml, isIdenticalTo(xml).ignoreWhitespace().ignoreElementContentWhitespace());
  }

  private static Stream<Arguments> xmlValues() {
    return Stream.of(
        Arguments.of("Single value", XML_SINGLE),
        Arguments.of("Unique values", XML_UNIQUE),
        Arguments.of("Duplicate values, ordered", XML_DUPLICATES),
        Arguments.of("Duplicate values, mixed order", XML_MIXED)
    );
  }

  public static final String XML_SINGLE = """
      <MessageContainsSequenceOfChoice>
        <id>10</id>
        <choices>
          <a>
            <a-int>5</a-int>
            <a-str>asdf</a-str>
          </a>
        </choices>
      </MessageContainsSequenceOfChoice>
      """;

  public static final String XML_UNIQUE = """
      <MessageContainsSequenceOfChoice>
        <id>10</id>
        <choices>
          <a>
            <a-int>5</a-int>
            <a-str>asdf</a-str>
          </a>
          <b>
            <b-int>6</b-int>
            <b-str>qwerty</b-str>
          </b>
        </choices>
      </MessageContainsSequenceOfChoice>
      """;

  public static final String XML_DUPLICATES = """
      <MessageContainsSequenceOfChoice>
        <id>10</id>
        <choices>
          <a>
            <a-int>5</a-int>
            <a-str>asdf</a-str>
          </a>
          <a>
            <a-int>10</a-int>
            <a-str>yuio</a-str>
          </a>
          <b>
            <b-int>6</b-int>
            <b-str>qwerty</b-str>
          </b>
          <b>
            <b-int>12</b-int>
            <b-str>hjkl</b-str>
          </b>
        </choices>
      </MessageContainsSequenceOfChoice>
      """;

  public static final String XML_MIXED = """
      <MessageContainsSequenceOfChoice>
        <id>10</id>
        <choices>
          <a>
            <a-int>5</a-int>
            <a-str>asdf</a-str>
          </a>
          <b>
            <b-int>6</b-int>
            <b-str>qwerty</b-str>
          </b>
          <a>
            <a-int>10</a-int>
            <a-str>yuio</a-str>
          </a>
          <b>
            <b-int>12</b-int>
            <b-str>hjkl</b-str>
          </b>
        </choices>
      </MessageContainsSequenceOfChoice>
      """;
}
