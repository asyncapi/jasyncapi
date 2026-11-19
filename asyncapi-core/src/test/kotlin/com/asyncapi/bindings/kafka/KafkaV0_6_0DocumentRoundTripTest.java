package com.asyncapi.bindings.kafka;

import com.asyncapi.schemas.asyncapi.security.v3.ApiKeySecurityScheme;
import com.asyncapi.v3._0_0.model.AsyncAPI;
import com.asyncapi.v3._0_0.model.channel.Channel;
import com.asyncapi.v3._0_0.model.operation.Operation;
import com.asyncapi.v3._0_0.model.server.Server;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * An AsyncAPI 3.0.0 document with Kafka bindings 0.6.0 survives being read and written: every field, every
 * <code>x-*</code> extension (document, info, servers, security schemes, channels, operations, traits, messages,
 * schemas, components and each binding) and every untyped <code>topicConfiguration</code> key.
 * <p>
 * The documents are kurkik's worked example, and the binding instances spec-json-schemas tests the 0.6.0 schemas with.
 */
@DisplayName("0.6.0 round trip")
public class KafkaV0_6_0DocumentRoundTripTest {

    private static final ObjectMapper yaml = new ObjectMapper(new YAMLFactory())
            .setSerializationInclusion(JsonInclude.Include.NON_NULL);

    private static final ObjectMapper json = new ObjectMapper()
            .setSerializationInclusion(JsonInclude.Include.NON_NULL);

    /**
     * Numbers compare by value: YAML reads <code>604800000</code> as an int, a Kafka long writes it as a long.
     */
    private static final Comparator<JsonNode> SAME_VALUE = (a, b) -> {
        if (a.equals(b)) return 0;
        if (a.isNumber() && b.isNumber()) return a.decimalValue().compareTo(b.decimalValue());
        return 1;
    };

    private static final String RESOURCES = "/bindings/kafka/0.6.0/";

    @ParameterizedTest(name = "{0}")
    @ValueSource(strings = {"payments.asyncapi.yaml", "payments-extended.asyncapi.yaml"})
    @DisplayName("an AsyncAPI 3.0.0 document is written back as it was read")
    public void documentIsWrittenBackAsItWasRead(String name) throws Exception {
        JsonNode original = yaml.readTree(read("document/" + name));

        AsyncAPI asyncAPI = yaml.treeToValue(original, AsyncAPI.class);
        JsonNode writtenBack = yaml.valueToTree(asyncAPI);

        assertSame(original, writtenBack);
    }

    @Test
    @DisplayName("the document's Kafka bindings are read as 0.6.0, and its extensions are kept where they were")
    public void bindingsAreTypedAndExtensionsKept() throws Exception {
        AsyncAPI asyncAPI = yaml.readValue(read("document/payments-extended.asyncapi.yaml"), AsyncAPI.class);

        Assertions.assertEquals("payments-team", asyncAPI.getInfo().getExtensionFields().get("x-kurkik-owner"));
        Assertions.assertNotNull(asyncAPI.getExtensionFields().get("x-kurkik-kafka-access"));

        Server dev = (Server) asyncAPI.getServers().get("dev");
        Assertions.assertEquals(Map.of("security", "PLAINTEXT"), dev.getExtensionFields().get("x-kurkik-kafka"));
        Assertions.assertInstanceOf(
                com.asyncapi.bindings.kafka.v0._6_0.server.KafkaServerBinding.class,
                dev.getBindings().get("kafka")
        );

        // H-1: MSK IAM is an apiKey in the user, with x-kurkik-kafka
        var iam = (ApiKeySecurityScheme) asyncAPI.getComponents().getSecuritySchemes().get("msk-iam");
        Assertions.assertEquals(ApiKeySecurityScheme.ApiKeyLocation.USER, iam.getIn());
        Assertions.assertEquals(
                "SASL_AWS_MSK_IAM",
                ((Map<?, ?>) iam.getExtensionFields().get("x-kurkik-kafka")).get("security")
        );

        Channel transactions = (Channel) asyncAPI.getChannels().get("transactions");
        var channelBinding = (com.asyncapi.bindings.kafka.v0._6_0.channel.KafkaChannelBinding) transactions.getBindings().get("kafka");
        Assertions.assertEquals(false, channelBinding.getExtensionFields().get("x-kurkik-inferred"));
        Assertions.assertEquals(604_800_000L, channelBinding.getTopicConfiguration().getRetentionMs());
        Assertions.assertEquals(
                Map.of("future.topic.setting", "kept as read", "confluent.placement.constraints", "{\"version\":1}"),
                channelBinding.getTopicConfiguration().getAdditionalProperties()
        );

        Operation buildLedger = (Operation) asyncAPI.getOperations().get("buildLedger");
        var operationBinding = (com.asyncapi.bindings.kafka.v0._6_0.operation.KafkaOperationBinding) buildLedger.getBindings().get("kafka");
        Assertions.assertEquals(
                com.asyncapi.bindings.kafka.v0._6_0.operation.KafkaOperationGroupType.CONSUMER,
                operationBinding.getGroupType()
        );
        Assertions.assertEquals("payments-ledger", operationBinding.getGroupId().getConstValue());
    }

