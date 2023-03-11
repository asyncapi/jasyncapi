package com.asyncapi.v2.binding.operation.amqp

import com.asyncapi.v2.SerDeTest

class AMQPOperationBindingTest: SerDeTest<AMQPOperationBinding>() {

    override fun objectClass() = AMQPOperationBinding::class.java

    override fun baseObjectJson() = "/json/2.6.0/binding/operation/amqp/amqpOperationBinding.json"

    override fun extendedObjectJson() = "/json/2.6.0/binding/operation/amqp/amqpOperationBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/2.6.0/binding/operation/amqp/amqpOperationBinding - wrongly extended.json"

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