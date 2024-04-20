package com.asyncapi.v3.schema.openapi.v3._0_0.properties

import com.asyncapi.v3.schema.SchemaProvider
import com.asyncapi.v3.schema.openapi.v3._0_0.OpenAPISchema

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