package com.asyncapi.v3.schema.multiformat.json

import com.asyncapi.schemas.json.*
import com.asyncapi.v3.ClasspathUtils
import com.asyncapi.schemas.multiformat.JsonFormatSchema
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

abstract class JsonFormatSchemaTest {

    private val objectMapper: ObjectMapper = ObjectMapper(YAMLFactory())
        .setSerializationInclusion(JsonInclude.Include.NON_NULL)
        .findAndRegisterModules()

    fun compareSchemas(
        jsonFormatSchemaToCompareWithFilePath: String,
        schemaToCheck: JsonFormatSchema
    ) {
        val schemaAsJson = ClasspathUtils.readAsString(jsonFormatSchemaToCompareWithFilePath)
        val schema = objectMapper.readValue(schemaAsJson, JsonFormatSchema::class.java)

        Assertions.assertEquals(schema, schemaToCheck)
    }

    @ArgumentsSource(Json::class)
    @ParameterizedTest(name = "Read: {0}")
    fun parseJson(
        jsonFormatSchemaToCompareWithFilePath: String,
        jsonFormatSchema: JsonFormatSchema
    ) {
        compareSchemas(jsonFormatSchemaToCompareWithFilePath, jsonFormatSchema)

    }

    @ArgumentsSource(Yaml::class)
    @ParameterizedTest(name = "Read: {0}")
    fun parseYaml(
        jsonFormatSchemaToCompareWithFilePath: String,
        jsonFormatSchema: JsonFormatSchema
    ) {
        compareSchemas(jsonFormatSchemaToCompareWithFilePath, jsonFormatSchema)
    }

    class Json: ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
            return Stream.of(
                Arguments.of(
                    "/json/v3/schema/multiformat/json/schema+json/arrays.schema.json",
                    JsonFormatSchema(ArraysSchemaTest().jsonSchema())
                ),
                Arguments.of(
                    "/json/v3/schema/multiformat/json/schema+json/complex-object.schema.json",
                    JsonFormatSchema(ComplexObjectTest().jsonSchema())
                ),
                Arguments.of(
                    "/json/v3/schema/multiformat/json/schema+json/conditional-validation-if-else.schema.json",
                    JsonFormatSchema(ConditionalValidationIfElse().jsonSchema())
                ),
                Arguments.of(
                    "/json/v3/schema/multiformat/json/schema+json/draft-07-core-schema-meta-schema.json",
                    JsonFormatSchema(Draft07CoreSchemaMetaSchemaTest().jsonSchema())
                ),
                Arguments.of(
                    "/json/v3/schema/multiformat/json/schema+json/enumerated-values.schema.json",
                    JsonFormatSchema(EnumeratedValuesTest().jsonSchema())
                ),
                Arguments.of(
                    "/json/v3/schema/multiformat/json/schema+json/person.schema.json",
                    JsonFormatSchema(PersonTest().jsonSchema())
                ),
                Arguments.of(
                    "/json/v3/schema/multiformat/json/schema+json/regex-pattern.schema.json",
                    JsonFormatSchema(RegexPatternTest().jsonSchema())
                )
            )
        }

    }

    class Yaml: ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
            return Stream.of(
                Arguments.of(
                    "/json/v3/schema/multiformat/json/schema+yaml/arrays.schema.yaml",
                    JsonFormatSchema(
                        "application/schema+yaml;version=draft-07",
                        ArraysSchemaTest().jsonSchema()
                    )
                ),
                Arguments.of(
                    "/json/v3/schema/multiformat/json/schema+yaml/complex-object.schema.yaml",
                    JsonFormatSchema(
                        "application/schema+yaml;version=draft-07",
                        ComplexObjectTest().jsonSchema()
                    )
                ),
                Arguments.of(
                    "/json/v3/schema/multiformat/json/schema+yaml/conditional-validation-if-else.schema.yaml",
                    JsonFormatSchema(
                        "application/schema+yaml;version=draft-07",
                        ConditionalValidationIfElse().jsonSchema()
                    )
                ),
                Arguments.of(
                    "/json/v3/schema/multiformat/json/schema+yaml/draft-07-core-schema-meta-schema.yaml",
                    JsonFormatSchema(
                        "application/schema+yaml;version=draft-07",
                        Draft07CoreSchemaMetaSchemaTest().jsonSchema()
                    )
                ),
                Arguments.of(
                    "/json/v3/schema/multiformat/json/schema+yaml/enumerated-values.schema.yaml",
                    JsonFormatSchema(
                        "application/schema+yaml;version=draft-07",
                        EnumeratedValuesTest().jsonSchema()
                    )
                ),
                Arguments.of(
                    "/json/v3/schema/multiformat/json/schema+yaml/person.schema.yaml",
                    JsonFormatSchema(
                        "application/schema+yaml;version=draft-07",
                        PersonTest().jsonSchema()
                    )
                ),
                Arguments.of(
                    "/json/v3/schema/multiformat/json/schema+yaml/regex-pattern.schema.yaml",
                    JsonFormatSchema(
                        "application/schema+yaml;version=draft-07",
                        RegexPatternTest().jsonSchema()
                    )
                )
            )
        }

    }

}