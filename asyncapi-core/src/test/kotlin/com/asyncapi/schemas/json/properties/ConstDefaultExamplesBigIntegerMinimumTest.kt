package com.asyncapi.schemas.json.properties

import com.asyncapi.schemas.AsyncAPISchema
import com.asyncapi.schemas.JsonSchema
import com.asyncapi.v3.schema.SchemaProvider
import java.math.BigInteger

class ConstDefaultExamplesBigIntegerMinimumTest: SchemaProvider {

    private val value = BigInteger("-214748364821474836482147483648")

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