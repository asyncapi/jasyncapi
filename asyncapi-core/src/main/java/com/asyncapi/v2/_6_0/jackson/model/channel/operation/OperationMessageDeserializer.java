package com.asyncapi.v2._6_0.jackson.model.channel.operation;

import com.asyncapi.v2._6_0.model.Reference;
import com.asyncapi.v2._6_0.model.channel.message.Message;
import com.asyncapi.v2._6_0.model.channel.message.OneOfMessages;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Serializes operation traits list.
 *
 * @author Pavel Bodiachevskii
 */
public class OperationMessageDeserializer extends JsonDeserializer<Object> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Object deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        ObjectCodec objectCodec = p.getCodec();
        JsonNode node = objectCodec.readTree(p);

        return chooseKnownPojo(node);
    }

    private Object chooseKnownPojo(JsonNode message) throws IOException {
        if (message.get("oneOf") != null) {
            return objectMapper.readValue(message.toString(), OneOfMessages.class);
        } else if (message.get("$ref") != null) {
            return objectMapper.readValue(message.toString(), Reference.class);
        } else {
            return objectMapper.readValue(message.toString(), Message.class);
        }
    }

}
