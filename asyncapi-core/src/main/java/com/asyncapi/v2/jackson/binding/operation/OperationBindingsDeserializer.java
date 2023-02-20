package com.asyncapi.v2.jackson.binding.operation;

import com.asyncapi.v2._6_0.model.Reference;
import com.asyncapi.v2.binding.operation.amqp.AMQPOperationBinding;
import com.asyncapi.v2.binding.operation.amqp1.AMQP1OperationBinding;
import com.asyncapi.v2.binding.operation.anypointmq.AnypointMQOperationBinding;
import com.asyncapi.v2.binding.operation.googlepubsub.GooglePubSubOperationBinding;
import com.asyncapi.v2.binding.operation.http.HTTPOperationBinding;
import com.asyncapi.v2.binding.operation.ibmmq.IBMMQOperationBinding;
import com.asyncapi.v2.binding.operation.jms.JMSOperationBinding;
import com.asyncapi.v2.binding.operation.kafka.KafkaOperationBinding;
import com.asyncapi.v2.binding.operation.mercure.MercureOperationBinding;
import com.asyncapi.v2.binding.operation.mqtt.MQTTOperationBinding;
import com.asyncapi.v2.binding.operation.mqtt5.MQTT5OperationBinding;
import com.asyncapi.v2.binding.operation.nats.NATSOperationBinding;
import com.asyncapi.v2.binding.operation.pulsar.PulsarOperationBinding;
import com.asyncapi.v2.binding.operation.redis.RedisOperationBinding;
import com.asyncapi.v2.binding.operation.sns.SNSOperationBinding;
import com.asyncapi.v2.binding.operation.solace.SolaceOperationBinding;
import com.asyncapi.v2.binding.operation.sqs.SQSOperationBinding;
import com.asyncapi.v2.binding.operation.stomp.STOMPOperationBinding;
import com.asyncapi.v2.binding.operation.ws.WebSocketsOperationBinding;
import com.asyncapi.v2.jackson.BindingsMapDeserializer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

/**
 * Serializes operation bindings map.
 *
 * @version 2.6.0
 * @author Pavel Bodiachevskii
 */
public class OperationBindingsDeserializer extends BindingsMapDeserializer {

    public Object chooseKnownPojo(String bindingKey, JsonNode binding, ObjectCodec objectCodec) throws IOException {
        if (binding.get("$ref" ) != null) {
            return binding.traverse(objectCodec).readValueAs(Reference.class);
        }

        switch (bindingKey) {
            case "amqp": return binding.traverse(objectCodec).readValueAs(AMQPOperationBinding.class);
            case "amqp1": return binding.traverse(objectCodec).readValueAs(AMQP1OperationBinding.class);
            case "anypointmq": return binding.traverse(objectCodec).readValueAs(AnypointMQOperationBinding.class);
            case "googlepubsub": return binding.traverse(objectCodec).readValueAs(GooglePubSubOperationBinding.class);
            case "http": return binding.traverse(objectCodec).readValueAs(HTTPOperationBinding.class);
            case "ibmmq": return binding.traverse(objectCodec).readValueAs(IBMMQOperationBinding.class);
            case "jms": return binding.traverse(objectCodec).readValueAs(JMSOperationBinding.class);
            case "kafka": return binding.traverse(objectCodec).readValueAs(KafkaOperationBinding.class);
            case "mercure": return binding.traverse(objectCodec).readValueAs(MercureOperationBinding.class);
            case "mqtt": return binding.traverse(objectCodec).readValueAs(MQTTOperationBinding.class);
            case "mqtt5": return binding.traverse(objectCodec).readValueAs(MQTT5OperationBinding.class);
            case "nats": return binding.traverse(objectCodec).readValueAs(NATSOperationBinding.class);
            case "pulsar": return binding.traverse(objectCodec).readValueAs(PulsarOperationBinding.class);
            case "redis": return binding.traverse(objectCodec).readValueAs(RedisOperationBinding.class);
            case "sns": return binding.traverse(objectCodec).readValueAs(SNSOperationBinding.class);
            case "solace": return binding.traverse(objectCodec).readValueAs(SolaceOperationBinding.class);
            case "sqs": return binding.traverse(objectCodec).readValueAs(SQSOperationBinding.class);
            case "stomp": return binding.traverse(objectCodec).readValueAs(STOMPOperationBinding.class);
            case "ws": return binding.traverse(objectCodec).readValueAs(WebSocketsOperationBinding.class);
            default: return null;
        }
    }

}
