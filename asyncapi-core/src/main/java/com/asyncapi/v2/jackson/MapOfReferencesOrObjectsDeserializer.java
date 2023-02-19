package com.asyncapi.v2.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Deserializes AsyncAPI map of parameters
 * @param <ObjectType> object
 */
public abstract class MapOfReferencesOrObjectsDeserializer<ObjectType> extends JsonDeserializer<Map<String, Object>> {

    abstract public Class<ObjectType> objectTypeClass();

    abstract public Class<?> referenceClass();

    @Override
    public Map<String, Object> deserialize(JsonParser jsonParser,
                                           DeserializationContext deserializationContext
    ) throws IOException, JsonProcessingException {
        ObjectCodec objectCodec = jsonParser.getCodec();
        JsonNode map = objectCodec.readTree(jsonParser);

        Map<String, Object> parameters = new HashMap<>();

        map.fieldNames().forEachRemaining(
                fieldName -> {
                    try {
                        parameters.put(fieldName, chooseKnownPojo(map.get(fieldName), objectCodec));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        );

        return parameters;
    }

    private Object chooseKnownPojo(JsonNode parametersValue, ObjectCodec objectCodec) throws IOException {
        JsonNode ref = parametersValue.get("$ref");
        if (ref != null) {
            return ref.traverse(objectCodec).readValueAs(referenceClass());
        } else {
            return parametersValue.traverse(objectCodec).readValueAs(objectTypeClass());
        }
    }

}
