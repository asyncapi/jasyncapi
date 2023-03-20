package com.asyncapi.v2.binding.message.ibmmq

import com.asyncapi.v2.SerDeTest

class IBMMQMessageBindingTest: SerDeTest<IBMMQMessageBinding>() {

    override fun objectClass() = IBMMQMessageBinding::class.java

    override fun baseObjectJson() = "/json/binding/message/ibmmq/ibmMQMessageBinding.json"

    override fun extendedObjectJson() = "/json/binding/message/ibmmq/ibmMQMessageBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/binding/message/ibmmq/ibmMQMessageBinding - wrongly extended.json"

    override fun build(): IBMMQMessageBinding {
        return IBMMQMessageBinding.builder()
                .type(IBMMQMessageType.JMS)
                .description("JMS stream message")
                .headers("Content-Type: application/json")
                .expiry(0)
                .build()
    }

}