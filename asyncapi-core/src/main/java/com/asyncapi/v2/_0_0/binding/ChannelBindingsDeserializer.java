package com.asyncapi.v2._0_0.binding;

import com.asyncapi.v2._0_0.binding.amqp.AMQPChannelBinding;
import com.asyncapi.v2._0_0.binding.amqp1.AMQP1ChannelBinding;
import com.asyncapi.v2._0_0.binding.http.HTTPChannelBinding;
import com.asyncapi.v2._0_0.binding.jms.JMSChannelBinding;
import com.asyncapi.v2._0_0.binding.mqtt.MQTTChannelBinding;
import com.asyncapi.v2._0_0.binding.mqtt5.MQTT5ChannelBinding;
import com.asyncapi.v2._0_0.binding.nats.NATSChannelBinding;
import com.asyncapi.v2._0_0.binding.redis.RedisChannelBinding;
import com.asyncapi.v2._0_0.binding.sns.SNSChannelBinding;
import com.asyncapi.v2._0_0.binding.solace.SolaceChannelBinding;
import com.asyncapi.v2._0_0.binding.sqs.SQSChannelBinding;
import com.asyncapi.v2._0_0.binding.stomp.STOMPChannelBinding;
import com.asyncapi.v2._0_0.binding.ws.WebSocketsChannelBinding;
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
 * Serializes channel bindings map.
 *
 * @author Pavel Bodiachevskii
 */
public class ChannelBindingsDeserializer extends JsonDeserializer<Map<String, ? extends ChannelBinding>> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Map<String, ? extends ChannelBinding> deserialize(
            JsonParser p,
            DeserializationContext ctxt
    ) throws IOException, JsonProcessingException {
        ObjectCodec objectCodec = p.getCodec();
        JsonNode node = objectCodec.readTree(p);

        Map<String, ? extends ChannelBinding> bindings = new HashMap<>();

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

    private <T extends ChannelBinding> T chooseKnownPojo(String bindingKey, JsonNode binding) throws IOException {
        switch (bindingKey) {
            case "amqp": return (T) objectMapper.readValue(binding.toString(), AMQPChannelBinding.class);
            case "amqp1":  return (T) objectMapper.readValue(binding.toString(), AMQP1ChannelBinding.class);
            case "http":  return (T) objectMapper.readValue(binding.toString(), HTTPChannelBinding.class);
            case "jms":  return (T) objectMapper.readValue(binding.toString(), JMSChannelBinding.class);
            case "kafka":  return (T) objectMapper.readValue(binding.toString(), JMSChannelBinding.class);
            case "mqtt":  return (T) objectMapper.readValue(binding.toString(), MQTTChannelBinding.class);
            case "mqtt5":  return (T) objectMapper.readValue(binding.toString(), MQTT5ChannelBinding.class);
            case "nats":  return (T) objectMapper.readValue(binding.toString(), NATSChannelBinding.class);
            case "redis":  return (T) objectMapper.readValue(binding.toString(), RedisChannelBinding.class);
            case "sns":  return (T) objectMapper.readValue(binding.toString(), SNSChannelBinding.class);
            case "solace": return (T) objectMapper.readValue(binding.toString(), SolaceChannelBinding.class);
            case "sqs":  return (T) objectMapper.readValue(binding.toString(), SQSChannelBinding.class);
            case "stomp":  return (T) objectMapper.readValue(binding.toString(), STOMPChannelBinding.class);
            case "ws":  return (T) objectMapper.readValue(binding.toString(), WebSocketsChannelBinding.class);
            default:     return null;
        }
    }

}
