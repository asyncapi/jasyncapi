package com.asyncapi.bindings.kafka.v0._4_0.operation

import com.asyncapi.v3.SerDeTest
import com.asyncapi.v3.schema.AsyncAPISchema
import com.asyncapi.v3.schema.Type

class KafkaOperationBindingTest: SerDeTest<KafkaOperationBinding>() {

    override fun objectClass() = KafkaOperationBinding::class.java

    override fun baseObjectJson() = "/json/v3/binding/operation/kafka/kafkaOperationBinding.json"

    override fun extendedObjectJson() = "/json/v3/binding/operation/kafka/kafkaOperationBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v3/binding/operation/kafka/kafkaOperationBinding - wrongly extended.json"

    override fun build(): KafkaOperationBinding {
        return KafkaOperationBinding.builder()
                .groupId(AsyncAPISchema.builder()
                        .type(Type.STRING)
                        .enumValue(listOf("myGroupId"))
                        .build())
                .clientId(AsyncAPISchema.builder()
                        .type(Type.STRING)
                        .enumValue(listOf("myClientId"))
                        .build())
                .build()
    }

}