package com.asyncapi.v3.schema.json

import com.asyncapi.v3.ClasspathUtils
import com.asyncapi.v3.schema.JsonSchema
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class Draft07CoreSchemaMetaSchemaTest {

    private val objectMapper = ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL)

    fun baseObjectJson() = "/json/v3/schema/json/draft-07-core-schema-meta-schema.json"

    fun objectClass() = JsonSchema::class.java

    fun build(): JsonSchema {
        return JsonSchema.builder()
                .schema("http://json-schema.org/draft-07/schema#")
                .id("http://json-schema.org/draft-07/schema#")
                .title("Core schema meta-schema")
                .definitions(mapOf(
                        Pair("schemaArray", JsonSchema.builder()
                                .type("array")
                                .minItems(1)
                                .items(JsonSchema.builder().ref("#").build())
                                .build()
                        ),
                        Pair("nonNegativeInteger", JsonSchema.builder()
                                .type("integer")
                                .minimum(BigDecimal.ZERO)
                                .build()
                        ),
                        Pair("nonNegativeIntegerDefault0", JsonSchema.builder()
                                .allOf(listOf(
                                        JsonSchema.builder().ref("#/definitions/nonNegativeInteger").build(),
                                        JsonSchema.builder().defaultValue(0).build()
                                ))
                                .build()
                        ),
                        Pair("simpleTypes", JsonSchema.builder()
                                .enumValue(listOf(
                                        "array",
                                        "boolean",
                                        "integer",
                                        "null",
                                        "number",
                                        "object",
                                        "string"
                                ))
                                .build()
                        ),
                        Pair("stringArray", JsonSchema.builder()
                                .type("array")
                                .items(JsonSchema.builder().type("string").build())
                                .uniqueItems(true)
                                .defaultValue(emptyList<String>())
                                .build()
                        )
                ))
                .type(listOf("object", "boolean"))
                .properties(mapOf(
                        Pair("\$id", JsonSchema.builder()
                                .type("string")
                                .format("uri-reference")
                                .build()
                        ),
                        Pair("\$schema", JsonSchema.builder()
                                .type("string")
                                .format("uri")
                                .build()
                        ),
                        Pair("\$ref", JsonSchema.builder()
                                .type("string")
                                .format("uri-reference")
                                .build()
                        ),
                        Pair("\$comment", JsonSchema.builder()
                                .type("string")
                                .build()
                        ),
                        Pair("title", JsonSchema.builder()
                                .type("string")
                                .build()
                        ),
                        Pair("description", JsonSchema.builder()
                                .type("string")
                                .build()
                        ),
                        Pair("default", true),
                        Pair("readOnly", JsonSchema.builder()
                                .type("boolean")
                                .defaultValue(false)
                                .build()
                        ),
                        Pair("writeOnly", JsonSchema.builder()
                                .type("boolean")
                                .defaultValue(false)
                                .build()
                        ),
                        Pair("examples", JsonSchema.builder()
                                .type("array")
                                .items(true)
                                .build()
                        ),
                        Pair("multipleOf", JsonSchema.builder()
                                .type("number")
                                .exclusiveMinimum(BigDecimal.ZERO)
                                .build()
                        ),
                        Pair("maximum", JsonSchema.builder()
                                .type("number")
                                .build()
                        ),
                        Pair("exclusiveMaximum", JsonSchema.builder()
                                .type("number")
                                .build()
                        ),
                        Pair("minimum", JsonSchema.builder()
                                .type("number")
                                .build()
                        ),
                        Pair("exclusiveMinimum", JsonSchema.builder()
                                .type("number")
                                .build()
                        ),
                        Pair("maxLength", JsonSchema.builder()
                                .ref("#/definitions/nonNegativeInteger")
                                .build()
                        ),
                        Pair("minLength", JsonSchema.builder()
                                .ref("#/definitions/nonNegativeIntegerDefault0")
                                .build()
                        ),
                        Pair("pattern", JsonSchema.builder()
                                .type("string")
                                .format("regex")
                                .build()
                        ),
                        Pair("additionalItems", JsonSchema.builder()
                                .ref("#")
                                .build()
                        ),
                        Pair("items", JsonSchema.builder()
                                .anyOf(listOf(
                                        JsonSchema.builder().ref("#").build(),
                                        JsonSchema.builder().ref("#/definitions/schemaArray").build(),
                                ))
                                .defaultValue(true)
                                .build()
                        ),
                        Pair("maxItems", JsonSchema.builder()
                                .ref("#/definitions/nonNegativeInteger")
                                .build()
                        ),
                        Pair("minItems", JsonSchema.builder()
                                .ref("#/definitions/nonNegativeIntegerDefault0")
                                .build()
                        ),
                        Pair("uniqueItems", JsonSchema.builder()
                                .type("boolean")
                                .defaultValue(false)
                                .build()
                        ),
                        Pair("contains", JsonSchema.builder()
                                .ref("#")
                                .build()
                        ),
                        Pair("maxProperties", JsonSchema.builder()
                                .ref("#/definitions/nonNegativeInteger")
                                .build()
                        ),
                        Pair("minProperties", JsonSchema.builder()
                                .ref("#/definitions/nonNegativeIntegerDefault0")
                                .build()
                        ),
                        Pair("required", JsonSchema.builder()
                                .ref("#/definitions/stringArray")
                                .build()
                        ),
                        Pair("additionalProperties", JsonSchema.builder()
                                .ref("#")
                                .build()
                        ),
                        Pair("definitions", JsonSchema.builder()
                                .type("object")
                                .additionalProperties(JsonSchema.builder().ref("#").build())
                                .defaultValue(JsonSchema())
                                .build()
                        ),
                        Pair("properties", JsonSchema.builder()
                                .type("object")
                                .additionalProperties(JsonSchema.builder().ref("#").build())
                                .defaultValue(JsonSchema())
                                .build()
                        ),
                        Pair("patternProperties", JsonSchema.builder()
                                .type("object")
                                .additionalProperties(JsonSchema.builder().ref("#").build())
                                .propertyNames(JsonSchema.builder().format("regex").build())
                                .defaultValue(JsonSchema())
                                .build()
                        ),
                        Pair("dependencies", JsonSchema.builder()
                                .type("object")
                                .additionalProperties(JsonSchema.builder().anyOf(listOf(
                                        JsonSchema.builder().ref("#").build(),
                                        JsonSchema.builder().ref("#/definitions/stringArray").build(),
                                )).build())
                                .build()
                        ),
                        Pair("propertyNames", JsonSchema.builder().ref("#").build()),
                        Pair("const", true),
                        Pair("enum", JsonSchema.builder()
                                .type("array")
                                .items(true)
                                .minItems(1)
                                .uniqueItems(true)
                                .build()
                        ),
                        Pair("type", JsonSchema.builder()
                                .anyOf(listOf(
                                        JsonSchema.builder().ref("#/definitions/simpleTypes").build(),
                                        JsonSchema.builder()
                                                .type("array")
                                                .items(JsonSchema.builder().ref("#/definitions/simpleTypes").build())
                                                .minItems(1)
                                                .uniqueItems(true)
                                                .build()
                                ))
                                .build()
                        ),
                        Pair("format", JsonSchema.builder()
                                .type("string")
                                .build()
                        ),
                        Pair("contentMediaType", JsonSchema.builder()
                                .type("string")
                                .build()
                        ),
                        Pair("contentEncoding", JsonSchema.builder()
                                .type("string")
                                .build()
                        ),
                        Pair("if", JsonSchema.builder()
                                .ref("#")
                                .build()
                        ),
                        Pair("then", JsonSchema.builder()
                                .ref("#")
                                .build()
                        ),
                        Pair("else", JsonSchema.builder()
                                .ref("#")
                                .build()
                        ),
                        Pair("allOf", JsonSchema.builder()
                                .ref("#/definitions/schemaArray")
                                .build()
                        ),
                        Pair("anyOf", JsonSchema.builder()
                                .ref("#/definitions/schemaArray")
                                .build()
                        ),
                        Pair("oneOf", JsonSchema.builder()
                                .ref("#/definitions/schemaArray")
                                .build()
                        ),
                        Pair("not", JsonSchema.builder()
                                .ref("#")
                                .build()
                        ),
                ))
                .defaultValue(true)
                .build()
    }

    @Test
    @DisplayName("Compare hand crafted object with parsed json")
    fun compareObjectWithParsedJson() {
        val model = ClasspathUtils.readAsString(baseObjectJson())

        Assertions.assertEquals(
                objectMapper.readValue(model, objectClass()),
                build()
        )
    }

}