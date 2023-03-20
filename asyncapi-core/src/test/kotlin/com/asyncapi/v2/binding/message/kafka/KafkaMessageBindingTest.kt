package com.asyncapi.v2.binding.message.kafka

import com.asyncapi.v2.SerDeTest
import com.asyncapi.v2.schema.Schema
import com.asyncapi.v2.schema.Type

class KafkaMessageBindingTest: SerDeTest<KafkaMessageBinding>() {

    override fun objectClass() = KafkaMessageBinding::class.java

    override fun baseObjectJson() = "/json/binding/message/kafka/kafkaMessageBinding.json"

    override fun extendedObjectJson() = "/json/binding/message/kafka/kafkaMessageBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/binding/message/kafka/kafkaMessageBinding - wrongly extended.json"

    override fun build(): KafkaMessageBinding {
        return KafkaMessageBinding.builder()
                .key(Schema.builder()
                        .type(Type.STRING)
                        .enumValue(listOf("myKey"))
                        .build())
                .schemaIdLocation(KafkaMessageSchemaIdLocation.PAYLOAD)
                .schemaIdPayloadEncoding("apicurio-new")
                .schemaLookupStrategy("TopicIdStrategy")
                .build()
    }

}