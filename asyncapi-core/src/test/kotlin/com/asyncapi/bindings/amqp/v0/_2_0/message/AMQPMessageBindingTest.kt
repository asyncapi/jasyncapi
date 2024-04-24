package com.asyncapi.bindings.amqp.v0._2_0.message

import com.asyncapi.v3.SerDeTest

class AMQPMessageBindingTest: SerDeTest<AMQPMessageBinding>() {

    override fun objectClass() = AMQPMessageBinding::class.java

    override fun baseObjectJson() = "/bindings/amqp/message/amqpMessageBinding.json"

    override fun extendedObjectJson() = "/bindings/amqp/message/amqpMessageBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/bindings/amqp/message/amqpMessageBinding - wrongly extended.json"

    override fun build(): AMQPMessageBinding {
        return AMQPMessageBinding.builder()
                .contentEncoding("gzip")
                .messageType("user.signup")
                .build()
    }

}