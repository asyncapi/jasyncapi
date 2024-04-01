package com.asyncapi.v3.schema.json

import com.asyncapi.v3.schema.JsonSchema
import com.asyncapi.v3.schema.ReadSchemaTest

class ConditionalValidationIfElse: ReadSchemaTest<JsonSchema>() {

    override fun schemaClass() = JsonSchema::class.java

    override fun schemaToReadPath() = "/json/v3/schema/json/conditional-validation-if-else.schema.json"

    override fun buildSchema(): JsonSchema {
        return JsonSchema.builder()
                .id("https://example.com/conditional-validation-if-else.schema.json")
                .schema("http://json-schema.org/draft-07/schema#")
                .title("Conditional Validation with If-Else")
                .type("object")
                .properties(mapOf(
                        Pair("isMember", JsonSchema.builder()
                                .type("boolean")
                                .build()
                        ),
                        Pair("membershipNumber", JsonSchema.builder()
                                .type("string")
                                .build()
                        )
                ))
                .required(listOf("isMember"))
                .ifValue(JsonSchema.builder()
                        .properties(mapOf(
                                Pair("isMember", JsonSchema.builder()
                                        .constValue(true)
                                        .build()
                                ),
                        ))
                        .build()
                )
                .thenValue(JsonSchema.builder()
                        .properties(mapOf(
                                Pair("membershipNumber", JsonSchema.builder()
                                        .type("string")
                                        .minLength(10)
                                        .maxLength(10)
                                        .build()
                                ),
                        ))
                        .build()
                )
                .elseValue(JsonSchema.builder()
                        .properties(mapOf(
                                Pair("membershipNumber", JsonSchema.builder()
                                        .type("string")
                                        .minLength(15)
                                        .build()
                                ),
                        ))
                        .build()
                )
                .build()
    }

}