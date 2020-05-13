package com.asyncapi.v2.jackson;

import com.asyncapi.v2.model.Reference;
import com.asyncapi.v2.model.channel.message.CorrelationId;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Serializes message traits list.
 *
 * @author Pavel Bodiachevskii
 */
public class MessageTraitCorrelationIdDeserializer extends JsonDeserializer<Object> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Object deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        ObjectCodec objectCodec = p.getCodec();
        JsonNode node = objectCodec.readTree(p);

        return chooseKnownPojo(node);
    }

    private Object chooseKnownPojo(JsonNode traitsValue) throws IOException {
        if (traitsValue.get("$ref") != null) {
            return objectMapper.readValue(traitsValue.toString(), Reference.class);
        } else {
            return objectMapper.readValue(traitsValue.toString(), CorrelationId.class);
        }
    }

}
