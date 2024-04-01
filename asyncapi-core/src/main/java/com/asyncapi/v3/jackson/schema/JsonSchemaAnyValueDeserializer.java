package com.asyncapi.v3.jackson.schema;

import com.asyncapi.v3.schema.JsonSchema;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Pavel Bodiachevskii
 */
public class JsonSchemaAnyValueDeserializer extends JsonDeserializer<Object> {

    @Override
    public Object deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
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
                    return jsonParser.readValueAs(JsonSchema.class);
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

    private Number readNumber(JsonNode jsonNode, JsonParser jsonParser) throws IOException {
        if (jsonNode.isBigDecimal()) {
            return jsonParser.readValueAs(BigDecimal.class);
        }

        if (jsonNode.isBigInteger()) {
            return jsonParser.readValueAs(BigInteger.class);
        }

        return jsonParser.readValueAs(Number.class);
    }

}
