package com.asyncapi.v2._6_0.jackson.binding.operation;

import com.asyncapi.v2._6_0.binding.operation.amqp.AMQPOperationBinding;
import com.asyncapi.v2._6_0.binding.operation.amqp1.AMQP1OperationBinding;
import com.asyncapi.v2._6_0.binding.operation.anypointmq.AnypointMQOperationBinding;
import com.asyncapi.v2._6_0.binding.operation.googlepubsub.GooglePubSubOperationBinding;
import com.asyncapi.v2._6_0.binding.operation.http.HTTPOperationBinding;
import com.asyncapi.v2._6_0.binding.operation.ibmmq.IBMMQOperationBinding;
import com.asyncapi.v2._6_0.binding.operation.jms.JMSOperationBinding;
import com.asyncapi.v2._6_0.binding.operation.kafka.KafkaOperationBinding;
import com.asyncapi.v2._6_0.binding.operation.mercure.MercureOperationBinding;
import com.asyncapi.v2._6_0.binding.operation.mqtt.MQTTOperationBinding;
import com.asyncapi.v2._6_0.binding.operation.mqtt5.MQTT5OperationBinding;
import com.asyncapi.v2._6_0.binding.operation.nats.NATSOperationBinding;
import com.asyncapi.v2._6_0.binding.operation.pulsar.PulsarOperationBinding;
import com.asyncapi.v2._6_0.binding.operation.redis.RedisOperationBinding;
import com.asyncapi.v2._6_0.binding.operation.sns.SNSOperationBinding;
import com.asyncapi.v2._6_0.binding.operation.solace.SolaceOperationBinding;
import com.asyncapi.v2._6_0.binding.operation.sqs.SQSOperationBinding;
import com.asyncapi.v2._6_0.binding.operation.stomp.STOMPOperationBinding;
import com.asyncapi.v2._6_0.binding.operation.ws.WebSocketsOperationBinding;
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
 * Serializes operation bindings map.
 *
 * @version 2.6.0
 * @author Pavel Bodiachevskii
 */
public class OperationBindingsDeserializer extends JsonDeserializer<Map<String, Object>> {

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
            case "amqp": return objectMapper.readValue(binding.toString(), AMQPOperationBinding.class);
            case "amqp1": return objectMapper.readValue(binding.toString(), AMQP1OperationBinding.class);
            case "anypointmq": return objectMapper.readValue(binding.toString(), AnypointMQOperationBinding.class);
            case "googlepubsub": return objectMapper.readValue(binding.toString(), GooglePubSubOperationBinding.class);
            case "http": return objectMapper.readValue(binding.toString(), HTTPOperationBinding.class);
            case "ibmmq": return objectMapper.readValue(binding.toString(), IBMMQOperationBinding.class);
            case "jms": return objectMapper.readValue(binding.toString(), JMSOperationBinding.class);
            case "kafka": return objectMapper.readValue(binding.toString(), KafkaOperationBinding.class);
            case "mercure": return objectMapper.readValue(binding.toString(), MercureOperationBinding.class);
            case "mqtt": return objectMapper.readValue(binding.toString(), MQTTOperationBinding.class);
            case "mqtt5": return objectMapper.readValue(binding.toString(), MQTT5OperationBinding.class);
            case "nats": return objectMapper.readValue(binding.toString(), NATSOperationBinding.class);
            case "pulsar": return objectMapper.readValue(binding.toString(), PulsarOperationBinding.class);
            case "redis": return objectMapper.readValue(binding.toString(), RedisOperationBinding.class);
            case "sns": return objectMapper.readValue(binding.toString(), SNSOperationBinding.class);
            case "solace": return objectMapper.readValue(binding.toString(), SolaceOperationBinding.class);
            case "sqs": return objectMapper.readValue(binding.toString(), SQSOperationBinding.class);
            case "stomp": return objectMapper.readValue(binding.toString(), STOMPOperationBinding.class);
            case "ws": return objectMapper.readValue(binding.toString(), WebSocketsOperationBinding.class);
            default: return null;
        }
    }

}
