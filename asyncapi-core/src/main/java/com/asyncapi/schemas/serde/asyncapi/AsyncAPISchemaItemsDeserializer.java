package com.asyncapi.schemas.serde.asyncapi;

import com.asyncapi.schemas.asyncapi.AsyncAPISchema;
import com.asyncapi.serde.SchemaItemsDeserializer;

/**
 * AsyncAPI Schema items deserializer
 */
public class AsyncAPISchemaItemsDeserializer extends SchemaItemsDeserializer<AsyncAPISchema> {

    public Class<AsyncAPISchema> schemaClass() {
        return AsyncAPISchema.class;
    }

}
