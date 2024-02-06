package com.asyncapi.examples.v3._0_0

import com.asyncapi.v3.Reference
import com.asyncapi.v3._0_0.model.channel.Channel
import com.asyncapi.v3._0_0.model.channel.Parameter
import com.asyncapi.v3._0_0.model.channel.message.CorrelationId
import com.asyncapi.v3._0_0.model.channel.message.Message
import com.asyncapi.v3._0_0.model.component.Components
import com.asyncapi.v3._0_0.model.info.Info
import com.asyncapi.v3._0_0.model.operation.Operation
import com.asyncapi.v3._0_0.model.operation.OperationAction
import com.asyncapi.v3._0_0.model.server.Server
import com.asyncapi.v3.binding.channel.amqp.AMQPChannelBinding
import com.asyncapi.v3.binding.channel.amqp.AMQPChannelType
import com.asyncapi.v3.binding.channel.amqp.queue.AMQPChannelQueueProperties
import com.asyncapi.v3.binding.operation.amqp.AMQPOperationBinding
import com.asyncapi.v3.schema.Schema

class RpcClientAsyncAPI: AbstractExampleValidationTest() {

    override fun specificationLocation(): String = "/examples/v3.0.0/rpc-client-asyncapi.yml"

    override fun expectedId(): String = "urn:example:rpcclient"

    override fun expectedInfo(): Info {
        return Info.builder()
                .title("RPC Client Example")
                .version("1.0.0")
                .description("This example demonstrates how to define an RPC client.")
                .build()
    }

    override fun expectedDefaultContentType(): String = "application/json"

    override fun expectedServers(): Map<String, Any> {
        return mapOf(
                Pair("production", Server.builder()
                        .host("rabbitmq.example.org")
                        .protocol("amqp")
                        .build()
                )
        )
    }

    override fun expectedChannels(): Map<String, Any> {
        return mapOf(
                Pair("queue",
                        Channel.builder()
                                .address("{queue}")
                                .messages(mapOf(
                                        Pair("receiveSumResult",
                                                Message.builder()
                                                        .correlationId(CorrelationId(null, "\$message.header#/correlation_id"))
                                                        .payload(Schema.builder()
                                                                .type("object")
                                                                .properties(mapOf(
                                                                        Pair("result", Schema.builder()
                                                                                .type("number")
                                                                                .examples(listOf(7))
                                                                                .build()
                                                                        )
                                                                ))
                                                                .build()
                                                        )
                                                        .build()
                                        )
                                ))
                                .parameters(mapOf(
                                        Pair("queue", Parameter())
                                ))
                                .bindings(mapOf(
                                        Pair("amqp",
                                                AMQPChannelBinding.builder()
                                                        .`is`(AMQPChannelType.QUEUE)
                                                        .queue(AMQPChannelQueueProperties.builder()
                                                                .exclusive(true)
                                                                .build()
                                                        )
                                                        .build()
                                        )
                                ))
                                .build()
                ),
                Pair("rpc_queue",
                        Channel.builder()
                                .address("rpc_queue")
                                .messages(mapOf(
                                        Pair("requestSum",
                                                Message.builder()
                                                        .correlationId(CorrelationId(null, "\$message.header#/correlation_id"))
                                                        .payload(Schema.builder()
                                                                .type("object")
                                                                .properties(mapOf(
                                                                        Pair("numbers", Schema.builder()
                                                                                .type("array")
                                                                                .items(Schema.builder()
                                                                                        .type("number")
                                                                                        .build()
                                                                                )
                                                                                .examples(listOf(listOf(4, 3)))
                                                                                .build()
                                                                        )
                                                                ))
                                                                .build()
                                                        )
                                                        .build()
                                        )
                                ))
                                .bindings(mapOf(
                                        Pair("amqp",
                                                AMQPChannelBinding.builder()
                                                        .`is`(AMQPChannelType.QUEUE)
                                                        .queue(AMQPChannelQueueProperties.builder()
                                                                .durable(false)
                                                                .build()
                                                        )
                                                        .build()
                                        )
                                ))
                                .build()
                )
        )
    }

    override fun expectedOperations(): Map<String, Any> {
        return mapOf(
                Pair("receiveSumResult",
                        Operation.builder()
                                .action(OperationAction.RECEIVE)
                                .channel(Reference("#/channels/queue"))
                                .bindings(mapOf(
                                        Pair("amqp",
                                                AMQPOperationBinding.builder()
                                                        .ack(false)
                                                        .build()
                                        )
                                ))
                                .messages(listOf(
                                        Reference("#/channels/queue/messages/receiveSumResult")
                                ))
                                .build()
                ),
                Pair("requestSum",
                        Operation.builder()
                                .action(OperationAction.SEND)
                                .channel(Reference("#/channels/rpc_queue"))
                                .bindings(mapOf(
                                        Pair("amqp",
                                                AMQPOperationBinding.builder()
                                                        .ack(true)
                                                        .build()
                                        )
                                ))
                                .messages(listOf(
                                        Reference("#/channels/rpc_queue/messages/requestSum")
                                ))
                                .build()
                )
        )
    }

    override fun expectedComponents(): Components? = null

}