package com.asyncapi.schemas.json.properties

import com.asyncapi.schemas.asyncapi.AsyncAPISchema
import com.asyncapi.schemas.json.JsonSchema
import com.asyncapi.schemas.SchemaProvider
import java.math.BigDecimal

class ConstDefaultExamplesBigDecimalMaximumTest: SchemaProvider {

    private val value = BigDecimal("2.214748364721474836472147483647214748364721474836472147483647214748364721474836472147483647")

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