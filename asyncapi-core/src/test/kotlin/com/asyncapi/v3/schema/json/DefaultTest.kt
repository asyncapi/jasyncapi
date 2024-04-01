package com.asyncapi.v3.schema.json

import com.asyncapi.v3.ClasspathUtils
import com.asyncapi.v3.schema.JsonSchema
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.type.CollectionType
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.math.BigInteger

class DefaultTest {

    private val objectMapper = ObjectMapper()
            .setSerializationInclusion(JsonInclude.Include.NON_NULL)

    private val schemasArray: CollectionType = objectMapper.typeFactory.constructCollectionType(List::class.java, JsonSchema::class.java)

    fun objectClass() = JsonSchema::class.java

    @Test
    @Disabled("Requires: DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS")
    @DisplayName("BigDecimal")
    fun compareBigDecimalWithParsedJson() {
        val jsonString = ClasspathUtils.readAsString("/json/v3/schema/json/default/bigdecimal.json")
        val values: List<JsonSchema> = objectMapper.readValue(jsonString, schemasArray)
        val expectedValues = listOf(
                JsonSchema.builder()
                        .defaultValue(BigDecimal("-2.214748364821474836482147483648214748364821474836482147483648214748364821474836482147483648"))
                        .build(),
                JsonSchema.builder()
                        .defaultValue(BigDecimal("1.123456789021474836471234567890214748364712345678902147483647"))
                        .build(),
                JsonSchema.builder()
                        .defaultValue(BigDecimal("2.214748364721474836472147483647214748364721474836472147483647214748364721474836472147483647"))
                        .build()
        )

        for (value: JsonSchema in values) {
            Assertions.assertTrue(
                    value.defaultValue!! is BigDecimal,
                    assertionMessage(BigDecimal::class.java, value.defaultValue!!)
            )
        }

        Assertions.assertEquals(values, expectedValues)
    }

    @Test
    @DisplayName("BigInteger")
    fun compareBigIntegerWithParsedJson() {
        val jsonString = ClasspathUtils.readAsString("/json/v3/schema/json/default/biginteger.json")
        val values: List<JsonSchema> = objectMapper.readValue(jsonString, schemasArray)
        val expectedValues = listOf(
                JsonSchema.builder()
                        .defaultValue(BigInteger("-214748364821474836482147483648"))
                        .build(),
                JsonSchema.builder()
                        .defaultValue(BigInteger("12345678902147483647"))
                        .build(),
                JsonSchema.builder()
                        .defaultValue(BigInteger("214748364721474836472147483647"))
                        .build()
        )

        for (value: JsonSchema in values) {
            Assertions.assertTrue(
                    value.defaultValue!! is BigInteger,
                    assertionMessage(BigInteger::class.java, value.defaultValue!!)
            )
        }

        Assertions.assertEquals(values, expectedValues)
    }

    @Test
    @DisplayName("Boolean")
    fun compareBooleanWithParsedJson() {
        val jsonString = ClasspathUtils.readAsString("/json/v3/schema/json/default/boolean.json")
        val values: List<JsonSchema> = objectMapper.readValue(jsonString, schemasArray)
        val expectedValues = listOf(
                JsonSchema.builder()
                        .defaultValue(false)
                        .build(),
                JsonSchema.builder()
                        .defaultValue(true)
                        .build()
        )

        for (value: JsonSchema in values) {
            Assertions.assertTrue(
                    value.defaultValue!! is Boolean,
                    assertionMessage(Boolean::class.java, value.defaultValue!!)
            )
        }

        Assertions.assertEquals(values, expectedValues)
    }

    @Test
    @DisplayName("Double")
    fun compareDoubleWithParsedJson() {
        val jsonString = ClasspathUtils.readAsString("/json/v3/schema/json/default/double.json")
        val values: List<JsonSchema> = objectMapper.readValue(jsonString, schemasArray)
        val expectedValues = listOf(
                JsonSchema.builder()
                        .defaultValue(-4.9E-324)
                        .build(),
                JsonSchema.builder()
                        .defaultValue(123.456)
                        .build(),
                JsonSchema.builder()
                        .defaultValue(1.7976931348623157E308)
                        .build()
        )

        for (value: JsonSchema in values) {
            Assertions.assertTrue(
                    value.defaultValue!! is Double,
                    assertionMessage(Double::class.java, value.defaultValue!!)
            )
        }

        Assertions.assertEquals(values, expectedValues)
    }

    @Test
    @Disabled("Required param. Collision with double on parsing")
    @DisplayName("Float")
    fun compareFloatWithParsedJson() {
        val jsonString = ClasspathUtils.readAsString("/json/v3/schema/json/default/float.json")
        val values: List<JsonSchema> = objectMapper.readValue(jsonString, schemasArray)
        val expectedValues = listOf(
                JsonSchema.builder()
                        .defaultValue(-1.1234567890)
                        .build(),
                JsonSchema.builder()
                        .defaultValue(0.123f)
                        .build(),
                JsonSchema.builder()
                        .defaultValue(3.4028235E38f)
                        .build()
        )

        for (value: JsonSchema in values) {
            Assertions.assertTrue(
                    value.defaultValue!! is Float,
                    assertionMessage(Float::class.java, value.defaultValue!!)
            )
        }

        Assertions.assertEquals(values, expectedValues)
    }

    @Test
    @DisplayName("Int")
    fun compareIntWithParsedJson() {
        val jsonString = ClasspathUtils.readAsString("/json/v3/schema/json/default/int.json")
        val values: List<JsonSchema> = objectMapper.readValue(jsonString, schemasArray)
        val expectedValues = listOf(
                JsonSchema.builder()
                        .defaultValue(-2147483648)
                        .build(),
                JsonSchema.builder()
                        .defaultValue(0)
                        .build(),
                JsonSchema.builder()
                        .defaultValue(2147483647)
                        .build()
        )

        for (value: JsonSchema in values) {
            Assertions.assertTrue(
                    value.defaultValue!! is Int,
                    assertionMessage(Int::class.java, value.defaultValue!!)
            )
        }

        Assertions.assertEquals(values, expectedValues)
    }

    @Test
    @DisplayName("Null")
    fun compareNullWithParsedJson() {
        val jsonString = ClasspathUtils.readAsString("/json/v3/schema/json/default/null.json")
        val values: List<JsonSchema> = objectMapper.readValue(jsonString, schemasArray)
        val expectedValues = listOf(
                JsonSchema.builder()
                        .defaultValue(null)
                        .build()
        )

        Assertions.assertEquals(values, expectedValues)
    }

    @Test
    @DisplayName("Object")
    fun compareObjectWithParsedJson() {
        val jsonString = ClasspathUtils.readAsString("/json/v3/schema/json/default/object.json")
        val values: List<JsonSchema> = objectMapper.readValue(jsonString, schemasArray)
        val expectedValues = listOf(
                JsonSchema.builder()
                        .defaultValue(JsonSchema.builder()
                                .type("string")
                                .constValue("abc")
                                .build()
                        )
                        .build()
        )

        for (value: JsonSchema in values) {
            Assertions.assertTrue(
                    value.defaultValue!! is JsonSchema,
                    assertionMessage(JsonSchema::class.java, value.defaultValue!!)
            )
        }

        Assertions.assertEquals(values, expectedValues)
    }

    private fun assertionMessage(expectedClass: Class<*>, value: Any): String {
        return "MUST be parsed as ${expectedClass.name}: $value but was ${value::class.java.name}"
    }

}