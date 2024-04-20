package com.asyncapi.examples.v3._0_0

import com.asyncapi.v3.Reference
import com.asyncapi.v3._0_0.model.Tag
import com.asyncapi.v3._0_0.model.channel.Channel
import com.asyncapi.v3._0_0.model.channel.Parameter
import com.asyncapi.v3._0_0.model.channel.message.CorrelationId
import com.asyncapi.v3._0_0.model.channel.message.Message
import com.asyncapi.v3._0_0.model.component.Components
import com.asyncapi.v3._0_0.model.info.Contact
import com.asyncapi.v3._0_0.model.info.Info
import com.asyncapi.v3._0_0.model.operation.Operation
import com.asyncapi.v3._0_0.model.operation.OperationAction
import com.asyncapi.v3._0_0.model.operation.reply.OperationReply
import com.asyncapi.v3._0_0.model.operation.reply.OperationReplyAddress
import com.asyncapi.v3._0_0.model.server.Server
import com.asyncapi.v3.binding.channel.kafka.KafkaChannelBinding
import com.asyncapi.v3.binding.channel.kafka.KafkaChannelTopicCleanupPolicy
import com.asyncapi.v3.binding.channel.kafka.KafkaChannelTopicConfiguration
import com.asyncapi.v3.binding.operation.kafka.KafkaOperationBinding
import com.asyncapi.v3.binding.server.kafka.KafkaServerBinding
import com.asyncapi.v3.schema.AsyncAPISchema
import com.asyncapi.v3.schema.multiformat.AvroFormatSchema
import com.asyncapi.v3.security_scheme.SecurityScheme

class AdeoKafkaRequestReplyAsyncAPI: AbstractExampleValidationTest() {

    override fun specificationLocation(): String = "/examples/v3.0.0/adeo-kafka-request-reply-asyncapi.yml"

    override fun expectedInfo(): Info {
        return Info(
                "Adeo AsyncAPI Case Study",
                "%REPLACED_BY_MAVEN%",
                "This Adeo specification illustrates how ADEO uses AsyncAPI to document some of their exchanges.\n",
                null,
                Contact(
                        "AsyncAPI Community",
                        null,
                        "case-study@asyncapi.com"
                ),
                null,
                listOf(
                        Tag("costing", "Costing channels, used by Costing clients.", null)
                ),
                null
        )
    }

    override fun expectedServers(): Map<String, Any> {
        return mapOf(
                Pair("production", Server.builder()
                        .host("prod.url:9092")
                        .protocol("kafka")
                        .description("Kafka PRODUCTION cluster")
                        .security(listOf(Reference("#/components/securitySchemes/sasl-ssl")))
                        .bindings(mapOf(
                                Pair("kafka", KafkaServerBinding.builder()
                                        .schemaRegistryUrl("https://schema-registry.prod.url/")
                                        .build()
                                )
                        ))
                        .build()
                ),
                Pair("staging", Server.builder()
                        .host("staging.url:9092")
                        .protocol("kafka")
                        .description("Kafka STAGING cluster for `uat` and `preprod` environments")
                        .security(listOf(Reference("#/components/securitySchemes/sasl-ssl")))
                        .bindings(mapOf(
                                Pair("kafka", KafkaServerBinding.builder()
                                        .schemaRegistryUrl("https://schema-registry.prod.url/")
                                        .build()
                                )
                        ))
                        .build()
                ),
                Pair("dev", Server.builder()
                        .host("dev.url:9092")
                        .protocol("kafka")
                        .description("Kafka DEV cluster for `dev` and `sit` environments")
                        .security(listOf(Reference("#/components/securitySchemes/sasl-ssl")))
                        .bindings(mapOf(
                                Pair("kafka", KafkaServerBinding.builder()
                                        .schemaRegistryUrl("https://schema-registry.prod.url/")
                                        .build()
                                )
                        ))
                        .build()
                )
        )
    }

