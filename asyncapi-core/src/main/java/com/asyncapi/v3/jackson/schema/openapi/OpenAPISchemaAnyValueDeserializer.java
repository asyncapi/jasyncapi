package com.asyncapi.v3.jackson.schema.openapi;

import com.asyncapi.v3.jackson.schema.SchemaAnyValueDeserializer;
import com.asyncapi.v3.schema.openapi.OpenAPISchema;

/**
 * @author Pavel Bodiachevskii
 */
public class OpenAPISchemaAnyValueDeserializer extends SchemaAnyValueDeserializer<OpenAPISchema> {

    @Override
    public Class<OpenAPISchema> schemaClass() {
        return OpenAPISchema.class;
    }

}
