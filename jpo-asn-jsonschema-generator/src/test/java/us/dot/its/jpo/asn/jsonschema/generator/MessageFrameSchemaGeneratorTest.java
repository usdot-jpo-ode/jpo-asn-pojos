package us.dot.its.jpo.asn.jsonschema.generator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.dot.its.jpo.asn.j2735.r2024.BasicSafetyMessage.BasicSafetyMessageMessageFrame;
import us.dot.its.jpo.asn.j2735.r2024.MapData.MapDataMessageFrame;
import us.dot.its.jpo.asn.j2735.r2024.MessageFrame.MessageFrame;
import us.dot.its.jpo.asn.j2735.r2024.PersonalSafetyMessage.PersonalSafetyMessageMessageFrame;
import us.dot.its.jpo.asn.j2735.r2024.RTCMcorrections.RTCMcorrectionsMessageFrame;
import us.dot.its.jpo.asn.j2735.r2024.RoadSafetyMessage.RoadSafetyMessageMessageFrame;
import us.dot.its.jpo.asn.j2735.r2024.SPAT.SPATMessageFrame;
import us.dot.its.jpo.asn.j2735.r2024.SensorDataSharingMessage.SensorDataSharingMessageMessageFrame;
import us.dot.its.jpo.asn.j2735.r2024.SignalRequestMessage.SignalRequestMessageMessageFrame;
import us.dot.its.jpo.asn.j2735.r2024.SignalStatusMessage.SignalStatusMessageMessageFrame;
import us.dot.its.jpo.asn.j2735.r2024.TravelerInformation.TravelerInformationMessageFrame;

class MessageFrameSchemaGeneratorTest {

  private static final ObjectMapper MAPPER = new ObjectMapper();

  private record TypedMessageFrameCase(
      Class<?> messageFrameClass,
      String module,
      String schemaFileName,
      String pduName,
      int messageId,
      List<String> sampleJsonResources) {}

  private static Stream<TypedMessageFrameCase> typedMessageFrameCases() {
    return Stream.of(
        new TypedMessageFrameCase(
            BasicSafetyMessageMessageFrame.class,
            "BasicSafetyMessage",
            "BasicSafetyMessageMessageFrame.schema.json",
            "BasicSafetyMessage",
            20,
            List.of(
                "/us/dot/its/jpo/asn/jsonschema/generator/BasicSafetyMessage/bsm_mf.json",
                "/us/dot/its/jpo/asn/jsonschema/generator/BasicSafetyMessage/message_frame/bsm_mf_noext_01.json",
                "/us/dot/its/jpo/asn/jsonschema/generator/BasicSafetyMessage/message_frame/bsm_mf_allext_01.json")),
        new TypedMessageFrameCase(
            MapDataMessageFrame.class,
            "MapData",
            "MapDataMessageFrame.schema.json",
            "MapData",
            18,
            List.of("/us/dot/its/jpo/asn/jsonschema/generator/MapData/map_mf.json")),
        new TypedMessageFrameCase(
            PersonalSafetyMessageMessageFrame.class,
            "PersonalSafetyMessage",
            "PersonalSafetyMessageMessageFrame.schema.json",
            "PersonalSafetyMessage",
            32,
            List.of("/us/dot/its/jpo/asn/jsonschema/generator/PersonalSafetyMessage/psm_mf.json")),
        new TypedMessageFrameCase(
            RoadSafetyMessageMessageFrame.class,
            "RoadSafetyMessage",
            "RoadSafetyMessageMessageFrame.schema.json",
            "RoadSafetyMessage",
            33,
            List.of("/us/dot/its/jpo/asn/jsonschema/generator/RoadSafetyMessage/rsm_mf.json")),
        new TypedMessageFrameCase(
            RTCMcorrectionsMessageFrame.class,
            "RTCMcorrections",
            "RTCMcorrectionsMessageFrame.schema.json",
            "RTCMcorrections",
            28,
            List.of("/us/dot/its/jpo/asn/jsonschema/generator/RTCMcorrections/rtcm_mf.json")),
        new TypedMessageFrameCase(
            SensorDataSharingMessageMessageFrame.class,
            "SensorDataSharingMessage",
            "SensorDataSharingMessageMessageFrame.schema.json",
            "SensorDataSharingMessage",
            41,
            List.of("/us/dot/its/jpo/asn/jsonschema/generator/SensorDataSharingMessage/sdsm_mf.json")),
        new TypedMessageFrameCase(
            SignalRequestMessageMessageFrame.class,
            "SignalRequestMessage",
            "SignalRequestMessageMessageFrame.schema.json",
            "SignalRequestMessage",
            29,
            List.of("/us/dot/its/jpo/asn/jsonschema/generator/SignalRequestMessage/srm_mf.json")),
        new TypedMessageFrameCase(
            SignalStatusMessageMessageFrame.class,
            "SignalStatusMessage",
            "SignalStatusMessageMessageFrame.schema.json",
            "SignalStatusMessage",
            30,
            List.of("/us/dot/its/jpo/asn/jsonschema/generator/SignalStatusMessage/ssm_mf.json")),
        new TypedMessageFrameCase(
            SPATMessageFrame.class,
            "SPAT",
            "SPATMessageFrame.schema.json",
            "SPAT",
            19,
            List.of("/us/dot/its/jpo/asn/jsonschema/generator/SPAT/spat_mf.json")),
        new TypedMessageFrameCase(
            TravelerInformationMessageFrame.class,
            "TravelerInformation",
            "TravelerInformationMessageFrame.schema.json",
            "TravelerInformation",
            31,
            List.of("/us/dot/its/jpo/asn/jsonschema/generator/TravelerInformation/tim_mf.json")));
  }

