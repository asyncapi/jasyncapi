package com.asyncapi.v3.schema.json

import com.asyncapi.v3.schema.JsonSchema
import com.asyncapi.v3.schema.ReadSchemaTest

class RegexPatternTest: ReadSchemaTest<JsonSchema>() {

    override fun schemaClass() = JsonSchema::class.java

    override fun schemaToReadPath() = "/json/v3/schema/json/regex-pattern.schema.json"

    override fun buildSchema(): JsonSchema {
        return JsonSchema.builder()
                .id("https://example.com/regex-pattern.schema.json")
                .schema("http://json-schema.org/draft-07/schema#")
                .title("Regular Expression Pattern")
                .type("object")
                .properties(mapOf(
                        Pair("code", JsonSchema.builder()
                                .type("string")
                                .pattern("^[A-Z]{3}-\\d{3}$")
                                .build()
                        )
                ))
                .build()
    }

}