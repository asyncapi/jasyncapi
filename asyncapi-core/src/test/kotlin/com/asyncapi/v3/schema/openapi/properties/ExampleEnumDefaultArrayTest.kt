package com.asyncapi.v3.schema.openapi.properties

import com.asyncapi.v3.schema.SchemaProvider
import com.asyncapi.v3.schema.openapi.OpenAPISchema

class ExampleEnumDefaultArrayTest: SchemaProvider {

    private val value = listOf(
        42,
        true,
        "hello",
        null,
        listOf(
            1,
            2,
            3,
            OpenAPISchema.builder()
                .type("string")
                .defaultValue("abc")
                .example(listOf(
                    OpenAPISchema.builder()
                        .type("string")
                        .defaultValue("abc")
                        .build(),
                    42,
                    true,
                    "hello",
                    null,
                    listOf(1, 2, 3)
                ))
                .build()
        )
    )

    override fun openAPISchema(): OpenAPISchema {
        return OpenAPISchema.builder()
            .example(value)
            .enumValue(value)
            .defaultValue(value)
            .build()
    }

}