package com.asyncapi.schemas.openapi.v3._0_0.properties

import com.asyncapi.schemas.SchemaProvider
import com.asyncapi.schemas.openapi.v3._0_0.OpenAPISchema

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