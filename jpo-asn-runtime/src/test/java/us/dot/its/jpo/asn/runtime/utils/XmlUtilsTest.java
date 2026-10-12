package us.dot.its.jpo.asn.runtime.utils;

import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static us.dot.its.jpo.asn.runtime.utils.XmlUtils.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.xmlunit.matchers.CompareMatcher.isIdenticalTo;

public class XmlUtilsTest {

  @ParameterizedTest
  @ValueSource(strings = {
      "<Example><A/><B/></Example>",
      "<Example><A>text</A><B>text</B></Example>",
      "<Example> <A> text </A><B> text </B> </Example>",
      " <Example><A/><B/></Example> ",
      " <Example> <A/><B/> </Example> ",
      """
          <Example>
              <A/>
              <B/>
          </Example>"""
  })
  public void unwrapTest(final String xml) {
    final String unwrapped = unwrap(xml);
    assertThat(xml, isIdenticalTo(BEGIN + unwrapped + END)
        .ignoreWhitespace().ignoreElementContentWhitespace());
  }

  @Test
  public void extractXmlSubtreePreservesOrderEscapesAndLeavesFollowingSibling() throws IOException {
    final String input = "<root><frame><item>first</item><item>second &amp; &lt;tag&gt;</item>"
        + "<empty/><enabled><true/></enabled></frame><after>yes</after></root>";
    final XmlMapper mapper = new XmlMapper();
    try (FromXmlParser parser = parserAtFrame(mapper, input)) {
      final String subtree = extractXmlSubtree(parser);
      assertEquals("<frame><item>first</item><item>second &amp; &lt;tag&gt;</item>"
          + "<empty></empty><enabled><true></true></enabled></frame>", subtree);
      assertEquals(JsonToken.END_OBJECT, parser.currentToken());
      assertEquals(JsonToken.FIELD_NAME, parser.nextToken());
      assertEquals("after", parser.getCurrentName());
    }
  }

  private static FromXmlParser parserAtFrame(XmlMapper mapper, String xml) throws IOException {
    FromXmlParser parser = (FromXmlParser) mapper.createParser(xml);
    JsonToken token;
    while ((token = parser.nextToken()) != null) {
      if (token == JsonToken.START_OBJECT
          && parser.getParsingContext().getParent() != null
          && "frame".equals(parser.getParsingContext().getParent().getCurrentName())) {
        return parser;
      }
    }
    parser.close();
    throw new IllegalStateException("frame element not found");
  }

  final static String EXAMPLE = "Example";
  final static String BEGIN = "<" + EXAMPLE + ">";
  final static String END = "</" + EXAMPLE + ">";

}
