package com.asyncapi.v2.binding.channel.ibmmq

import com.asyncapi.v2.SerDeTest
import com.asyncapi.v2.binding.channel.ibmmq.IBMMQChannelBinding.Topic

class IBMMQChannelBindingTest: SerDeTest<IBMMQChannelBinding>() {

    override fun objectClass() = IBMMQChannelBinding::class.java

    override fun baseObjectJson() = "/json/2.6.0/binding/channel/ibmmq/ibmMQChannelBinding.json"

    override fun extendedObjectJson() = "/json/2.6.0/binding/channel/ibmmq/ibmMQChannelBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/2.6.0/binding/channel/ibmmq/ibmMQChannelBinding - wrongly extended.json"

    override fun build(): IBMMQChannelBinding {
        return IBMMQChannelBinding.builder()
                .destinationType("topic")
                .queue(IBMMQChannelBinding.Queue.builder()
                        .objectName("message")
                        .isPartitioned(false)
                        .exclusive(true)
                        .build()
                )
                .topic(Topic.builder()
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