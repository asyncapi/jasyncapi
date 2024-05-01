package com.asyncapi.v3.schema.json

import com.asyncapi.schemas.AsyncAPISchema
import com.asyncapi.schemas.JsonSchema
import com.asyncapi.v3.schema.SchemaProvider
import java.math.BigDecimal

class ComplexObjectTest: SchemaProvider {

    override fun jsonSchema(): JsonSchema {
        return JsonSchema.builder()
                .id("https://example.com/complex-object.schema.json")
                .schema("http://json-schema.org/draft-07/schema#")
                .title("Complex Object")
                .type("object")
                .properties(mapOf(
                        Pair("name", JsonSchema.builder()
                                .type("string")
                                .build()
                        ),
                        Pair("age", JsonSchema.builder()
                                .type("integer")
                                .minimum(BigDecimal.ZERO)
                                .build()
                        ),
                        Pair("address", JsonSchema.builder()
                                .type("object")
                                .properties(mapOf(
                                        Pair("street", JsonSchema.builder()
                                                .type("string")
                                                .build()
                                        ),
                                        Pair("city", JsonSchema.builder()
                                                .type("string")
                                                .build()
                                        ),
                                        Pair("state", JsonSchema.builder()
                                                .type("string")
                                                .build()
                                        ),
                                        Pair("postalCode", JsonSchema.builder()
                                                .type("string")
                                                .pattern("\\d{5}")
                                                .build()
                                        )
                                ))
                                .required(listOf("street", "city", "state", "postalCode"))
                                .build()
                        ),
                        Pair("hobbies", JsonSchema.builder()
                                .type("array")
                                .items(JsonSchema.builder().type("string").build())
                                .build()
                        ),
                ))
                .required(listOf("name", "age"))
                .build()
    }

    override fun asyncAPISchema(): AsyncAPISchema {
        return AsyncAPISchema.builder()
                .id("https://example.com/complex-object.schema.json")
                .schema("http://json-schema.org/draft-07/schema#")
                .title("Complex Object")
                .type("object")
                .properties(mapOf(
                        Pair("name", AsyncAPISchema.builder()
                                .type("string")
                                .build()
                        ),
                        Pair("age", AsyncAPISchema.builder()
                                .type("integer")
                                .minimum(BigDecimal.ZERO)
                                .build()
                        ),
                        Pair("address", AsyncAPISchema.builder()
                                .type("object")
                                .properties(mapOf(
                                        Pair("street", AsyncAPISchema.builder()
                                                .type("string")
                                                .build()
                                        ),
                                        Pair("city", AsyncAPISchema.builder()
                                                .type("string")
                                                .build()
                                        ),
                                        Pair("state", AsyncAPISchema.builder()
                                                .type("string")
                                                .build()
                                        ),
                                        Pair("postalCode", AsyncAPISchema.builder()
                                                .type("string")
                                                .pattern("\\d{5}")
                                                .build()
                                        )
                                ))
                                .required(listOf("street", "city", "state", "postalCode"))
                                .build()
                        ),
                        Pair("hobbies", AsyncAPISchema.builder()
                                .type("array")
                                .items(AsyncAPISchema.builder().type("string").build())
                                .build()
                        ),
                ))
                .required(listOf("name", "age"))
                .build()
    }

}