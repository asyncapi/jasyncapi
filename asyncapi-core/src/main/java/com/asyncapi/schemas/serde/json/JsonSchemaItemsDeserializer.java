package com.asyncapi.schemas.serde.json;

import com.asyncapi.serde.SchemaItemsDeserializer;
import com.asyncapi.schemas.json.JsonSchema;

/**
 * Json Schema items deserializer
 */
public class JsonSchemaItemsDeserializer extends SchemaItemsDeserializer<JsonSchema> {

    public Class<JsonSchema> schemaClass() {
        return JsonSchema.class;
    }

}
