package com.asyncapi.schemas.jackson;

import com.asyncapi.v3.jackson.SchemaItemsDeserializer;
import com.asyncapi.schemas.AsyncAPISchema;

/**
 * AsyncAPI Schema items deserializer
 */
public class AsyncAPISchemaItemsDeserializer extends SchemaItemsDeserializer<AsyncAPISchema> {

    public Class<AsyncAPISchema> schemaClass() {
        return AsyncAPISchema.class;
    }

}
