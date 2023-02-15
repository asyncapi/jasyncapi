package com.asyncapi.v2._6_0.jackson.model.channel.message;

import com.asyncapi.v2._6_0.model.Reference;
import com.asyncapi.v2._6_0.model.channel.message.MessageTrait;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Serializes message traits list.
 *
 * @author Pavel Bodiachevskii
 */
public class MessageTraitsDeserializer extends JsonDeserializer<List<Object>> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public List<Object> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        ObjectCodec objectCodec = p.getCodec();
        JsonNode node = objectCodec.readTree(p);

        List<Object> traits = new ArrayList<>();

        node.forEach(
                traitsValue -> {
                    try {
                        traits.add(chooseKnownPojo(traitsValue));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        );

        return traits;
    }

    private Object chooseKnownPojo(JsonNode traitsValue) throws IOException {
        if (traitsValue.get("$ref") != null) {
            return objectMapper.readValue(traitsValue.toString(), Reference.class);
        } else {
            return objectMapper.readValue(traitsValue.toString(), MessageTrait.class);
        }
    }

}
