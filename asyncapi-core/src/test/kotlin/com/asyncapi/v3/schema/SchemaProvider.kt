package com.asyncapi.v3.schema

import com.asyncapi.schemas.AsyncAPISchema
import com.asyncapi.schemas.JsonSchema
import com.asyncapi.schemas.multiformat.AsyncAPIFormatSchema
import com.asyncapi.schemas.multiformat.JsonFormatSchema
import com.asyncapi.schemas.openapi.v3._0_0.OpenAPISchema

interface SchemaProvider {

    fun jsonSchema(): JsonSchema =
        JsonSchema()

    fun jsonFormatSchemaJson(): JsonFormatSchema =
        JsonFormatSchema(jsonSchema())

    fun jsonFormatSchemaYaml(): JsonFormatSchema =
        JsonFormatSchema(
            "application/schema+yaml;version=draft-07",
            jsonSchema()
        )

    fun asyncAPISchema(): AsyncAPISchema =
        AsyncAPISchema()

    fun asyncAPIFormatSchemaEmptySchemaFormat(): AsyncAPIFormatSchema =
        AsyncAPIFormatSchema(
            "application/vnd.aai.asyncapi+json;version=3.0.0",
            asyncAPISchema()
        )

    fun openAPISchema(): OpenAPISchema =
        OpenAPISchema()

}