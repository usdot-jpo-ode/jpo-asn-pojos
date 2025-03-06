package asn2pojo.runtime.serialization;

import static net.javacrumbs.jsonunit.JsonMatchers.jsonEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.xmlunit.matchers.CompareMatcher.isIdenticalTo;

import asn2pojo.runtime.BaseSerializeTest;
import asn2pojo.runtime.examples.MessageContainsSequenceOfEnumerated;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SequenceOfEnumeratedDeserializerTest extends
    BaseSerializeTest<MessageContainsSequenceOfEnumerated> {

  public SequenceOfEnumeratedDeserializerTest() {
    super(MessageContainsSequenceOfEnumerated.class);
  }

  @ParameterizedTest
  @MethodSource("xmlValues")
  public void canRoundTripXml(final String description, final String xml) throws IOException {
    MessageContainsSequenceOfEnumerated m = fromXml(xml);
    assertThat(description, m, notNullValue());
    String roundTripXml = toXml(m);
    assertThat(description, roundTripXml, isIdenticalTo(xml).ignoreWhitespace().ignoreElementContentWhitespace());
  }

  @ParameterizedTest
  @MethodSource("jsonValues")
  public void canRoundTripJson(final String description, final String json) throws IOException {
    MessageContainsSequenceOfEnumerated m = fromJson(json);
    assertThat(description, m, notNullValue());
    String roundTripJson = toJson(m);
    assertThat(description, roundTripJson, jsonEquals(json));
  }

  private static Stream<Arguments> xmlValues() {
    return Stream.of(
        Arguments.of("Single value", XML_SINGLE),
        Arguments.of("Unique values", XML_UNIQUE),
        Arguments.of("Duplicate values, ordered", XML_DUPLICATES),
        Arguments.of("Duplicate values, mixed order", XML_MIXED)
    );
  }

  private static Stream<Arguments> jsonValues() {
    return Stream.of(
        Arguments.of("Single value", JSON_SINGLE),
        Arguments.of("Unique values", JSON_UNIQUE),
        Arguments.of("Duplicate values, ordered", JSON_DUPLICATES),
        Arguments.of("Duplicate values, mixed order", JSON_MIXED)
    );
  }

  public static final String XML_SINGLE = """
      <MessageContainsSequenceOfEnumerated>
        <id>1</id>
        <fruits>
          <apple/>
        </fruits>
      </MessageContainsSequenceOfEnumerated>
      """;

  public static final String JSON_SINGLE = """
      {
        "id": 1,
        "fruits": [
          "apple"
        ]
      }
      """;

  public static final String XML_UNIQUE = """
      <MessageContainsSequenceOfEnumerated>
        <id>1</id>
        <fruits>
          <apple/>
          <orange/>
          <banana/>
        </fruits>
      </MessageContainsSequenceOfEnumerated>
      """;

  public static final String JSON_UNIQUE = """
      {
        "id": 1,
        "fruits": [
          "apple",
          "orange",
          "banana"
        ]
      }
      """;

  public static final String XML_DUPLICATES = """
      <MessageContainsSequenceOfEnumerated>
        <id>1</id>
        <fruits>
          <apple/>
          <apple/>
          <orange/>
          <orange/>
          <banana/>
          <banana/>
        </fruits>
      </MessageContainsSequenceOfEnumerated>
      """;

  public static final String JSON_DUPLICATES = """
      {
        "id": 1,
        "fruits": [
          "apple",
          "apple",
          "orange",
          "orange",
          "banana",
          "banana"
        ]
      }
      """;

  public static final String XML_MIXED = """
      <MessageContainsSequenceOfEnumerated>
        <id>1</id>
        <fruits>
          <apple/>
          <orange/>
          <apple/>
          <banana/>
          <orange/>
          <banana/>
        </fruits>
      </MessageContainsSequenceOfEnumerated>
      """;

  public static final String JSON_MIXED = """
    {
        "id": 1,
        "fruits": [
          "apple",
          "orange",
          "apple",
          "banana",
          "orange",
          "banana"
        ]
      }
    """;
}


