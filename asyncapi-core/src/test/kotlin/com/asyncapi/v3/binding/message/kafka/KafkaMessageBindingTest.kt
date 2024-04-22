package com.asyncapi.v3.binding.message.kafka

import com.asyncapi.v3.SerDeTest
import com.asyncapi.v3.schema.AsyncAPISchema
import com.asyncapi.v3.schema.Type
import com.asyncapi.bindings.kafka.v0._4_0.message.KafkaMessageBinding
import com.asyncapi.bindings.kafka.v0._4_0.message.KafkaMessageSchemaIdLocation

class KafkaMessageBindingTest: SerDeTest<KafkaMessageBinding>() {

    override fun objectClass() = KafkaMessageBinding::class.java

    override fun baseObjectJson() = "/json/v3/binding/message/kafka/kafkaMessageBinding.json"

    override fun extendedObjectJson() = "/json/v3/binding/message/kafka/kafkaMessageBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v3/binding/message/kafka/kafkaMessageBinding - wrongly extended.json"

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