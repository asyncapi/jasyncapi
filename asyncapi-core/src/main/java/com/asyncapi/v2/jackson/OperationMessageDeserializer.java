package com.asyncapi.v2.jackson;

import com.asyncapi.v2.model.Reference;
import com.asyncapi.v2.model.channel.message.Message;
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
 * Serializes operation message list.
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

    private Object chooseKnownPojo(JsonNode messageValue) throws IOException {
        if (messageValue.get("$ref") != null) {
            return objectMapper.readValue(messageValue.toString(), Reference.class);
        } else if (messageValue.get("oneOf") != null) {
            return extractOneOf(messageValue);
        } else {
            return objectMapper.readValue(messageValue.toString(), Message.class);
        }
    }

    private List extractOneOf(JsonNode messageValue) throws IOException {
        List oneOf = new ArrayList();
        for (JsonNode array : messageValue) {
            if (array.isArray()) {
                for (JsonNode item : array) {
                    Object parsedChildOrNull = chooseKnownPojo(item);
                    if (parsedChildOrNull != null)
                        oneOf.add(parsedChildOrNull);
                }
            }
        }
        return oneOf;
    }

}
