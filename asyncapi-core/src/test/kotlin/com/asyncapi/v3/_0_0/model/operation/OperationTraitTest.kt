package com.asyncapi.v3._0_0.model.operation

import com.asyncapi.bindings.amqp.v0._2_0.operation.AMQPOperationBindingTest
import com.asyncapi.v3.binding.operation.http.HTTPOperationBindingTest
import com.asyncapi.v3.binding.operation.kafka.KafkaOperationBindingTest
import com.asyncapi.v3.binding.operation.mqtt.MQTTOperationBindingTest
import com.asyncapi.v3.binding.operation.nats.NATSOperationBindingTest
import com.asyncapi.v3.binding.operation.solace.SolaceOperationBindingTest
import com.asyncapi.Reference
import com.asyncapi.v3.SerDeTest
import com.asyncapi.v3._0_0.model.ExternalDocumentation
import com.asyncapi.v3._0_0.model.Tag
import com.asyncapi.v3.security_scheme.ApiKeySecuritySchemeTest

/**
 * @version 3.0.0
 * @author Pavel Bodiachevskii
 */
class OperationTraitTest: SerDeTest<OperationTrait>() {

    override fun objectClass() = OperationTrait::class.java

    override fun baseObjectJson() = "/json/v3/3.0.0/model/operation/operationTrait.json"

    override fun extendedObjectJson() = "/json/v3/3.0.0/model/operation/operationTrait - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v3/3.0.0/model/operation/operationTrait - wrongly extended.json"

    override fun build(): OperationTrait {
        return OperationTrait.builder()
                .title("Send message operation")
                .summary("Send message")
                .description("Send message to remote server")
                .security(listOf(
                        ApiKeySecuritySchemeTest().build(),
                    Reference("#/components/security/plain")
                ))
                .tags(listOf(
                        Tag("messages", "operations with messages", ExternalDocumentation(
                                "Messages validation rules", "messages/validation-rules"
                        )),
                    Reference("#/components/tags/tag")
                ))
                .externalDocs(ExternalDocumentation("Messages validation rules", "messages/validation-rules"))
                .bindings(mapOf(
                        Pair("amqp", AMQPOperationBindingTest().build()),
                        Pair("amqp1", Reference("#/components/operationBindings/amqp1")),
                        Pair("anypointmq",
                            Reference("#/components/operationBindings/anypointmq")
                        ),
                        Pair("googlepubsub",
                            Reference("#/components/operationBindings/googlepubsub")
                        ),
                        Pair("http", HTTPOperationBindingTest().build()),
                        Pair("ibmmq", Reference("#/components/operationBindings/ibmmq")),
                        Pair("jms", Reference("#/components/operationBindings/jms")),
                        Pair("kafka", KafkaOperationBindingTest().build()),
                        Pair("mercure",
                            Reference("#/components/operationBindings/mercure")
                        ),
                        Pair("mqtt", MQTTOperationBindingTest().build()),
                        Pair("mqtt5", Reference("#/components/operationBindings/mqtt5")),
                        Pair("nats", NATSOperationBindingTest().build()),
                        Pair("pulsar",
                            Reference("#/components/operationBindings/pulsar")
                        ),
                        Pair("redis", Reference("#/components/operationBindings/redis")),
                        Pair("sns", Reference("#/components/operationBindings/sns")),
                        Pair("solace", SolaceOperationBindingTest().build()),
                        Pair("sqs", Reference("#/components/operationBindings/sqs")),
                        Pair("stomp", Reference("#/components/operationBindings/stomp")),
                        Pair("ws", Reference("#/components/operationBindings/ws"))
                ))
                .build()
    }

}

class OperationTraitTestWithReference: SerDeTest<OperationTrait>() {

    override fun objectClass() = OperationTrait::class.java

    override fun baseObjectJson() = "/json/v3/3.0.0/model/operation/operationTrait with reference.json"

    override fun extendedObjectJson() = "/json/v3/3.0.0/model/operation/operationTrait with reference - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v3/3.0.0/model/operation/operationTrait with reference - wrongly extended.json"

    override fun build(): OperationTrait {
        return OperationTrait.builder()
                .title("Send message operation")
                .summary("Send message")
                .description("Send message to remote server")
                .security(listOf(
                        ApiKeySecuritySchemeTest().build(),
                    Reference("#/components/security/plain")
                ))
                .tags(listOf(
                        Tag("messages", "operations with messages", ExternalDocumentation(
                                "Messages validation rules", "messages/validation-rules"
                        )),
                    Reference("#/components/tags/tag")
                ))
                .externalDocs(Reference("#/components/externalDocs/external-doc"))
                .bindings(mapOf(
                        Pair("amqp", AMQPOperationBindingTest().build()),
                        Pair("amqp1", Reference("#/components/operationBindings/amqp1")),
                        Pair("anypointmq",
                            Reference("#/components/operationBindings/anypointmq")
                        ),
                        Pair("googlepubsub",
                            Reference("#/components/operationBindings/googlepubsub")
                        ),
                        Pair("http", HTTPOperationBindingTest().build()),
                        Pair("ibmmq", Reference("#/components/operationBindings/ibmmq")),
                        Pair("jms", Reference("#/components/operationBindings/jms")),
                        Pair("kafka", KafkaOperationBindingTest().build()),
                        Pair("mercure",
                            Reference("#/components/operationBindings/mercure")
                        ),
                        Pair("mqtt", MQTTOperationBindingTest().build()),
                        Pair("mqtt5", Reference("#/components/operationBindings/mqtt5")),
                        Pair("nats", NATSOperationBindingTest().build()),
                        Pair("pulsar",
                            Reference("#/components/operationBindings/pulsar")
                        ),
                        Pair("redis", Reference("#/components/operationBindings/redis")),
                        Pair("sns", Reference("#/components/operationBindings/sns")),
                        Pair("solace", SolaceOperationBindingTest().build()),
                        Pair("sqs", Reference("#/components/operationBindings/sqs")),
                        Pair("stomp", Reference("#/components/operationBindings/stomp")),
                        Pair("ws", Reference("#/components/operationBindings/ws"))
                ))
                .build()
    }

}
