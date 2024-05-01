package com.asyncapi.bindings;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SelectClasses({
        com.asyncapi.bindings.amqp.AMQP.class,
        com.asyncapi.bindings.amqp1.AMQP1.class,
        com.asyncapi.bindings.anypointmq.AnypointMQ.class,
        com.asyncapi.bindings.googlepubsub.GooglePubSub.class,
        com.asyncapi.bindings.http.HTTP.class,
        com.asyncapi.bindings.ibmmq.IBMMQ.class,
        com.asyncapi.bindings.jms.JMS.class,
        com.asyncapi.bindings.kafka.Kafka.class,
        com.asyncapi.bindings.mercure.Mercure.class,
        com.asyncapi.bindings.mqtt.MQTT.class,
        com.asyncapi.bindings.mqtt5.MQTT5.class,
        com.asyncapi.bindings.nats.NATS.class,
        com.asyncapi.bindings.pulsar.Pulsar.class,
//        com.asyncapi.bindings.redis.Pulsar.class,
        com.asyncapi.bindings.sns.SNS.class,
        com.asyncapi.bindings.solace.Solace.class,
        com.asyncapi.bindings.sqs.SQS.class,
//        com.asyncapi.bindings.stomp.STOMP.class,
//        com.asyncapi.bindings.websockets.WebSockets.class,
})
@SuiteDisplayName("Bindings")
public class BindingsTest {}