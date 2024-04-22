package com.asyncapi.v2._6_0.jackson.model.channel.operation;

import com.asyncapi.Reference;
import com.asyncapi.v2._6_0.model.channel.message.Message;
import com.asyncapi.v2._6_0.model.channel.message.OneOfMessages;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

/**
 * Serializes operation traits list.
 *
 * @author Pavel Bodiachevskii
 */
public class OperationMessageDeserializer extends JsonDeserializer<Object> {

    @Override
    public Object deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        ObjectCodec objectCodec = p.getCodec();
        JsonNode node = objectCodec.readTree(p);

        return chooseKnownPojo(node, objectCodec);
    }

    private Object chooseKnownPojo(JsonNode message, ObjectCodec objectCodec) throws IOException {
        try (JsonParser jsonParser = message.traverse(objectCodec)) {
            if (message.get("oneOf") != null) {
                return jsonParser.readValueAs(OneOfMessages.class);
            } else if (message.get("$ref") != null) {
                return jsonParser.readValueAs(Reference.class);
            } else {
                return jsonParser.readValueAs(Message.class);
            }
        }
    }
}
