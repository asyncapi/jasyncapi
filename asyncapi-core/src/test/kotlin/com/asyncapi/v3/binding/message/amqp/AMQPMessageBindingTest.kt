package com.asyncapi.v3.binding.message.amqp

import com.asyncapi.v3.SerDeTest

class AMQPMessageBindingTest: SerDeTest<AMQPMessageBinding>() {

    override fun objectClass() = AMQPMessageBinding::class.java

    override fun baseObjectJson() = "/json/v3/binding/message/amqp/amqpMessageBinding.json"

    override fun extendedObjectJson() = "/json/v3/binding/message/amqp/amqpMessageBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v3/binding/message/amqp/amqpMessageBinding - wrongly extended.json"

    override fun build(): AMQPMessageBinding {
        return AMQPMessageBinding.builder()
                .contentEncoding("gzip")
                .messageType("user.signup")
                .build()
    }

}