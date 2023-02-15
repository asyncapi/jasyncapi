package com.asyncapi.v2.binding;

import com.asyncapi.v2.binding.amqp.AMQPMessageBinding;
import com.asyncapi.v2.binding.amqp1.AMQP1MessageBinding;
import com.asyncapi.v2.binding.http.HTTPMessageBinding;
import com.asyncapi.v2.binding.jms.JMSMessageBinding;
import com.asyncapi.v2.binding.mqtt.MQTTMessageBinding;
import com.asyncapi.v2.binding.mqtt5.MQTT5MessageBinding;
import com.asyncapi.v2.binding.nats.NATSMessageBinding;
import com.asyncapi.v2.binding.redis.RedisMessageBinding;
import com.asyncapi.v2.binding.sns.SNSMessageBinding;
import com.asyncapi.v2.binding.solace.SolaceMessageBinding;
import com.asyncapi.v2.binding.sqs.SQSMessageBinding;
import com.asyncapi.v2.binding.stomp.STOMPMessageBinding;
import com.asyncapi.v2.binding.ws.WebSocketsMessageBinding;
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
 * Serializes message bindings map.
 *
 * @author Pavel Bodiachevskii
 */
public class MessageBindingsDeserializer extends JsonDeserializer<Map<String, ? extends MessageBinding>> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Map<String, ? extends MessageBinding> deserialize(
            JsonParser p,
            DeserializationContext ctxt
    ) throws IOException, JsonProcessingException {
        ObjectCodec objectCodec = p.getCodec();
        JsonNode node = objectCodec.readTree(p);

        Map<String, ? extends MessageBinding> bindings = new HashMap<>();

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

    private <T extends MessageBinding> T chooseKnownPojo(String bindingKey, JsonNode binding) throws IOException {
        switch (bindingKey) {
            case "amqp": return (T) objectMapper.readValue(binding.toString(), AMQPMessageBinding.class);
            case "amqp1":  return (T) objectMapper.readValue(binding.toString(), AMQP1MessageBinding.class);
            case "http":  return (T) objectMapper.readValue(binding.toString(), HTTPMessageBinding.class);
            case "jms":  return (T) objectMapper.readValue(binding.toString(), JMSMessageBinding.class);
            case "kafka":  return (T) objectMapper.readValue(binding.toString(), JMSMessageBinding.class);
            case "mqtt":  return (T) objectMapper.readValue(binding.toString(), MQTTMessageBinding.class);
            case "mqtt5":  return (T) objectMapper.readValue(binding.toString(), MQTT5MessageBinding.class);
            case "nats":  return (T) objectMapper.readValue(binding.toString(), NATSMessageBinding.class);
            case "redis":  return (T) objectMapper.readValue(binding.toString(), RedisMessageBinding.class);
            case "sns":  return (T) objectMapper.readValue(binding.toString(), SNSMessageBinding.class);
            case "solace":  return (T) objectMapper.readValue(binding.toString(), SolaceMessageBinding.class);
            case "sqs":  return (T) objectMapper.readValue(binding.toString(), SQSMessageBinding.class);
            case "stomp":  return (T) objectMapper.readValue(binding.toString(), STOMPMessageBinding.class);
            case "ws":  return (T) objectMapper.readValue(binding.toString(), WebSocketsMessageBinding.class);
            default:     return null;
        }
    }

}
