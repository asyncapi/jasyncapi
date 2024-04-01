package com.asyncapi.v3.schema.json

import com.asyncapi.v3.schema.JsonSchema
import com.asyncapi.v3.schema.ReadSchemaTest
import java.math.BigDecimal

class ComplexObjectTest: ReadSchemaTest<JsonSchema>() {

    override fun schemaClass() = JsonSchema::class.java

    override fun schemaToReadPath() = "/json/v3/schema/json/complex-object.schema.json"

    override fun buildSchema(): JsonSchema {
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

}