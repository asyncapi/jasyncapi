package com.asyncapi.v2.jackson.binding.message;

import com.asyncapi.v2._6_0.model.Reference;
import com.asyncapi.v2.binding.message.amqp.AMQPMessageBinding;
import com.asyncapi.v2.binding.message.amqp1.AMQP1MessageBinding;
import com.asyncapi.v2.binding.message.anypointmq.AnypointMQMessageBinding;
import com.asyncapi.v2.binding.message.googlepubsub.GooglePubSubMessageBinding;
import com.asyncapi.v2.binding.message.http.HTTPMessageBinding;
import com.asyncapi.v2.binding.message.ibmmq.IBMMQMessageBinding;
import com.asyncapi.v2.binding.message.jms.JMSMessageBinding;
import com.asyncapi.v2.binding.message.kafka.KafkaMessageBinding;
import com.asyncapi.v2.binding.message.mercure.MercureMessageBinding;
import com.asyncapi.v2.binding.message.mqtt.MQTTMessageBinding;
import com.asyncapi.v2.binding.message.mqtt5.MQTT5MessageBinding;
import com.asyncapi.v2.binding.message.nats.NATSMessageBinding;
import com.asyncapi.v2.binding.message.pulsar.PulsarMessageBinding;
import com.asyncapi.v2.binding.message.redis.RedisMessageBinding;
import com.asyncapi.v2.binding.message.sns.SNSMessageBinding;
import com.asyncapi.v2.binding.message.solace.SolaceMessageBinding;
import com.asyncapi.v2.binding.message.sqs.SQSMessageBinding;
import com.asyncapi.v2.binding.message.stomp.STOMPMessageBinding;
import com.asyncapi.v2.binding.message.ws.WebSocketsMessageBinding;
import com.asyncapi.v2.jackson.BindingsMapDeserializer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

/**
 * Serializes message bindings map.
 *
 * @author Pavel Bodiachevskii
 */
public class MessageBindingsDeserializer extends BindingsMapDeserializer {

    public Object chooseKnownPojo(String bindingKey, JsonNode binding, ObjectCodec objectCodec) throws IOException {
        if (binding.get("$ref" ) != null) {
            return binding.traverse(objectCodec).readValueAs(Reference.class);
        }

        switch (bindingKey) {
            case "amqp": return binding.traverse(objectCodec).readValueAs(AMQPMessageBinding.class);
            case "amqp1": return binding.traverse(objectCodec).readValueAs(AMQP1MessageBinding.class);
            case "anypointmq": return binding.traverse(objectCodec).readValueAs(AnypointMQMessageBinding.class);
            case "googlepubsub": return binding.traverse(objectCodec).readValueAs(GooglePubSubMessageBinding.class);
            case "http": return binding.traverse(objectCodec).readValueAs(HTTPMessageBinding.class);
            case "ibmmq": return binding.traverse(objectCodec).readValueAs(IBMMQMessageBinding.class);
            case "jms": return binding.traverse(objectCodec).readValueAs(JMSMessageBinding.class);
            case "kafka": return binding.traverse(objectCodec).readValueAs(KafkaMessageBinding.class);
            case "mercure": return binding.traverse(objectCodec).readValueAs(MercureMessageBinding.class);
            case "mqtt": return binding.traverse(objectCodec).readValueAs(MQTTMessageBinding.class);
            case "mqtt5": return binding.traverse(objectCodec).readValueAs(MQTT5MessageBinding.class);
            case "nats": return binding.traverse(objectCodec).readValueAs(NATSMessageBinding.class);
            case "pulsar": return binding.traverse(objectCodec).readValueAs(PulsarMessageBinding.class);
            case "redis": return binding.traverse(objectCodec).readValueAs(RedisMessageBinding.class);
            case "sns": return binding.traverse(objectCodec).readValueAs(SNSMessageBinding.class);
            case "solace": return binding.traverse(objectCodec).readValueAs(SolaceMessageBinding.class);
            case "sqs": return binding.traverse(objectCodec).readValueAs(SQSMessageBinding.class);
            case "stomp": return binding.traverse(objectCodec).readValueAs(STOMPMessageBinding.class);
            case "ws": return binding.traverse(objectCodec).readValueAs(WebSocketsMessageBinding.class);
            default: return null;
        }
    }

}
