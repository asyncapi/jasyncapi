package com.asyncapi.schemas.serde.asyncapi;

import com.asyncapi.v3.jackson.SchemaItemsDeserializer;
import com.asyncapi.schemas.asyncapi.AsyncAPISchema;

/**
 * AsyncAPI Schema items deserializer
 */
public class AsyncAPISchemaItemsDeserializer extends SchemaItemsDeserializer<AsyncAPISchema> {

    public Class<AsyncAPISchema> schemaClass() {
        return AsyncAPISchema.class;
    }

}
