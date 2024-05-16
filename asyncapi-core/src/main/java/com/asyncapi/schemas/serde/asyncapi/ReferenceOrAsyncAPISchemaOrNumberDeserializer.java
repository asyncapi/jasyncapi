package com.asyncapi.schemas.serde.asyncapi;

import com.asyncapi.schemas.asyncapi.AsyncAPISchema;
import com.asyncapi.schemas.asyncapi.Reference;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;

public class ReferenceOrAsyncAPISchemaOrNumberDeserializer extends JsonDeserializer<Object> {

    @Override
    public Object deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
        ObjectCodec objectCodec = p.getCodec();
        JsonNode node = objectCodec.readTree(p);

        JsonNode jsonNode = node.get("$ref");
        Object parsedNode;
        try (JsonParser jsonParser = node.traverse(objectCodec)) {
            if (node.isNumber()) {
                parsedNode = jsonParser.readValueAs(Number.class);
            } else if (isReference(jsonNode)) {
                parsedNode = jsonParser.readValueAs(Reference.class);
            } else {
                parsedNode = jsonParser.readValueAs(AsyncAPISchema.class);
            }
        }

        return parsedNode;
    }

    private boolean isReference(@Nullable JsonNode jsonNode) {
        return jsonNode != null && jsonNode.properties().size() == 1 && jsonNode.get("$ref") != null;
    }

}
