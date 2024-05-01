package com.asyncapi.examples.v2._6_0

import com.asyncapi.schemas.Reference
import com.asyncapi.v2._6_0.model.channel.ChannelItem
import com.asyncapi.v2._6_0.model.channel.message.Message
import com.asyncapi.v2._6_0.model.channel.message.OneOfMessages
import com.asyncapi.v2._6_0.model.channel.operation.Operation
import com.asyncapi.v2._6_0.model.component.Components
import com.asyncapi.v2._6_0.model.info.Info
import com.asyncapi.schemas.AsyncAPISchema

class OneOf: AbstractExampleValidationTest() {

    override fun specificationLocation(): String = "/examples/v2.6.0/oneof.yml"

    override fun expectedInfo(): Info {
        return Info.builder()
                .title("OneOf example")
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
                ),
                Pair("test2", ChannelItem.builder()
                        .subscribe(Operation.builder()
                                .message(OneOfMessages(listOf(
                                        Message.builder()
                                                .payload(AsyncAPISchema.builder().ref("#/components/schemas/objectWithKey").build())
                                                .build(),
                                        Message.builder()
                                                .payload(AsyncAPISchema.builder().ref("#/components/schemas/objectWithKey2").build())
                                                .build(),
                                )))
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
                                        .oneOf(listOf(
                                                AsyncAPISchema.builder().ref("#/components/schemas/objectWithKey").build(),
                                                AsyncAPISchema.builder().ref("#/components/schemas/objectWithKey2").build()
                                        ))
                                        .build()
                                )
                                .build()
                        ),
                        Pair("testMessage1", Message.builder()
                                .payload(AsyncAPISchema.builder().ref("#/components/schemas/objectWithKey").build())
                                .build()
                        ),
                        Pair("testMessage2", Message.builder()
                                .payload(AsyncAPISchema.builder().ref("#/components/schemas/objectWithKey2").build())
                                .build()
                        )
                ))
                .schemas(mapOf(
                        Pair("objectWithKey", AsyncAPISchema.builder()
                                .type("object")
                                .properties(mapOf(
                                        Pair("key", AsyncAPISchema.builder()
                                                .type("string")
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