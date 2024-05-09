package com.asyncapi.v2.jackson;

import com.asyncapi.schemas.asyncapi.AsyncAPISchema;
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

public class SchemaItemsDeserializer extends JsonDeserializer<Object> {

    @Override
    public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        ObjectCodec objectCodec = jsonParser.getCodec();
        JsonNode node = objectCodec.readTree(jsonParser);
        JsonNodeType nodeType = node.getNodeType();
        if (nodeType == JsonNodeType.OBJECT) {
            return readAsSchema(node, objectCodec);
        }
        if (nodeType == JsonNodeType.ARRAY) {
            return readAsListOfSchemas((ArrayNode) node, objectCodec);
        }
        return readAsObject(node, objectCodec);
    }

    private List<AsyncAPISchema> readAsListOfSchemas(ArrayNode arrayNode, ObjectCodec objectCodec) throws IOException {
        List<AsyncAPISchema> schemaList = new ArrayList<>();
        for (JsonNode childNode : arrayNode) {
            schemaList.add(readAsSchema(childNode, objectCodec));
        }
        return schemaList;
    }

    private AsyncAPISchema readAsSchema(JsonNode jsonNode, ObjectCodec objectCodec) throws IOException {
        try (JsonParser parser = jsonNode.traverse(objectCodec)) {
            return parser.readValueAs(AsyncAPISchema.class);
        }
    }

    private Object readAsObject(JsonNode jsonNode, ObjectCodec objectCodec) throws IOException {
        try (JsonParser jsonParser = jsonNode.traverse(objectCodec)) {
            return jsonParser.readValueAs(Object.class);
        }
    }
}
