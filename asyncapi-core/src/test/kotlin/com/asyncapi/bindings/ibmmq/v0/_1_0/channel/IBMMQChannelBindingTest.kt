package com.asyncapi.bindings.ibmmq.v0._1_0.channel

import com.asyncapi.v3.SerDeTest

class IBMMQChannelBindingTest: SerDeTest<IBMMQChannelBinding>() {

    override fun objectClass() = IBMMQChannelBinding::class.java

    override fun baseObjectJson() = "/bindings/ibmmq/channel/ibmMQChannelBinding.json"

    override fun extendedObjectJson() = "/bindings/ibmmq/channel/ibmMQChannelBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/bindings/ibmmq/channel/ibmMQChannelBinding - wrongly extended.json"

    override fun build(): IBMMQChannelBinding {
        return IBMMQChannelBinding.builder()
                .destinationType(IBMMQChannelDestinationType.TOPIC)
                .queue(IBMMQChannelQueueProperties.builder()
                        .objectName("message")
                        .isPartitioned(false)
                        .exclusive(true)
                        .build()
                )
                .topic(IBMMQChannelTopicProperties.builder()
                        .string("messages")
                        .objectName("message")
                        .durablePermitted(true)
                        .lastMsgRetained(true)
                        .build()
                )
                .maxMsgLength(1024)
                .build()
    }

}