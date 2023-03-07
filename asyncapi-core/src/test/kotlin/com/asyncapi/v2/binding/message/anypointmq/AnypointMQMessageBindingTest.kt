package com.asyncapi.v2.binding.message.anypointmq

import com.asyncapi.v2.SerDeTest

class AnypointMQMessageBindingTest: SerDeTest<AnypointMQMessageBinding>() {

    override fun objectClass() = AnypointMQMessageBinding::class.java

    override fun baseObjectJson() = "/json/2.6.0/binding/message/anypointmq/anypointMQMessageBinding.json"

    override fun extendedObjectJson() = "/json/2.6.0/binding/message/anypointmq/anypointMQMessageBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/2.6.0/binding/message/anypointmq/anypointMQMessageBinding - wrongly extended.json"

    override fun build(): AnypointMQMessageBinding {
        return AnypointMQMessageBinding.builder()
                .headers(mapOf(
                        Pair("type", "object"),
                        Pair("properties", mapOf(

                                Pair("correlationId", mapOf(
                                        Pair("description", "Correlation ID set by application"),
                                        Pair("type", "string")
                                ))
                        ))
                ))
                .build()
    }

}