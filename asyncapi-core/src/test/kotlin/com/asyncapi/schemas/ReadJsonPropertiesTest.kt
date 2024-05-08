package com.asyncapi.schemas

import com.asyncapi.schemas.json.JsonSchema
import com.asyncapi.schemas.json.properties.*
import com.asyncapi.v3.ClasspathUtils
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.*
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.math.BigDecimal
import java.util.stream.Stream

class ReadJsonPropertiesTest {

    private val objectMapper: ObjectMapper = ObjectMapper()
            .setSerializationInclusion(JsonInclude.Include.NON_NULL)

    private val bigDecimalObjectMapper: ObjectMapper = ObjectMapper()
            .configure(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS, true)
            .setSerializationInclusion(JsonInclude.Include.NON_NULL)

    fun compareSchemas(schemaToCompareWith: String,
                       schemaClass: Class<*>,
                       schemaProvider: SchemaProvider
    ) {
        val jsonSchemaString = ClasspathUtils.readAsString(schemaToCompareWith)
        val jsonSchema = if (schemaProvider.jsonSchema().defaultValue is BigDecimal) {
            bigDecimalObjectMapper.readValue(jsonSchemaString, schemaClass)
        } else {
            objectMapper.readValue(jsonSchemaString, schemaClass)
        }
        val schemaToCheck: Any? = when (schemaClass) {
            JsonSchema::class.java -> schemaProvider.jsonSchema()
            AsyncAPISchema::class.java -> schemaProvider.asyncAPISchema()
            else -> null
        }

        Assertions.assertEquals(jsonSchema, schemaToCheck)
    }

    @Nested
    inner class JsonSchemaImplementation {

        @ArgumentsSource(Properties::class)
        @ParameterizedTest(name = "Read: {0}")
        fun readAnyTypeProperty(constPropertyToRead: String, schemaProvider: SchemaProvider) {
            compareSchemas(constPropertyToRead, JsonSchema::class.java, schemaProvider)
        }

    }

    @Nested
    inner class AsyncAPISchemaImplementation {

        @ArgumentsSource(Properties::class)
        @ParameterizedTest(name = "Read: {0}")
        fun readAnyTypeProperty(constPropertyToRead: String, schemaProvider: SchemaProvider) {
            compareSchemas(constPropertyToRead, AsyncAPISchema::class.java, schemaProvider)
        }

    }

    class Properties: ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
            return Stream.of(
                    Arguments.of("/schemas/json/properties/bigdecimal.json", ConstDefaultExamplesBigDecimalTest()),
                    Arguments.of("/schemas/json/properties/bigdecimal-maximum.json", ConstDefaultExamplesBigDecimalMaximumTest()),
                    Arguments.of("/schemas/json/properties/bigdecimal-minimum.json", ConstDefaultExamplesBigDecimalMinimumTest()),

                    Arguments.of("/schemas/json/properties/biginteger.json", ConstDefaultExamplesBigIntegerTest()),
                    Arguments.of("/schemas/json/properties/biginteger-maximum.json", ConstDefaultExamplesBigIntegerMaximumTest()),
                    Arguments.of("/schemas/json/properties/biginteger-minimum.json", ConstDefaultExamplesBigIntegerMinimumTest()),

                    Arguments.of("/schemas/json/properties/boolean-false.json", ConstDefaultExamplesBooleanFalseTest()),
                    Arguments.of("/schemas/json/properties/boolean-true.json", ConstDefaultExamplesBooleanTrueTest()),

                    Arguments.of("/schemas/json/properties/double.json", ConstDefaultExamplesDoubleTest()),
                    Arguments.of("/schemas/json/properties/double-maximum.json", ConstDefaultExamplesDoubleMaximumTest()),
                    Arguments.of("/schemas/json/properties/double-minimum.json", ConstDefaultExamplesDoubleMinimumTest()),

                    Arguments.of("/schemas/json/properties/int.json", ConstDefaultExamplesIntTest()),
                    Arguments.of("/schemas/json/properties/int-maximum.json", ConstDefaultExamplesIntMaximumTest()),
                    Arguments.of("/schemas/json/properties/int-minimum.json", ConstDefaultExamplesIntMinimumTest()),

                    Arguments.of("/schemas/json/properties/null.json", ConstDefaultExamplesNullTest()),

                    Arguments.of("/schemas/json/properties/object.json", ConstDefaultExamplesObjectTest()),

                    Arguments.of("/schemas/json/properties/array.json", ConstDefaultExamplesArrayTest()),
            )
        }

    }

}