    override fun expectedChannels(): Map<String, Any> {
        val costingResponseChannelKafkaBinding = KafkaChannelBinding()
        costingResponseChannelKafkaBinding.extensionFields = mapOf(
                Pair("x-key.subject.name.strategy", mapOf(
                        Pair("type", "string"),
                        Pair("description", "We use the RecordNameStrategy to infer the messages schema. Use `key.subject.name.strategy=io.confluent.kafka.serializers.subject.RecordNameStrategy` in your consumer configuration.\n"),
                )),
                Pair("x-value.subject.name.strategy", mapOf(
                        Pair("type", "string"),
                        Pair("description", "We use the RecordNameStrategy to infer the messages schema. Use `value.subject.name.strategy=io.confluent.kafka.serializers.subject.RecordNameStrategy` in your consumer configuration.\n"),
                ))
        )

        return mapOf(
                Pair("costingRequestChannel", Channel.builder()
                        .address("adeo-{env}-case-study-COSTING-REQUEST-{version}")
                        .description(
                                "Use this topic to do a Costing Request to Costing product. We use the " +
                                        "[**RecordNameStrategy**](https://docs.confluent.io/platform/current/schema-registry/serdes-develop/index.html#subject-name-strategy) " +
                                        "to infer the messages schema. You have to define " +
                                        "`value.subject.name.strategy` to " +
                                        "`io.confluent.kafka.serializers.subject.RecordNameStrategy` in your " +
                                        "producer to use the schema we manage. The schema below illustrates how " +
                                        "Costing Request messages are handled. " +
                                        "![](https://user-images.githubusercontent.com/5501911/188920831-689cec5f-8dc3-460b-8794-0b54ec8b0ac8.png)\n"
                        )
                        .parameters(mapOf(
                                Pair("env", Reference("#/components/parameters/Env")),
                                Pair("version", Reference("#/components/parameters/Version"))
                        ))
                        .bindings(mapOf(
                                Pair("kafka", KafkaChannelBinding.builder()
                                        .replicas(3)
                                        .partitions(3)
                                        .topicConfiguration(KafkaChannelTopicConfiguration.builder()
                                                .cleanupPolicy(listOf(KafkaChannelTopicCleanupPolicy.DELETE))
                                                .retentionMs(60000000)
                                                .build()
                                        )
                                        .build()
                                )
                        ))
                        .messages(mapOf(
                                Pair("CostingRequest", Reference("#/components/messages/costingRequestV1"))
                        ))
                        .build()
                ),
                Pair("costingResponseChannel", Channel.builder()
                        .address(null)
                        .description("This topic is used to REPLY Costing Requests and is targeted by the " +
                                "`REPLY_TOPIC` header. **You must grant PUBLISH access to our `svc-ccr-app` " +
                                "service account.**. We use the " +
                                "[**RecordNameStrategy**](https://docs.confluent.io/platform/current/schema-registry/serdes-develop/index.html#subject-name-strategy) " +
                                "to infer the messages schema. " +
                                "\n" +
                                "Topic should follow pattern \"adeo-{env}-case-study-COSTING-RESPONSE-{version}\"" +
                                "\n" +
                                "You have to define " +
                                "`key.subject.name.strategy` and `value.subject.name.strategy` to " +
                                "`io.confluent.kafka.serializers.subject.RecordNameStrategy` in your " +
                                "consumer. The schema below illustrates how Costing Response messages are " +
                                "handled.\n" +
                                "     ![](https://user-images.githubusercontent.com/5501911/188920831-689cec5f-8dc3-460b-8794-0b54ec8b0ac8.png)\n"
                        )
                        .bindings(mapOf(
                                Pair("kafka", costingResponseChannelKafkaBinding)
                        ))
                        .tags(listOf(Tag.builder().name("costing").build()))
                        .messages(mapOf(
                                Pair("costingResponse", Reference("#/components/messages/costingResponse"))
                        ))
                        .build()
                )
        )
    }

    override fun expectedOperations(): Map<String, Any> {
        val receiveACostingRequestKafkaBinding = KafkaOperationBinding.builder()
                .groupId(AsyncAPISchema.builder()
                        .type("string")
                        .description("The groupId must be prefixed by your `svc` account, deliver by the Adeo Kafka team. This `svc` must have the write access to the topic.\n")
                        .build()
                )
                .build()
        receiveACostingRequestKafkaBinding.extensionFields = mapOf(
                Pair("x-value.subject.name.strategy", mapOf(
                        Pair("type", "string"),
                        Pair("description", "We use the RecordNameStrategy to infer the messages schema. Use `value.subject.name.strategy=io.confluent.kafka.serializers.subject.RecordNameStrategy` in your producer configuration.\n"
                        ),
                ))
        )

        return mapOf(
                Pair("receiveACostingRequest", Operation.builder()
                        .action(OperationAction.RECEIVE)
                        .channel(Reference("#/channels/costingRequestChannel"))
                        .reply(OperationReply.builder()
                                .channel(Reference("#/channels/costingResponseChannel"))
                                .address(OperationReplyAddress(
                                        null,
                                        "\$message.header#/REPLY_TOPIC"
                                ))
                                .build()
                        )
                        .summary("[COSTING] Request one or more Costing calculation for any product\n")
                        .description("You can try a costing request using our [Conduktor producer template](https://conduktor.url/)\n")
                        .tags(listOf(Tag.builder().name("costing").build()))
                        .bindings(mapOf(
                                Pair("kafka", receiveACostingRequestKafkaBinding)
                        ))
                        .build()
                )
        )
    }

