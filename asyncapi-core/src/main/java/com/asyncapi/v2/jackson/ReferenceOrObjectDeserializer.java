package com.asyncapi.v2.jackson;

import com.asyncapi.v2._6_0.model.Reference;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

public abstract class ReferenceOrObjectDeserializer<ObjectType> extends JsonDeserializer<Object> {

    abstract public Class<ObjectType> objectTypeClass();

    @Override
    public Object deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        ObjectCodec objectCodec = p.getCodec();
        JsonNode node = objectCodec.readTree(p);

        return chooseKnownPojo(node, objectCodec);
    }

    private Object chooseKnownPojo(JsonNode jsonNode, ObjectCodec objectCodec) throws IOException {
        JsonNode ref = jsonNode.get("$ref");
        if (ref != null) {
            return ref.traverse(objectCodec).readValueAs(Reference.class);
        } else {
            return jsonNode.traverse(objectCodec).readValueAs(objectTypeClass());
        }
    }

}
