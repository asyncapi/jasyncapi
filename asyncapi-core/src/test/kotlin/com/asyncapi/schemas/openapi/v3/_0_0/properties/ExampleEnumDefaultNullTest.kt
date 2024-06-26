package com.asyncapi.schemas.openapi.v3._0_0.properties

import com.asyncapi.schemas.SchemaProvider
import com.asyncapi.schemas.openapi.v3._0_0.OpenAPISchema

class ExampleEnumDefaultNullTest: SchemaProvider {

    private val value = null

    override fun openAPISchema(): OpenAPISchema {
        return OpenAPISchema.builder()
            .example(value)
            .enumValue(value)
            .defaultValue(value)
            .build()
    }

}