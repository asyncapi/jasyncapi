package com.asyncapi.bindings.kafka.v0._4_0.message

import com.asyncapi.v3.SerDeTest
import com.asyncapi.v3.schema.AsyncAPISchema
import com.asyncapi.v3.schema.Type

class KafkaMessageBindingTest: SerDeTest<KafkaMessageBinding>() {

    override fun objectClass() = KafkaMessageBinding::class.java

    override fun baseObjectJson() = "/bindings/kafka/message/kafkaMessageBinding.json"

    override fun extendedObjectJson() = "/bindings/kafka/message/kafkaMessageBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/bindings/kafka/message/kafkaMessageBinding - wrongly extended.json"

    override fun build(): KafkaMessageBinding {
        return KafkaMessageBinding.builder()
                .key(AsyncAPISchema.builder()
                        .type(Type.STRING)
                        .enumValue(listOf("myKey"))
                        .build())
                .schemaIdLocation(KafkaMessageSchemaIdLocation.PAYLOAD)
                .schemaIdPayloadEncoding("apicurio-new")
                .schemaLookupStrategy("TopicIdStrategy")
                .build()
    }

}