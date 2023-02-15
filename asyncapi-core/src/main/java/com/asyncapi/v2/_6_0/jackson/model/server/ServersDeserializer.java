package com.asyncapi.v2._6_0.jackson.model.server;

import com.asyncapi.v2._6_0.model.Reference;
import com.asyncapi.v2._6_0.model.server.Server;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Serializes component servers map.
 *
 * @author Pavel Bodiachevskii
 */
public class ServersDeserializer extends JsonDeserializer<Map<String, Object>> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Map<String, Object> deserialize(
            JsonParser p,
            DeserializationContext ctxt
    ) throws IOException, JsonProcessingException {
        ObjectCodec objectCodec = p.getCodec();
        JsonNode node = objectCodec.readTree(p);

        Map<String, Object> parameters = new HashMap<>();

        node.fieldNames().forEachRemaining(
                fieldName -> {
                    try {
                        parameters.put(fieldName, chooseKnownPojo(node.get(fieldName)));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        );

        return parameters;
    }

    private Object chooseKnownPojo(JsonNode parametersValue) throws IOException {
        if (parametersValue.get("$ref") != null) {
            return objectMapper.readValue(parametersValue.toString(), Reference.class);
        } else {
            return objectMapper.readValue(parametersValue.toString(), Server.class);
        }
    }

}
