package com.asyncapi.v2._0_0.jackson;

import com.asyncapi.v2._0_0.model.Reference;
import com.asyncapi.v2._0_0.model.channel.message.Message;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Serializes operation message list.
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

    private Object chooseKnownPojo(JsonNode messageValue, final ObjectCodec objectCodec) throws IOException {
        JsonNode ref = messageValue.get("$ref");
        if (messageValue.get("$ref") != null) {
            return ref.traverse(objectCodec).readValueAs(Reference.class);
        } else if (messageValue.get("oneOf") != null) {
            return extractOneOf(messageValue, objectCodec);
        } else {
            return messageValue.traverse(objectCodec).readValueAs(Message.class);
        }
    }

    private List<Object> extractOneOf(JsonNode messageValue, final ObjectCodec objectCodec) throws IOException {
        List<Object> oneOf = new ArrayList<>();
        for (JsonNode array : messageValue) {
            if (array.isArray()) {
                for (JsonNode item : array) {
                    Object parsedChildOrNull = chooseKnownPojo(item, objectCodec);
                    if (parsedChildOrNull != null)
                        oneOf.add(parsedChildOrNull);
                }
            }
        }
        return oneOf;
    }
}
