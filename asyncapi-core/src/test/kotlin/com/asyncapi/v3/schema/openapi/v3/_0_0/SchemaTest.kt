package com.asyncapi.v3.schema.openapi.v3._0_0

import com.asyncapi.schemas.openapi.v3._0_0.OpenAPISchema
import com.asyncapi.v3.schema.SchemaProvider
import com.asyncapi.schemas.openapi.v3._0_0.properties.Discriminator
import com.asyncapi.schemas.openapi.v3._0_0.properties.ExternalDocumentation
import com.asyncapi.schemas.openapi.v3._0_0.properties.XML
import java.math.BigDecimal

class SchemaTest: SchemaProvider {

    override fun openAPISchema(): OpenAPISchema {
        val schema = OpenAPISchema.builder()
            .name("schema name")
            .title("schema title")
            .multipleOf(BigDecimal(2.5))
            .maximum(BigDecimal(100))
            .exclusiveMaximum(true)
            .minimum(BigDecimal(0))
            .exclusiveMinimum(true)
            .maxLength(3)
            .minLength(20)
            .pattern("^\\d{3}-\\d{2}-\\d{4}$")
            .maxItems(10)
            .minItems(1)
            .uniqueItems(true)
            .maxProperties(10)
            .minProperties(2)
            .required(listOf("id", "username"))
            .type("object")
            .allOf(listOf(
                OpenAPISchema.builder().ref("#/components/schemas/Pet").build(),
                OpenAPISchema.builder()
                    .type("object")
                    .properties(mapOf(
                        Pair("hunts", OpenAPISchema.builder().type("boolean").build()),
                        Pair("age", OpenAPISchema.builder().type("integer").build())
                    ))
                    .build()
            ))
            .anyOf(listOf(
                OpenAPISchema.builder().ref("#/components/schemas/PetByAge").build(),
                OpenAPISchema.builder()
                    .name("Pet by age")
                    .type("object")
                    .properties(mapOf(
                        Pair("age", OpenAPISchema.builder().type("integer").build()),
                        Pair("nickname", OpenAPISchema.builder().type("string").build())
                    ))
                    .build(),
                OpenAPISchema.builder().ref("#/components/schemas/PetByType").build(),
                OpenAPISchema.builder()
                    .name("Pet by type")
                    .type("object")
                    .properties(mapOf(
                        Pair("pet_type", OpenAPISchema.builder()
                            .type("string")
                            .enumValue(listOf("Cat", "Dog"))
                            .build())
                        ,
                        Pair("hunts", OpenAPISchema.builder().type("boolean").build())
                    ))
                    .required(listOf("pet_type"))
                    .build()
            ))
            .oneOf(listOf(
                OpenAPISchema.builder().ref("#/components/schemas/PetByAge").build(),
                OpenAPISchema.builder()
                    .name("Pet by age")
                    .type("object")
                    .properties(mapOf(
                        Pair("age", OpenAPISchema.builder().type("integer").build()),
                        Pair("nickname", OpenAPISchema.builder().type("string").build())
                    ))
                    .build(),
                OpenAPISchema.builder().ref("#/components/schemas/PetByType").build(),
                OpenAPISchema.builder()
                    .name("Pet by type")
                    .type("object")
                    .properties(mapOf(
                        Pair("pet_type", OpenAPISchema.builder()
                            .type("string")
                            .enumValue(listOf("Cat", "Dog"))
                            .build())
                        ,
                        Pair("hunts", OpenAPISchema.builder().type("boolean").build())
                    ))
                    .required(listOf("pet_type"))
                    .build()
            ))
            .not(
                OpenAPISchema.builder()
                .name("Pet by type")
                .type("object")
                .properties(mapOf(
                    Pair("pet_type", OpenAPISchema.builder()
                        .type("string")
                        .enumValue(listOf("Cat", "Dog"))
                        .build())
                    ,
                    Pair("hunts", OpenAPISchema.builder().type("boolean").build())
                ))
                .required(listOf("pet_type"))
                .build()
            )
            .properties(mapOf(
                Pair("pet_type", OpenAPISchema.builder()
                    .type("string")
                    .enumValue(listOf("Cat", "Dog", "Owl"))
                    .build()
                ),
                Pair("hunts", OpenAPISchema.builder()
                    .type("boolean")
                    .build()
                )
            ))
            .additionalProperties(
                OpenAPISchema.builder()
                .properties(mapOf(
                    Pair("pet_type", OpenAPISchema.builder()
                        .type("string")
                        .enumValue(listOf("Cat", "Dog", "Owl"))
                        .additionalProperties(false)
                        .build()
                    )
                ))
                .additionalProperties(
                    OpenAPISchema.builder()
                    .properties(mapOf(
                        Pair("hunts", OpenAPISchema.builder()
                            .type("boolean")
                            .build()
                        )
                    ))
                    .build()
                )
                .build()
            )
            .description("schema description")
            .format("uri")
            .ref("#/components/example/ref")
            .nullable(true)
            .readOnly(true)
            .writeOnly(true)
            .example(
                OpenAPISchema.builder()
                .type("string")
                .enumValue(listOf("approved", "pending", "closed", "new"))
                .example("approved")
                .build()
            )
            .externalDocs(ExternalDocumentation(
                    "external docs description",
                    "https://example.docs/this"
            ))
            .deprecated(true)
            .xml(XML(
                "animal",
                "http://example.com/schema/sample",
                "sample",
                true,
                true
            ))
            .enumValue(listOf("asc", "desc", null))
            .defaultValue(listOf("asc", "desc", null))
            .discriminator(Discriminator(
                "pet_type",
                mapOf(
                    Pair("dog", "#/components/schemas/Dog"),
                    Pair("monster", "https://gigantic-server.com/schemas/Monster/schema.json"),
                )
            ))
            .build()
        schema.extensions = mapOf(Pair("x-extension-property", "value"))

        return schema
    }

}