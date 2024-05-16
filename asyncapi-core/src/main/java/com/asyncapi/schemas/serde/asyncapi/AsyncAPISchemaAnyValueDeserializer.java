package com.asyncapi.schemas.serde.asyncapi;

import com.asyncapi.schemas.asyncapi.AsyncAPISchema;
import com.asyncapi.schemas.serde.SchemaAnyValueDeserializer;

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
