package com.asyncapi.v2._6_0.jackson.model.channel.message;

import com.asyncapi.bindings.MessageBindingsDeserializer;
import com.asyncapi.schemas.asyncapi.AsyncAPISchema;
import com.asyncapi.schemas.asyncapi.ExtendableObject;
import com.asyncapi.schemas.json.JsonSchema;
import com.asyncapi.schemas.asyncapi.Reference;
import com.asyncapi.schemas.avro.v1._9_0.AvroSchema;
import com.asyncapi.schemas.openapi.v3._0_0.OpenAPISchema;
import com.asyncapi.v2._6_0.model.ExternalDocumentation;
import com.asyncapi.v2._6_0.model.Tag;
import com.asyncapi.v2._6_0.model.channel.message.Message;
import com.asyncapi.v2._6_0.model.channel.message.MessageExample;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Deserializes Message
 * <p>
 * TODO: Fix this
 */
public class MessageDeserializer extends JsonDeserializer<Message> {

    private static final List<String> propertiesToIgnore = Arrays.asList(
            "messageId",
            "headers",
            "payload",
            "correlationId",
            "schemaFormat",
            "contentType",
            "name",
            "title",
            "summary",
            "description",
            "tags",
            "externalDocs",
            "bindings",
            "tags",
            "examples",
            "traits"
    );

    private String string(JsonNode node, ObjectCodec objectCodec) throws IOException {
        if (node == null) {
            return null;
        }

        try (JsonParser jsonParser = node.traverse(objectCodec)) {
            return jsonParser.readValueAs(String.class);
        }
    }

    private Object headers(JsonNode node, ObjectCodec objectCodec, DeserializationContext deserializationContext) throws IOException {
        if (node == null) {
            return null;
        }

        try (JsonParser jsonParser = node.traverse(objectCodec)) {
            MessageHeadersDeserializer deserializer = new MessageHeadersDeserializer();

            return deserializer.deserialize(jsonParser, deserializationContext);
        }
    }

    private Object correlationId(JsonNode node, ObjectCodec objectCodec, DeserializationContext deserializationContext) throws IOException {
        if (node == null) {
            return null;
        }

        try (JsonParser jsonParser = node.traverse(objectCodec)) {
            MessageCorrelationIdDeserializer deserializer = new MessageCorrelationIdDeserializer();

            return deserializer.deserialize(jsonParser, deserializationContext);
        }
    }

    private List<Tag> tags(JsonNode node, ObjectCodec objectCodec) throws IOException {
        if (node == null) {
            return null;
        }

        try (JsonParser jsonParser = node.traverse(objectCodec)) {
            return jsonParser.readValueAs(new TypeReference<List<Tag>>() {});
        }
    }

    private ExternalDocumentation externalDocs(JsonNode node, ObjectCodec objectCodec) throws IOException {
        if (node == null) {
            return null;
        }

        try (JsonParser jsonParser = node.traverse(objectCodec)) {
            return jsonParser.readValueAs(ExternalDocumentation.class);
        }
    }

    private Map<String, Object> bindings(JsonNode node, ObjectCodec objectCodec, DeserializationContext deserializationContext) throws IOException {
        if (node == null) {
            return null;
        }

        try (JsonParser jsonParser = node.traverse(objectCodec)) {
            MessageBindingsDeserializer deserializer = new MessageBindingsDeserializer();

            return deserializer.deserialize(jsonParser, deserializationContext);
        }
    }

    private List<MessageExample> examples(JsonNode node, ObjectCodec objectCodec) throws IOException {
        if (node == null) {
            return null;
        }

        try (JsonParser jsonParser = node.traverse(objectCodec)) {
            return jsonParser.readValueAs(new TypeReference<List<MessageExample>>() {});
        }
    }

    private List<Object> traits(JsonNode node, ObjectCodec objectCodec, DeserializationContext deserializationContext) throws IOException {
        if (node == null) {
            return null;
        }

        try (JsonParser jsonParser = node.traverse(objectCodec)) {
            MessageTraitsDeserializer deserializer = new MessageTraitsDeserializer();

            return deserializer.deserialize(jsonParser, deserializationContext);
        }
    }

