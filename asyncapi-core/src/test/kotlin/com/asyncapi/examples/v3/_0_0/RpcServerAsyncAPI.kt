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
import com.asyncapi.v3.schema.AsyncAPISchema

class RpcServerAsyncAPI: AbstractExampleValidationTest() {

    override fun specificationLocation(): String = "/examples/v3.0.0/rpc-server-asyncapi.yml"

    override fun expectedId(): String = "urn:example:rpcserver"

    override fun expectedInfo(): Info {
        return Info.builder()
                .title("RPC Server Example")
                .version("1.0.0")
                .description("This example demonstrates how to define an RPC server.")
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
                                        Pair("sendSumResult",
                                                Message.builder()
                                                        .correlationId(CorrelationId(null, "\$message.header#/correlation_id"))
                                                        .payload(AsyncAPISchema.builder()
                                                                .type("object")
                                                                .properties(mapOf(
                                                                        Pair("result", AsyncAPISchema.builder()
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
                                        Pair("sum",
                                                Message.builder()
                                                        .correlationId(CorrelationId(null, "\$message.header#/correlation_id"))
                                                        .payload(AsyncAPISchema.builder()
                                                                .type("object")
                                                                .properties(mapOf(
                                                                        Pair("numbers", AsyncAPISchema.builder()
                                                                                .type("array")
                                                                                .items(AsyncAPISchema.builder()
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
                Pair("sendSumResult",
                        Operation.builder()
                                .action(OperationAction.SEND)
                                .channel(Reference("#/channels/queue"))
                                .bindings(mapOf(
                                        Pair("amqp",
                                                AMQPOperationBinding.builder()
                                                        .ack(true)
                                                        .build()
                                        )
                                ))
                                .messages(listOf(
                                        Reference("#/channels/queue/messages/sendSumResult")
                                ))
                                .build()
                ),
                Pair("sum",
                        Operation.builder()
                                .action(OperationAction.RECEIVE)
                                .channel(Reference("#/channels/rpc_queue"))
                                .messages(listOf(
                                        Reference("#/channels/rpc_queue/messages/sum")
                                ))
                                .build()
                )
        )
    }

    override fun expectedComponents(): Components? = null

}