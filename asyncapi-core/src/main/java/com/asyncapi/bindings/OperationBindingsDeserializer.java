package com.asyncapi.bindings;

import com.asyncapi.bindings.amqp.AMQPOperationBinding;
import com.asyncapi.bindings.amqp1.AMQP1OperationBinding;
import com.asyncapi.bindings.anypointmq.AnypointMQOperationBinding;
import com.asyncapi.bindings.googlepubsub.GooglePubSubOperationBinding;
import com.asyncapi.bindings.http.HTTPOperationBinding;
import com.asyncapi.bindings.ibmmq.IBMMQOperationBinding;
import com.asyncapi.bindings.jms.JMSOperationBinding;
import com.asyncapi.bindings.kafka.KafkaOperationBinding;
import com.asyncapi.bindings.mercure.MercureOperationBinding;
import com.asyncapi.bindings.mqtt.MQTTOperationBinding;
import com.asyncapi.bindings.mqtt5.MQTT5OperationBinding;
import com.asyncapi.bindings.nats.NATSOperationBinding;
import com.asyncapi.bindings.pulsar.PulsarOperationBinding;
import com.asyncapi.bindings.redis.RedisOperationBinding;
import com.asyncapi.bindings.sns.SNSOperationBinding;
import com.asyncapi.bindings.solace.SolaceOperationBinding;
import com.asyncapi.bindings.sqs.SQSOperationBinding;
import com.asyncapi.bindings.stomp.STOMPOperationBinding;
import com.asyncapi.bindings.websockets.WebSocketsOperationBinding;
import com.asyncapi.schemas.asyncapi.Reference;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

/**
 * Serializes operation bindings map.
 *
 * @author Pavel Bodiachevskii
 * @since 1.0.0-RC2
 */
public class OperationBindingsDeserializer extends BindingsMapDeserializer {

    public Object chooseKnownPojo(String bindingKey, JsonNode binding, ObjectCodec objectCodec) throws IOException {
        try (JsonParser jsonParser = binding.traverse(objectCodec)) {
            if (binding.get("$ref" ) != null) {
                return jsonParser.readValueAs(Reference.class);
            }

            switch (bindingKey) {
                case "amqp": return jsonParser.readValueAs(AMQPOperationBinding.class);
                case "amqp1": return jsonParser.readValueAs(AMQP1OperationBinding.class);
                case "anypointmq": return jsonParser.readValueAs(AnypointMQOperationBinding.class);
                case "googlepubsub": return jsonParser.readValueAs(GooglePubSubOperationBinding.class);
                case "http": return jsonParser.readValueAs(HTTPOperationBinding.class);
                case "ibmmq": return jsonParser.readValueAs(IBMMQOperationBinding.class);
                case "jms": return jsonParser.readValueAs(JMSOperationBinding.class);
                case "kafka": return jsonParser.readValueAs(KafkaOperationBinding.class);
                case "mercure": return jsonParser.readValueAs(MercureOperationBinding.class);
                case "mqtt": return jsonParser.readValueAs(MQTTOperationBinding.class);
                case "mqtt5": return jsonParser.readValueAs(MQTT5OperationBinding.class);
                case "nats": return jsonParser.readValueAs(NATSOperationBinding.class);
                case "pulsar": return jsonParser.readValueAs(PulsarOperationBinding.class);
                case "redis": return jsonParser.readValueAs(RedisOperationBinding.class);
                case "sns": return jsonParser.readValueAs(SNSOperationBinding.class);
                case "solace": return jsonParser.readValueAs(SolaceOperationBinding.class);
                case "sqs": return jsonParser.readValueAs(SQSOperationBinding.class);
                case "stomp": return jsonParser.readValueAs(STOMPOperationBinding.class);
                case "ws": return jsonParser.readValueAs(WebSocketsOperationBinding.class);
                default: return null;
            }
        }
    }

}
