package com.asyncapi.examples.v2._6_0

import com.asyncapi.schemas.asyncapi.Reference
import com.asyncapi.v2._6_0.model.channel.ChannelItem
import com.asyncapi.v2._6_0.model.channel.message.Message
import com.asyncapi.v2._6_0.model.channel.operation.Operation
import com.asyncapi.v2._6_0.model.component.Components
import com.asyncapi.v2._6_0.model.info.Info
import com.asyncapi.schemas.asyncapi.AsyncAPISchema

class Not: AbstractExampleValidationTest() {

    override fun specificationLocation(): String = "/examples/v2.6.0/not.yml"

    override fun expectedInfo(): Info {
        return Info.builder()
                .title("Not example")
                .version("1.0.0")
                .build()
    }

    override fun expectedServers(): Map<String, Any>? = null

    override fun expectedChannels(): Map<String, Any> {
        return mapOf(
                Pair("test", ChannelItem.builder()
                        .publish(Operation.builder()
                                .message(Reference("#/components/messages/testMessages"))
                                .build()
                        )
                        .build()
                )
        )
    }

    override fun expectedComponents(): Components? {
        return Components.builder()
                .messages(mapOf(
                        Pair("testMessages", Message.builder()
                                .payload(Reference("#/components/schemas/testSchema"))
                                .build()
                        )
                ))
                .schemas(mapOf(
                        Pair("testSchema", AsyncAPISchema.builder()
                                .type("object")
                                .properties(mapOf(
                                        Pair("key", AsyncAPISchema.builder()
                                                .not(AsyncAPISchema.builder().type("integer").build())
                                                .build()
                                        )
                                ))
                                .build()
                        )
                ))
                .build()
    }

}