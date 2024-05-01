package com.asyncapi.v3.schema.json.properties

import com.asyncapi.v3.schema.AsyncAPISchema
import com.asyncapi.schemas.JsonSchema
import com.asyncapi.v3.schema.SchemaProvider

class ConstDefaultExamplesArrayTest: SchemaProvider {

    private val jsonValue = JsonSchema.builder()
            .type("string")
            .constValue("abc")
            .examples(listOf(
                    JsonSchema.builder().type("string").constValue("abc").build(),
                    42,
                    true,
                    "hello",
                    null,
                    listOf(1, 2, 3,
                            JsonSchema.builder()
                                    .type("string")
                                    .constValue("abc")
                                    .examples(listOf(
                                            JsonSchema.builder().type("string").constValue("abc").build(),
                                            42,
                                            true,
                                            "hello",
                                            null,
                                            listOf(1, 2, 3)
                                    ))
                                    .build()
                    )
            ))
            .build()

    private val asyncapiValue = AsyncAPISchema.builder()
            .type("string")
            .constValue("abc")
            .examples(listOf(
                    AsyncAPISchema.builder().type("string").constValue("abc").build(),
                    42,
                    true,
                    "hello",
                    null,
                    listOf(1, 2, 3,
                            AsyncAPISchema.builder()
                                    .type("string")
                                    .constValue("abc")
                                    .examples(listOf(
                                            AsyncAPISchema.builder().type("string").constValue("abc").build(),
                                            42,
                                            true,
                                            "hello",
                                            null,
                                            listOf(1, 2, 3)
                                    ))
                                    .build()
                    )
            ))
            .build()

    override fun jsonSchema(): JsonSchema {
        return JsonSchema.builder()
                .constValue(listOf(jsonValue))
                .defaultValue(listOf(jsonValue))
                .examples(listOf(
                        jsonValue,
                        42,
                        true,
                        "hello",
                        null,
                        listOf(1, 2, 3)
                ))
                .build()
    }

    override fun asyncAPISchema(): AsyncAPISchema {
        return AsyncAPISchema.builder()
                .constValue(listOf(asyncapiValue))
                .defaultValue(listOf(asyncapiValue))
                .examples(listOf(
                        asyncapiValue,
                        42,
                        true,
                        "hello",
                        null,
                        listOf(1, 2, 3)
                ))
                .build()
    }

}