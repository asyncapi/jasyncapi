package com.asyncapi.schemas.jackson.openapi;

import com.asyncapi.schemas.jackson.SchemaAnyValueDeserializer;
import com.asyncapi.schemas.openapi.v3._0_0.OpenAPISchema;

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
