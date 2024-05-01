package com.asyncapi.v3.schema.json

import com.asyncapi.schemas.AsyncAPISchema
import com.asyncapi.schemas.JsonSchema
import com.asyncapi.v3.schema.SchemaProvider
import java.math.BigDecimal

class Draft07CoreSchemaMetaSchemaTest: SchemaProvider {

    override fun jsonSchema(): JsonSchema {
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
                                .additionalProperties(
                                    JsonSchema.builder().anyOf(listOf(
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

    override fun asyncAPISchema(): AsyncAPISchema {
        return AsyncAPISchema.builder()
                .schema("http://json-schema.org/draft-07/schema#")
                .id("http://json-schema.org/draft-07/schema#")
                .title("Core schema meta-schema")
                .definitions(mapOf(
                        Pair("schemaArray", AsyncAPISchema.builder()
                                .type("array")
                                .minItems(1)
                                .items(AsyncAPISchema.builder().ref("#").build())
                                .build()
                        ),
                        Pair("nonNegativeInteger", AsyncAPISchema.builder()
                                .type("integer")
                                .minimum(BigDecimal.ZERO)
                                .build()
                        ),
                        Pair("nonNegativeIntegerDefault0", AsyncAPISchema.builder()
                                .allOf(listOf(
                                        AsyncAPISchema.builder().ref("#/definitions/nonNegativeInteger").build(),
                                        AsyncAPISchema.builder().defaultValue(0).build()
                                ))
                                .build()
                        ),
                        Pair("simpleTypes", AsyncAPISchema.builder()
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
                        Pair("stringArray", AsyncAPISchema.builder()
                                .type("array")
                                .items(AsyncAPISchema.builder().type("string").build())
                                .uniqueItems(true)
                                .defaultValue(emptyList<String>())
                                .build()
                        )
                ))
                .type(listOf("object", "boolean"))
                .properties(mapOf(
                        Pair("\$id", AsyncAPISchema.builder()
                                .type("string")
                                .format("uri-reference")
                                .build()
                        ),
                        Pair("\$schema", AsyncAPISchema.builder()
                                .type("string")
                                .format("uri")
                                .build()
                        ),
                        Pair("\$ref", AsyncAPISchema.builder()
                                .type("string")
                                .format("uri-reference")
                                .build()
                        ),
                        Pair("\$comment", AsyncAPISchema.builder()
                                .type("string")
                                .build()
                        ),
                        Pair("title", AsyncAPISchema.builder()
                                .type("string")
                                .build()
                        ),
                        Pair("description", AsyncAPISchema.builder()
                                .type("string")
                                .build()
                        ),
                        Pair("default", true),
                        Pair("readOnly", AsyncAPISchema.builder()
                                .type("boolean")
                                .defaultValue(false)
                                .build()
                        ),
                        Pair("writeOnly", AsyncAPISchema.builder()
                                .type("boolean")
                                .defaultValue(false)
                                .build()
                        ),
                        Pair("examples", AsyncAPISchema.builder()
                                .type("array")
                                .items(true)
                                .build()
                        ),
                        Pair("multipleOf", AsyncAPISchema.builder()
                                .type("number")
                                .exclusiveMinimum(BigDecimal.ZERO)
                                .build()
                        ),
                        Pair("maximum", AsyncAPISchema.builder()
                                .type("number")
                                .build()
                        ),
                        Pair("exclusiveMaximum", AsyncAPISchema.builder()
                                .type("number")
                                .build()
                        ),
                        Pair("minimum", AsyncAPISchema.builder()
                                .type("number")
                                .build()
                        ),
                        Pair("exclusiveMinimum", AsyncAPISchema.builder()
                                .type("number")
                                .build()
                        ),
                        Pair("maxLength", AsyncAPISchema.builder()
                                .ref("#/definitions/nonNegativeInteger")
                                .build()
                        ),
                        Pair("minLength", AsyncAPISchema.builder()
                                .ref("#/definitions/nonNegativeIntegerDefault0")
                                .build()
                        ),
                        Pair("pattern", AsyncAPISchema.builder()
                                .type("string")
                                .format("regex")
                                .build()
                        ),
                        Pair("additionalItems", AsyncAPISchema.builder()
                                .ref("#")
                                .build()
                        ),
                        Pair("items", AsyncAPISchema.builder()
                                .anyOf(listOf(
                                        AsyncAPISchema.builder().ref("#").build(),
                                        AsyncAPISchema.builder().ref("#/definitions/schemaArray").build(),
                                ))
                                .defaultValue(true)
                                .build()
                        ),
                        Pair("maxItems", AsyncAPISchema.builder()
                                .ref("#/definitions/nonNegativeInteger")
                                .build()
                        ),
                        Pair("minItems", AsyncAPISchema.builder()
                                .ref("#/definitions/nonNegativeIntegerDefault0")
                                .build()
                        ),
                        Pair("uniqueItems", AsyncAPISchema.builder()
                                .type("boolean")
                                .defaultValue(false)
                                .build()
                        ),
                        Pair("contains", AsyncAPISchema.builder()
                                .ref("#")
                                .build()
                        ),
                        Pair("maxProperties", AsyncAPISchema.builder()
                                .ref("#/definitions/nonNegativeInteger")
                                .build()
                        ),
                        Pair("minProperties", AsyncAPISchema.builder()
                                .ref("#/definitions/nonNegativeIntegerDefault0")
                                .build()
                        ),
                        Pair("required", AsyncAPISchema.builder()
                                .ref("#/definitions/stringArray")
                                .build()
                        ),
                        Pair("additionalProperties", AsyncAPISchema.builder()
                                .ref("#")
                                .build()
                        ),
                        Pair("definitions", AsyncAPISchema.builder()
                                .type("object")
                                .additionalProperties(AsyncAPISchema.builder().ref("#").build())
                                .defaultValue(AsyncAPISchema())
                                .build()
                        ),
                        Pair("properties", AsyncAPISchema.builder()
                                .type("object")
                                .additionalProperties(AsyncAPISchema.builder().ref("#").build())
                                .defaultValue(AsyncAPISchema())
                                .build()
                        ),
                        Pair("patternProperties", AsyncAPISchema.builder()
                                .type("object")
                                .additionalProperties(AsyncAPISchema.builder().ref("#").build())
                                .propertyNames(AsyncAPISchema.builder().format("regex").build())
                                .defaultValue(AsyncAPISchema())
                                .build()
                        ),
                        Pair("dependencies", AsyncAPISchema.builder()
                                .type("object")
                                .additionalProperties(
                                    AsyncAPISchema.builder().anyOf(listOf(
                                        AsyncAPISchema.builder().ref("#").build(),
                                        AsyncAPISchema.builder().ref("#/definitions/stringArray").build(),
                                )).build())
                                .build()
                        ),
                        Pair("propertyNames", AsyncAPISchema.builder().ref("#").build()),
                        Pair("const", true),
                        Pair("enum", AsyncAPISchema.builder()
                                .type("array")
                                .items(true)
                                .minItems(1)
                                .uniqueItems(true)
                                .build()
                        ),
                        Pair("type", AsyncAPISchema.builder()
                                .anyOf(listOf(
                                        AsyncAPISchema.builder().ref("#/definitions/simpleTypes").build(),
                                        AsyncAPISchema.builder()
                                                .type("array")
                                                .items(AsyncAPISchema.builder().ref("#/definitions/simpleTypes").build())
                                                .minItems(1)
                                                .uniqueItems(true)
                                                .build()
                                ))
                                .build()
                        ),
                        Pair("format", AsyncAPISchema.builder()
                                .type("string")
                                .build()
                        ),
                        Pair("contentMediaType", AsyncAPISchema.builder()
                                .type("string")
                                .build()
                        ),
                        Pair("contentEncoding", AsyncAPISchema.builder()
                                .type("string")
                                .build()
                        ),
                        Pair("if", AsyncAPISchema.builder()
                                .ref("#")
                                .build()
                        ),
                        Pair("then", AsyncAPISchema.builder()
                                .ref("#")
                                .build()
                        ),
                        Pair("else", AsyncAPISchema.builder()
                                .ref("#")
                                .build()
                        ),
                        Pair("allOf", AsyncAPISchema.builder()
                                .ref("#/definitions/schemaArray")
                                .build()
                        ),
                        Pair("anyOf", AsyncAPISchema.builder()
                                .ref("#/definitions/schemaArray")
                                .build()
                        ),
                        Pair("oneOf", AsyncAPISchema.builder()
                                .ref("#/definitions/schemaArray")
                                .build()
                        ),
                        Pair("not", AsyncAPISchema.builder()
                                .ref("#")
                                .build()
                        ),
                ))
                .defaultValue(true)
                .build()
    }

}