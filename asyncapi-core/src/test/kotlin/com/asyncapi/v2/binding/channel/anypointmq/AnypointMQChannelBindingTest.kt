package com.asyncapi.v2.binding.channel.anypointmq

import com.asyncapi.v2.SerDeTest

/**
 * @version 2.6.0
 * @author Pavel Bodiachevskii
 */
class AnypointMQChannelBindingTest: SerDeTest<AnypointMQChannelBinding>() {

    override fun objectClass() = AnypointMQChannelBinding::class.java

    override fun baseObjectJson() = "/json/2.6.0/binding/channel/anypoint/anypointMQChannelBinding.json"

    override fun extendedObjectJson() = "/json/2.6.0/binding/channel/anypoint/anypointMQChannelBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/2.6.0/binding/channel/anypoint/anypointMQChannelBinding - wrongly extended.json"

    override fun build(): AnypointMQChannelBinding {
        return AnypointMQChannelBinding.builder()
                .destination("user-signup-exchg")
                .destinationType("exchange")
                .build()
    }

}