package com.asyncapi.v2.binding.operation.kafka

import com.asyncapi.v2.SerDeTest
import com.asyncapi.v2.schema.Schema
import com.asyncapi.v2.schema.Type

class KafkaOperationBindingTest: SerDeTest<KafkaOperationBinding>() {

    override fun objectClass() = KafkaOperationBinding::class.java

    override fun baseObjectJson() = "/json/v2/binding/operation/kafka/kafkaOperationBinding.json"

    override fun extendedObjectJson() = "/json/v2/binding/operation/kafka/kafkaOperationBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v2/binding/operation/kafka/kafkaOperationBinding - wrongly extended.json"

    override fun build(): KafkaOperationBinding {
        return KafkaOperationBinding.builder()
                .groupId(Schema.builder()
                        .type(Type.STRING)
                        .enumValue(listOf("myGroupId"))
                        .build())
                .clientId(Schema.builder()
                        .type(Type.STRING)
                        .enumValue(listOf("myClientId"))
                        .build())
                .build()
    }

}