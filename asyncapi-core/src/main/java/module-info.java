open module com.asyncapi {
    requires static lombok;
    requires java.validation;
    requires org.jetbrains.annotations;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.databind;

    //////////////////////////////////////////////////
    // V2                                           //
    //////////////////////////////////////////////////
    exports com.asyncapi.v2;
    exports com.asyncapi.v2.jackson;
    exports com.asyncapi.v2.jackson.binding.channel;
    exports com.asyncapi.v2.jackson.binding.message;
    exports com.asyncapi.v2.jackson.binding.operation;
    exports com.asyncapi.v2.jackson.binding.server;
    exports com.asyncapi.v2.schema;
    exports com.asyncapi.v2.security_scheme;
    exports com.asyncapi.v2.security_scheme.http;
    exports com.asyncapi.v2.security_scheme.oauth2;
    exports com.asyncapi.v2.security_scheme.oauth2.flow;
    exports com.asyncapi.v2._0_0.jackson.model.channel;
    exports com.asyncapi.v2._0_0.jackson.model.channel.message;
    exports com.asyncapi.v2._0_0.jackson.model.channel.operation;
    exports com.asyncapi.v2._0_0.jackson.model.component;
    exports com.asyncapi.v2._0_0.jackson.model.schema;
    exports com.asyncapi.v2._0_0.model;
    exports com.asyncapi.v2._0_0.model.channel;
    exports com.asyncapi.v2._0_0.model.channel.message;
    exports com.asyncapi.v2._0_0.model.channel.operation;
    exports com.asyncapi.v2._0_0.model.component;
    exports com.asyncapi.v2._0_0.model.info;
    exports com.asyncapi.v2._0_0.model.server;
    exports com.asyncapi.v2._6_0.jackson.model.channel;
    exports com.asyncapi.v2._6_0.jackson.model.channel.message;
    exports com.asyncapi.v2._6_0.jackson.model.channel.operation;
    exports com.asyncapi.v2._6_0.jackson.model.component;
    exports com.asyncapi.v2._6_0.jackson.model.schema;
    exports com.asyncapi.v2._6_0.jackson.model.server;
    exports com.asyncapi.v2._6_0.model;
    exports com.asyncapi.v2._6_0.model.channel;
    exports com.asyncapi.v2._6_0.model.channel.message;
    exports com.asyncapi.v2._6_0.model.channel.operation;
    exports com.asyncapi.v2._6_0.model.component;
    exports com.asyncapi.v2._6_0.model.info;
    exports com.asyncapi.v2._6_0.model.server;

    // Bindings: channels
    exports com.asyncapi.v2.binding.channel;
    exports com.asyncapi.v2.binding.channel.amqp;
    exports com.asyncapi.v2.binding.channel.amqp.queue;
    exports com.asyncapi.v2.binding.channel.amqp.exchange;
    exports com.asyncapi.v2.binding.channel.amqp1;
    exports com.asyncapi.v2.binding.channel.anypointmq;
    exports com.asyncapi.v2.binding.channel.googlepubsub;
    exports com.asyncapi.v2.binding.channel.http;
    exports com.asyncapi.v2.binding.channel.ibmmq;
    exports com.asyncapi.v2.binding.channel.jms;
    exports com.asyncapi.v2.binding.channel.kafka;
    exports com.asyncapi.v2.binding.channel.mercure;
    exports com.asyncapi.v2.binding.channel.mqtt;
    exports com.asyncapi.v2.binding.channel.mqtt5;
    exports com.asyncapi.v2.binding.channel.nats;
    exports com.asyncapi.v2.binding.channel.pulsar;
    exports com.asyncapi.v2.binding.channel.redis;
    exports com.asyncapi.v2.binding.channel.sns;
    exports com.asyncapi.v2.binding.channel.solace;
    exports com.asyncapi.v2.binding.channel.sqs;
    exports com.asyncapi.v2.binding.channel.stomp;
    exports com.asyncapi.v2.binding.channel.ws;

    // Bindings: messages
    exports com.asyncapi.v2.binding.message;
    exports com.asyncapi.v2.binding.message.amqp;
    exports com.asyncapi.v2.binding.message.amqp1;
    exports com.asyncapi.v2.binding.message.anypointmq;
    exports com.asyncapi.v2.binding.message.googlepubsub;
    exports com.asyncapi.v2.binding.message.http;
    exports com.asyncapi.v2.binding.message.ibmmq;
    exports com.asyncapi.v2.binding.message.jms;
    exports com.asyncapi.v2.binding.message.kafka;
    exports com.asyncapi.v2.binding.message.mercure;
    exports com.asyncapi.v2.binding.message.mqtt;
    exports com.asyncapi.v2.binding.message.mqtt5;
    exports com.asyncapi.v2.binding.message.nats;
    exports com.asyncapi.v2.binding.message.pulsar;
    exports com.asyncapi.v2.binding.message.redis;
    exports com.asyncapi.v2.binding.message.sns;
    exports com.asyncapi.v2.binding.message.solace;
    exports com.asyncapi.v2.binding.message.sqs;
    exports com.asyncapi.v2.binding.message.stomp;
    exports com.asyncapi.v2.binding.message.ws;

    // Bindings: operations
    exports com.asyncapi.v2.binding.operation;
    exports com.asyncapi.v2.binding.operation.amqp;
    exports com.asyncapi.v2.binding.operation.amqp1;
    exports com.asyncapi.v2.binding.operation.anypointmq;
    exports com.asyncapi.v2.binding.operation.googlepubsub;
    exports com.asyncapi.v2.binding.operation.http;
    exports com.asyncapi.v2.binding.operation.ibmmq;
    exports com.asyncapi.v2.binding.operation.jms;
    exports com.asyncapi.v2.binding.operation.kafka;
    exports com.asyncapi.v2.binding.operation.mercure;
    exports com.asyncapi.v2.binding.operation.mqtt;
    exports com.asyncapi.v2.binding.operation.mqtt5;
    exports com.asyncapi.v2.binding.operation.nats;
    exports com.asyncapi.v2.binding.operation.pulsar;
    exports com.asyncapi.v2.binding.operation.redis;
    exports com.asyncapi.v2.binding.operation.sns;
    exports com.asyncapi.v2.binding.operation.solace;
    exports com.asyncapi.v2.binding.operation.solace.queue;
    exports com.asyncapi.v2.binding.operation.solace.topic;
    exports com.asyncapi.v2.binding.operation.sqs;
    exports com.asyncapi.v2.binding.operation.stomp;
    exports com.asyncapi.v2.binding.operation.ws;

    // Bindings: servers
    exports com.asyncapi.v2.binding.server;
    exports com.asyncapi.v2.binding.server.amqp;
    exports com.asyncapi.v2.binding.server.amqp1;
    exports com.asyncapi.v2.binding.server.anypointmq;
    exports com.asyncapi.v2.binding.server.googlepubsub;
    exports com.asyncapi.v2.binding.server.http;
    exports com.asyncapi.v2.binding.server.ibmmq;
    exports com.asyncapi.v2.binding.server.jms;
    exports com.asyncapi.v2.binding.server.kafka;
    exports com.asyncapi.v2.binding.server.mercure;
    exports com.asyncapi.v2.binding.server.mqtt;
    exports com.asyncapi.v2.binding.server.mqtt5;
    exports com.asyncapi.v2.binding.server.nats;
    exports com.asyncapi.v2.binding.server.pulsar;
    exports com.asyncapi.v2.binding.server.redis;
    exports com.asyncapi.v2.binding.server.sns;
    exports com.asyncapi.v2.binding.server.solace;
    exports com.asyncapi.v2.binding.server.sqs;
    exports com.asyncapi.v2.binding.server.stomp;
    exports com.asyncapi.v2.binding.server.ws;


    //////////////////////////////////////////////////
    // V3                                           //
    //////////////////////////////////////////////////
    exports com.asyncapi.v3;
    exports com.asyncapi.v3.jackson;
    exports com.asyncapi.v3.jackson.binding.channel;
    exports com.asyncapi.v3.jackson.binding.message;
    exports com.asyncapi.v3.jackson.binding.operation;
    exports com.asyncapi.v3.jackson.binding.server;
    exports com.asyncapi.v3.jackson.schema;
    exports com.asyncapi.v3.jackson.security_scheme;
    exports com.asyncapi.v3.schema;
    exports com.asyncapi.v3.security_scheme;
    exports com.asyncapi.v3.security_scheme.http;
    exports com.asyncapi.v3.security_scheme.oauth2;
    exports com.asyncapi.v3.security_scheme.oauth2.flow;
    exports com.asyncapi.v3._0_0.jackson.model;
    exports com.asyncapi.v3._0_0.jackson.model.channel;
    exports com.asyncapi.v3._0_0.jackson.model.channel.message;
    exports com.asyncapi.v3._0_0.jackson.model.component;
    exports com.asyncapi.v3._0_0.jackson.model.operation;
    exports com.asyncapi.v3._0_0.jackson.model.operation.reply;
    exports com.asyncapi.v3._0_0.jackson.model.server;
    exports com.asyncapi.v3._0_0.model;
    exports com.asyncapi.v3._0_0.model.channel;
    exports com.asyncapi.v3._0_0.model.channel.message;
    exports com.asyncapi.v3._0_0.model.component;
    exports com.asyncapi.v3._0_0.model.info;
    exports com.asyncapi.v3._0_0.model.operation;
    exports com.asyncapi.v3._0_0.model.operation.reply;
    exports com.asyncapi.v3._0_0.model.server;

    // Bindings: channels
    exports com.asyncapi.v3.binding.channel;
    exports com.asyncapi.v3.binding.channel.amqp;
    exports com.asyncapi.v3.binding.channel.amqp.queue;
    exports com.asyncapi.v3.binding.channel.amqp.exchange;
    exports com.asyncapi.v3.binding.channel.amqp1;
    exports com.asyncapi.v3.binding.channel.anypointmq;
    exports com.asyncapi.v3.binding.channel.googlepubsub;
    exports com.asyncapi.v3.binding.channel.http;
    exports com.asyncapi.v3.binding.channel.ibmmq;
    exports com.asyncapi.v3.binding.channel.jms;
    exports com.asyncapi.v3.binding.channel.kafka;
    exports com.asyncapi.v3.binding.channel.mercure;
    exports com.asyncapi.v3.binding.channel.mqtt;
    exports com.asyncapi.v3.binding.channel.mqtt5;
    exports com.asyncapi.v3.binding.channel.nats;
    exports com.asyncapi.v3.binding.channel.pulsar;
    exports com.asyncapi.v3.binding.channel.redis;
    exports com.asyncapi.v3.binding.channel.sns;
    exports com.asyncapi.v3.binding.channel.solace;
    exports com.asyncapi.v3.binding.channel.sqs;
    exports com.asyncapi.v3.binding.channel.stomp;
    exports com.asyncapi.v3.binding.channel.ws;

    // Bindings: messages
    exports com.asyncapi.v3.binding.message;
    exports com.asyncapi.v3.binding.message.amqp;
    exports com.asyncapi.v3.binding.message.amqp1;
    exports com.asyncapi.v3.binding.message.anypointmq;
    exports com.asyncapi.v3.binding.message.googlepubsub;
    exports com.asyncapi.v3.binding.message.http;
    exports com.asyncapi.v3.binding.message.ibmmq;
    exports com.asyncapi.v3.binding.message.jms;
    exports com.asyncapi.v3.binding.message.kafka;
    exports com.asyncapi.v3.binding.message.mercure;
    exports com.asyncapi.v3.binding.message.mqtt;
    exports com.asyncapi.v3.binding.message.mqtt5;
    exports com.asyncapi.v3.binding.message.nats;
    exports com.asyncapi.v3.binding.message.pulsar;
    exports com.asyncapi.v3.binding.message.redis;
    exports com.asyncapi.v3.binding.message.sns;
    exports com.asyncapi.v3.binding.message.solace;
    exports com.asyncapi.v3.binding.message.sqs;
    exports com.asyncapi.v3.binding.message.stomp;
    exports com.asyncapi.v3.binding.message.ws;

    // Bindings: operations
    exports com.asyncapi.v3.binding.operation;
    exports com.asyncapi.v3.binding.operation.amqp;
    exports com.asyncapi.v3.binding.operation.amqp1;
    exports com.asyncapi.v3.binding.operation.anypointmq;
    exports com.asyncapi.v3.binding.operation.googlepubsub;
    exports com.asyncapi.v3.binding.operation.http;
    exports com.asyncapi.v3.binding.operation.ibmmq;
    exports com.asyncapi.v3.binding.operation.jms;
    exports com.asyncapi.v3.binding.operation.kafka;
    exports com.asyncapi.v3.binding.operation.mercure;
    exports com.asyncapi.v3.binding.operation.mqtt;
    exports com.asyncapi.v3.binding.operation.mqtt5;
    exports com.asyncapi.v3.binding.operation.nats;
    exports com.asyncapi.v3.binding.operation.pulsar;
    exports com.asyncapi.v3.binding.operation.redis;
    exports com.asyncapi.v3.binding.operation.sns;
    exports com.asyncapi.v3.binding.operation.solace;
    exports com.asyncapi.v3.binding.operation.solace.queue;
    exports com.asyncapi.v3.binding.operation.solace.topic;
    exports com.asyncapi.v3.binding.operation.sqs;
    exports com.asyncapi.v3.binding.operation.stomp;
    exports com.asyncapi.v3.binding.operation.ws;

    // Bindings: servers
    exports com.asyncapi.v3.binding.server;
    exports com.asyncapi.v3.binding.server.amqp;
    exports com.asyncapi.v3.binding.server.amqp1;
    exports com.asyncapi.v3.binding.server.anypointmq;
    exports com.asyncapi.v3.binding.server.googlepubsub;
    exports com.asyncapi.v3.binding.server.http;
    exports com.asyncapi.v3.binding.server.ibmmq;
    exports com.asyncapi.v3.binding.server.jms;
    exports com.asyncapi.v3.binding.server.kafka;
    exports com.asyncapi.v3.binding.server.mercure;
    exports com.asyncapi.v3.binding.server.mqtt;
    exports com.asyncapi.v3.binding.server.mqtt5;
    exports com.asyncapi.v3.binding.server.nats;
    exports com.asyncapi.v3.binding.server.pulsar;
    exports com.asyncapi.v3.binding.server.redis;
    exports com.asyncapi.v3.binding.server.sns;
    exports com.asyncapi.v3.binding.server.solace;
    exports com.asyncapi.v3.binding.server.sqs;
    exports com.asyncapi.v3.binding.server.stomp;
    exports com.asyncapi.v3.binding.server.ws;
}