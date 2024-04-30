package com.asyncapi.bindings;

import com.asyncapi.bindings.amqp.AMQPServerBinding;
import com.asyncapi.bindings.amqp1.AMQP1ServerBinding;
import com.asyncapi.bindings.anypointmq.AnypointMQServerBinding;
import com.asyncapi.bindings.googlepubsub.GooglePubSubServerBinding;
import com.asyncapi.bindings.http.HTTPServerBinding;
import com.asyncapi.bindings.ibmmq.IBMMQServerBinding;
import com.asyncapi.bindings.jms.JMSServerBinding;
import com.asyncapi.bindings.kafka.KafkaServerBinding;
import com.asyncapi.bindings.mercure.MercureServerBinding;
import com.asyncapi.bindings.mqtt.v0._1_0.server.MQTTServerBinding;
import com.asyncapi.bindings.mqtt5.MQTT5ServerBinding;
import com.asyncapi.bindings.nats.NATSServerBinding;
import com.asyncapi.bindings.pulsar.PulsarServerBinding;
import com.asyncapi.bindings.redis.RedisServerBinding;
import com.asyncapi.bindings.sns.SNSServerBinding;
import com.asyncapi.bindings.solace.v0._3_0.server.SolaceServerBinding;
import com.asyncapi.bindings.sqs.SQSServerBinding;
import com.asyncapi.bindings.stomp.STOMPServerBinding;
import com.asyncapi.bindings.websockets.WebSocketsServerBinding;
import com.asyncapi.Reference;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

/**
 * Serializes server bindings map.
 *
 * @version 3.0.0
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
