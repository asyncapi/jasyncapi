package com.asyncapi.v2.binding.message.kafka

import com.asyncapi.bindings.kafka.v0._4_0.message.KafkaMessageBinding
import com.asyncapi.bindings.kafka.v0._4_0.message.KafkaMessageSchemaIdLocation
import com.asyncapi.v2.SerDeTest
import com.asyncapi.v2.schema.Type
import com.asyncapi.v3.schema.AsyncAPISchema

class KafkaMessageBindingTest: SerDeTest<KafkaMessageBinding>() {

    override fun objectClass() = KafkaMessageBinding::class.java

    override fun baseObjectJson() = "/json/v2/binding/message/kafka/kafkaMessageBinding.json"

    override fun extendedObjectJson() = "/json/v2/binding/message/kafka/kafkaMessageBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v2/binding/message/kafka/kafkaMessageBinding - wrongly extended.json"

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