package com.asyncapi.v3.schema

interface SchemaProvider {

    fun jsonSchema(): JsonSchema

    fun asyncAPISchema(): AsyncAPISchema

}