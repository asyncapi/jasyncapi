package com.asyncapi.v2.jackson;

import com.asyncapi.v2.model.Reference;
import com.asyncapi.v2.model.channel.Parameter;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Serializes channel parameters map.
 *
 * @author Pavel Bodiachevskii
 */
public class ChannelParametersDeserializer extends JsonDeserializer<Map<String, Object>> {

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
                        parameters.put(fieldName, chooseKnownPojo(node.get(fieldName), objectCodec));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        );

        return parameters;
    }

    private Object chooseKnownPojo(JsonNode parametersValue, final ObjectCodec objectCodec) throws IOException {
        JsonNode ref = parametersValue.get("$ref");
        if (ref != null) {
            return ref.traverse(objectCodec).readValueAs(Reference.class);
        } else {
            return parametersValue.traverse(objectCodec).readValueAs(Parameter.class);
        }
    }
}
