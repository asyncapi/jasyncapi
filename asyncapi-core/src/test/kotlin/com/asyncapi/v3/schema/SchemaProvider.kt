package com.asyncapi.v3.schema

import com.asyncapi.v3.schema.multiformat.AsyncAPIFormatSchema
import com.asyncapi.v3.schema.multiformat.JsonFormatSchema
import com.asyncapi.v3.schema.multiformat.OpenAPIFormatSchema
import com.asyncapi.v3.schema.openapi.OpenAPISchema

interface SchemaProvider {

    fun jsonSchema(): JsonSchema = JsonSchema()

    fun jsonFormatSchemaJson(): JsonFormatSchema = JsonFormatSchema(jsonSchema())

    fun jsonFormatSchemaYaml(): JsonFormatSchema = JsonFormatSchema("application/schema+yaml;version=draft-07", jsonSchema())

    fun asyncAPISchema(): AsyncAPISchema = AsyncAPISchema()

    fun asyncAPIFormatSchemaJsonV2_0_0(): AsyncAPIFormatSchema = AsyncAPIFormatSchema("application/vnd.aai.asyncapi+json;version=2.0.0", asyncAPISchema())

    fun asyncAPIFormatSchemaYamlV2_0_0(): AsyncAPIFormatSchema = AsyncAPIFormatSchema("application/vnd.aai.asyncapi+yaml;version=2.0.0", asyncAPISchema())

    fun asyncAPIFormatSchemaJsonV2_1_0(): AsyncAPIFormatSchema = AsyncAPIFormatSchema("application/vnd.aai.asyncapi+json;version=2.1.0", asyncAPISchema())

    fun asyncAPIFormatSchemaYamlV2_1_0(): AsyncAPIFormatSchema = AsyncAPIFormatSchema("application/vnd.aai.asyncapi+yaml;version=2.1.0", asyncAPISchema())

    fun asyncAPIFormatSchemaJsonV2_2_0(): AsyncAPIFormatSchema = AsyncAPIFormatSchema("application/vnd.aai.asyncapi+json;version=2.2.0", asyncAPISchema())

    fun asyncAPIFormatSchemaYamlV2_2_0(): AsyncAPIFormatSchema = AsyncAPIFormatSchema("application/vnd.aai.asyncapi+yaml;version=2.2.0", asyncAPISchema())

    fun asyncAPIFormatSchemaJsonV2_3_0(): AsyncAPIFormatSchema = AsyncAPIFormatSchema("application/vnd.aai.asyncapi+json;version=2.3.0", asyncAPISchema())

    fun asyncAPIFormatSchemaYamlV2_3_0(): AsyncAPIFormatSchema = AsyncAPIFormatSchema("application/vnd.aai.asyncapi+yaml;version=2.3.0", asyncAPISchema())

    fun asyncAPIFormatSchemaJsonV2_4_0(): AsyncAPIFormatSchema = AsyncAPIFormatSchema("application/vnd.aai.asyncapi+json;version=2.4.0", asyncAPISchema())

    fun asyncAPIFormatSchemaYamlV2_4_0(): AsyncAPIFormatSchema = AsyncAPIFormatSchema("application/vnd.aai.asyncapi+yaml;version=2.4.0", asyncAPISchema())

    fun asyncAPIFormatSchemaJsonV2_5_0(): AsyncAPIFormatSchema = AsyncAPIFormatSchema("application/vnd.aai.asyncapi+json;version=2.5.0", asyncAPISchema())

    fun asyncAPIFormatSchemaYamlV2_5_0(): AsyncAPIFormatSchema = AsyncAPIFormatSchema("application/vnd.aai.asyncapi+yaml;version=2.5.0", asyncAPISchema())

    fun asyncAPIFormatSchemaJsonV2_6_0(): AsyncAPIFormatSchema = AsyncAPIFormatSchema("application/vnd.aai.asyncapi+json;version=2.6.0", asyncAPISchema())

    fun asyncAPIFormatSchemaYamlV2_6_0(): AsyncAPIFormatSchema = AsyncAPIFormatSchema("application/vnd.aai.asyncapi+yaml;version=2.6.0", asyncAPISchema())

    fun asyncAPIFormatSchemaJsonV3_0_0(): AsyncAPIFormatSchema = AsyncAPIFormatSchema(asyncAPISchema())

    fun asyncAPIFormatSchemaYamlV3_0_0(): AsyncAPIFormatSchema = AsyncAPIFormatSchema("application/vnd.aai.asyncapi+yaml;version=3.0.0", asyncAPISchema())

    fun asyncAPIFormatSchemaEmptySchemaFormat(): AsyncAPIFormatSchema = AsyncAPIFormatSchema("application/vnd.aai.asyncapi+json;version=3.0.0", asyncAPISchema())

    fun openAPISchema(): OpenAPISchema = OpenAPISchema()

    fun openAPIFormatSchemaJson(): OpenAPIFormatSchema = OpenAPIFormatSchema(openAPISchema())

    fun openAPIFormatSchemaYaml(): OpenAPIFormatSchema = OpenAPIFormatSchema("application/vnd.oai.openapi+yaml;version=3.0.0", openAPISchema())

}