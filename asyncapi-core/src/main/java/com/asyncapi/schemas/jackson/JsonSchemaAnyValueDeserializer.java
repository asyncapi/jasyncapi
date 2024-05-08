package com.asyncapi.schemas.jackson;

import com.asyncapi.schemas.json.JsonSchema;

/**
 * Json Schema any value deserializer
 *
 * @author Pavel Bodiachevskii
 */
public class JsonSchemaAnyValueDeserializer extends SchemaAnyValueDeserializer<JsonSchema> {

    @Override
    public Class<JsonSchema> schemaClass() {
        return JsonSchema.class;
    }

}
