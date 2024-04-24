package com.asyncapi.bindings.anypointmq.v0._0_1.message

import com.asyncapi.v3.SerDeTest
import com.asyncapi.v3.schema.AsyncAPISchema
import com.asyncapi.v3.schema.Type

class AnypointMQMessageBindingTest: SerDeTest<AnypointMQMessageBinding>() {

    override fun objectClass() = AnypointMQMessageBinding::class.java

    override fun baseObjectJson() = "/bindings/anypointmq/message/anypointMQMessageBinding.json"

    override fun extendedObjectJson() = "/bindings/anypointmq/message/anypointMQMessageBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/bindings/anypointmq/message/anypointMQMessageBinding - wrongly extended.json"

    override fun build(): AnypointMQMessageBinding {
        return AnypointMQMessageBinding.builder()
                .headers(AsyncAPISchema.builder()
                        .type(Type.OBJECT)
                        .properties(mapOf(
                                Pair(
                                        "correlationId",
                                        AsyncAPISchema.builder()
                                                .type(Type.STRING)
                                                .description("Correlation ID set by application")
                                                .build()
                                )
                        ))
                        .build())
                .build()
    }

}