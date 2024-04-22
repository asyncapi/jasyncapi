package com.asyncapi.v2.binding.channel.ibmmq

import com.asyncapi.v2.SerDeTest
import com.asyncapi.bindings.ibmmq.v0._1_0.channel.IBMMQChannelBinding
import com.asyncapi.bindings.ibmmq.v0._1_0.channel.IBMMQChannelDestinationType
import com.asyncapi.bindings.ibmmq.v0._1_0.channel.IBMMQChannelQueueProperties
import com.asyncapi.bindings.ibmmq.v0._1_0.channel.IBMMQChannelTopicProperties

class IBMMQChannelBindingTest: SerDeTest<IBMMQChannelBinding>() {

    override fun objectClass() = IBMMQChannelBinding::class.java

    override fun baseObjectJson() = "/json/v2/binding/channel/ibmmq/ibmMQChannelBinding.json"

    override fun extendedObjectJson() = "/json/v2/binding/channel/ibmmq/ibmMQChannelBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v2/binding/channel/ibmmq/ibmMQChannelBinding - wrongly extended.json"

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