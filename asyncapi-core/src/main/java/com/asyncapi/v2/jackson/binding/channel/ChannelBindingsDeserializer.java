package com.asyncapi.v2.jackson.binding.channel;

import com.asyncapi.v2._6_0.model.Reference;
import com.asyncapi.v2.binding.channel.amqp.AMQPChannelBinding;
import com.asyncapi.v2.binding.channel.amqp1.AMQP1ChannelBinding;
import com.asyncapi.v2.binding.channel.anypointmq.AnypointMQChannelBinding;
import com.asyncapi.v2.binding.channel.googlepubsub.GooglePubSubChannelBinding;
import com.asyncapi.v2.binding.channel.http.HTTPChannelBinding;
import com.asyncapi.v2.binding.channel.ibmmq.IBMMQChannelBinding;
import com.asyncapi.v2.binding.channel.jms.JMSChannelBinding;
import com.asyncapi.v2.binding.channel.kafka.KafkaChannelBinding;
import com.asyncapi.v2.binding.channel.mercure.MercureChannelBinding;
import com.asyncapi.v2.binding.channel.mqtt.MQTTChannelBinding;
import com.asyncapi.v2.binding.channel.mqtt5.MQTT5ChannelBinding;
import com.asyncapi.v2.binding.channel.nats.NATSChannelBinding;
import com.asyncapi.v2.binding.channel.pulsar.PulsarChannelBinding;
import com.asyncapi.v2.binding.channel.redis.RedisChannelBinding;
import com.asyncapi.v2.binding.channel.sns.SNSChannelBinding;
import com.asyncapi.v2.binding.channel.solace.SolaceChannelBinding;
import com.asyncapi.v2.binding.channel.sqs.SQSChannelBinding;
import com.asyncapi.v2.binding.channel.stomp.STOMPChannelBinding;
import com.asyncapi.v2.binding.channel.ws.WebSocketsChannelBinding;
import com.asyncapi.v2.jackson.BindingsMapDeserializer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * Serializes channel bindings map.
 *
 * @author Pavel Bodiachevskii
 */
public class ChannelBindingsDeserializer extends BindingsMapDeserializer {

    public Object chooseKnownPojo(String bindingKey, JsonNode binding) throws JsonProcessingException {
        if (binding.get("$ref" ) != null) {
            return objectMapper.readValue(binding.toString(), Reference.class);
        }

        switch (bindingKey) {
            case "amqp": return objectMapper.readValue(binding.toString(), AMQPChannelBinding.class);
            case "amqp1": return objectMapper.readValue(binding.toString(), AMQP1ChannelBinding.class);
            case "anypointmq": return objectMapper.readValue(binding.toString(), AnypointMQChannelBinding.class);
            case "googlepubsub": return objectMapper.readValue(binding.toString(), GooglePubSubChannelBinding.class);
            case "http": return objectMapper.readValue(binding.toString(), HTTPChannelBinding.class);
            case "ibmmq": return objectMapper.readValue(binding.toString(), IBMMQChannelBinding.class);
            case "jms": return objectMapper.readValue(binding.toString(), JMSChannelBinding.class);
            case "kafka": return objectMapper.readValue(binding.toString(), KafkaChannelBinding.class);
            case "mercure": return objectMapper.readValue(binding.toString(), MercureChannelBinding.class);
            case "mqtt": return objectMapper.readValue(binding.toString(), MQTTChannelBinding.class);
            case "mqtt5": return objectMapper.readValue(binding.toString(), MQTT5ChannelBinding.class);
            case "nats": return objectMapper.readValue(binding.toString(), NATSChannelBinding.class);
            case "pulsar": return objectMapper.readValue(binding.toString(), PulsarChannelBinding.class);
            case "redis": return objectMapper.readValue(binding.toString(), RedisChannelBinding.class);
            case "sns": return objectMapper.readValue(binding.toString(), SNSChannelBinding.class);
            case "solace": return objectMapper.readValue(binding.toString(), SolaceChannelBinding.class);
            case "sqs": return objectMapper.readValue(binding.toString(), SQSChannelBinding.class);
            case "stomp": return objectMapper.readValue(binding.toString(), STOMPChannelBinding.class);
            case "ws": return objectMapper.readValue(binding.toString(), WebSocketsChannelBinding.class);
            default: return null;
        }
    }

}
