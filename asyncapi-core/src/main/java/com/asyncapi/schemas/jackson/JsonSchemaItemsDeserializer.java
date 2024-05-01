package com.asyncapi.schemas.jackson;

import com.asyncapi.v3.jackson.SchemaItemsDeserializer;
import com.asyncapi.schemas.JsonSchema;

/**
 * Json Schema items deserializer
 */
public class JsonSchemaItemsDeserializer extends SchemaItemsDeserializer<JsonSchema> {

    public Class<JsonSchema> schemaClass() {
        return JsonSchema.class;
    }

}
