package com.asyncapi.v3.schema.json

import com.asyncapi.v3.schema.JsonSchema
import com.asyncapi.v3.schema.ReadSchemaTest
import java.math.BigDecimal

class PersonTest: ReadSchemaTest<JsonSchema>() {

    override fun schemaClass() = JsonSchema::class.java

    override fun schemaToReadPath() = "/json/v3/schema/json/person.schema.json"

    override fun buildSchema(): JsonSchema {
        return JsonSchema.builder()
                .id("https://example.com/person.schema.json")
                .schema("http://json-schema.org/draft-07/schema#")
                .title("Person")
                .type("object")
                .properties(mapOf(
                        Pair("firstName", JsonSchema.builder()
                                .type("string")
                                .description("The person's first name.")
                                .build()
                        ),
                        Pair("lastName", JsonSchema.builder()
                                .type("string")
                                .description("The person's last name.")
                                .build()
                        ),
                        Pair("age", JsonSchema.builder()
                                .type("integer")
                                .description("Age in years which must be equal to or greater than zero.")
                                .minimum(BigDecimal.ZERO)
                                .build()
                        )
                ))
                .build()
    }

}