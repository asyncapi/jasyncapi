package com.asyncapi.schemas.serde.json;

import com.asyncapi.schemas.json.JsonSchema;
import com.asyncapi.schemas.serde.SchemaAnyValueDeserializer;

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
