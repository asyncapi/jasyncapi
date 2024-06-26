package com.asyncapi.bindings;

import com.asyncapi.bindings.amqp.AMQPMessageBinding;
import com.asyncapi.bindings.amqp1.AMQP1MessageBinding;
import com.asyncapi.bindings.anypointmq.AnypointMQMessageBinding;
import com.asyncapi.bindings.googlepubsub.GooglePubSubMessageBinding;
import com.asyncapi.bindings.http.HTTPMessageBinding;
import com.asyncapi.bindings.ibmmq.IBMMQMessageBinding;
import com.asyncapi.bindings.jms.JMSMessageBinding;
import com.asyncapi.bindings.kafka.KafkaMessageBinding;
import com.asyncapi.bindings.mercure.MercureMessageBinding;
import com.asyncapi.bindings.mqtt.MQTTMessageBinding;
import com.asyncapi.bindings.mqtt5.MQTT5MessageBinding;
import com.asyncapi.bindings.nats.NATSMessageBinding;
import com.asyncapi.bindings.pulsar.PulsarMessageBinding;
import com.asyncapi.bindings.redis.RedisMessageBinding;
import com.asyncapi.bindings.sns.SNSMessageBinding;
import com.asyncapi.bindings.solace.SolaceMessageBinding;
import com.asyncapi.bindings.sqs.SQSMessageBinding;
import com.asyncapi.bindings.stomp.STOMPMessageBinding;
import com.asyncapi.bindings.websockets.WebSocketsMessageBinding;
import com.asyncapi.schemas.asyncapi.Reference;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

/**
 * Serializes message bindings map.
 *
 * @author Pavel Bodiachevskii
 * @since 1.0.0-RC2
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
