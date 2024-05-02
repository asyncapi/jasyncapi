package com.asyncapi.schemas.json.properties

import com.asyncapi.schemas.AsyncAPISchema
import com.asyncapi.schemas.JsonSchema
import com.asyncapi.v3.schema.SchemaProvider

class ConstDefaultExamplesIntMaximumTest: SchemaProvider {

    private val value: Int = 2147483647

    override fun jsonSchema(): JsonSchema {
        return JsonSchema.builder()
                .constValue(value)
                .defaultValue(value)
                .examples(listOf(value))
                .build()
    }

    override fun asyncAPISchema(): AsyncAPISchema {
        return AsyncAPISchema.builder()
                .constValue(value)
                .defaultValue(value)
                .examples(listOf(value))
                .build()
    }

}