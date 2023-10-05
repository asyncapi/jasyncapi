package com.asyncapi.v3.binding.channel.ibmmq

import com.asyncapi.v3.SerDeTest

class IBMMQChannelBindingTest: SerDeTest<IBMMQChannelBinding>() {

    override fun objectClass() = IBMMQChannelBinding::class.java

    override fun baseObjectJson() = "/json/v3/binding/channel/ibmmq/ibmMQChannelBinding.json"

    override fun extendedObjectJson() = "/json/v3/binding/channel/ibmmq/ibmMQChannelBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v3/binding/channel/ibmmq/ibmMQChannelBinding - wrongly extended.json"

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