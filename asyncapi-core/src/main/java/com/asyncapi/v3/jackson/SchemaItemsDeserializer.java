package com.asyncapi.v3.jackson;

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

public abstract class SchemaItemsDeserializer<Schema> extends JsonDeserializer<Object> {

    abstract public Class<Schema> schemaClass();

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

    private List<Schema> readAsListOfSchemas(ArrayNode arrayNode, ObjectCodec objectCodec) throws IOException {
        List<Schema> schemaList = new ArrayList<>();
        for (JsonNode childNode : arrayNode) {
            schemaList.add(readAsSchema(childNode, objectCodec));
        }
        return schemaList;
    }

    private Schema readAsSchema(JsonNode jsonNode, ObjectCodec objectCodec) throws IOException {
        try (JsonParser parser = jsonNode.traverse(objectCodec)) {
            return parser.readValueAs(schemaClass());
        }
    }

    private Object readAsObject(JsonNode jsonNode, ObjectCodec objectCodec) throws IOException {
        try (JsonParser jsonParser = jsonNode.traverse(objectCodec)) {
            return jsonParser.readValueAs(Object.class);
        }
    }
}
