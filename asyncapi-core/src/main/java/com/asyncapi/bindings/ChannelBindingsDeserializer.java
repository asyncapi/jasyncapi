package com.asyncapi.bindings;

import com.asyncapi.bindings.amqp.AMQPChannelBinding;
import com.asyncapi.bindings.amqp1.AMQP1ChannelBinding;
import com.asyncapi.bindings.anypointmq.AnypointMQChannelBinding;
import com.asyncapi.bindings.googlepubsub.GooglePubSubChannelBinding;
import com.asyncapi.bindings.http.HTTPChannelBinding;
import com.asyncapi.bindings.ibmmq.IBMMQChannelBinding;
import com.asyncapi.bindings.jms.JMSChannelBinding;
import com.asyncapi.bindings.kafka.KafkaChannelBinding;
import com.asyncapi.bindings.mercure.MercureChannelBinding;
import com.asyncapi.bindings.mqtt.MQTTChannelBinding;
import com.asyncapi.bindings.mqtt5.MQTT5ChannelBinding;
import com.asyncapi.bindings.nats.NATSChannelBinding;
import com.asyncapi.bindings.pulsar.PulsarChannelBinding;
import com.asyncapi.bindings.redis.RedisChannelBinding;
import com.asyncapi.bindings.sns.SNSChannelBinding;
import com.asyncapi.bindings.solace.SolaceChannelBinding;
import com.asyncapi.bindings.sqs.SQSChannelBinding;
import com.asyncapi.bindings.stomp.STOMPChannelBinding;
import com.asyncapi.bindings.websockets.WebSocketsChannelBinding;
import com.asyncapi.schemas.asyncapi.Reference;
import com.fasterxml.jackson.core.JsonParser;
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
        try (JsonParser jsonParser = binding.traverse(objectCodec)) {
            if (binding.get("$ref" ) != null) {
                return jsonParser.readValueAs(Reference.class);
            }

            switch (bindingKey) {
                case "amqp": return jsonParser.readValueAs(AMQPChannelBinding.class);
                case "amqp1": return jsonParser.readValueAs(AMQP1ChannelBinding.class);
                case "anypointmq": return jsonParser.readValueAs(AnypointMQChannelBinding.class);
                case "googlepubsub": return jsonParser.readValueAs(GooglePubSubChannelBinding.class);
                case "http": return jsonParser.readValueAs(HTTPChannelBinding.class);
                case "ibmmq": return jsonParser.readValueAs(IBMMQChannelBinding.class);
                case "jms": return jsonParser.readValueAs(JMSChannelBinding.class);
                case "kafka": return jsonParser.readValueAs(KafkaChannelBinding.class);
                case "mercure": return jsonParser.readValueAs(MercureChannelBinding.class);
                case "mqtt": return jsonParser.readValueAs(MQTTChannelBinding.class);
                case "mqtt5": return jsonParser.readValueAs(MQTT5ChannelBinding.class);
                case "nats": return jsonParser.readValueAs(NATSChannelBinding.class);
                case "pulsar": return jsonParser.readValueAs(PulsarChannelBinding.class);
                case "redis": return jsonParser.readValueAs(RedisChannelBinding.class);
                case "sns": return jsonParser.readValueAs(SNSChannelBinding.class);
                case "solace": return jsonParser.readValueAs(SolaceChannelBinding.class);
                case "sqs": return jsonParser.readValueAs(SQSChannelBinding.class);
                case "stomp": return jsonParser.readValueAs(STOMPChannelBinding.class);
                case "ws": return jsonParser.readValueAs(WebSocketsChannelBinding.class);
                default: return null;
            }
        }
    }

}
