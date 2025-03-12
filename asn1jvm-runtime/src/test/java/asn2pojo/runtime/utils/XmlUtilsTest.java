package asn2pojo.runtime.utils;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static asn2pojo.runtime.utils.XmlUtils.*;
import static org.hamcrest.MatcherAssert.assertThat;
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

  final static String EXAMPLE = "Example";
  final static String BEGIN = "<" + EXAMPLE + ">";
  final static String END = "</" + EXAMPLE + ">";

}
