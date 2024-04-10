package com.asyncapi.v3.schema.multiformat

import com.asyncapi.v3.ClasspathUtils
import com.asyncapi.v3.schema.SchemaProvider
import com.asyncapi.v3.schema.json.*
import com.asyncapi.v3.schema.openapi.SchemaTest
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
        inner class V2_0_0 {

            @ArgumentsSource(AsyncAPISchemasJsonFormatV2_0_0::class)
            @ParameterizedTest(name = "Read: {0}")
            fun json(schemaToCompareWith: String, schemaProvider: SchemaProvider) {
                compareSchemas(schemaToCompareWith, AsyncAPIFormatSchema::class.java, schemaProvider.asyncAPIFormatSchemaJsonV2_0_0())
            }

            @ArgumentsSource(AsyncAPISchemasYamlFormatV2_0_0::class)
            @ParameterizedTest(name = "Read: {0}")
            fun yaml(schemaToCompareWith: String, schemaProvider: SchemaProvider) {
                compareSchemas(schemaToCompareWith, AsyncAPIFormatSchema::class.java, schemaProvider.asyncAPIFormatSchemaYamlV2_0_0())
            }

        }

        @Nested
        @DisplayName("2.1.0")
        inner class V2_1_0 {

            @ArgumentsSource(AsyncAPISchemasJsonFormatV2_1_0::class)
            @ParameterizedTest(name = "Read: {0}")
            fun json(schemaToCompareWith: String, schemaProvider: SchemaProvider) {
                compareSchemas(schemaToCompareWith, AsyncAPIFormatSchema::class.java, schemaProvider.asyncAPIFormatSchemaJsonV2_1_0())
            }

            @ArgumentsSource(AsyncAPISchemasYamlFormatV2_1_0::class)
            @ParameterizedTest(name = "Read: {0}")
            fun yaml(schemaToCompareWith: String, schemaProvider: SchemaProvider) {
                compareSchemas(schemaToCompareWith, AsyncAPIFormatSchema::class.java, schemaProvider.asyncAPIFormatSchemaYamlV2_1_0())
            }

        }

        @Nested
        @DisplayName("2.2.0")
        inner class V2_2_0 {

            @ArgumentsSource(AsyncAPISchemasJsonFormatV2_2_0::class)
            @ParameterizedTest(name = "Read: {0}")
            fun json(schemaToCompareWith: String, schemaProvider: SchemaProvider) {
                compareSchemas(schemaToCompareWith, AsyncAPIFormatSchema::class.java, schemaProvider.asyncAPIFormatSchemaJsonV2_2_0())
            }

            @ArgumentsSource(AsyncAPISchemasYamlFormatV2_2_0::class)
            @ParameterizedTest(name = "Read: {0}")
            fun yaml(schemaToCompareWith: String, schemaProvider: SchemaProvider) {
                compareSchemas(schemaToCompareWith, AsyncAPIFormatSchema::class.java, schemaProvider.asyncAPIFormatSchemaYamlV2_2_0())
            }

        }

        @Nested
        @DisplayName("2.3.0")
        inner class V2_3_0 {

            @ArgumentsSource(AsyncAPISchemasJsonFormatV2_3_0::class)
            @ParameterizedTest(name = "Read: {0}")
            fun json(schemaToCompareWith: String, schemaProvider: SchemaProvider) {
                compareSchemas(schemaToCompareWith, AsyncAPIFormatSchema::class.java, schemaProvider.asyncAPIFormatSchemaJsonV2_3_0())
            }

            @ArgumentsSource(AsyncAPISchemasYamlFormatV2_3_0::class)
            @ParameterizedTest(name = "Read: {0}")
            fun yaml(schemaToCompareWith: String, schemaProvider: SchemaProvider) {
                compareSchemas(schemaToCompareWith, AsyncAPIFormatSchema::class.java, schemaProvider.asyncAPIFormatSchemaYamlV2_3_0())
            }

        }

        @Nested
        @DisplayName("2.4.0")
        inner class V2_4_0 {

            @ArgumentsSource(AsyncAPISchemasJsonFormatV2_4_0::class)
            @ParameterizedTest(name = "Read: {0}")
            fun json(schemaToCompareWith: String, schemaProvider: SchemaProvider) {
                compareSchemas(schemaToCompareWith, AsyncAPIFormatSchema::class.java, schemaProvider.asyncAPIFormatSchemaJsonV2_4_0())
            }

            @ArgumentsSource(AsyncAPISchemasYamlFormatV2_4_0::class)
            @ParameterizedTest(name = "Read: {0}")
            fun yaml(schemaToCompareWith: String, schemaProvider: SchemaProvider) {
                compareSchemas(schemaToCompareWith, AsyncAPIFormatSchema::class.java, schemaProvider.asyncAPIFormatSchemaYamlV2_4_0())
            }

        }

        @Nested
        @DisplayName("2.5.0")
        inner class V2_5_0 {

            @ArgumentsSource(AsyncAPISchemasJsonFormatV2_5_0::class)
            @ParameterizedTest(name = "Read: {0}")
            fun json(schemaToCompareWith: String, schemaProvider: SchemaProvider) {
                compareSchemas(schemaToCompareWith, AsyncAPIFormatSchema::class.java, schemaProvider.asyncAPIFormatSchemaJsonV2_5_0())
            }

            @ArgumentsSource(AsyncAPISchemasYamlFormatV2_5_0::class)
            @ParameterizedTest(name = "Read: {0}")
            fun yaml(schemaToCompareWith: String, schemaProvider: SchemaProvider) {
                compareSchemas(schemaToCompareWith, AsyncAPIFormatSchema::class.java, schemaProvider.asyncAPIFormatSchemaYamlV2_5_0())
            }

        }

        @Nested
        @DisplayName("2.6.0")
        inner class V2_6_0 {

            @ArgumentsSource(AsyncAPISchemasJsonFormatV2_6_0::class)
            @ParameterizedTest(name = "Read: {0}")
            fun json(schemaToCompareWith: String, schemaProvider: SchemaProvider) {
                compareSchemas(schemaToCompareWith, AsyncAPIFormatSchema::class.java, schemaProvider.asyncAPIFormatSchemaJsonV2_6_0())
            }

            @ArgumentsSource(AsyncAPISchemasYamlFormatV2_6_0::class)
            @ParameterizedTest(name = "Read: {0}")
            fun yaml(schemaToCompareWith: String, schemaProvider: SchemaProvider) {
                compareSchemas(schemaToCompareWith, AsyncAPIFormatSchema::class.java, schemaProvider.asyncAPIFormatSchemaYamlV2_6_0())
            }

        }

        @Nested
        @DisplayName("3.0.0")
        inner class V3_0_0 {

            @ArgumentsSource(AsyncAPISchemasJsonFormatV3_0_0::class)
            @ParameterizedTest(name = "Read: {0}")
            fun json(schemaToCompareWith: String, schemaProvider: SchemaProvider) {
                compareSchemas(schemaToCompareWith, AsyncAPIFormatSchema::class.java, schemaProvider.asyncAPIFormatSchemaJsonV3_0_0())
            }

            @ArgumentsSource(AsyncAPISchemasYamlFormatV3_0_0::class)
            @ParameterizedTest(name = "Read: {0}")
            fun yaml(schemaToCompareWith: String, schemaProvider: SchemaProvider) {
                compareSchemas(schemaToCompareWith, AsyncAPIFormatSchema::class.java, schemaProvider.asyncAPIFormatSchemaYamlV3_0_0())
            }

        }

        @Nested
        @DisplayName("MultiFormatSchema with empty schemaFormat is AsyncAPI Schema")
        inner class EmptySchemaFormat {

            @ArgumentsSource(JsonSchemasWithEmptySchemaFormat::class)
            @ParameterizedTest(name = "Read: {0}")
            fun json(schemaToCompareWith: String, schemaProvider: SchemaProvider) {
                compareSchemas(schemaToCompareWith, AsyncAPIFormatSchema::class.java, schemaProvider.asyncAPIFormatSchemaEmptySchemaFormat())
            }

            @ArgumentsSource(YamlSchemasWithEmptySchemaFormat::class)
            @ParameterizedTest(name = "Read: {0}")
            fun yaml(schemaToCompareWith: String, schemaProvider: SchemaProvider) {
                compareSchemas(schemaToCompareWith, AsyncAPIFormatSchema::class.java, schemaProvider.asyncAPIFormatSchemaEmptySchemaFormat())
            }

        }

        @Nested
        @DisplayName("MultiFormatSchema with null schemaFormat is AsyncAPI Schema")
        inner class NullSchemaFormat {

            @ArgumentsSource(JsonSchemasWithNullSchemaFormat::class)
            @ParameterizedTest(name = "Read: {0}")
            fun json(schemaToCompareWith: String, schemaProvider: SchemaProvider) {
                compareSchemas(schemaToCompareWith, AsyncAPIFormatSchema::class.java, schemaProvider.asyncAPIFormatSchemaEmptySchemaFormat())
            }

            @ArgumentsSource(YamlSchemasWithNullSchemaFormat::class)
            @ParameterizedTest(name = "Read: {0}")
            fun yaml(schemaToCompareWith: String, schemaProvider: SchemaProvider) {
                compareSchemas(schemaToCompareWith, AsyncAPIFormatSchema::class.java, schemaProvider.asyncAPIFormatSchemaEmptySchemaFormat())
            }

        }

        @Nested
        @DisplayName("MultiFormatSchema without schemaFormat is AsyncAPI Schema")
        inner class WithoutSchemaFormat {

            @ArgumentsSource(JsonSchemasWithoutSchemaFormat::class)
            @ParameterizedTest(name = "Read: {0}")
            fun json(schemaToCompareWith: String, schemaProvider: SchemaProvider) {
                compareSchemas(schemaToCompareWith, AsyncAPIFormatSchema::class.java, schemaProvider.asyncAPIFormatSchemaEmptySchemaFormat())
            }

            @ArgumentsSource(YamlSchemasWithoutSchemaFormat::class)
            @ParameterizedTest(name = "Read: {0}")
            fun yaml(schemaToCompareWith: String, schemaProvider: SchemaProvider) {
                compareSchemas(schemaToCompareWith, AsyncAPIFormatSchema::class.java, schemaProvider.asyncAPIFormatSchemaEmptySchemaFormat())
            }

        }

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

        @ArgumentsSource(OpenAPISchemasJsonFormat::class)
        @ParameterizedTest(name = "Read: {0}")
        fun json(schemaToCompareWith: String, schemaProvider: SchemaProvider) {
            compareSchemas(schemaToCompareWith, OpenAPIFormatSchema::class.java, schemaProvider.openAPIFormatSchemaJson())
        }

        @ArgumentsSource(OpenAPISchemasYamlFormat::class)
        @ParameterizedTest(name = "Read: {0}")
        fun yaml(schemaToCompareWith: String, schemaProvider: SchemaProvider) {
            compareSchemas(schemaToCompareWith, OpenAPIFormatSchema::class.java, schemaProvider.openAPIFormatSchemaYaml())
        }

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

    class AsyncAPISchemasJsonFormatV2_0_0: ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
            return Stream.of(
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.0.0/arrays.schema.json", ArraysSchemaTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.0.0/complex-object.schema.json", ComplexObjectTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.0.0/conditional-validation-if-else.schema.json", ConditionalValidationIfElse()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.0.0/draft-07-core-schema-meta-schema.json", Draft07CoreSchemaMetaSchemaTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.0.0/enumerated-values.schema.json", EnumeratedValuesTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.0.0/person.schema.json", PersonTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.0.0/regex-pattern.schema.json", RegexPatternTest())
            )
        }

    }

    class AsyncAPISchemasYamlFormatV2_0_0: ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
            return Stream.of(
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.0.0/arrays.schema.yaml", ArraysSchemaTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.0.0/complex-object.schema.yaml", ComplexObjectTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.0.0/conditional-validation-if-else.schema.yaml", ConditionalValidationIfElse()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.0.0/draft-07-core-schema-meta-schema.yaml", Draft07CoreSchemaMetaSchemaTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.0.0/enumerated-values.schema.yaml", EnumeratedValuesTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.0.0/person.schema.yaml", PersonTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.0.0/regex-pattern.schema.yaml", RegexPatternTest())
            )
        }

    }

    class AsyncAPISchemasJsonFormatV2_1_0: ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
            return Stream.of(
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.1.0/arrays.schema.json", ArraysSchemaTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.1.0/complex-object.schema.json", ComplexObjectTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.1.0/conditional-validation-if-else.schema.json", ConditionalValidationIfElse()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.1.0/draft-07-core-schema-meta-schema.json", Draft07CoreSchemaMetaSchemaTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.1.0/enumerated-values.schema.json", EnumeratedValuesTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.1.0/person.schema.json", PersonTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.1.0/regex-pattern.schema.json", RegexPatternTest())
            )
        }

    }

    class AsyncAPISchemasYamlFormatV2_1_0: ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
            return Stream.of(
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.1.0/arrays.schema.yaml", ArraysSchemaTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.1.0/complex-object.schema.yaml", ComplexObjectTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.1.0/conditional-validation-if-else.schema.yaml", ConditionalValidationIfElse()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.1.0/draft-07-core-schema-meta-schema.yaml", Draft07CoreSchemaMetaSchemaTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.1.0/enumerated-values.schema.yaml", EnumeratedValuesTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.1.0/person.schema.yaml", PersonTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.1.0/regex-pattern.schema.yaml", RegexPatternTest())
            )
        }

    }

    class AsyncAPISchemasJsonFormatV2_2_0: ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
            return Stream.of(
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.2.0/arrays.schema.json", ArraysSchemaTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.2.0/complex-object.schema.json", ComplexObjectTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.2.0/conditional-validation-if-else.schema.json", ConditionalValidationIfElse()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.2.0/draft-07-core-schema-meta-schema.json", Draft07CoreSchemaMetaSchemaTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.2.0/enumerated-values.schema.json", EnumeratedValuesTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.2.0/person.schema.json", PersonTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.2.0/regex-pattern.schema.json", RegexPatternTest())
            )
        }

    }

    class AsyncAPISchemasYamlFormatV2_2_0: ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
            return Stream.of(
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.2.0/arrays.schema.yaml", ArraysSchemaTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.2.0/complex-object.schema.yaml", ComplexObjectTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.2.0/conditional-validation-if-else.schema.yaml", ConditionalValidationIfElse()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.2.0/draft-07-core-schema-meta-schema.yaml", Draft07CoreSchemaMetaSchemaTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.2.0/enumerated-values.schema.yaml", EnumeratedValuesTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.2.0/person.schema.yaml", PersonTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.2.0/regex-pattern.schema.yaml", RegexPatternTest())
            )
        }

    }

    class AsyncAPISchemasJsonFormatV2_3_0: ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
            return Stream.of(
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.3.0/arrays.schema.json", ArraysSchemaTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.3.0/complex-object.schema.json", ComplexObjectTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.3.0/conditional-validation-if-else.schema.json", ConditionalValidationIfElse()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.3.0/draft-07-core-schema-meta-schema.json", Draft07CoreSchemaMetaSchemaTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.3.0/enumerated-values.schema.json", EnumeratedValuesTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.3.0/person.schema.json", PersonTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.3.0/regex-pattern.schema.json", RegexPatternTest())
            )
        }

    }

    class AsyncAPISchemasYamlFormatV2_3_0: ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
            return Stream.of(
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.3.0/arrays.schema.yaml", ArraysSchemaTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.3.0/complex-object.schema.yaml", ComplexObjectTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.3.0/conditional-validation-if-else.schema.yaml", ConditionalValidationIfElse()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.3.0/draft-07-core-schema-meta-schema.yaml", Draft07CoreSchemaMetaSchemaTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.3.0/enumerated-values.schema.yaml", EnumeratedValuesTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.3.0/person.schema.yaml", PersonTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.3.0/regex-pattern.schema.yaml", RegexPatternTest())
            )
        }

    }

    class AsyncAPISchemasJsonFormatV2_4_0: ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
            return Stream.of(
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.4.0/arrays.schema.json", ArraysSchemaTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.4.0/complex-object.schema.json", ComplexObjectTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.4.0/conditional-validation-if-else.schema.json", ConditionalValidationIfElse()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.4.0/draft-07-core-schema-meta-schema.json", Draft07CoreSchemaMetaSchemaTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.4.0/enumerated-values.schema.json", EnumeratedValuesTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.4.0/person.schema.json", PersonTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.4.0/regex-pattern.schema.json", RegexPatternTest())
            )
        }

    }

    class AsyncAPISchemasYamlFormatV2_4_0: ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
            return Stream.of(
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.4.0/arrays.schema.yaml", ArraysSchemaTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.4.0/complex-object.schema.yaml", ComplexObjectTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.4.0/conditional-validation-if-else.schema.yaml", ConditionalValidationIfElse()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.4.0/draft-07-core-schema-meta-schema.yaml", Draft07CoreSchemaMetaSchemaTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.4.0/enumerated-values.schema.yaml", EnumeratedValuesTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.4.0/person.schema.yaml", PersonTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.4.0/regex-pattern.schema.yaml", RegexPatternTest())
            )
        }

    }

    class AsyncAPISchemasJsonFormatV2_5_0: ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
            return Stream.of(
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.5.0/arrays.schema.json", ArraysSchemaTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.5.0/complex-object.schema.json", ComplexObjectTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.5.0/conditional-validation-if-else.schema.json", ConditionalValidationIfElse()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.5.0/draft-07-core-schema-meta-schema.json", Draft07CoreSchemaMetaSchemaTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.5.0/enumerated-values.schema.json", EnumeratedValuesTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.5.0/person.schema.json", PersonTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.5.0/regex-pattern.schema.json", RegexPatternTest())
            )
        }

    }

    class AsyncAPISchemasYamlFormatV2_5_0: ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
            return Stream.of(
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.5.0/arrays.schema.yaml", ArraysSchemaTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.5.0/complex-object.schema.yaml", ComplexObjectTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.5.0/conditional-validation-if-else.schema.yaml", ConditionalValidationIfElse()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.5.0/draft-07-core-schema-meta-schema.yaml", Draft07CoreSchemaMetaSchemaTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.5.0/enumerated-values.schema.yaml", EnumeratedValuesTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.5.0/person.schema.yaml", PersonTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.5.0/regex-pattern.schema.yaml", RegexPatternTest())
            )
        }

    }

    class AsyncAPISchemasJsonFormatV2_6_0: ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
            return Stream.of(
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.6.0/arrays.schema.json", ArraysSchemaTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.6.0/complex-object.schema.json", ComplexObjectTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.6.0/conditional-validation-if-else.schema.json", ConditionalValidationIfElse()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.6.0/draft-07-core-schema-meta-schema.json", Draft07CoreSchemaMetaSchemaTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.6.0/enumerated-values.schema.json", EnumeratedValuesTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.6.0/person.schema.json", PersonTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.6.0/regex-pattern.schema.json", RegexPatternTest())
            )
        }

    }

    class AsyncAPISchemasYamlFormatV2_6_0: ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
            return Stream.of(
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.6.0/arrays.schema.yaml", ArraysSchemaTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.6.0/complex-object.schema.yaml", ComplexObjectTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.6.0/conditional-validation-if-else.schema.yaml", ConditionalValidationIfElse()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.6.0/draft-07-core-schema-meta-schema.yaml", Draft07CoreSchemaMetaSchemaTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.6.0/enumerated-values.schema.yaml", EnumeratedValuesTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.6.0/person.schema.yaml", PersonTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/2.6.0/regex-pattern.schema.yaml", RegexPatternTest())
            )
        }

    }

    class AsyncAPISchemasJsonFormatV3_0_0: ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
            return Stream.of(
                Arguments.of("/json/v3/schema/multiformat/asyncapi/3.0.0/arrays.schema.json", ArraysSchemaTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/3.0.0/complex-object.schema.json", ComplexObjectTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/3.0.0/conditional-validation-if-else.schema.json", ConditionalValidationIfElse()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/3.0.0/draft-07-core-schema-meta-schema.json", Draft07CoreSchemaMetaSchemaTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/3.0.0/enumerated-values.schema.json", EnumeratedValuesTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/3.0.0/person.schema.json", PersonTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/3.0.0/regex-pattern.schema.json", RegexPatternTest())
            )
        }

    }

    class AsyncAPISchemasYamlFormatV3_0_0: ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
            return Stream.of(
                Arguments.of("/json/v3/schema/multiformat/asyncapi/3.0.0/arrays.schema.yaml", ArraysSchemaTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/3.0.0/complex-object.schema.yaml", ComplexObjectTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/3.0.0/conditional-validation-if-else.schema.yaml", ConditionalValidationIfElse()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/3.0.0/draft-07-core-schema-meta-schema.yaml", Draft07CoreSchemaMetaSchemaTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/3.0.0/enumerated-values.schema.yaml", EnumeratedValuesTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/3.0.0/person.schema.yaml", PersonTest()),
                Arguments.of("/json/v3/schema/multiformat/asyncapi/3.0.0/regex-pattern.schema.yaml", RegexPatternTest())
            )
        }

    }

    class OpenAPISchemasJsonFormat: ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
            return Stream.of(
                Arguments.of("/json/v3/schema/multiformat/openapi/schema.json", SchemaTest()),
            )
        }

    }

    class OpenAPISchemasYamlFormat: ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
            return Stream.of(
                Arguments.of("/json/v3/schema/multiformat/openapi/schema.yaml", SchemaTest()),
            )
        }

    }

    class JsonSchemasWithEmptySchemaFormat: ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
            return Stream.of(
                Arguments.of("/json/v3/schema/multiformat/schemaFormat is empty/arrays.schema.json", ArraysSchemaTest()),
                Arguments.of("/json/v3/schema/multiformat/schemaFormat is empty/complex-object.schema.json", ComplexObjectTest()),
                Arguments.of("/json/v3/schema/multiformat/schemaFormat is empty/conditional-validation-if-else.schema.json", ConditionalValidationIfElse()),
                Arguments.of("/json/v3/schema/multiformat/schemaFormat is empty/draft-07-core-schema-meta-schema.json", Draft07CoreSchemaMetaSchemaTest()),
                Arguments.of("/json/v3/schema/multiformat/schemaFormat is empty/enumerated-values.schema.json", EnumeratedValuesTest()),
                Arguments.of("/json/v3/schema/multiformat/schemaFormat is empty/person.schema.json", PersonTest()),
                Arguments.of("/json/v3/schema/multiformat/schemaFormat is empty/regex-pattern.schema.json", RegexPatternTest())
            )
        }

    }

    class YamlSchemasWithEmptySchemaFormat: ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
            return Stream.of(
                Arguments.of("/json/v3/schema/multiformat/schemaFormat is empty/arrays.schema.yaml", ArraysSchemaTest()),
                Arguments.of("/json/v3/schema/multiformat/schemaFormat is empty/complex-object.schema.yaml", ComplexObjectTest()),
                Arguments.of("/json/v3/schema/multiformat/schemaFormat is empty/conditional-validation-if-else.schema.yaml", ConditionalValidationIfElse()),
                Arguments.of("/json/v3/schema/multiformat/schemaFormat is empty/draft-07-core-schema-meta-schema.yaml", Draft07CoreSchemaMetaSchemaTest()),
                Arguments.of("/json/v3/schema/multiformat/schemaFormat is empty/enumerated-values.schema.yaml", EnumeratedValuesTest()),
                Arguments.of("/json/v3/schema/multiformat/schemaFormat is empty/person.schema.yaml", PersonTest()),
                Arguments.of("/json/v3/schema/multiformat/schemaFormat is empty/regex-pattern.schema.yaml", RegexPatternTest())
            )
        }

    }

    class JsonSchemasWithNullSchemaFormat: ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
            return Stream.of(
                Arguments.of("/json/v3/schema/multiformat/schemaFormat is null/arrays.schema.json", ArraysSchemaTest()),
                Arguments.of("/json/v3/schema/multiformat/schemaFormat is null/complex-object.schema.json", ComplexObjectTest()),
                Arguments.of("/json/v3/schema/multiformat/schemaFormat is null/conditional-validation-if-else.schema.json", ConditionalValidationIfElse()),
                Arguments.of("/json/v3/schema/multiformat/schemaFormat is null/draft-07-core-schema-meta-schema.json", Draft07CoreSchemaMetaSchemaTest()),
                Arguments.of("/json/v3/schema/multiformat/schemaFormat is null/enumerated-values.schema.json", EnumeratedValuesTest()),
                Arguments.of("/json/v3/schema/multiformat/schemaFormat is null/person.schema.json", PersonTest()),
                Arguments.of("/json/v3/schema/multiformat/schemaFormat is null/regex-pattern.schema.json", RegexPatternTest())
            )
        }

    }

    class YamlSchemasWithNullSchemaFormat: ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
            return Stream.of(
                Arguments.of("/json/v3/schema/multiformat/schemaFormat is null/arrays.schema.yaml", ArraysSchemaTest()),
                Arguments.of("/json/v3/schema/multiformat/schemaFormat is null/complex-object.schema.yaml", ComplexObjectTest()),
                Arguments.of("/json/v3/schema/multiformat/schemaFormat is null/conditional-validation-if-else.schema.yaml", ConditionalValidationIfElse()),
                Arguments.of("/json/v3/schema/multiformat/schemaFormat is null/draft-07-core-schema-meta-schema.yaml", Draft07CoreSchemaMetaSchemaTest()),
                Arguments.of("/json/v3/schema/multiformat/schemaFormat is null/enumerated-values.schema.yaml", EnumeratedValuesTest()),
                Arguments.of("/json/v3/schema/multiformat/schemaFormat is null/person.schema.yaml", PersonTest()),
                Arguments.of("/json/v3/schema/multiformat/schemaFormat is null/regex-pattern.schema.yaml", RegexPatternTest())
            )
        }

    }

    class JsonSchemasWithoutSchemaFormat: ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
            return Stream.of(
                Arguments.of("/json/v3/schema/multiformat/without schemaFormat/arrays.schema.json", ArraysSchemaTest()),
                Arguments.of("/json/v3/schema/multiformat/without schemaFormat/complex-object.schema.json", ComplexObjectTest()),
                Arguments.of("/json/v3/schema/multiformat/without schemaFormat/conditional-validation-if-else.schema.json", ConditionalValidationIfElse()),
                Arguments.of("/json/v3/schema/multiformat/without schemaFormat/draft-07-core-schema-meta-schema.json", Draft07CoreSchemaMetaSchemaTest()),
                Arguments.of("/json/v3/schema/multiformat/without schemaFormat/enumerated-values.schema.json", EnumeratedValuesTest()),
                Arguments.of("/json/v3/schema/multiformat/without schemaFormat/person.schema.json", PersonTest()),
                Arguments.of("/json/v3/schema/multiformat/without schemaFormat/regex-pattern.schema.json", RegexPatternTest())
            )
        }

    }

    class YamlSchemasWithoutSchemaFormat: ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
            return Stream.of(
                Arguments.of("/json/v3/schema/multiformat/without schemaFormat/arrays.schema.yaml", ArraysSchemaTest()),
                Arguments.of("/json/v3/schema/multiformat/without schemaFormat/complex-object.schema.yaml", ComplexObjectTest()),
                Arguments.of("/json/v3/schema/multiformat/without schemaFormat/conditional-validation-if-else.schema.yaml", ConditionalValidationIfElse()),
                Arguments.of("/json/v3/schema/multiformat/without schemaFormat/draft-07-core-schema-meta-schema.yaml", Draft07CoreSchemaMetaSchemaTest()),
                Arguments.of("/json/v3/schema/multiformat/without schemaFormat/enumerated-values.schema.yaml", EnumeratedValuesTest()),
                Arguments.of("/json/v3/schema/multiformat/without schemaFormat/person.schema.yaml", PersonTest()),
                Arguments.of("/json/v3/schema/multiformat/without schemaFormat/regex-pattern.schema.yaml", RegexPatternTest())
            )
        }

    }

}