package com.asyncapi.examples.v2._6_0

import com.asyncapi.v2.Reference
import com.asyncapi.v2._6_0.model.channel.ChannelItem
import com.asyncapi.v2._6_0.model.channel.message.Message
import com.asyncapi.v2._6_0.model.channel.operation.Operation
import com.asyncapi.v2._6_0.model.component.Components
import com.asyncapi.v2._6_0.model.info.Info
import com.asyncapi.v2.schema.Schema

class AnyOf: AbstractExampleValidationTest() {

    override fun specificationLocation(): String = "/examples/v2.6.0/anyof.yml"

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
                                .payload(Schema.builder()
                                        .anyOf(listOf(
                                                Schema.builder().ref("#/components/schemas/objectWithKey").build(),
                                                Schema.builder().ref("#/components/schemas/objectWithKey2").build(),
                                        ))
                                        .build()
                                )
                                .build()
                        )
                ))
                .schemas(mapOf(
                        Pair("objectWithKey", Schema.builder()
                                .type("object")
                                .properties(mapOf(
                                        Pair("key", Schema.builder()
                                                .type("string")
                                                .additionalProperties(false)
                                                .build()
                                        )
                                ))
                                .build()
                        ),
                        Pair("objectWithKey2", Schema.builder()
                                .type("object")
                                .properties(mapOf(
                                        Pair("key2", Schema.builder()
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