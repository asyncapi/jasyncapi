package com.asyncapi.v2.jackson;

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
 * Deserializes AsyncAPI bindings map.
 */
public abstract class BindingsMapDeserializer extends JsonDeserializer<Map<String, Object>> {

    public abstract Object chooseKnownPojo(String bindingKey, JsonNode binding, ObjectCodec objectCodec) throws IOException;

    @Override
    public Map<String, Object> deserialize(
            JsonParser p,
            DeserializationContext ctxt
    ) throws IOException, JsonProcessingException {
        ObjectCodec objectCodec = p.getCodec();
        JsonNode node = objectCodec.readTree(p);

        Map<String, Object> bindings = new HashMap<>();

        node.fieldNames().forEachRemaining(
                fieldName -> {
                    try {
                        bindings.put(fieldName, chooseKnownPojo(fieldName, node.get(fieldName), objectCodec));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        );

        return bindings;
    }

}
