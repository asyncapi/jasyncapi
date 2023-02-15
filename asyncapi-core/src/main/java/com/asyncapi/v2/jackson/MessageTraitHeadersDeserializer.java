package com.asyncapi.v2.jackson;

import com.asyncapi.v2.model.Reference;
import com.asyncapi.v2.model.schema.Schema;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

/**
 * Serializes message traits list.
 *
 * @author Pavel Bodiachevskii
 */
public class MessageTraitHeadersDeserializer extends JsonDeserializer<Object> {

    @Override
    public Object deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        ObjectCodec objectCodec = p.getCodec();
        JsonNode node = objectCodec.readTree(p);

        return chooseKnownPojo(node, objectCodec);
    }

    private Object chooseKnownPojo(JsonNode traitsValue, final ObjectCodec objectCodec) throws IOException {
        JsonNode ref = traitsValue.get("$ref");
        if (ref != null) {
            return ref.traverse(objectCodec).readValueAs(Reference.class);
        } else {
            return traitsValue.traverse(objectCodec).readValueAs(Schema.class);
        }
    }
}
