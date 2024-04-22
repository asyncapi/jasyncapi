package com.asyncapi.bindings.anypointmq.v0._0_1.channel

import com.asyncapi.v3.SerDeTest

/**
 * @version 3.0.0
 * @author Pavel Bodiachevskii
 */
class AnypointMQChannelBindingTest: SerDeTest<AnypointMQChannelBinding>() {

    override fun objectClass() = AnypointMQChannelBinding::class.java

    override fun baseObjectJson() = "/json/v3/binding/channel/anypoint/anypointMQChannelBinding.json"

    override fun extendedObjectJson() = "/json/v3/binding/channel/anypoint/anypointMQChannelBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v3/binding/channel/anypoint/anypointMQChannelBinding - wrongly extended.json"

    override fun build(): AnypointMQChannelBinding {
        return AnypointMQChannelBinding.builder()
                .destination("user-signup-exchg")
                .destinationType(AnypointMQChannelDestinationType.EXCHANGE)
                .build()
    }

}