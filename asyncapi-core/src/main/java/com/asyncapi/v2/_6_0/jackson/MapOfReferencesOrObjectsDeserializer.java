package com.asyncapi.v2._6_0.jackson;

import com.asyncapi.v2._6_0.model.Reference;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Deserializes AsyncAPI map of parameters
 * @param <ObjectType> object
 */
public abstract class MapOfReferencesOrObjectsDeserializer<ObjectType> extends JsonDeserializer<Map<String, Object>> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    abstract public Class<ObjectType> objectTypeClass();

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
                        parameters.put(fieldName, chooseKnownPojo(map.get(fieldName)));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        );

        return parameters;
    }

    private Object chooseKnownPojo(JsonNode parametersValue) throws IOException {
        if (parametersValue.get("$ref") != null) {
            return objectMapper.readValue(parametersValue.toString(), Reference.class);
        } else {
            return objectMapper.readValue(parametersValue.toString(), objectTypeClass());
        }
    }

}
