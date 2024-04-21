package com.asyncapi.v3.jackson.binding.operation;

import com.asyncapi.v3.Reference;
import com.asyncapi.v3.binding.operation.amqp.AMQPOperationBinding;
import com.asyncapi.v3.binding.operation.amqp1.AMQP1OperationBinding;
import com.asyncapi.v3.binding.operation.anypointmq.AnypointMQOperationBinding;
import com.asyncapi.v3.binding.operation.googlepubsub.GooglePubSubOperationBinding;
import com.asyncapi.v3.binding.operation.http.HTTPOperationBinding;
import com.asyncapi.v3.binding.operation.ibmmq.IBMMQOperationBinding;
import com.asyncapi.v3.binding.operation.jms.JMSOperationBinding;
import com.asyncapi.v3.binding.operation.kafka.KafkaOperationBinding;
import com.asyncapi.v3.binding.operation.mercure.MercureOperationBinding;
import com.asyncapi.v3.binding.operation.mqtt.MQTTOperationBinding;
import com.asyncapi.bindings.mqtt5.v0._2_0.operation.MQTT5OperationBinding;
import com.asyncapi.bindings.nats.v0._1_0.operation.NATSOperationBinding;
import com.asyncapi.bindings.pulsar.v0._1_0.operation.PulsarOperationBinding;
import com.asyncapi.bindings.redis.v0._1_0.operation.RedisOperationBinding;
import com.asyncapi.bindings.sns.v0._1_0.operation.SNSOperationBinding;
import com.asyncapi.bindings.solace.v0._3_0.operation.SolaceOperationBinding;
import com.asyncapi.bindings.sqs.v0._1_0.operation.SQSOperationBinding;
import com.asyncapi.bindings.stomp.v0._1_0.operation.STOMPOperationBinding;
import com.asyncapi.bindings.websockets.v0._1_0.operation.WebSocketsOperationBinding;
import com.asyncapi.v3.jackson.BindingsMapDeserializer;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

/**
 * Serializes operation bindings map.
 *
 * @version 3.0.0
 * @author Pavel Bodiachevskii
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
