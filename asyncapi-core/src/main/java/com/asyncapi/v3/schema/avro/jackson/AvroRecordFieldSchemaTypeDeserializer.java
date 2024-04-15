package com.asyncapi.v3.schema.avro.jackson;

import com.asyncapi.v3.schema.avro.AvroSchema;
import com.asyncapi.v3.schema.avro.AvroSchemaType;
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

public class AvroRecordFieldSchemaTypeDeserializer extends JsonDeserializer<Object> {

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
                    return jsonParser.readValueAs(AvroSchema.class);
                case STRING:
                    return jsonParser.readValueAs(AvroSchemaType.class);
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
