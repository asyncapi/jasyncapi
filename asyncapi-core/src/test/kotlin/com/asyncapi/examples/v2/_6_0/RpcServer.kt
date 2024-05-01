package com.asyncapi.examples.v2._6_0

import com.asyncapi.v2._6_0.model.channel.ChannelItem
import com.asyncapi.v2._6_0.model.channel.Parameter
import com.asyncapi.v2._6_0.model.channel.message.CorrelationId
import com.asyncapi.v2._6_0.model.channel.message.Message
import com.asyncapi.v2._6_0.model.channel.operation.Operation
import com.asyncapi.v2._6_0.model.component.Components
import com.asyncapi.v2._6_0.model.info.Info
import com.asyncapi.v2._6_0.model.server.Server
import com.asyncapi.bindings.amqp.v0._3_0.channel.AMQPChannelBinding
import com.asyncapi.bindings.amqp.v0._3_0.channel.AMQPChannelType
import com.asyncapi.bindings.amqp.v0._3_0.channel.queue.AMQPChannelQueueProperties
import com.asyncapi.bindings.amqp.v0._3_0.operation.AMQPOperationBinding
import com.asyncapi.schemas.AsyncAPISchema

class RpcServer: AbstractExampleValidationTest() {

    override fun specificationLocation(): String = "/examples/v2.6.0/rpc-server.yml"

    override fun expectedId(): String = "urn:example:rpcserver"

    override fun expectedDefaultContentType(): String = "application/json"

    override fun expectedInfo(): Info {
        return Info.builder()
                .title("RPC Server Example")
                .version("1.0.0")
                .description("This example demonstrates how to define an RPC server."
                )
                .build()
    }

    override fun expectedServers(): Map<String, Any> {
        return mapOf(
                Pair("production", Server.builder()
                        .url("rabbitmq.example.org")
                        .protocol("amqp")
                        .build()
                )
        )
    }

    override fun expectedChannels(): Map<String, Any> {
        return mapOf(
                Pair("{queue}", ChannelItem.builder()
                        .parameters(mapOf(
                                Pair("queue", Parameter.builder()
                                        .schema(AsyncAPISchema.builder()
                                                .type("string")
                                                .pattern("^amq\\\\.gen\\\\-.+\$")
                                                .build())
                                        .build()
                                ),
                        ))
                        .bindings(mapOf(
                                Pair("amqp", AMQPChannelBinding.builder()
                                        .`is`(AMQPChannelType.QUEUE)
                                        .queue(AMQPChannelQueueProperties.builder()
                                                .exclusive(true)
                                                .build()
                                        )
                                        .build()
                                )
                        ))
                        .subscribe(Operation.builder()
                                .operationId("sendSumResult")
                                .bindings(mapOf(
                                        Pair("amqp", AMQPOperationBinding.builder()
                                                .ack(true)
                                                .build()
                                        )
                                ))
                                .message(Message.builder()
                                        .correlationId(CorrelationId(null, "\$message.header#/correlation_id"))
                                        .payload(AsyncAPISchema.builder()
                                                .type("object")
                                                .properties(mapOf(
                                                        Pair("result", AsyncAPISchema.builder()
                                                                .type("number")
                                                                .examples(listOf(7))
                                                                .build())
                                                ))
                                                .build()
                                        )
                                        .build()
                                )
                                .build()
                        )
                        .build()
                ),
                Pair("rpc_queue", ChannelItem.builder()
                        .bindings(mapOf(
                                Pair("amqp", AMQPChannelBinding.builder()
                                        .`is`(AMQPChannelType.QUEUE)
                                        .queue(AMQPChannelQueueProperties.builder()
                                                .durable(false)
                                                .build()
                                        )
                                        .build()
                                )
                        ))
                        .publish(Operation.builder()
                                .operationId("sum")
                                .message(Message.builder()
                                        .correlationId(CorrelationId(null, "\$message.header#/correlation_id"))
                                        .payload(AsyncAPISchema.builder()
                                                .type("object")
                                                .properties(mapOf(
                                                        Pair("numbers", AsyncAPISchema.builder()
                                                                .type("array")
                                                                .items(AsyncAPISchema.builder().type("number").build())
                                                                .examples(listOf(listOf(4, 3)))
                                                                .build())
                                                ))
                                                .build()
                                        )
                                        .build()
                                )
                                .build()
                        )
                        .build()
                )
        )
    }

    override fun expectedComponents(): Components? = null

}