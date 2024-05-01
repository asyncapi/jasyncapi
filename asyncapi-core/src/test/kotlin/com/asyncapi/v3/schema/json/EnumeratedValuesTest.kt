package com.asyncapi.v3.schema.json

import com.asyncapi.schemas.AsyncAPISchema
import com.asyncapi.schemas.JsonSchema
import com.asyncapi.v3.schema.SchemaProvider

class EnumeratedValuesTest: SchemaProvider {

    override fun jsonSchema(): JsonSchema {
        return JsonSchema.builder()
                .id("https://example.com/enumerated-values.schema.json")
                .schema("http://json-schema.org/draft-07/schema#")
                .title("Enumerated Values")
                .type("object")
                .properties(mapOf(
                        Pair("data", JsonSchema.builder()
                                .enumValue(listOf(
                                        42, true, "hello", null, listOf(1, 2, 3)
                                ))
                                .build()
                        )
                ))
                .build()
    }

    override fun asyncAPISchema(): AsyncAPISchema {
        return AsyncAPISchema.builder()
                .id("https://example.com/enumerated-values.schema.json")
                .schema("http://json-schema.org/draft-07/schema#")
                .title("Enumerated Values")
                .type("object")
                .properties(mapOf(
                        Pair("data", AsyncAPISchema.builder()
                                .enumValue(listOf(
                                        42, true, "hello", null, listOf(1, 2, 3)
                                ))
                                .build()
                        )
                ))
                .build()
    }

}