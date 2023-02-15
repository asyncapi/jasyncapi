package com.asyncapi.v2._6_0.jackson.model.channel.message;

import com.asyncapi.v2._6_0.model.Reference;
import com.asyncapi.v2._6_0.model.channel.message.CorrelationId;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Serializes message correlation id.
 *
 * @author Pavel Bodiachevskii
 */
public class MessageCorrelationIdDeserializer extends JsonDeserializer<Object> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Object deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        ObjectCodec objectCodec = p.getCodec();
        JsonNode node = objectCodec.readTree(p);

        return chooseKnownPojo(node);
    }

    private Object chooseKnownPojo(JsonNode correlationId) throws IOException {
        if (correlationId.get("$ref") != null) {
            return objectMapper.readValue(correlationId.toString(), Reference.class);
        } else {
            return objectMapper.readValue(correlationId.toString(), CorrelationId.class);
        }
    }

}
