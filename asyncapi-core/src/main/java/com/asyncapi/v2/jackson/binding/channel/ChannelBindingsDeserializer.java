package com.asyncapi.v2.jackson.binding.channel;

import com.asyncapi.v2.Reference;
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
import com.asyncapi.bindings.solace.v0._3_0.channel.SolaceChannelBinding;
import com.asyncapi.bindings.sqs.v0._1_0.channel.SQSChannelBinding;
import com.asyncapi.bindings.stomp.v0._1_0.channel.STOMPChannelBinding;
import com.asyncapi.bindings.websockets.v0._1_0.channel.WebSocketsChannelBinding;
import com.asyncapi.v2.jackson.BindingsMapDeserializer;
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
