package com.asyncapi.v2.jackson;

import com.asyncapi.v2._6_0.model.Reference;
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

public abstract class ListOfReferencesOrObjectsDeserializer<ObjectType> extends JsonDeserializer<List<Object>> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    abstract public Class<ObjectType> objectTypeClass();

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

    private Object chooseKnownPojo(JsonNode messagesValue) throws IOException {
        if (messagesValue.get("$ref") != null) {
            return objectMapper.readValue(messagesValue.toString(), Reference.class);
        } else {
            return objectMapper.readValue(messagesValue.toString(), objectTypeClass());
        }
    }

}
