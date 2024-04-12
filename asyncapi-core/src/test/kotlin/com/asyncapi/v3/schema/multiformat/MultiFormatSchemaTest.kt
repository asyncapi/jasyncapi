package com.asyncapi.v3.schema.multiformat

import com.asyncapi.v3.ClasspathUtils
import com.asyncapi.v3.schema.SchemaProvider
import com.asyncapi.v3.schema.json.*
import com.asyncapi.v3.schema.multiformat.asyncapi.*
import com.asyncapi.v3.schema.multiformat.openapi.OpenAPIFormatSchemaV3_0_0Test
import com.asyncapi.v3.schema.multiformat.openapi.OpenAPIFormatSchemaV3_0_1Test
import com.asyncapi.v3.schema.multiformat.openapi.OpenAPIFormatSchemaV3_0_2Test
import com.asyncapi.v3.schema.multiformat.openapi.OpenAPIFormatSchemaV3_0_3Test
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class MultiFormatSchemaTest {

    private val objectMapper: ObjectMapper = ObjectMapper(YAMLFactory())
        .setSerializationInclusion(JsonInclude.Include.NON_NULL)
        .findAndRegisterModules()

    fun <Schema> compareSchemas(
        schemaToCompareWith: String,
        schemaClass: Class<*>,
        schemaToCheck: Schema
    ) {
        val jsonSchemaString = ClasspathUtils.readAsString(schemaToCompareWith)
        val jsonSchema = objectMapper.readValue(jsonSchemaString, schemaClass)

        Assertions.assertEquals(jsonSchema, schemaToCheck)
    }

    @Nested
    inner class AsyncAPISchema {

        @Nested
        @DisplayName("2.0.0")
        inner class V2_0_0: AsyncAPIFormatSchemaV2_0_0Test()

        @Nested
        @DisplayName("2.1.0")
        inner class V2_1_0: AsyncAPIFormatSchemaV2_1_0Test()

        @Nested
        @DisplayName("2.2.0")
        inner class V2_2_0: AsyncAPIFormatSchemaV2_2_0Test()

        @Nested
        @DisplayName("2.3.0")
        inner class V2_3_0: AsyncAPIFormatSchemaV2_3_0Test()

        @Nested
        @DisplayName("2.4.0")
        inner class V2_4_0: AsyncAPIFormatSchemaV2_4_0Test()

        @Nested
        @DisplayName("2.5.0")
        inner class V2_5_0: AsyncAPIFormatSchemaV2_5_0Test()

        @Nested
        @DisplayName("2.6.0")
        inner class V2_6_0: AsyncAPIFormatSchemaV2_6_0Test()

        @Nested
        @DisplayName("3.0.0")
        inner class V3_0_0: AsyncAPIFormatSchemaV3_0_0Test()

        @Nested
        @DisplayName("MultiFormatSchema with empty schemaFormat is AsyncAPI Schema")
        inner class EmptySchemaFormat: EmptySchemaFormatTest()

        @Nested
        @DisplayName("MultiFormatSchema with null schemaFormat is AsyncAPI Schema")
        inner class NullSchemaFormat: NullSchemaFormatTest()

        @Nested
        @DisplayName("MultiFormatSchema without schemaFormat is AsyncAPI Schema")
        inner class WithoutSchemaFormat: WithoutSchemaFormatTest()

    }

    @Nested
    inner class JsonSchema {

        @ArgumentsSource(JsonSchemasJsonFormat::class)
        @ParameterizedTest(name = "Read: {0}")
        fun json(schemaToCompareWith: String, schemaProvider: SchemaProvider) {
            compareSchemas(schemaToCompareWith, JsonFormatSchema::class.java, schemaProvider.jsonFormatSchemaJson())
        }

        @ArgumentsSource(JsonSchemasYamlFormat::class)
        @ParameterizedTest(name = "Read: {0}")
        fun yaml(schemaToCompareWith: String, schemaProvider: SchemaProvider) {
            compareSchemas(schemaToCompareWith, JsonFormatSchema::class.java, schemaProvider.jsonFormatSchemaYaml())
        }

    }

    @Nested
    inner class OpenAPISchema {

        @Nested
        @DisplayName("3.0.0")
        inner class V3_0_0: OpenAPIFormatSchemaV3_0_0Test()

        @Nested
        @DisplayName("3.0.1")
        inner class V3_0_1: OpenAPIFormatSchemaV3_0_1Test()

        @Nested
        @DisplayName("3.0.2")
        inner class V3_0_2: OpenAPIFormatSchemaV3_0_2Test()

        @Nested
        @DisplayName("3.0.3")
        inner class V3_0_3: OpenAPIFormatSchemaV3_0_3Test()

    }

    class JsonSchemasJsonFormat: ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
            return Stream.of(
                Arguments.of("/json/v3/schema/multiformat/json/arrays.schema.json", ArraysSchemaTest()),
                Arguments.of("/json/v3/schema/multiformat/json/complex-object.schema.json", ComplexObjectTest()),
                Arguments.of("/json/v3/schema/multiformat/json/conditional-validation-if-else.schema.json", ConditionalValidationIfElse()),
                Arguments.of("/json/v3/schema/multiformat/json/draft-07-core-schema-meta-schema.json", Draft07CoreSchemaMetaSchemaTest()),
                Arguments.of("/json/v3/schema/multiformat/json/enumerated-values.schema.json", EnumeratedValuesTest()),
                Arguments.of("/json/v3/schema/multiformat/json/person.schema.json", PersonTest()),
                Arguments.of("/json/v3/schema/multiformat/json/regex-pattern.schema.json", RegexPatternTest())
            )
        }

    }

    class JsonSchemasYamlFormat: ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
            return Stream.of(
                Arguments.of("/json/v3/schema/multiformat/json/arrays.schema.yaml", ArraysSchemaTest()),
                Arguments.of("/json/v3/schema/multiformat/json/complex-object.schema.yaml", ComplexObjectTest()),
                Arguments.of("/json/v3/schema/multiformat/json/conditional-validation-if-else.schema.yaml", ConditionalValidationIfElse()),
                Arguments.of("/json/v3/schema/multiformat/json/draft-07-core-schema-meta-schema.yaml", Draft07CoreSchemaMetaSchemaTest()),
                Arguments.of("/json/v3/schema/multiformat/json/enumerated-values.schema.yaml", EnumeratedValuesTest()),
                Arguments.of("/json/v3/schema/multiformat/json/person.schema.yaml", PersonTest()),
                Arguments.of("/json/v3/schema/multiformat/json/regex-pattern.schema.yaml", RegexPatternTest())
            )
        }

    }

}