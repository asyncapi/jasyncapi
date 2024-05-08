package com.asyncapi.schemas.json

import com.asyncapi.schemas.AsyncAPISchema
import com.asyncapi.schemas.SchemaProvider

class RegexPatternTest: SchemaProvider {

    override fun jsonSchema(): JsonSchema {
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

    override fun asyncAPISchema(): AsyncAPISchema {
        return AsyncAPISchema.builder()
                .id("https://example.com/regex-pattern.schema.json")
                .schema("http://json-schema.org/draft-07/schema#")
                .title("Regular Expression Pattern")
                .type("object")
                .properties(mapOf(
                        Pair("code", AsyncAPISchema.builder()
                                .type("string")
                                .pattern("^[A-Z]{3}-\\d{3}$")
                                .build()
                        )
                ))
                .build()
    }

}