package com.asyncapi.v3._0_0.jackson.model.component;

import com.asyncapi.v3.Reference;
import com.asyncapi.v3.schema.multiformat.MultiFormatSchema;
import com.asyncapi.v3.schema.AsyncAPISchema;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ComponentsSchemasDeserializer extends JsonDeserializer<Object> {

    public Class<AsyncAPISchema> objectTypeClass() {
        return AsyncAPISchema.class;
    }

    public Class<?> referenceClass() {
        return Reference.class;
    }

    @Override
    public Map<String, Object> deserialize(JsonParser jsonParser,
                                           DeserializationContext deserializationContext
    ) throws IOException, JsonProcessingException {
        ObjectCodec objectCodec = jsonParser.getCodec();
        JsonNode map = objectCodec.readTree(jsonParser);

        Map<String, Object> parameters = new HashMap<>();

        map.fieldNames().forEachRemaining(
                fieldName -> {
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
                        parameters.put(fieldName, chooseKnownPojo(map.get(fieldName), objectCodec));
                    } catch (IOException ignore) {
                        try {
                            parameters.put(fieldName, readAsObject(map.get(fieldName), objectCodec));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );

        return parameters;
    }

    private Object chooseKnownPojo(JsonNode jsonNode, ObjectCodec objectCodec) throws IOException {
        JsonNode ref = jsonNode.get("$ref");
        try (JsonParser jsonParser = jsonNode.traverse(objectCodec)) {
            if (isMultiFormatSchema(jsonNode)) {
                return jsonParser.readValueAs(MultiFormatSchema.class);
            }

            if (ref != null) {
                return jsonParser.readValueAs(referenceClass());
            } else {
                return jsonParser.readValueAs(objectTypeClass());
            }
        }
    }

    private Object readAsObject(JsonNode jsonNode, ObjectCodec objectCodec) throws IOException {
        try (JsonParser jsonParser = jsonNode.traverse(objectCodec)) {
            return jsonParser.readValueAs(objectTypeClass());
        }
    }

    private boolean isMultiFormatSchema(@NotNull JsonNode jsonNode) {
        JsonNode schemaFormat = jsonNode.get("schemaFormat");
        JsonNode schema = jsonNode.get("schema");

        return (schemaFormat != null) && (schema != null);
    }

}
