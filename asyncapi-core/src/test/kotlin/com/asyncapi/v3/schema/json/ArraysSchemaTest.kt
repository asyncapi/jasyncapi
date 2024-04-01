package com.asyncapi.v3.schema.json

import com.asyncapi.v3.schema.JsonSchema
import com.asyncapi.v3.schema.ReadSchemaTest

class ArraysSchemaTest: ReadSchemaTest<JsonSchema>() {

    override fun schemaClass() = JsonSchema::class.java

    override fun schemaToReadPath() = "/json/v3/schema/json/arrays.schema.json"

    override fun buildSchema(): JsonSchema {
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

}