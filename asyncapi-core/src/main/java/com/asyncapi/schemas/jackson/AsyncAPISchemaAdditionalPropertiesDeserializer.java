package com.asyncapi.schemas.jackson;

import com.asyncapi.schemas.AsyncAPISchema;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

/**
 * AsyncAPI Schema additional properties deserializer
 *
 * @author Guillaume LAMIRAND (guillaume.lamirand at graviteesource.com)
 * @author GraviteeSource Team
 */
public class AsyncAPISchemaAdditionalPropertiesDeserializer extends JsonDeserializer<Object> {

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
                return jsonParser.readValueAs(AsyncAPISchema.class);
            }
        }
    }
}
