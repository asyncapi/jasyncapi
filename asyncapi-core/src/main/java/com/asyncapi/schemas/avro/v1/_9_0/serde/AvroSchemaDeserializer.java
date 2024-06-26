package com.asyncapi.schemas.avro.v1._9_0.serde;

import com.asyncapi.schemas.asyncapi.Reference;
import com.asyncapi.schemas.avro.v1._9_0.AvroSchema;
import com.asyncapi.schemas.avro.v1._9_0.AvroSchemaUnion;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;

public class AvroSchemaDeserializer extends JsonDeserializer<Object> {

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
                    return readAsUnion((ArrayNode) jsonNode, objectCodec);
                case OBJECT:
                    return readAvroSchema((ObjectNode) jsonNode, objectCodec);
                case STRING:
                    return jsonParser.readValueAs(String.class);
                case BOOLEAN:
                case NUMBER:
                case BINARY:
                case POJO:
                case MISSING:
                case NULL:
                    return null;
            }

            return null;
        }
    }

    private AvroSchemaUnion readAsUnion(ArrayNode arrayNode, ObjectCodec objectCodec) throws IOException {
        AvroSchemaUnion avroSchemaUnion = new AvroSchemaUnion();
        for (JsonNode childNode : arrayNode) {
            avroSchemaUnion.add(chooseKnownPojo(childNode, objectCodec));
        }

        return avroSchemaUnion;
    }

    private Object readAvroSchema(ObjectNode objectNode, ObjectCodec objectCodec) throws IOException {
        try (JsonParser jsonParser = objectNode.traverse(objectCodec)) {
            if (objectNode.size() == 1 && objectNode.has("$ref")) {
                return jsonParser.readValueAs(Reference.class);
            }

            return jsonParser.readValueAs(AvroSchema.class);
        }
    }

}
