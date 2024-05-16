package com.asyncapi.schemas.serde.openapi;

import com.asyncapi.schemas.openapi.v3._0_0.OpenAPISchema;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

/**
 * OpenAPI Schema additional properties deserializer
 *
 * @author Pavel Bodiachevskii
 * @version 3.0.0
 */
public class OpenAPISchemaAdditionalPropertiesDeserializer extends JsonDeserializer<Object> {

    @Override
    public Object deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        ObjectCodec objectCodec = p.getCodec();
        JsonNode node = objectCodec.readTree(p);

        return chooseKnownPojo(node, objectCodec);
    }

    private Object chooseKnownPojo(JsonNode jsonNode, final ObjectCodec objectCodec) throws IOException {
        try (JsonParser jsonParser = jsonNode.traverse(objectCodec)) {
            if (jsonNode.isBoolean()) {
                return jsonNode.asBoolean();
            } else {
                return jsonParser.readValueAs(OpenAPISchema.class);
            }
        }
    }
}
