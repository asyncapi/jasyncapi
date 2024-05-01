package com.asyncapi.v3.jackson.schema.openapi;

import com.asyncapi.v3.jackson.schema.SchemaAnyValueDeserializer;
import com.asyncapi.v3.schema.openapi.v3._0_0.OpenAPISchema;

/**
 * OpenAPI Schema any value deserializer
 *
 * @author Pavel Bodiachevskii
 */
public class OpenAPISchemaAnyValueDeserializer extends SchemaAnyValueDeserializer<OpenAPISchema> {

    @Override
    public Class<OpenAPISchema> schemaClass() {
        return OpenAPISchema.class;
    }

}
