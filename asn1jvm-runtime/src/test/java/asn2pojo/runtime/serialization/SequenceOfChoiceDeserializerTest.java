package asn2pojo.runtime.serialization;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.xmlunit.matchers.CompareMatcher.isIdenticalTo;

import asn2pojo.runtime.BaseSerializeTest;
import asn2pojo.runtime.examples.Message;
import java.io.IOException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class SequenceOfChoiceDeserializerTest extends BaseSerializeTest<Message> {

  public SequenceOfChoiceDeserializerTest() {
    super(Message.class);
  }

  @ParameterizedTest
  @ValueSource(strings = {
      XML_SINGLE,
      XML_UNIQUE,
      XML_DUPLICATES,
      XML_MIXED})
  public void canRoundTripXml(final String xml) throws IOException {
    Message m = fromXml(xml);
    assertThat(m, notNullValue());
    String roundTripXml = toXml(m);
    assertThat(roundTripXml, isIdenticalTo(xml).ignoreWhitespace().ignoreElementContentWhitespace());
  }

  public static final String XML_SINGLE = """
      <Message>
        <id>10</id>
        <choices>
          <a>
            <a-int>5</a-int>
            <a-str>asdf</a-str>
          </a>
        </choices>
      </Message>
      """;

  public static final String XML_UNIQUE = """
      <Message>
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
      </Message>
      """;

  public static final String XML_DUPLICATES = """
      <Message>
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
      </Message>
      """;

  public static final String XML_MIXED = """
      <Message>
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
      </Message>
      """;
}
