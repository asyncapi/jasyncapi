package com.asyncapi.schemas.json

import com.asyncapi.schemas.AsyncAPISchema
import com.asyncapi.schemas.JsonSchema
import com.asyncapi.v3.schema.SchemaProvider

class ArraysSchemaTest: SchemaProvider {

    override fun jsonSchema(): JsonSchema {
        return JsonSchema.builder()
                .id("https://example.com/arrays.schema.json")
                .schema("http://json-schema.org/draft-07/schema#")
                .description("A representation of a person, company, organization, or place")
                .type("object")
                .properties(mapOf(
                        Pair("fruits", JsonSchema.builder()
                                .type("array")
                                .items(JsonSchema.builder().type("string").build())
                                .build()
                        ),
                        Pair("vegetables", JsonSchema.builder()
                                .type("array")
                                .items(JsonSchema.builder().ref("#/definitions/veggie").build())
                                .build()
                        )
                ))
                .definitions(mapOf(
                        Pair("veggie", JsonSchema.builder()
                                .type("object")
                                .required(listOf("veggieName", "veggieLike"))
                                .properties(mapOf(
                                        Pair("veggieName", JsonSchema.builder()
                                                .type("string")
                                                .description("The name of the vegetable.")
                                                .build()
                                        ),
                                        Pair("veggieLike", JsonSchema.builder()
                                                .type("boolean")
                                                .description("Do I like this vegetable?")
                                                .build()
                                        )
                                ))
                                .build()
                        )
                ))
                .build()
    }

    override fun asyncAPISchema(): AsyncAPISchema {
        return AsyncAPISchema.builder()
                .id("https://example.com/arrays.schema.json")
                .schema("http://json-schema.org/draft-07/schema#")
                .description("A representation of a person, company, organization, or place")
                .type("object")
                .properties(mapOf(
                        Pair("fruits", AsyncAPISchema.builder()
                                .type("array")
                                .items(AsyncAPISchema.builder().type("string").build())
                                .build()
                        ),
                        Pair("vegetables", AsyncAPISchema.builder()
                                .type("array")
                                .items(AsyncAPISchema.builder().ref("#/definitions/veggie").build())
                                .build()
                        )
                ))
                .definitions(mapOf(
                        Pair("veggie", AsyncAPISchema.builder()
                                .type("object")
                                .required(listOf("veggieName", "veggieLike"))
                                .properties(mapOf(
                                        Pair("veggieName", AsyncAPISchema.builder()
                                                .type("string")
                                                .description("The name of the vegetable.")
                                                .build()
                                        ),
                                        Pair("veggieLike", AsyncAPISchema.builder()
                                                .type("boolean")
                                                .description("Do I like this vegetable?")
                                                .build()
                                        )
                                ))
                                .build()
                        )
                ))
                .build()
    }

}