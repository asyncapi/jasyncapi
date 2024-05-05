package com.asyncapi.schemas.jackson;

import com.asyncapi.schemas.AsyncAPISchema;

/**
 * AsyncAPI Schema any value deserializer
 *
 * @author Pavel Bodiachevskii
 */
public class AsyncAPISchemaAnyValueDeserializer extends SchemaAnyValueDeserializer<AsyncAPISchema> {

    @Override
    public Class<AsyncAPISchema> schemaClass() {
        return AsyncAPISchema.class;
    }

}