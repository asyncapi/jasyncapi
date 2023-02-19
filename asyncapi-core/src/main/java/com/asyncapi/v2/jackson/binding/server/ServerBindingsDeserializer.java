package com.asyncapi.v2.jackson.binding.server;

import com.asyncapi.v2.binding.server.amqp.AMQPServerBinding;
import com.asyncapi.v2.binding.server.amqp1.AMQP1ServerBinding;
import com.asyncapi.v2.binding.server.anypointmq.AnypointMQServerBinding;
import com.asyncapi.v2.binding.server.googlepubsub.GooglePubSubServerBinding;
import com.asyncapi.v2.binding.server.http.HTTPServerBinding;
import com.asyncapi.v2.binding.server.ibmmq.IBMMQServerBinding;
import com.asyncapi.v2.binding.server.jms.JMSServerBinding;
import com.asyncapi.v2.binding.server.kafka.KafkaServerBinding;
import com.asyncapi.v2.binding.server.mercure.MercureServerBinding;
import com.asyncapi.v2.binding.server.mqtt.MQTTServerBinding;
import com.asyncapi.v2.binding.server.mqtt5.MQTT5ServerBinding;
import com.asyncapi.v2.binding.server.nats.NATSServerBinding;
import com.asyncapi.v2.binding.server.pulsar.PulsarServerBinding;
import com.asyncapi.v2.binding.server.redis.RedisServerBinding;
import com.asyncapi.v2.binding.server.sns.SNSServerBinding;
import com.asyncapi.v2.binding.server.solace.SolaceServerBinding;
import com.asyncapi.v2.binding.server.sqs.SQSServerBinding;
import com.asyncapi.v2.binding.server.stomp.STOMPServerBinding;
import com.asyncapi.v2.binding.server.ws.WebSocketsServerBinding;
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
 * Serializes server bindings map.
 *
 * @version 2.6.0
 * @author Pavel Bodiachevskii
 */
public class ServerBindingsDeserializer extends JsonDeserializer<Map<String, Object>> {

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
            case "amqp": return objectMapper.readValue(binding.toString(), AMQPServerBinding.class);
            case "amqp1": return objectMapper.readValue(binding.toString(), AMQP1ServerBinding.class);
            case "anypointmq": return objectMapper.readValue(binding.toString(), AnypointMQServerBinding.class);
            case "googlepubsub": return objectMapper.readValue(binding.toString(), GooglePubSubServerBinding.class);
            case "http": return objectMapper.readValue(binding.toString(), HTTPServerBinding.class);
            case "ibmmq": return objectMapper.readValue(binding.toString(), IBMMQServerBinding.class);
            case "jms": return objectMapper.readValue(binding.toString(), JMSServerBinding.class);
            case "kafka": return objectMapper.readValue(binding.toString(), KafkaServerBinding.class);
            case "mercure": return objectMapper.readValue(binding.toString(), MercureServerBinding.class);
            case "mqtt": return objectMapper.readValue(binding.toString(), MQTTServerBinding.class);
            case "mqtt5": return objectMapper.readValue(binding.toString(), MQTT5ServerBinding.class);
            case "nats": return objectMapper.readValue(binding.toString(), NATSServerBinding.class);
            case "pulsar": return objectMapper.readValue(binding.toString(), PulsarServerBinding.class);
            case "redis": return objectMapper.readValue(binding.toString(), RedisServerBinding.class);
            case "sns": return objectMapper.readValue(binding.toString(), SNSServerBinding.class);
            case "solace": return objectMapper.readValue(binding.toString(), SolaceServerBinding.class);
            case "sqs": return objectMapper.readValue(binding.toString(), SQSServerBinding.class);
            case "stomp": return objectMapper.readValue(binding.toString(), STOMPServerBinding.class);
            case "ws": return objectMapper.readValue(binding.toString(), WebSocketsServerBinding.class);
            default: return null;
        }
    }

}
