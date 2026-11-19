package com.asyncapi.bindings.kafka;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Which class a Kafka binding is read into, by its <code>bindingVersion</code>, when it is read through the
 * version-dispatching base class, as a document's bindings are.
 * <p>
 * A missing or <code>latest</code> version means 0.6.0, the newest, as in the spec-json-schemas dispatchers. So does
 * a version this library does not know. An explicit older version keeps its own class.
 */
@DisplayName("bindingVersion dispatch")
public class KafkaBindingVersionDispatchTest {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    private static final List<Class<?>> BASES = List.of(
            KafkaChannelBinding.class,
            KafkaOperationBinding.class,
            KafkaServerBinding.class,
            KafkaMessageBinding.class
    );

    static Stream<Arguments> versions() {
        // json fragment for bindingVersion (null: absent), the package the class must come from, the version written
        List<Arguments> arguments = new ArrayList<>();
        for (Class<?> base : BASES) {
            arguments.add(Arguments.of(base, null, "v0._6_0", "0.6.0"));
            arguments.add(Arguments.of(base, "latest", "v0._6_0", "0.6.0"));
            arguments.add(Arguments.of(base, "0.6.0", "v0._6_0", "0.6.0"));
            arguments.add(Arguments.of(base, "9.9.9", "v0._6_0", "0.6.0"));
            arguments.add(Arguments.of(base, "0.5.0", "v0._5_0", "0.5.0"));
            arguments.add(Arguments.of(base, "0.4.0", "v0._4_0", "0.4.0"));
        }

        return arguments.stream();
    }

    @ParameterizedTest(name = "{0} with bindingVersion {1} is {2}")
    @MethodSource("versions")
    @DisplayName("read through the base class")
    public void readThroughTheBaseClass(Class<?> base, String bindingVersion, String expectedPackage, String written) throws Exception {
        String json = bindingVersion == null ? "{}" : "{\"bindingVersion\": \"" + bindingVersion + "\"}";

        Object binding = objectMapper.readValue(json, base);

        Assertions.assertEquals(
                "com.asyncapi.bindings.kafka." + expectedPackage,
                binding.getClass().getPackageName().replaceFirst("\\.[a-z]+$", "")
        );
        Assertions.assertEquals(base.getSimpleName(), binding.getClass().getSimpleName());

        JsonNode writtenBack = objectMapper.valueToTree(binding);
        Assertions.assertEquals(written, writtenBack.get("bindingVersion").asText());
    }

}
