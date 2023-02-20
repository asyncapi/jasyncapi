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
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

/**
 * Serializes channel bindings map.
 *
 * @author Pavel Bodiachevskii
 */
public class ChannelBindingsDeserializer extends BindingsMapDeserializer {

    public Object chooseKnownPojo(String bindingKey, JsonNode binding, ObjectCodec objectCodec) throws IOException {
        if (binding.get("$ref" ) != null) {
            return binding.traverse(objectCodec).readValueAs(Reference.class);
        }

        switch (bindingKey) {
            case "amqp": return binding.traverse(objectCodec).readValueAs(AMQPChannelBinding.class);
            case "amqp1": return binding.traverse(objectCodec).readValueAs(AMQP1ChannelBinding.class);
            case "anypointmq": return binding.traverse(objectCodec).readValueAs(AnypointMQChannelBinding.class);
            case "googlepubsub": return binding.traverse(objectCodec).readValueAs(GooglePubSubChannelBinding.class);
            case "http": return binding.traverse(objectCodec).readValueAs(HTTPChannelBinding.class);
            case "ibmmq": return binding.traverse(objectCodec).readValueAs(IBMMQChannelBinding.class);
            case "jms": return binding.traverse(objectCodec).readValueAs(JMSChannelBinding.class);
            case "kafka": return binding.traverse(objectCodec).readValueAs(KafkaChannelBinding.class);
            case "mercure": return binding.traverse(objectCodec).readValueAs(MercureChannelBinding.class);
            case "mqtt": return binding.traverse(objectCodec).readValueAs(MQTTChannelBinding.class);
            case "mqtt5": return binding.traverse(objectCodec).readValueAs(MQTT5ChannelBinding.class);
            case "nats": return binding.traverse(objectCodec).readValueAs(NATSChannelBinding.class);
            case "pulsar": return binding.traverse(objectCodec).readValueAs(PulsarChannelBinding.class);
            case "redis": return binding.traverse(objectCodec).readValueAs(RedisChannelBinding.class);
            case "sns": return binding.traverse(objectCodec).readValueAs(SNSChannelBinding.class);
            case "solace": return binding.traverse(objectCodec).readValueAs(SolaceChannelBinding.class);
            case "sqs": return binding.traverse(objectCodec).readValueAs(SQSChannelBinding.class);
            case "stomp": return binding.traverse(objectCodec).readValueAs(STOMPChannelBinding.class);
            case "ws": return binding.traverse(objectCodec).readValueAs(WebSocketsChannelBinding.class);
            default: return null;
        }
    }

}
