package com.asyncapi.examples.v2._6_0

import com.asyncapi.v2.Reference
import com.asyncapi.v2._6_0.model.channel.ChannelItem
import com.asyncapi.v2._6_0.model.channel.message.Message
import com.asyncapi.v2._6_0.model.channel.operation.Operation
import com.asyncapi.v2._6_0.model.component.Components
import com.asyncapi.v2._6_0.model.info.Info
import com.asyncapi.v2.schema.Schema

class Simple: AbstractExampleValidationTest() {

    override fun specificationLocation(): String = "/examples/v2.6.0/simple.yml"

    override fun expectedInfo(): Info {
        return Info.builder()
                .title("Account Service")
                .version("1.0.0")
                .description("This service is in charge of processing user signups")
                .build()
    }

    override fun expectedServers(): Map<String, Any>? = null

    override fun expectedChannels(): Map<String, Any> {
        return mapOf(
                Pair("user/signedup", ChannelItem.builder()
                        .subscribe(Operation.builder()
                                .message(Reference("#/components/messages/UserSignedUp"))
                                .build()
                        )
                        .build()
                ),
        )
    }

    override fun expectedComponents(): Components {
        return Components.builder()
                .messages(mapOf(
                        Pair("UserSignedUp", Message.builder()
                                .payload(Schema.builder()
                                        .type("object")
                                        .properties(mapOf(
                                                Pair("displayName", Schema.builder()
                                                        .type("string")
                                                        .description("Name of the user")
                                                        .build()
                                                ),
                                                Pair("email", Schema.builder()
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