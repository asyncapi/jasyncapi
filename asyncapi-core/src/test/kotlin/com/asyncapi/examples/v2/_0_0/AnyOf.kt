package com.asyncapi.examples.v2._0_0

import com.asyncapi.schemas.Reference
import com.asyncapi.v2._0_0.model.channel.ChannelItem
import com.asyncapi.v2._0_0.model.channel.message.Message
import com.asyncapi.v2._0_0.model.channel.operation.Operation
import com.asyncapi.v2._0_0.model.component.Components
import com.asyncapi.v2._0_0.model.info.Info
import com.asyncapi.schemas.AsyncAPISchema

class AnyOf: AbstractExampleValidationTest() {

    override fun specificationLocation(): String = "/examples/v2.0.0/anyof.yml"

    override fun expectedInfo(): Info {
        return Info.builder()
                .title("AnyOf example")
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
                                .payload(AsyncAPISchema.builder()
                                        .anyOf(listOf(
                                                AsyncAPISchema.builder().ref("#/components/schemas/objectWithKey").build(),
                                                AsyncAPISchema.builder().ref("#/components/schemas/objectWithKey2").build(),
                                        ))
                                        .build()
                                )
                                .build()
                        )
                ))
                .schemas(mapOf(
                        Pair("objectWithKey", AsyncAPISchema.builder()
                                .type("object")
                                .properties(mapOf(
                                        Pair("key", AsyncAPISchema.builder()
                                                .type("string")
                                                .additionalProperties(false)
                                                .build()
                                        )
                                ))
                                .build()
                        ),
                        Pair("objectWithKey2", AsyncAPISchema.builder()
                                .type("object")
                                .properties(mapOf(
                                        Pair("key2", AsyncAPISchema.builder()
                                                .type("string")
                                                .build()
                                        )
                                ))
                                .build()
                        )
                ))
                .build()
    }

}