package com.asyncapi.v2.binding.message.kafka

import com.asyncapi.v2.SerDeTest

class KafkaMessageBindingTest: SerDeTest<KafkaMessageBinding>() {

    override fun objectClass() = KafkaMessageBinding::class.java

    override fun baseObjectJson() = "/json/2.6.0/binding/message/kafka/kafkaMessageBinding.json"

    override fun extendedObjectJson() = "/json/2.6.0/binding/message/kafka/kafkaMessageBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/2.6.0/binding/message/kafka/kafkaMessageBinding - wrongly extended.json"

    override fun build(): KafkaMessageBinding {
        return KafkaMessageBinding.builder()
                .key(mapOf(
                        Pair("type", "string"),
                        Pair("enum", listOf("myKey"))
                ))
                .schemaIdLocation("payload")
                .schemaIdPayloadEncoding("apicurio-new")
                .schemaLookupStrategy("TopicIdStrategy")
                .build()
    }

}