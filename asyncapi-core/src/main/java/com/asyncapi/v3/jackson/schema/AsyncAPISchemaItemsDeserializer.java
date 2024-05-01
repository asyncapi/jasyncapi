package com.asyncapi.v3.jackson.schema;

import com.asyncapi.v3.jackson.SchemaItemsDeserializer;
import com.asyncapi.v3.schema.AsyncAPISchema;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * AsyncAPI Schema items deserializer
 */
public class AsyncAPISchemaItemsDeserializer extends SchemaItemsDeserializer<AsyncAPISchema> {

    public Class<AsyncAPISchema> schemaClass() {
        return AsyncAPISchema.class;
    }

}
