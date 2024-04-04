package com.asyncapi.v3.schema

import com.asyncapi.v3.schema.openapi.OpenAPISchema

interface SchemaProvider {

    fun jsonSchema(): JsonSchema = JsonSchema()

    fun asyncAPISchema(): AsyncAPISchema = AsyncAPISchema()

    fun openAPISchema(): OpenAPISchema = OpenAPISchema()

}