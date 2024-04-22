package com.asyncapi.v3.binding.message.ibmmq

import com.asyncapi.v3.SerDeTest
import com.asyncapi.bindings.ibmmq.v0._1_0.message.IBMMQMessageBinding
import com.asyncapi.bindings.ibmmq.v0._1_0.message.IBMMQMessageType

class IBMMQMessageBindingTest: SerDeTest<IBMMQMessageBinding>() {

    override fun objectClass() = IBMMQMessageBinding::class.java

    override fun baseObjectJson() = "/json/v3/binding/message/ibmmq/ibmMQMessageBinding.json"

    override fun extendedObjectJson() = "/json/v3/binding/message/ibmmq/ibmMQMessageBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v3/binding/message/ibmmq/ibmMQMessageBinding - wrongly extended.json"

    override fun build(): IBMMQMessageBinding {
        return IBMMQMessageBinding.builder()
                .type(IBMMQMessageType.JMS)
                .description("JMS stream message")
                .headers("Content-Type: application/json")
                .expiry(0)
                .build()
    }

}