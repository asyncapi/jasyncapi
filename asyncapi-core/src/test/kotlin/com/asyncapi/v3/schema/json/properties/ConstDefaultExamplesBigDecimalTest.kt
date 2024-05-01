package com.asyncapi.v3.schema.json.properties

import com.asyncapi.schemas.AsyncAPISchema
import com.asyncapi.schemas.JsonSchema
import com.asyncapi.v3.schema.SchemaProvider
import java.math.BigDecimal

class ConstDefaultExamplesBigDecimalTest: SchemaProvider {

    private val value = BigDecimal("1.123456789021474836471234567890214748364712345678902147483647")

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