    private Object payload(JsonNode messageNode, ObjectCodec objectCodec) throws IOException {
        JsonNode payloadNode = messageNode.get("payload");
        if (payloadNode == null) {
            return null;
        }

        try (JsonParser jsonParser = payloadNode.traverse(objectCodec)) {
            if (payloadNode.properties().size() == 1 && payloadNode.get("$ref") != null) {
                return jsonParser.readValueAs(Reference.class);
            }

            JsonNode schemaFormatNode = messageNode.findValue("schemaFormat");
            if (schemaFormatNode == null) {
                return jsonParser.readValueAs(AsyncAPISchema.class);
            }

            Class<?> messageToDeserializeTo = AsyncAPISchema.class;
            switch (schemaFormatNode.textValue()) {
                case "application/schema+json;version=draft-07":
                case "application/schema+yaml;version=draft-07": {
                    messageToDeserializeTo = JsonSchema.class;
                    break;
                }
                case "application/vnd.oai.openapi;version=3.0.0":
                case "application/vnd.oai.openapi+json;version=3.0.0":
                case "application/vnd.oai.openapi+yaml;version=3.0.0":
                case "application/vnd.oai.openapi;version=3.0.1":
                case "application/vnd.oai.openapi+json;version=3.0.1":
                case "application/vnd.oai.openapi+yaml;version=3.0.1":
                case "application/vnd.oai.openapi;version=3.0.2":
                case "application/vnd.oai.openapi+json;version=3.0.2":
                case "application/vnd.oai.openapi+yaml;version=3.0.2":
                case "application/vnd.oai.openapi;version=3.0.3":
                case "application/vnd.oai.openapi+json;version=3.0.3":
                case "application/vnd.oai.openapi+yaml;version=3.0.3": {
                    messageToDeserializeTo = OpenAPISchema.class;
                    break;
                }
                case "application/vnd.apache.avro;version=1.9.0":
                case "application/vnd.apache.avro+json;version=1.9.0":
                case "application/vnd.apache.avro+yaml;version=1.9.0":
                case "application/vnd.apache.avro;version=1.9.1":
                case "application/vnd.apache.avro+json;version=1.9.1":
                case "application/vnd.apache.avro+yaml;version=1.9.1":
                case "application/vnd.apache.avro;version=1.9.2":
                case "application/vnd.apache.avro+json;version=1.9.2":
                case "application/vnd.apache.avro+yaml;version=1.9.2":
                case "application/vnd.apache.avro;version=1.10.0":
                case "application/vnd.apache.avro+json;version=1.10.0":
                case "application/vnd.apache.avro+yaml;version=1.10.0":
                case "application/vnd.apache.avro;version=1.10.1":
                case "application/vnd.apache.avro+json;version=1.10.1":
                case "application/vnd.apache.avro+yaml;version=1.10.1":
                case "application/vnd.apache.avro;version=1.10.2":
                case "application/vnd.apache.avro+json;version=1.10.2":
                case "application/vnd.apache.avro+yaml;version=1.10.2":
                case "application/vnd.apache.avro;version=1.11.0":
                case "application/vnd.apache.avro+json;version=1.11.0":
                case "application/vnd.apache.avro+yaml;version=1.11.0":
                case "application/vnd.apache.avro;version=1.11.1":
                case "application/vnd.apache.avro+json;version=1.11.1":
                case "application/vnd.apache.avro+yaml;version=1.11.1": {
                    messageToDeserializeTo = AvroSchema.class;
                    break;
                }
            }

            return jsonParser.readValueAs(messageToDeserializeTo);
        }
    }

    private Object chooseKnownPojo(JsonNode jsonNode, final ObjectCodec objectCodec) throws IOException {
        try (JsonParser jsonParser = jsonNode.traverse(objectCodec)) {
            JsonNodeType nodeType = jsonNode.getNodeType();

            switch (nodeType) {
                case ARRAY:
                    return readAsList((ArrayNode) jsonNode, objectCodec);
                case BOOLEAN:
                    return jsonNode.asBoolean();
                case NUMBER:
                    return jsonParser.readValueAs(Number.class);
                case OBJECT:
                    return jsonParser.readValueAs(Object.class);
                case STRING:
                    return jsonParser.readValueAs(String.class);
                case BINARY:
                case POJO:
                case MISSING:
                case NULL:
                    return null;
            }

            return null;
        }
    }

    private List<Object> readAsList(ArrayNode arrayNode, ObjectCodec objectCodec) throws IOException {
        List<Object> list = new ArrayList<>();
        for (JsonNode childNode : arrayNode) {
            list.add(chooseKnownPojo(childNode, objectCodec));
        }

        return list;
    }

    private Map<String, Object> extensionFields(JsonNode messageNode, ObjectCodec objectCodec) throws IOException {
        if (messageNode == null) {
            return null;
        }

        Map<String, Object> extensionFields = new HashMap<>();
        List<Map.Entry<String, JsonNode>> unknownProperties = messageNode.properties().stream()
                .filter(property -> !propertiesToIgnore.contains(property.getKey()))
                .collect(Collectors.toList());

        for (Map.Entry<String, JsonNode> property: unknownProperties) {
            if (ExtendableObject.extensionPropertyNamePattern.matcher(property.getKey()).matches()) {
                extensionFields.put(property.getKey(), chooseKnownPojo(property.getValue(), objectCodec));
            } else {
                throw new JsonMappingException(String.format("\"%s\" is not valid extension property (through reference chain: com.asyncapi.v2._6_0.model.channel.message.Message[\"%s\"])", property.getKey(), property.getKey()));
            }
        }

        if (extensionFields.isEmpty()) {
            return null;
        }

        return extensionFields;
    }

    @Override
    public Message deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        ObjectCodec objectCodec = jsonParser.getCodec();
        JsonNode messageNode = objectCodec.readTree(jsonParser);

        Message message = Message.builder()
                .messageId(string(messageNode.get("messageId"), objectCodec))
                .headers(headers(messageNode.get("headers"), objectCodec, deserializationContext))
                .payload(payload(messageNode, objectCodec))
                .correlationId(correlationId(messageNode.get("correlationId"), objectCodec, deserializationContext))
                .schemaFormat(string(messageNode.get("schemaFormat"), objectCodec))
                .contentType(string(messageNode.get("contentType"), objectCodec))
                .name(string(messageNode.get("name"), objectCodec))
                .title(string(messageNode.get("title"), objectCodec))
                .summary(string(messageNode.get("summary"), objectCodec))
                .description(string(messageNode.get("description"), objectCodec))
                .tags(tags(messageNode.get("tags"), objectCodec))
                .externalDocs(externalDocs(messageNode.get("externalDocs"), objectCodec))
                .bindings(bindings(messageNode.get("bindings"), objectCodec, deserializationContext))
                .examples(examples(messageNode.get("examples"), objectCodec))
                .traits(traits(messageNode.get("traits"), objectCodec, deserializationContext))
                .build();

        message.setExtensionFields(extensionFields(messageNode, objectCodec));
        return message;
    }

}
