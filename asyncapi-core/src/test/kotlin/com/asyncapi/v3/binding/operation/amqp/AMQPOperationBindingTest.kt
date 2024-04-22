package com.asyncapi.v3.binding.operation.amqp

import com.asyncapi.v3.SerDeTest
import com.asyncapi.bindings.amqp.v0._2_0.operation.AMQPOperationBinding

class AMQPOperationBindingTest: SerDeTest<AMQPOperationBinding>() {

    override fun objectClass() = AMQPOperationBinding::class.java

    override fun baseObjectJson() = "/json/v3/binding/operation/amqp/amqpOperationBinding.json"

    override fun extendedObjectJson() = "/json/v3/binding/operation/amqp/amqpOperationBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v3/binding/operation/amqp/amqpOperationBinding - wrongly extended.json"

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