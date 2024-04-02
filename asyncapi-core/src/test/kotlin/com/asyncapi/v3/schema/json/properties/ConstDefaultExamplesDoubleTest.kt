package com.asyncapi.v3.schema.json.properties

import com.asyncapi.v3.schema.AsyncAPISchema
import com.asyncapi.v3.schema.JsonSchema
import com.asyncapi.v3.schema.SchemaProvider

class ConstDefaultExamplesDoubleTest: SchemaProvider {

    private val value: Double = 123.456

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