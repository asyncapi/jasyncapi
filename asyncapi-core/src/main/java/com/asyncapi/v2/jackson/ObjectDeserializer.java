package com.asyncapi.v2.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public abstract class ObjectDeserializer<ObjectType> extends JsonDeserializer<Object> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    abstract public Class<ObjectType> objectTypeClass();

    @Override
    public Object deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        ObjectCodec objectCodec = p.getCodec();
        JsonNode node = objectCodec.readTree(p);

        return chooseKnownPojo(node);
    }

    private Object chooseKnownPojo(JsonNode correlationId) throws IOException {
        return objectMapper.readValue(correlationId.toString(), objectTypeClass());
    }

}
