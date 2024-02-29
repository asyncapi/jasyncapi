package com.asyncapi.examples.v2._0_0

import com.asyncapi.v2._0_0.model.channel.ChannelItem
import com.asyncapi.v2._0_0.model.channel.Parameter
import com.asyncapi.v2._0_0.model.channel.message.CorrelationId
import com.asyncapi.v2._0_0.model.channel.message.Message
import com.asyncapi.v2._0_0.model.channel.operation.Operation
import com.asyncapi.v2._0_0.model.component.Components
import com.asyncapi.v2._0_0.model.info.Info
import com.asyncapi.v2._0_0.model.server.Server
import com.asyncapi.v2.binding.channel.amqp.AMQPChannelBinding
import com.asyncapi.v2.binding.channel.amqp.AMQPChannelType
import com.asyncapi.v2.binding.channel.amqp.queue.AMQPChannelQueueProperties
import com.asyncapi.v2.binding.operation.amqp.AMQPOperationBinding
import com.asyncapi.v2.schema.Schema

class RpcClient: AbstractExampleValidationTest() {

    override fun specificationLocation(): String = "/examples/v2.0.0/rpc-client.yml"

    override fun expectedId(): String = "urn:example:rpcclient"

    override fun expectedDefaultContentType(): String = "application/json"

    override fun expectedInfo(): Info {
        return Info.builder()
                .title("RPC Client Example")
                .version("1.0.0")
                .description("This example demonstrates how to define an RPC client."
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
                                        .schema(Schema.builder()
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
                        .publish(Operation.builder()
                                .operationId("receiveSumResult")
                                .bindings(mapOf(
                                        Pair("amqp", AMQPOperationBinding.builder()
                                                .ack(false)
                                                .build()
                                        )
                                ))
                                .message(Message.builder()
                                        .correlationId(CorrelationId(null, "\$message.header#/correlation_id"))
                                        .payload(Schema.builder()
                                                .type("object")
                                                .properties(mapOf(
                                                        Pair("result", Schema.builder()
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
                        .subscribe(Operation.builder()
                                .operationId("requestSum")
                                .bindings(mapOf(
                                        Pair("amqp", AMQPOperationBinding.builder()
                                                .ack(true)
                                                .build()
                                        )
                                ))
                                .message(Message.builder()
                                        .correlationId(CorrelationId(null, "\$message.header#/correlation_id"))
                                        .payload(Schema.builder()
                                                .type("object")
                                                .properties(mapOf(
                                                        Pair("numbers", Schema.builder()
                                                                .type("array")
                                                                .items(Schema.builder().type("number").build())
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