  private static Stream<Arguments> typedMessageFrameProvider() {
    return typedMessageFrameCases().map(
        caseData ->
            Arguments.of(
                caseData.messageFrameClass(),
                caseData.module(),
                caseData.schemaFileName(),
                caseData.pduName(),
                caseData.messageId(),
                caseData.sampleJsonResources()));
  }

  @ParameterizedTest
  @MethodSource("typedMessageFrameProvider")
  void generatedTypedSchemaMatchesCommittedResource(
      Class<?> messageFrameClass, String module, String schemaFileName)
      throws IOException {
    JsonNode expected = loadCommittedSchema(module, schemaFileName);
    JsonNode generated = MAPPER.readTree(new JsonSchemaGenerator(messageFrameClass).generate());

    assertThat(generated, equalTo(expected));
  }

  @ParameterizedTest
  @MethodSource("typedMessageFrameProvider")
  void rootTypedMessageFrameSchemaHasMessageIdAndValueEnvelope(
      Class<?> messageFrameClass, String module, String schemaFileName, String pduName, int messageId)
      throws IOException {
    JsonNode schema = MAPPER.readTree(new JsonSchemaGenerator(messageFrameClass).generate());

    assertThat(toStringList(schema.get("required")), contains("messageId", "value"));
    assertThat(schema.get("properties").get("messageId").get("const").asInt(), equalTo(messageId));

    JsonNode value = schema.get("properties").get("value");
    assertThat(value.get("properties").has(pduName), is(true));
    assertThat(toStringList(value.get("required")), contains(pduName));
    assertThat(
        value.get("title").asText(),
        equalTo(messageFrameClass.getName() + "Value"));
  }

  @Test
  void nestedMessageFrameGenerationUsesOpenTypeWrapperOnly() throws IOException {
    JsonNode schema =
        MAPPER.readTree(new JsonSchemaGenerator(BasicSafetyMessageMessageFrame.class, false).generate());

    assertThat(schema.get("properties").has("messageId"), is(false));
    assertThat(schema.get("properties").has("value"), is(false));
    assertThat(schema.get("properties").has("BasicSafetyMessage"), is(true));
    assertThat(toStringList(schema.get("required")), contains("BasicSafetyMessage"));
  }

  @Test
  void generatedGenericMessageFrameSchemaMatchesCommittedResource() throws IOException {
    JsonNode expected = loadCommittedSchema("MessageFrame", "MessageFrame.schema.json");
    JsonNode generated = MAPPER.readTree(new JsonSchemaGenerator(MessageFrame.class).generate());

    assertThat(generated, equalTo(expected));
  }

  @Test
  void genericMessageFrameOneOfBranchesWrapPduInValue() throws IOException {
    JsonNode schema = MAPPER.readTree(new JsonSchemaGenerator(MessageFrame.class).generate());
    ArrayNode oneOf = (ArrayNode) schema.get("oneOf");

    assertThat(oneOf.size(), greaterThan(0));

    for (JsonNode branch : oneOf) {
      JsonNode valueProperties = branch.get("properties").get("value").get("properties");
      assertThat(
          "Generic MessageFrame branches must not double-wrap messageId/value",
          valueProperties.has("messageId"),
          is(false));
      assertThat(valueProperties.size(), greaterThan(0));
    }

    JsonNode basicSafetyBranch = findBranchByMessageId(oneOf, 20);
    assertThat(
        basicSafetyBranch.get("properties").get("value").get("properties").has("BasicSafetyMessage"),
        is(true));
  }

  @ParameterizedTest
  @MethodSource("typedMessageFrameProvider")
  void generatedTypedSchemaValidatesSampleMessageFrameJson(
      Class<?> messageFrameClass, String module, String schemaFileName, String pduName,
      int messageId, List<String> sampleJsonResources)
      throws IOException {
    JsonNode schemaNode = MAPPER.readTree(new JsonSchemaGenerator(messageFrameClass).generate());
    JsonSchemaFactory factory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V7);
    JsonSchema jsonSchema = factory.getSchema(schemaNode);

    for (String resource : sampleJsonResources) {
      JsonNode jsonNode = MAPPER.readTree(JsonFileLoader.loadResource(resource));
      Set<ValidationMessage> errors = jsonSchema.validate(jsonNode);
      assertThat("Sample JSON should validate: " + resource, errors, empty());
    }
  }

  private static JsonNode loadCommittedSchema(String module, String schemaFileName)
      throws IOException {
    String path = String.format("/schemas/%s/%s", module, schemaFileName);
    return MAPPER.readTree(JsonFileLoader.loadResource(path));
  }

  private static List<String> toStringList(JsonNode arrayNode) {
    List<String> values = new ArrayList<>();
    if (arrayNode != null && arrayNode.isArray()) {
      arrayNode.forEach(node -> values.add(node.asText()));
    }
    return values;
  }

  private static JsonNode findBranchByMessageId(ArrayNode oneOf, int messageId) {
    for (JsonNode branch : oneOf) {
      if (branch.get("properties").get("messageId").get("const").asInt() == messageId) {
        return branch;
      }
    }
    throw new IllegalArgumentException("No oneOf branch found for messageId " + messageId);
  }
}
