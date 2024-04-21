package com.asyncapi.v2.jackson.binding.message;

import com.asyncapi.v2.Reference;
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
import com.asyncapi.bindings.stomp.v0._1_0.message.STOMPMessageBinding;
import com.asyncapi.v2.binding.message.ws.WebSocketsMessageBinding;
import com.asyncapi.v2.jackson.BindingsMapDeserializer;
import com.fasterxml.jackson.core.JsonParser;
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
        try (JsonParser jsonParser = binding.traverse(objectCodec)) {
            if (binding.get("$ref" ) != null) {
                return jsonParser.readValueAs(Reference.class);
            }

            switch (bindingKey) {
                case "amqp": return jsonParser.readValueAs(AMQPMessageBinding.class);
                case "amqp1": return jsonParser.readValueAs(AMQP1MessageBinding.class);
                case "anypointmq": return jsonParser.readValueAs(AnypointMQMessageBinding.class);
                case "googlepubsub": return jsonParser.readValueAs(GooglePubSubMessageBinding.class);
                case "http": return jsonParser.readValueAs(HTTPMessageBinding.class);
                case "ibmmq": return jsonParser.readValueAs(IBMMQMessageBinding.class);
                case "jms": return jsonParser.readValueAs(JMSMessageBinding.class);
                case "kafka": return jsonParser.readValueAs(KafkaMessageBinding.class);
                case "mercure": return jsonParser.readValueAs(MercureMessageBinding.class);
                case "mqtt": return jsonParser.readValueAs(MQTTMessageBinding.class);
                case "mqtt5": return jsonParser.readValueAs(MQTT5MessageBinding.class);
                case "nats": return jsonParser.readValueAs(NATSMessageBinding.class);
                case "pulsar": return jsonParser.readValueAs(PulsarMessageBinding.class);
                case "redis": return jsonParser.readValueAs(RedisMessageBinding.class);
                case "sns": return jsonParser.readValueAs(SNSMessageBinding.class);
                case "solace": return jsonParser.readValueAs(SolaceMessageBinding.class);
                case "sqs": return jsonParser.readValueAs(SQSMessageBinding.class);
                case "stomp": return jsonParser.readValueAs(STOMPMessageBinding.class);
                case "ws": return jsonParser.readValueAs(WebSocketsMessageBinding.class);
                default: return null;
            }
        }
    }

}
