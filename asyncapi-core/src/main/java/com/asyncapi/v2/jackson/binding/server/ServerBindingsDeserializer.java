package com.asyncapi.v2.jackson.binding.server;

import com.asyncapi.v2._6_0.model.Reference;
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
import com.asyncapi.v2.jackson.BindingsMapDeserializer;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

/**
 * Serializes server bindings map.
 *
 * @version 2.6.0
 * @author Pavel Bodiachevskii
 */
public class ServerBindingsDeserializer extends BindingsMapDeserializer {

    @Override
    public Object chooseKnownPojo(String bindingKey, JsonNode binding, ObjectCodec objectCodec) throws IOException {
        try (JsonParser jsonParser = binding.traverse(objectCodec)) {
            if (binding.get("$ref" ) != null) {
                return jsonParser.readValueAs(Reference.class);
            }

            switch (bindingKey) {
                case "amqp": return jsonParser.readValueAs(AMQPServerBinding.class);
                case "amqp1": return jsonParser.readValueAs(AMQP1ServerBinding.class);
                case "anypointmq": return jsonParser.readValueAs(AnypointMQServerBinding.class);
                case "googlepubsub": return jsonParser.readValueAs(GooglePubSubServerBinding.class);
                case "http": return jsonParser.readValueAs(HTTPServerBinding.class);
                case "ibmmq": return jsonParser.readValueAs(IBMMQServerBinding.class);
                case "jms": return jsonParser.readValueAs(JMSServerBinding.class);
                case "kafka": return jsonParser.readValueAs(KafkaServerBinding.class);
                case "mercure": return jsonParser.readValueAs(MercureServerBinding.class);
                case "mqtt": return jsonParser.readValueAs(MQTTServerBinding.class);
                case "mqtt5": return jsonParser.readValueAs(MQTT5ServerBinding.class);
                case "nats": return jsonParser.readValueAs(NATSServerBinding.class);
                case "pulsar": return jsonParser.readValueAs(PulsarServerBinding.class);
                case "redis": return jsonParser.readValueAs(RedisServerBinding.class);
                case "sns": return jsonParser.readValueAs(SNSServerBinding.class);
                case "solace": return jsonParser.readValueAs(SolaceServerBinding.class);
                case "sqs": return jsonParser.readValueAs(SQSServerBinding.class);
                case "stomp": return jsonParser.readValueAs(STOMPServerBinding.class);
                case "ws": return jsonParser.readValueAs(WebSocketsServerBinding.class);
                default: return null;
            }
        }
    }

}
