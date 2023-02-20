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
import com.fasterxml.jackson.core.JsonProcessingException;
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
        if (binding.get("$ref" ) != null) {
            return binding.traverse(objectCodec).readValueAs(Reference.class);
        }

        switch (bindingKey) {
            case "amqp": return binding.traverse(objectCodec).readValueAs(AMQPServerBinding.class);
            case "amqp1": return binding.traverse(objectCodec).readValueAs(AMQP1ServerBinding.class);
            case "anypointmq": return binding.traverse(objectCodec).readValueAs(AnypointMQServerBinding.class);
            case "googlepubsub": return binding.traverse(objectCodec).readValueAs(GooglePubSubServerBinding.class);
            case "http": return binding.traverse(objectCodec).readValueAs(HTTPServerBinding.class);
            case "ibmmq": return binding.traverse(objectCodec).readValueAs(IBMMQServerBinding.class);
            case "jms": return binding.traverse(objectCodec).readValueAs(JMSServerBinding.class);
            case "kafka": return binding.traverse(objectCodec).readValueAs(KafkaServerBinding.class);
            case "mercure": return binding.traverse(objectCodec).readValueAs(MercureServerBinding.class);
            case "mqtt": return binding.traverse(objectCodec).readValueAs(MQTTServerBinding.class);
            case "mqtt5": return binding.traverse(objectCodec).readValueAs(MQTT5ServerBinding.class);
            case "nats": return binding.traverse(objectCodec).readValueAs(NATSServerBinding.class);
            case "pulsar": return binding.traverse(objectCodec).readValueAs(PulsarServerBinding.class);
            case "redis": return binding.traverse(objectCodec).readValueAs(RedisServerBinding.class);
            case "sns": return binding.traverse(objectCodec).readValueAs(SNSServerBinding.class);
            case "solace": return binding.traverse(objectCodec).readValueAs(SolaceServerBinding.class);
            case "sqs": return binding.traverse(objectCodec).readValueAs(SQSServerBinding.class);
            case "stomp": return binding.traverse(objectCodec).readValueAs(STOMPServerBinding.class);
            case "ws": return binding.traverse(objectCodec).readValueAs(WebSocketsServerBinding.class);
            default: return null;
        }
    }

}
