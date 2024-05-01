package com.asyncapi.v3.jackson.schema;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Abstract Schema any value deserializer
 *
 * @param <Schema> schema to deserialize
 * @author Pavel Bodiachevskii
 */
public abstract class SchemaAnyValueDeserializer<Schema> extends JsonDeserializer<Object> {

    abstract public Class<Schema> schemaClass();

    @Override
    final public Object deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        ObjectCodec objectCodec = p.getCodec();
        JsonNode node = objectCodec.readTree(p);

        return chooseKnownPojo(node, objectCodec);
    }

    private Object chooseKnownPojo(JsonNode jsonNode, final ObjectCodec objectCodec) throws IOException {
        try (JsonParser jsonParser = jsonNode.traverse(objectCodec)) {
            JsonNodeType nodeType = jsonNode.getNodeType();

            switch (nodeType) {
                case ARRAY:
                    return readAsList((ArrayNode) jsonNode, objectCodec);
                case BOOLEAN:
                    return jsonNode.asBoolean();
                case NUMBER:
                    return jsonParser.readValueAs(Number.class);
                case OBJECT:
                    return jsonParser.readValueAs(schemaClass());
                case STRING:
                    return jsonParser.readValueAs(String.class);
                case BINARY:
                case POJO:
                case MISSING:
                case NULL:
                    return null;
            }

            return null;
        }
    }

    private List<Object> readAsList(ArrayNode arrayNode, ObjectCodec objectCodec) throws IOException {
        List<Object> list = new ArrayList<>();
        for (JsonNode childNode : arrayNode) {
            list.add(chooseKnownPojo(childNode, objectCodec));
        }

        return list;
    }

}
