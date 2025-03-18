package com.asyncapi.schemas.xml;

import com.asyncapi.schemas.asyncapi.Reference;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;

import java.io.IOException;
import java.util.Objects;

public class XMLSchemaDeserializer extends JsonDeserializer<Object> {

    @Override
    public Object deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        ObjectCodec objectCodec = p.getCodec();
        JsonNode node = objectCodec.readTree(p);

        return chooseKnownPojo(node, objectCodec);
    }

    private Object chooseKnownPojo(JsonNode jsonNode, final ObjectCodec objectCodec) throws IOException {
        try (JsonParser jsonParser = jsonNode.traverse(objectCodec)) {
            JsonNodeType nodeType = jsonNode.getNodeType();

            if (Objects.requireNonNull(nodeType) == JsonNodeType.STRING) {
                return jsonParser.readValueAs(String.class);
            }

            if(Objects.requireNonNull(nodeType) == JsonNodeType.OBJECT) {
                if (isRefNode(jsonNode)) {
                    return jsonParser.readValueAs(Reference.class);
                }
                return null;
            }

            return null;
        }
    }

    private boolean isRefNode(JsonNode jsonNode) {
        return jsonNode.size() == 1 && jsonNode.has("$ref");
    }

}