    static Stream<String> validBindings() throws IOException, URISyntaxException {
        return list("spec-examples/valid");
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("validBindings")
    @DisplayName("a valid 0.6.0 binding is written back as it was read, with its version made explicit")
    public void validBindingIsWrittenBackAsItWasRead(String name) throws Exception {
        ObjectNode original = (ObjectNode) json.readTree(read("spec-examples/valid/" + name));

        Object binding = json.treeToValue(original, baseOf(name));
        JsonNode writtenBack = json.valueToTree(binding);

        // a missing or "latest" bindingVersion means 0.6.0 (H-3), and is written as such
        String version = original.path("bindingVersion").asText("latest");
        Assertions.assertTrue(List.of("0.6.0", "latest").contains(version), name + " is not a 0.6.0 instance");
        Assertions.assertEquals("0.6.0", writtenBack.get("bindingVersion").asText());
        original.put("bindingVersion", "0.6.0");

        assertSame(original, writtenBack);
    }

    @ParameterizedTest(name = "{0}")
    @ValueSource(strings = {
            "channel.cleanup-policy-string.json",
            "channel.compression-type-unknown.json",
            "message.schema-id-location-unknown.json",
            "operation.group-type-unknown.json",
            "operation.isolation-level-upper-case.json",
            "operation.no-version-unknown-field.json",
            "operation.principal-plain-string.json",
            "operation.principal-with-0.5.0.json",
            "operation.transactional-boolean.json",
            "operation.transactional-id-prefix-field.json",
            "server.unknown-field.json",
    })
    @DisplayName("an invalid binding whose shape the classes cannot hold is refused")
    public void invalidShapeIsRefused(String name) throws Exception {
        String content = read("spec-examples/invalid/" + name);

        Assertions.assertThrows(IOException.class, () -> json.readValue(content, baseOf(name)));
    }

    /**
     * What the classes can hold, but the schema refuses: ranges, a version this library does not know (read as the
     * newest), a non-JSON-Schema key and a number where a string goes. Checking those is a JSON Schema validator's
     * job, as for every other binding of this library.
     */
    @ParameterizedTest(name = "{0}")
    @ValueSource(strings = {
            "channel.min-insync-zero.json",
            "channel.partitions-zero.json",
            "channel.segment-bytes-below-4-1-minimum.json",
            "channel.unknown-version.json",
            "message.avro-key-inline.json",
            "server.registry-url-number.json",
    })
    @DisplayName("an invalid binding whose shape the classes can hold is read: validation is the schema's job")
    public void invalidValueIsLeftToTheSchema(String name) throws Exception {
        String content = read("spec-examples/invalid/" + name);

        Assertions.assertDoesNotThrow(() -> json.readValue(content, baseOf(name)));
    }

    @Test
    @DisplayName("every spec-json-schemas instance is used by one of the tests above")
    public void everyInstanceIsUsed() throws Exception {
        Assertions.assertEquals(17, list("spec-examples/valid").count());
        Assertions.assertEquals(17, list("spec-examples/invalid").count());
    }

    private static Class<?> baseOf(String name) {
        String kind = name.substring(0, name.indexOf('.'));
        return switch (kind) {
            case "channel" -> KafkaChannelBinding.class;
            case "operation" -> KafkaOperationBinding.class;
            case "server" -> KafkaServerBinding.class;
            case "message" -> KafkaMessageBinding.class;
            default -> throw new IllegalArgumentException(name);
        };
    }

    private static void assertSame(JsonNode expected, JsonNode actual) throws IOException {
        // Object members compare regardless of order; the text below is sorted so that a failure shows only real changes
        if (!expected.equals(SAME_VALUE, actual)) {
            Assertions.assertEquals(sortedText(expected), sortedText(actual));
            Assertions.fail("the trees differ only in ways their text does not show");
        }
    }

    private static String sortedText(JsonNode node) throws IOException {
        return json.copy()
                .enable(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS)
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(json.treeToValue(node, Object.class));
    }

    private static Stream<String> list(String directory) throws IOException, URISyntaxException {
        Path path = Path.of(KafkaV0_6_0DocumentRoundTripTest.class.getResource(RESOURCES + directory).toURI());
        try (Stream<Path> files = Files.list(path)) {
            return files.map(file -> file.getFileName().toString()).sorted().toList().stream();
        }
    }

    private static String read(String file) throws IOException, URISyntaxException {
        Path path = Path.of(KafkaV0_6_0DocumentRoundTripTest.class.getResource(RESOURCES + file).toURI());
        return Files.readString(path);
    }

}
