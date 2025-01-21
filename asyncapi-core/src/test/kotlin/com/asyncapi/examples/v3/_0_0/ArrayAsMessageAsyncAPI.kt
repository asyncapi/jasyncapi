package com.asyncapi.examples.v3._0_0

import com.asyncapi.schemas.asyncapi.Reference
import com.asyncapi.v3._0_0.model.channel.Channel
import com.asyncapi.v3._0_0.model.channel.message.Message
import com.asyncapi.v3._0_0.model.component.Components
import com.asyncapi.v3._0_0.model.info.Info
import com.asyncapi.v3._0_0.model.operation.Operation
import com.asyncapi.v3._0_0.model.operation.OperationAction
import com.asyncapi.schemas.asyncapi.AsyncAPISchema
import com.asyncapi.v3._0_0.model.channel.message.MessageExample

class ArrayAsMessageAsyncAPI: AbstractExampleValidationTest() {

    override fun specificationLocation(): String = "/examples/v3.0.0/message-of-array-type-asyncapi.yml"

    override fun expectedInfo(): Info {
        return Info.builder()
                .title("Message of array type example")
                .version("1.0.0")
                .build()
    }

    override fun expectedServers(): Map<String, Any> = emptyMap()

    override fun expectedChannels(): Map<String, Any> {
        return mapOf(
                Pair("test",
                        Channel.builder()
                                .address("test")
                                .messages(mapOf(
                                        Pair("testMessages",
                                            Reference("#/components/messages/testMessages")
                                        )
                                ))
                                .build()
                )
        )
    }

    override fun expectedOperations(): Map<String, Any> {
        return mapOf(
                Pair("onTestMsg",
                        Operation.builder()
                                .action(OperationAction.RECEIVE)
                                .channel(Reference("#/channels/test"))
                                .messages(listOf(Reference("#/channels/test/messages/testMessages")))
                                .build()
                )
        )
    }

    override fun expectedComponents(): Components {
        return Components.builder()
                .messages(mapOf(
                        Pair("testMessages",
                                Message.builder()
                                        .payload(
                                            Reference("#/components/schemas/objectWithKeyArray")
                                        )
                                        .examples(
                                            listOf(
                                                MessageExample.builder().name("example1").payload(
                                                    listOf(
                                                        mapOf("key" to "value1"),
                                                        mapOf("key" to "value2")
                                                    )
                                                ).build(),
                                                MessageExample.builder().name("example2").payload(
                                                    listOf(
                                                        mapOf("key" to "value3")
                                                    )
                                                ).build()
                                            )
                                        )
                                        .build()
                        )
                ))
                .schemas(mapOf(
                    Pair(
                        "objectWithKeyArray", AsyncAPISchema.builder()
                            .type("array")
                            .items(
                                AsyncAPISchema.builder()
                                    .type("object")
                                    .properties(
                                        mapOf(
                                            Pair("key", AsyncAPISchema.builder().type("string").build())
                                        )
                                    )
                                    .build()
                            )
                            .build()
                    )
                ))
                .build()
    }

}

