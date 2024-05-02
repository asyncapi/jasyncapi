package com.asyncapi.schemas

import com.asyncapi.schemas.json.properties.*
import com.asyncapi.v3.ClasspathUtils
import com.asyncapi.v3.schema.SchemaProvider
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
                    Arguments.of("/json/v3/schema/json/properties/bigdecimal.json", ConstDefaultExamplesBigDecimalTest()),
                    Arguments.of("/json/v3/schema/json/properties/bigdecimal-maximum.json", ConstDefaultExamplesBigDecimalMaximumTest()),
                    Arguments.of("/json/v3/schema/json/properties/bigdecimal-minimum.json", ConstDefaultExamplesBigDecimalMinimumTest()),

                    Arguments.of("/json/v3/schema/json/properties/biginteger.json", ConstDefaultExamplesBigIntegerTest()),
                    Arguments.of("/json/v3/schema/json/properties/biginteger-maximum.json", ConstDefaultExamplesBigIntegerMaximumTest()),
                    Arguments.of("/json/v3/schema/json/properties/biginteger-minimum.json", ConstDefaultExamplesBigIntegerMinimumTest()),

                    Arguments.of("/json/v3/schema/json/properties/boolean-false.json", ConstDefaultExamplesBooleanFalseTest()),
                    Arguments.of("/json/v3/schema/json/properties/boolean-true.json", ConstDefaultExamplesBooleanTrueTest()),

                    Arguments.of("/json/v3/schema/json/properties/double.json", ConstDefaultExamplesDoubleTest()),
                    Arguments.of("/json/v3/schema/json/properties/double-maximum.json", ConstDefaultExamplesDoubleMaximumTest()),
                    Arguments.of("/json/v3/schema/json/properties/double-minimum.json", ConstDefaultExamplesDoubleMinimumTest()),

                    Arguments.of("/json/v3/schema/json/properties/int.json", ConstDefaultExamplesIntTest()),
                    Arguments.of("/json/v3/schema/json/properties/int-maximum.json", ConstDefaultExamplesIntMaximumTest()),
                    Arguments.of("/json/v3/schema/json/properties/int-minimum.json", ConstDefaultExamplesIntMinimumTest()),

                    Arguments.of("/json/v3/schema/json/properties/null.json", ConstDefaultExamplesNullTest()),

                    Arguments.of("/json/v3/schema/json/properties/object.json", ConstDefaultExamplesObjectTest()),

                    Arguments.of("/json/v3/schema/json/properties/array.json", ConstDefaultExamplesArrayTest()),
            )
        }

    }

}