package com.asyncapi.v3._0_0.jackson.model.channel.message;

import com.asyncapi.schemas.Reference;
import com.asyncapi.schemas.multiformat.MultiFormatSchema;
import com.asyncapi.schemas.AsyncAPISchema;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

/**
 * Serializes message traits list.
 *
 * @author Pavel Bodiachevskii
 */
public class MessagePayloadDeserializer extends JsonDeserializer<Object> {

    @Override
    public Object deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        ObjectCodec objectCodec = p.getCodec();
        JsonNode node = objectCodec.readTree(p);

        /*
            Problem:
              Both, Reference class and Schema class have $ref field.
              So, this is only reason why I receive next exception:
              "com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException:
                Unrecognized field "title" (class com.asyncapi.v2._6_0.model.Reference),
                not marked as ignorable (one known property: "$ref"])"
              in case when Schema contains $ref.
            Solution:
             Try to deserialize reference. In case of exception, try to deserialize it as given ObjectType. In case of
             one more exception, throw it.
            TODO: Think how to improve.
         */
        try {
            return chooseKnownPojo(node, objectCodec);
        } catch (UnrecognizedPropertyException unrecognizedPropertyException) {
            return readAsObject(node, objectCodec);
        }
    }

    private Object chooseKnownPojo(JsonNode jsonNode, ObjectCodec objectCodec) throws IOException {
        JsonNode ref = jsonNode.get("$ref");
        try (JsonParser jsonParser = jsonNode.traverse(objectCodec)) {
            if (isMultiFormatSchema(jsonNode)) {
                return jsonParser.readValueAs(MultiFormatSchema.class);
            }

            if (ref != null) {
                return jsonParser.readValueAs(Reference.class);
            } else {
                return jsonParser.readValueAs(AsyncAPISchema.class);
            }
        }
    }

    private Object readAsObject(JsonNode jsonNode, ObjectCodec objectCodec) throws IOException {
        try (JsonParser jsonParser = jsonNode.traverse(objectCodec)) {
            return jsonParser.readValueAs(AsyncAPISchema.class);
        }
    }

    private boolean isMultiFormatSchema(@NotNull JsonNode jsonNode) {
        JsonNode schemaFormat = jsonNode.get("schemaFormat");
        JsonNode schema = jsonNode.get("schema");

        return (schemaFormat != null) && (schema != null);
    }

}
