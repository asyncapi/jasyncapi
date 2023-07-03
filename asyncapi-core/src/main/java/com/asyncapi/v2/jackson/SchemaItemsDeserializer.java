package com.asyncapi.v2.jackson;

import com.asyncapi.v2.schema.Schema;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;

import java.io.IOException;

public class SchemaItemsDeserializer extends JsonDeserializer<Object> {

    @Override
    public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        ObjectCodec objectCodec = jsonParser.getCodec();
        JsonNode node = objectCodec.readTree(jsonParser);
        JsonNodeType nodeType = node.getNodeType();
        if (nodeType == JsonNodeType.OBJECT) {
            return readAsSchema(node, objectCodec);
        }
        // TODO: Implement handling of scenario when items is an array of schemas. Maybe return a List<Schema>?
        return readAsObject(node, objectCodec);
    }

    private Object readAsSchema(JsonNode jsonNode, ObjectCodec objectCodec) throws IOException {
        try (JsonParser parser = jsonNode.traverse(objectCodec)) {
            return parser.readValueAs(Schema.class);
        }
    }

    private Object readAsObject(JsonNode jsonNode, ObjectCodec objectCodec) throws IOException {
        try (JsonParser jsonParser = jsonNode.traverse(objectCodec)) {
            return jsonParser.readValueAs(Object.class);
        }
    }
}
