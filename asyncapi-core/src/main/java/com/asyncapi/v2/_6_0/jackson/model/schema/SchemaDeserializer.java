package com.asyncapi.v2._6_0.jackson.model.schema;

import com.asyncapi.v2._6_0.model.Reference;
import com.asyncapi.v2._6_0.model.schema.Schema;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Serializes component servers map.
 *
 * @author Pavel Bodiachevskii
 */
public class SchemaDeserializer extends JsonDeserializer<Object> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Object deserialize(
            JsonParser p,
            DeserializationContext ctxt
    ) throws IOException, JsonProcessingException {
        ObjectCodec objectCodec = p.getCodec();
        JsonNode node = objectCodec.readTree(p);

        return chooseKnownPojo(node);
    }

    private Object chooseKnownPojo(JsonNode parametersValue) throws IOException {
        if (parametersValue.get("$ref") != null) {
            return objectMapper.readValue(parametersValue.toString(), Reference.class);
        } else {
            return objectMapper.readValue(parametersValue.toString(), Schema.class);
        }
    }

}
