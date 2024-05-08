package com.asyncapi.schemas.json

import com.asyncapi.schemas.AsyncAPISchema
import com.asyncapi.schemas.SchemaProvider

class ConditionalValidationIfElse: SchemaProvider {

    override fun jsonSchema(): JsonSchema {
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
                .ifValue(
                    JsonSchema.builder()
                        .properties(mapOf(
                                Pair("isMember", JsonSchema.builder()
                                        .constValue(true)
                                        .build()
                                ),
                        ))
                        .build()
                )
                .thenValue(
                    JsonSchema.builder()
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
                .elseValue(
                    JsonSchema.builder()
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

    override fun asyncAPISchema(): AsyncAPISchema {
        return AsyncAPISchema.builder()
                .id("https://example.com/conditional-validation-if-else.schema.json")
                .schema("http://json-schema.org/draft-07/schema#")
                .title("Conditional Validation with If-Else")
                .type("object")
                .properties(mapOf(
                        Pair("isMember", AsyncAPISchema.builder()
                                .type("boolean")
                                .build()
                        ),
                        Pair("membershipNumber", AsyncAPISchema.builder()
                                .type("string")
                                .build()
                        )
                ))
                .required(listOf("isMember"))
                .ifValue(
                    AsyncAPISchema.builder()
                        .properties(mapOf(
                                Pair("isMember", AsyncAPISchema.builder()
                                        .constValue(true)
                                        .build()
                                ),
                        ))
                        .build()
                )
                .thenValue(
                    AsyncAPISchema.builder()
                        .properties(mapOf(
                                Pair("membershipNumber", AsyncAPISchema.builder()
                                        .type("string")
                                        .minLength(10)
                                        .maxLength(10)
                                        .build()
                                ),
                        ))
                        .build()
                )
                .elseValue(
                    AsyncAPISchema.builder()
                        .properties(mapOf(
                                Pair("membershipNumber", AsyncAPISchema.builder()
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