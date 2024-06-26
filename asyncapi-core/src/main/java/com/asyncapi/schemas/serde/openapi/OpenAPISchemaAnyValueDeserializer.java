package com.asyncapi.schemas.serde.openapi;

import com.asyncapi.schemas.openapi.v3._0_0.OpenAPISchema;
import com.asyncapi.schemas.serde.SchemaAnyValueDeserializer;

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
