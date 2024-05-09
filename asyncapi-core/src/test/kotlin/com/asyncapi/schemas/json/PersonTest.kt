package com.asyncapi.schemas.json

import com.asyncapi.schemas.asyncapi.AsyncAPISchema
import com.asyncapi.schemas.SchemaProvider
import java.math.BigDecimal

class PersonTest: SchemaProvider {

    override fun jsonSchema(): JsonSchema {
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

    override fun asyncAPISchema(): AsyncAPISchema {
        return AsyncAPISchema.builder()
                .id("https://example.com/person.schema.json")
                .schema("http://json-schema.org/draft-07/schema#")
                .title("Person")
                .type("object")
                .properties(mapOf(
                        Pair("firstName", AsyncAPISchema.builder()
                                .type("string")
                                .description("The person's first name.")
                                .build()
                        ),
                        Pair("lastName", AsyncAPISchema.builder()
                                .type("string")
                                .description("The person's last name.")
                                .build()
                        ),
                        Pair("age", AsyncAPISchema.builder()
                                .type("integer")
                                .description("Age in years which must be equal to or greater than zero.")
                                .minimum(BigDecimal.ZERO)
                                .build()
                        )
                ))
                .build()
    }

}