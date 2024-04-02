package com.asyncapi.v3.schema.json.properties

import com.asyncapi.v3.schema.AsyncAPISchema
import com.asyncapi.v3.schema.JsonSchema
import com.asyncapi.v3.schema.SchemaProvider

class ConstDefaultExamplesObjectTest: SchemaProvider {

    private val jsonValue = JsonSchema.builder()
            .type("string")
            .constValue("abc")
            .build()

    private val asyncapiValue = AsyncAPISchema.builder()
            .type("string")
            .constValue("abc")
            .build()

    override fun jsonSchema(): JsonSchema {
        return JsonSchema.builder()
                .constValue(jsonValue)
                .defaultValue(jsonValue)
                .examples(listOf(jsonValue))
                .build()
    }

    override fun asyncAPISchema(): AsyncAPISchema {
        return AsyncAPISchema.builder()
                .constValue(asyncapiValue)
                .defaultValue(asyncapiValue)
                .examples(listOf(asyncapiValue))
                .build()
    }

}