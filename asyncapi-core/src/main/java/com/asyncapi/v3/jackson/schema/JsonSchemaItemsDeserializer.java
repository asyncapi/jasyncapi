package com.asyncapi.v3.jackson.schema;

import com.asyncapi.v3.jackson.SchemaItemsDeserializer;
import com.asyncapi.v3.schema.JsonSchema;

/**
 * Json Schema items deserializer
 */
public class JsonSchemaItemsDeserializer extends SchemaItemsDeserializer<JsonSchema> {

    public Class<JsonSchema> schemaClass() {
        return JsonSchema.class;
    }

}
