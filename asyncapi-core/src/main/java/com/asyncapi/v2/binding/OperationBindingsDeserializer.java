package com.asyncapi.v2.binding;

import com.asyncapi.v2.binding.amqp.AMQPOperationBinding;
import com.asyncapi.v2.binding.amqp1.AMQP1OperationBinding;
import com.asyncapi.v2.binding.http.HTTPOperationBinding;
import com.asyncapi.v2.binding.jms.JMSOperationBinding;
import com.asyncapi.v2.binding.mqtt.MQTTOperationBinding;
import com.asyncapi.v2.binding.mqtt5.MQTT5OperationBinding;
import com.asyncapi.v2.binding.nats.NATSOperationBinding;
import com.asyncapi.v2.binding.redis.RedisOperationBinding;
import com.asyncapi.v2.binding.sns.SNSOperationBinding;
import com.asyncapi.v2.binding.sqs.SQSOperationBinding;
import com.asyncapi.v2.binding.stomp.STOMPOperationBinding;
import com.asyncapi.v2.binding.ws.WebSocketsOperationBinding;
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
 * Serializes operation bindings map.
 *
 * @author Pavel Bodiachevskii
 */
public class OperationBindingsDeserializer extends JsonDeserializer<Map<String, ? extends OperationBinding>> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Map<String, ? extends OperationBinding> deserialize(
            JsonParser p,
            DeserializationContext ctxt
    ) throws IOException, JsonProcessingException {
        ObjectCodec objectCodec = p.getCodec();
        JsonNode node = objectCodec.readTree(p);

        Map<String, ? extends OperationBinding> bindings = new HashMap<>();

        node.fieldNames().forEachRemaining(
                fieldName -> {
                    try {
                        bindings.put(fieldName, chooseKnownPojo(fieldName, node.get(fieldName)));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        );

        return bindings;
    }

    private <T extends OperationBinding> T chooseKnownPojo(String bindingKey, JsonNode binding) throws IOException {
        switch (bindingKey) {
            case "amqp": return (T) objectMapper.readValue(binding.toString(), AMQPOperationBinding.class);
            case "amqp1":  return (T) objectMapper.readValue(binding.toString(), AMQP1OperationBinding.class);
            case "http":  return (T) objectMapper.readValue(binding.toString(), HTTPOperationBinding.class);
            case "jms":  return (T) objectMapper.readValue(binding.toString(), JMSOperationBinding.class);
            case "kafka":  return (T) objectMapper.readValue(binding.toString(), JMSOperationBinding.class);
            case "mqtt":  return (T) objectMapper.readValue(binding.toString(), MQTTOperationBinding.class);
            case "mqtt5":  return (T) objectMapper.readValue(binding.toString(), MQTT5OperationBinding.class);
            case "nats":  return (T) objectMapper.readValue(binding.toString(), NATSOperationBinding.class);
            case "redis":  return (T) objectMapper.readValue(binding.toString(), RedisOperationBinding.class);
            case "sns":  return (T) objectMapper.readValue(binding.toString(), SNSOperationBinding.class);
            case "sqs":  return (T) objectMapper.readValue(binding.toString(), SQSOperationBinding.class);
            case "stomp":  return (T) objectMapper.readValue(binding.toString(), STOMPOperationBinding.class);
            case "ws":  return (T) objectMapper.readValue(binding.toString(), WebSocketsOperationBinding.class);
            default:     return null;
        }
    }

}
