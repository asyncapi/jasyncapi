package com.asyncapi.v2.binding;

import com.asyncapi.v2.binding.amqp.AMQPServerBinding;
import com.asyncapi.v2.binding.amqp1.AMQP1ServerBinding;
import com.asyncapi.v2.binding.http.HTTPServerBinding;
import com.asyncapi.v2.binding.jms.JMSServerBinding;
import com.asyncapi.v2.binding.mqtt.MQTTServerBinding;
import com.asyncapi.v2.binding.mqtt5.MQTT5ServerBinding;
import com.asyncapi.v2.binding.nats.NATSServerBinding;
import com.asyncapi.v2.binding.redis.RedisServerBinding;
import com.asyncapi.v2.binding.sns.SNSServerBinding;
import com.asyncapi.v2.binding.solace.SolaceServerBinding;
import com.asyncapi.v2.binding.sqs.SQSServerBinding;
import com.asyncapi.v2.binding.stomp.STOMPServerBinding;
import com.asyncapi.v2.binding.ws.WebSocketsServerBinding;
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
 * Serializes server bindings map.
 *
 * @author Pavel Bodiachevskii
 */
public class ServerBindingsDeserializer extends JsonDeserializer<Map<String, ? extends ServerBinding>> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Map<String, ? extends ServerBinding> deserialize(
            JsonParser p,
            DeserializationContext ctxt
    ) throws IOException, JsonProcessingException {
        ObjectCodec objectCodec = p.getCodec();
        JsonNode node = objectCodec.readTree(p);

        Map<String, ? extends ServerBinding> bindings = new HashMap<>();

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

    private <T extends ServerBinding> T chooseKnownPojo(String bindingKey, JsonNode binding) throws IOException {
        switch (bindingKey) {
            case "amqp": return (T) objectMapper.readValue(binding.toString(), AMQPServerBinding.class);
            case "amqp1":  return (T) objectMapper.readValue(binding.toString(), AMQP1ServerBinding.class);
            case "http":  return (T) objectMapper.readValue(binding.toString(), HTTPServerBinding.class);
            case "jms":  return (T) objectMapper.readValue(binding.toString(), JMSServerBinding.class);
            case "kafka":  return (T) objectMapper.readValue(binding.toString(), JMSServerBinding.class);
            case "mqtt":  return (T) objectMapper.readValue(binding.toString(), MQTTServerBinding.class);
            case "mqtt5":  return (T) objectMapper.readValue(binding.toString(), MQTT5ServerBinding.class);
            case "nats":  return (T) objectMapper.readValue(binding.toString(), NATSServerBinding.class);
            case "redis":  return (T) objectMapper.readValue(binding.toString(), RedisServerBinding.class);
            case "sns":  return (T) objectMapper.readValue(binding.toString(), SNSServerBinding.class);
            case "solace": return (T) objectMapper.readValue(binding.toString(), SolaceServerBinding.class);
            case "sqs":  return (T) objectMapper.readValue(binding.toString(), SQSServerBinding.class);
            case "stomp":  return (T) objectMapper.readValue(binding.toString(), STOMPServerBinding.class);
            case "ws":  return (T) objectMapper.readValue(binding.toString(), WebSocketsServerBinding.class);
            default:     return null;
        }
    }

}
