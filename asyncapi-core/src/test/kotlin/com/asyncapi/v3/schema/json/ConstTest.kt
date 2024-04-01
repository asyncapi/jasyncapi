package com.asyncapi.v3.schema.json

import com.asyncapi.v3.ClasspathUtils
import com.asyncapi.v3.schema.JsonSchema
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.type.CollectionType
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.math.BigInteger

class ConstTest {

    private val objectMapper = ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL)

    private val schemasArray: CollectionType = objectMapper.typeFactory.constructCollectionType(List::class.java, JsonSchema::class.java)

    fun objectClass() = JsonSchema::class.java

    @Test
    @Disabled("Requires: DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS")
    @DisplayName("BigDecimal")
    fun compareBigDecimalWithParsedJson() {
        val jsonString = ClasspathUtils.readAsString("/json/v3/schema/json/const/bigdecimal.json")
        val values: List<JsonSchema> = objectMapper.readValue(jsonString, schemasArray)
        val expectedValues = listOf(
                JsonSchema.builder()
                        .constValue(BigDecimal.valueOf(-214748364821474836482147483648214748364821474836482147483648214748364821474836482147483648.214748364821474836482147483648214748364821474836482147483648214748364821474836482147483648))
                        .build(),
                JsonSchema.builder()
                        .constValue(BigDecimal.valueOf(123456789021474836471234567890214748364712345678902147483647.123456789021474836471234567890214748364712345678902147483647))
                        .build(),
                JsonSchema.builder()
                        .constValue(BigDecimal.valueOf(214748364721474836472147483647214748364721474836472147483647214748364721474836472147483647.214748364721474836472147483647214748364721474836472147483647214748364721474836472147483647))
                        .build()
        )

        for (value: JsonSchema in values) {
            Assertions.assertTrue(
                    value.constValue!! is BigDecimal,
                    assertionMessage(BigDecimal::class.java, value.constValue!!)
            )
        }

        Assertions.assertEquals(values, expectedValues)
    }

    @Test
    @DisplayName("BigInteger")
    fun compareBigIntegerWithParsedJson() {
        val jsonString = ClasspathUtils.readAsString("/json/v3/schema/json/const/biginteger.json")
        val values: List<JsonSchema> = objectMapper.readValue(jsonString, schemasArray)
        val expectedValues = listOf(
                JsonSchema.builder()
                        .constValue(BigInteger("-214748364821474836482147483648"))
                        .build(),
                JsonSchema.builder()
                        .constValue(BigInteger("12345678902147483647"))
                        .build(),
                JsonSchema.builder()
                        .constValue(BigInteger("214748364721474836472147483647"))
                        .build()
        )

        for (value: JsonSchema in values) {
            Assertions.assertTrue(
                    value.constValue!! is BigInteger,
                    assertionMessage(BigInteger::class.java, value.constValue!!)
            )
        }

        Assertions.assertEquals(values, expectedValues)
    }

    @Test
    @DisplayName("Boolean")
    fun compareBooleanWithParsedJson() {
        val jsonString = ClasspathUtils.readAsString("/json/v3/schema/json/const/boolean.json")
        val values: List<JsonSchema> = objectMapper.readValue(jsonString, schemasArray)
        val expectedValues = listOf(
                JsonSchema.builder()
                        .constValue(false)
                        .build(),
                JsonSchema.builder()
                        .constValue(true)
                        .build()
        )

        for (value: JsonSchema in values) {
            Assertions.assertTrue(
                    value.constValue!! is Boolean,
                    assertionMessage(Boolean::class.java, value.constValue!!)
            )
        }

        Assertions.assertEquals(values, expectedValues)
    }

    @Test
    @DisplayName("Double")
    fun compareDoubleWithParsedJson() {
        val jsonString = ClasspathUtils.readAsString("/json/v3/schema/json/const/double.json")
        val values: List<JsonSchema> = objectMapper.readValue(jsonString, schemasArray)
        val expectedValues = listOf(
                JsonSchema.builder()
                        .constValue(-4.9E-324)
                        .build(),
                JsonSchema.builder()
                        .constValue(123.456)
                        .build(),
                JsonSchema.builder()
                        .constValue(1.7976931348623157E308)
                        .build()
        )

        for (value: JsonSchema in values) {
            Assertions.assertTrue(
                    value.constValue!! is Double,
                    assertionMessage(Double::class.java, value.constValue!!)
            )
        }

        Assertions.assertEquals(values, expectedValues)
    }

    @Test
    @Disabled("Required param. Collision with double on parsing")
    @DisplayName("Float")
    fun compareFloatWithParsedJson() {
        val jsonString = ClasspathUtils.readAsString("/json/v3/schema/json/const/double.json")
        val values: List<JsonSchema> = objectMapper.readValue(jsonString, schemasArray)
        val expectedValues = listOf(
                JsonSchema.builder()
                        .constValue(-1.4E-45)
                        .build(),
                JsonSchema.builder()
                        .constValue(1234567890.1234567890)
                        .build(),
                JsonSchema.builder()
                        .constValue(3.4028235E38)
                        .build()
        )

        for (value: JsonSchema in values) {
            Assertions.assertTrue(
                    value.constValue!! is Float,
                    assertionMessage(Float::class.java, value.constValue!!)
            )
        }

        Assertions.assertEquals(values, expectedValues)
    }

    @Test
    @DisplayName("Int")
    fun compareIntWithParsedJson() {
        val jsonString = ClasspathUtils.readAsString("/json/v3/schema/json/const/int.json")
        val values: List<JsonSchema> = objectMapper.readValue(jsonString, schemasArray)
        val expectedValues = listOf(
                JsonSchema.builder()
                        .constValue(-2147483648)
                        .build(),
                JsonSchema.builder()
                        .constValue(0)
                        .build(),
                JsonSchema.builder()
                        .constValue(2147483647)
                        .build()
        )

        for (value: JsonSchema in values) {
            Assertions.assertTrue(
                    value.constValue!! is Int,
                    assertionMessage(Int::class.java, value.constValue!!)
            )
        }

        Assertions.assertEquals(values, expectedValues)
    }

    @Test
    @DisplayName("Null")
    fun compareNullWithParsedJson() {
        val jsonString = ClasspathUtils.readAsString("/json/v3/schema/json/const/null.json")
        val values: List<JsonSchema> = objectMapper.readValue(jsonString, schemasArray)
        val expectedValues = listOf(
                JsonSchema.builder()
                        .constValue(null)
                        .build()
        )

        Assertions.assertEquals(values, expectedValues)
    }

    @Test
    @DisplayName("Object")
    fun compareObjectWithParsedJson() {
        val jsonString = ClasspathUtils.readAsString("/json/v3/schema/json/const/object.json")
        val values: List<JsonSchema> = objectMapper.readValue(jsonString, schemasArray)
        val expectedValues = listOf(
                JsonSchema.builder()
                        .constValue(JsonSchema.builder()
                                .type("string")
                                .constValue("abc")
                                .build()
                        )
                        .build()
        )

        for (value: JsonSchema in values) {
            Assertions.assertTrue(
                    value.constValue!! is JsonSchema,
                    assertionMessage(JsonSchema::class.java, value.constValue!!)
            )
        }

        Assertions.assertEquals(values, expectedValues)
    }

    private fun assertionMessage(expectedClass: Class<*>, value: Any): String {
        return "MUST be parsed as ${expectedClass.name}: $value but was ${value::class.java.name}"
    }

}