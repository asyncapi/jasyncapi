package com.asyncapi.v3.binding.message.anypointmq

import com.asyncapi.v3.SerDeTest
import com.asyncapi.v3.schema.Schema
import com.asyncapi.v3.schema.Type

class AnypointMQMessageBindingTest: SerDeTest<AnypointMQMessageBinding>() {

    override fun objectClass() = AnypointMQMessageBinding::class.java

    override fun baseObjectJson() = "/json/v3/binding/message/anypointmq/anypointMQMessageBinding.json"

    override fun extendedObjectJson() = "/json/v3/binding/message/anypointmq/anypointMQMessageBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v3/binding/message/anypointmq/anypointMQMessageBinding - wrongly extended.json"

    override fun build(): AnypointMQMessageBinding {
        return AnypointMQMessageBinding.builder()
                .headers(Schema.builder()
                        .type(Type.OBJECT)
                        .properties(mapOf(
                                Pair(
                                        "correlationId",
                                        Schema.builder()
                                                .type(Type.STRING)
                                                .description("Correlation ID set by application")
                                                .build()
                                )
                        ))
                        .build())
                .build()
    }

}