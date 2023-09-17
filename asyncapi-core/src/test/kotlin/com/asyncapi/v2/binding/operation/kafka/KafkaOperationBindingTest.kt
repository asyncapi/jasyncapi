package com.asyncapi.v2.binding.operation.kafka

import com.asyncapi.v2.SerDeTest

class KafkaOperationBindingTest: SerDeTest<KafkaOperationBinding>() {

    override fun objectClass() = KafkaOperationBinding::class.java

    override fun baseObjectJson() = "/json/binding/operation/kafka/kafkaOperationBinding.json"

    override fun extendedObjectJson() = "/json/binding/operation/kafka/kafkaOperationBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/binding/operation/kafka/kafkaOperationBinding - wrongly extended.json"

    override fun build(): KafkaOperationBinding {
        return KafkaOperationBinding.builder()
                .groupId(mapOf(
                        Pair("type", "string"),
                        Pair("enum", listOf("myGroupId"))
                ))
                .clientId(mapOf(
                        Pair("type", "string"),
                        Pair("enum", listOf("myClientId"))
                ))
                .build()
    }

}