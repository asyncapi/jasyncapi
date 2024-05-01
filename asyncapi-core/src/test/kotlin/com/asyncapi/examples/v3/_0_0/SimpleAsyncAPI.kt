package com.asyncapi.examples.v3._0_0

import com.asyncapi.schemas.Reference
import com.asyncapi.v3._0_0.model.channel.Channel
import com.asyncapi.v3._0_0.model.channel.message.Message
import com.asyncapi.v3._0_0.model.component.Components
import com.asyncapi.v3._0_0.model.info.Info
import com.asyncapi.v3._0_0.model.operation.Operation
import com.asyncapi.v3._0_0.model.operation.OperationAction
import com.asyncapi.schemas.AsyncAPISchema

class SimpleAsyncAPI: AbstractExampleValidationTest() {

    override fun specificationLocation(): String = "/examples/v3.0.0/simple-asyncapi.yml"

    override fun expectedInfo(): Info {
        return Info.builder()
                .title("Account Service")
                .version("1.0.0")
                .description("This service is in charge of processing user signups")
                .build()
    }

    override fun expectedServers(): Map<String, Any> = emptyMap()

    override fun expectedChannels(): Map<String, Any> {
        return mapOf(
                Pair("userSignedup",
                        Channel.builder()
                                .address("user/signedup")
                                .messages(mapOf(
                                        Pair("UserSignedUp",
                                            Reference("#/components/messages/UserSignedUp")
                                        )
                                ))
                                .build()
                )
        )
    }

    override fun expectedOperations(): Map<String, Any> {
        return mapOf(
                Pair("sendUserSignedup",
                        Operation.builder()
                                .action(OperationAction.SEND)
                                .channel(Reference("#/channels/userSignedup"))
                                .messages(listOf(
                                    Reference("#/channels/userSignedup/messages/UserSignedUp")
                                ))
                                .build()
                )
        )
    }

    override fun expectedComponents(): Components {
        return Components.builder()
                .messages(mapOf(
                        Pair("UserSignedUp",
                                Message.builder()
                                        .payload(
                                            AsyncAPISchema.builder()
                                                .type("object")
                                                .properties(mapOf(
                                                        Pair("displayName",
                                                                AsyncAPISchema.builder()
                                                                        .type("string")
                                                                        .description("Name of the user")
                                                                        .build()
                                                        ),
                                                        Pair("email",
                                                                AsyncAPISchema.builder()
                                                                        .type("string")
                                                                        .format("email")
                                                                        .description("Email of the user")
                                                                        .build()
                                                        )
                                                ))
                                                .build()
                                        )
                                        .build()
                        )
                ))
                .build()
    }

}