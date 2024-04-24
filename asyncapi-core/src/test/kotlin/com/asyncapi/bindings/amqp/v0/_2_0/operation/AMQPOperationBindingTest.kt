package com.asyncapi.bindings.amqp.v0._2_0.operation

import com.asyncapi.v3.SerDeTest

class AMQPOperationBindingTest: SerDeTest<AMQPOperationBinding>() {

    override fun objectClass() = AMQPOperationBinding::class.java

    override fun baseObjectJson() = "/bindings/amqp/operation/amqpOperationBinding.json"

    override fun extendedObjectJson() = "/bindings/amqp/operation/amqpOperationBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/bindings/amqp/operation/amqpOperationBinding - wrongly extended.json"

    override fun build(): AMQPOperationBinding {
        return AMQPOperationBinding.builder()
                .expiration(100_000)
                .userId("guest")
                .cc(listOf("user.logs"))
                .priority(10)
                .deliveryMode(2)
                .mandatory(false)
                .bcc(listOf("external.audit"))
                .replyTo("user.signedup")
                .timestamp(true)
                .ack(false)
                .build()
    }

}