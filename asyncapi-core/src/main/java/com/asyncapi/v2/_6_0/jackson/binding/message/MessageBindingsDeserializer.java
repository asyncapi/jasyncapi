package com.asyncapi.v2._6_0.jackson.binding.message;

import com.asyncapi.v2._6_0.binding.message.amqp.AMQPMessageBinding;
import com.asyncapi.v2._6_0.binding.message.amqp1.AMQP1MessageBinding;
import com.asyncapi.v2._6_0.binding.message.anypointmq.AnypointMQMessageBinding;
import com.asyncapi.v2._6_0.binding.message.googlepubsub.GooglePubSubMessageBinding;
import com.asyncapi.v2._6_0.binding.message.http.HTTPMessageBinding;
import com.asyncapi.v2._6_0.binding.message.ibmmq.IBMMQMessageBinding;
import com.asyncapi.v2._6_0.binding.message.jms.JMSMessageBinding;
import com.asyncapi.v2._6_0.binding.message.kafka.KafkaMessageBinding;
import com.asyncapi.v2._6_0.binding.message.mercure.MercureMessageBinding;
import com.asyncapi.v2._6_0.binding.message.mqtt.MQTTMessageBinding;
import com.asyncapi.v2._6_0.binding.message.mqtt5.MQTT5MessageBinding;
import com.asyncapi.v2._6_0.binding.message.nats.NATSMessageBinding;
import com.asyncapi.v2._6_0.binding.message.pulsar.PulsarMessageBinding;
import com.asyncapi.v2._6_0.binding.message.redis.RedisMessageBinding;
import com.asyncapi.v2._6_0.binding.message.sns.SNSMessageBinding;
import com.asyncapi.v2._6_0.binding.message.solace.SolaceMessageBinding;
import com.asyncapi.v2._6_0.binding.message.sqs.SQSMessageBinding;
import com.asyncapi.v2._6_0.binding.message.stomp.STOMPMessageBinding;
import com.asyncapi.v2._6_0.binding.message.ws.WebSocketsMessageBinding;
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
 * Serializes message bindings map.
 *
 * @author Pavel Bodiachevskii
 */
public class MessageBindingsDeserializer extends JsonDeserializer<Map<String, Object>> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Map<String, Object> deserialize(
            JsonParser p,
            DeserializationContext ctxt
    ) throws IOException, JsonProcessingException {
        ObjectCodec objectCodec = p.getCodec();
        JsonNode node = objectCodec.readTree(p);

        Map<String, Object> bindings = new HashMap<>();

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

    private Object chooseKnownPojo(String bindingKey, JsonNode binding) throws IOException {
        if (binding.get("$ref" ) != null) {
            return objectMapper.readValue(binding.toString(), Reference.class);
        }

        switch (bindingKey) {
            case "amqp": return objectMapper.readValue(binding.toString(), AMQPMessageBinding.class);
            case "amqp1": return objectMapper.readValue(binding.toString(), AMQP1MessageBinding.class);
            case "anypointmq": return objectMapper.readValue(binding.toString(), AnypointMQMessageBinding.class);
            case "googlepubsub": return objectMapper.readValue(binding.toString(), GooglePubSubMessageBinding.class);
            case "http": return objectMapper.readValue(binding.toString(), HTTPMessageBinding.class);
            case "ibmmq": return objectMapper.readValue(binding.toString(), IBMMQMessageBinding.class);
            case "jms": return objectMapper.readValue(binding.toString(), JMSMessageBinding.class);
            case "kafka": return objectMapper.readValue(binding.toString(), KafkaMessageBinding.class);
            case "mercure": return objectMapper.readValue(binding.toString(), MercureMessageBinding.class);
            case "mqtt": return objectMapper.readValue(binding.toString(), MQTTMessageBinding.class);
            case "mqtt5": return objectMapper.readValue(binding.toString(), MQTT5MessageBinding.class);
            case "nats": return objectMapper.readValue(binding.toString(), NATSMessageBinding.class);
            case "pulsar": return objectMapper.readValue(binding.toString(), PulsarMessageBinding.class);
            case "redis": return objectMapper.readValue(binding.toString(), RedisMessageBinding.class);
            case "sns": return objectMapper.readValue(binding.toString(), SNSMessageBinding.class);
            case "solace": return objectMapper.readValue(binding.toString(), SolaceMessageBinding.class);
            case "sqs": return objectMapper.readValue(binding.toString(), SQSMessageBinding.class);
            case "stomp": return objectMapper.readValue(binding.toString(), STOMPMessageBinding.class);
            case "ws": return objectMapper.readValue(binding.toString(), WebSocketsMessageBinding.class);
            default: return null;
        }
    }

}
