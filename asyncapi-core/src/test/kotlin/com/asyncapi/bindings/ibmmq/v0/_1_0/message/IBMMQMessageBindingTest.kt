package com.asyncapi.bindings.ibmmq.v0._1_0.message

import com.asyncapi.v3.SerDeTest

class IBMMQMessageBindingTest: SerDeTest<IBMMQMessageBinding>() {

    override fun objectClass() = IBMMQMessageBinding::class.java

    override fun baseObjectJson() = "/bindings/ibmmq/message/ibmMQMessageBinding.json"

    override fun extendedObjectJson() = "/bindings/ibmmq/message/ibmMQMessageBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/bindings/ibmmq/message/ibmMQMessageBinding - wrongly extended.json"

    override fun build(): IBMMQMessageBinding {
        return IBMMQMessageBinding.builder()
                .type(IBMMQMessageType.JMS)
                .description("JMS stream message")
                .headers("Content-Type: application/json")
                .expiry(0)
                .build()
    }

}