package com.asyncapi.schemas

import com.asyncapi.schemas.asyncapi.AsyncAPISchema
import com.asyncapi.schemas.json.*
import com.asyncapi.v3.ClasspathUtils
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.*
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class ReadJsonSchemaTest {

    private val objectMapper: ObjectMapper = ObjectMapper()
            .setSerializationInclusion(JsonInclude.Include.NON_NULL)

    fun compareSchemas(schemaToCompareWith: String,
                       schemaClass: Class<*>,
                       schemaProvider: SchemaProvider
    ) {
        val jsonSchemaString = ClasspathUtils.readAsString(schemaToCompareWith)
        val jsonSchema = objectMapper.readValue(jsonSchemaString, schemaClass)
        val schemaToCheck: Any? = when (schemaClass) {
            JsonSchema::class.java -> schemaProvider.jsonSchema()
            AsyncAPISchema::class.java -> schemaProvider.asyncAPISchema()
            else -> null
        }

        Assertions.assertEquals(jsonSchema, schemaToCheck)
    }

    @Nested
    inner class JsonSchemaImplementation {

        @ArgumentsSource(JsonSchemas::class)
        @ParameterizedTest(name = "Read: {0}")
        fun readJsonSchema(schemaToCompareWith: String, schemaProvider: SchemaProvider) {
            compareSchemas(schemaToCompareWith, JsonSchema::class.java, schemaProvider)
        }

    }

    @Nested
    inner class AsyncAPISchemaImplementation {

        @ArgumentsSource(JsonSchemas::class)
        @ParameterizedTest(name = "Read: {0}")
        fun readJsonSchema(schemaToCompareWith: String, schemaProvider: SchemaProvider) {
            compareSchemas(schemaToCompareWith, AsyncAPISchema::class.java, schemaProvider)
        }

    }

    class JsonSchemas: ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
            return Stream.of(
                    Arguments.of("/schemas/json/arrays.schema.json", ArraysSchemaTest()),
                    Arguments.of("/schemas/json/complex-object.schema.json", ComplexObjectTest()),
                    Arguments.of("/schemas/json/conditional-validation-if-else.schema.json", ConditionalValidationIfElse()),
                    Arguments.of("/schemas/json/draft-07-core-schema-meta-schema.json", Draft07CoreSchemaMetaSchemaTest()),
                    Arguments.of("/schemas/json/enumerated-values.schema.json", EnumeratedValuesTest()),
                    Arguments.of("/schemas/json/person.schema.json", PersonTest()),
                    Arguments.of("/schemas/json/regex-pattern.schema.json", RegexPatternTest())
            )
        }

    }

}