    override fun expectedComponents(): Components? {
        val saslSslSecurityScheme = SecurityScheme(
                SecurityScheme.Type.PLAIN,
                "Use [SASL authentication with SSL " +
                        "encryption](https://docs.confluent.io/platform/current/security/security_tutorial.html#configure-clients) " +
                        "to connect to the ADEO Broker."
        )
        saslSslSecurityScheme.extensionFields = mapOf(
                Pair("x-sasl.jaas.config", "org.apache.kafka.common.security.plain.PlainLoginModule required " +
                        "username=\"<CLUSTER_API_KEY>\" password=\"<CLUSTER_API_SECRET>\";"),
                Pair("x-security.protocol", "SASL_SSL"),
                Pair("x-ssl.endpoint.identification.algorithm", "https"),
                Pair("x-sasl.mechanism", "PLAIN")
        )

        return Components.builder()
                .correlationIds(mapOf(
                        Pair("costingCorrelationId", CorrelationId(
                                "This correlation ID is used for message tracing and messages " +
                                        "correlation. This correlation ID is generated at runtime based on the " +
                                        "`REQUEST_ID` and sent to the RESPONSE message.\n",
                                "\$message.header#/REQUEST_ID"
                        ))
                ))
                .messages(mapOf(
                        Pair("costingRequestV1", Message.builder()
                                .name("CostingRequestV1")
                                .title("Costing Request V1")
                                .summary("Costing Request V1 inputs.")
                                .tags(listOf(
                                        Tag.builder().name("costing").build()
                                ))
                                .correlationId(Reference("#/components/correlationIds/costingCorrelationId"))
                                .headers(AsyncAPISchema.builder()
                                        .type("object")
                                        .required(listOf(
                                                "REQUESTER_ID", "REQUESTER_CODE", "REQUEST_ID", "REPLY_TOPIC"
                                        ))
                                        .properties(mapOf(
                                                Pair("REQUEST_ID", AsyncAPISchema.builder().ref("#/components/schemas/RequestId").build()),
                                                Pair("REPLY_TOPIC", AsyncAPISchema.builder().ref("#/components/schemas/ReplyTopic").build()),
                                                Pair("REQUESTER_ID", AsyncAPISchema.builder().ref("#/components/schemas/RequesterId").build()),
                                                Pair("REQUESTER_CODE", AsyncAPISchema.builder().ref("#/components/schemas/RequesterCode").build()),
                                        ))
                                        .build()
                                )
                                .payload(AvroFormatSchema(
                                        "application/vnd.apache.avro;version=1.9.0",
                                        Reference("https://www.asyncapi.com/resources/casestudies/adeo/CostingRequestPayload.avsc")
                                ))
                                .build()
                        ),
                        Pair("costingResponse", Message.builder()
                                .name("CostingResponse")
                                .title("Costing Response")
                                .summary("Costing Response ouputs.")
                                .description("Please refer to the `CostingResponseKey.avsc` schema, available on [our " +
                                        "github project](https://github.url/).\n")
                                .tags(listOf(
                                        Tag.builder().name("costing").build()
                                ))
                                .correlationId(Reference("#/components/correlationIds/costingCorrelationId"))
                                .headers(AsyncAPISchema.builder()
                                        .type("object")
                                        .properties(mapOf(
                                                Pair("CALCULATION_ID", AsyncAPISchema.builder().ref("#/components/schemas/MessageId").build()),
                                                Pair("CORRELATION_ID", AsyncAPISchema.builder().ref("#/components/schemas/CorrelationId").build()),
                                                Pair("REQUEST_TIMESTAMP", AsyncAPISchema.builder()
                                                        .type("string")
                                                        .format("date-time")
                                                        .description("Timestamp of the costing request")
                                                        .build()
                                                ),
                                                Pair("CALCULATION_TIMESTAMP", AsyncAPISchema.builder()
                                                        .type("string")
                                                        .format("date-time")
                                                        .description("Technical timestamp for the costing calculation")
                                                        .build()
                                                ),
                                        ))
                                        .build()
                                )
                                .payload(AvroFormatSchema(
                                        "application/vnd.apache.avro;version=1.9.0",
                                        Reference("https://www.asyncapi.com/resources/casestudies/adeo/CostingResponsePayload.avsc")
                                ))
                                .build()
                        )
                ))
                .schemas(mapOf(
                        Pair("RequesterId", AsyncAPISchema.builder()
                                .type("string")
                                .description("The Costing requester service account used to produce costing request.")
                                .examples(listOf("svc-ecollect-app"))
                                .build()
                        ),
                        Pair("RequesterCode", AsyncAPISchema.builder()
                                .type("string")
                                .description("The Costing requester code (generally the BU Code). The requester code is useful to get the dedicated context (tenant).")
                                .examples(listOf(1))
                                .build()
                        ),
                        Pair("MessageId", AsyncAPISchema.builder()
                                .type("string")
                                .format("uuid")
                                .description("A unique Message ID.")
                                .examples(listOf("1fa6ef40-8f47-40a8-8cf6-f8607d0066ef"))
                                .build()
                        ),
                        Pair("RequestId", AsyncAPISchema.builder()
                                .type("string")
                                .format("uuid")
                                .description("A unique Request ID needed to define a `CORRELATION_ID` for exchanges, " +
                                        "which will be sent back in the Costing Responses.")
                                .examples(listOf("1fa6ef40-8f47-40a8-8cf6-f8607d0066ef"))
                                .build()
                        ),
                        Pair("CorrelationId", AsyncAPISchema.builder()
                                .type("string")
                                .format("uuid")
                                .description("A unique Correlation ID defined from the `REQUEST_ID` or the " +
                                        "`MESSAGE_ID` provided in the Costing Request.")
                                .examples(listOf("1fa6ef40-8f47-40a8-8cf6-f8607d0066ef"))
                                .build()
                        ),
                        Pair("BuCode", AsyncAPISchema.builder()
                                .type("string")
                                .description("The Business Unit code for which data are applicable.")
                                .examples(listOf(1))
                                .build()
                        ),
                        Pair("ReplyTopic", AsyncAPISchema.builder()
                                .type("string")
                                .description("The Kafka topic where to send the Costing Response. This is required for " +
                                        "the [Return Address EIP " +
                                        "pattern](https://www.enterpriseintegrationpatterns.com/patterns/messaging/ReturnAddress.html). " +
                                        "**You must grant WRITE access to our `svc-ccr-app` service account.**\n")
                                .examples(listOf("adeo-case-study-COSTING-RESPONSE-V1"))
                                .build()
                        ),
                        Pair("ErrorStep", AsyncAPISchema.builder()
                                .type("string")
                                .description("The woker that has thrown the error.\n")
                                .examples(listOf("EXPOSE_RESULT"))
                                .build()
                        ),
                        Pair("ErrorMessage", AsyncAPISchema.builder()
                                .type("string")
                                .description("The error message describing the error.\n")
                                .examples(listOf("Error message"))
                                .build()
                        ),
                        Pair("ErrorCode", AsyncAPISchema.builder()
                                .type("string")
                                .description("The error code.\n")
                                .examples(listOf("CURRENCY_NOT_FOUND"))
                                .build()
                        )
                ))
                .parameters(mapOf(
                        Pair("Env", Parameter.builder()
                                .description("Adeo Kafka Environement for messages publications.")
                                .enumValues(listOf(
                                        "dev", "sit", "uat1", "preprod", "prod"
                                ))
                                .build()
                        ),
                        Pair("Version", Parameter.builder()
                                .description("the topic version you want to use")
                                .examples(listOf("V1"))
                                .defaultValue("V1")
                                .build()
                        )
                ))
                .securitySchemes(mapOf(
                        Pair("sasl-ssl", saslSslSecurityScheme)
                ))
                .build()
    }

}