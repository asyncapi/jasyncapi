package com.asyncapi.v2.binding.server.kafka

import com.asyncapi.v2.SerDeTest

/**
 * @version 2.6.0
 * @author Pavel Bodiachevskii
 */
class KafkaServerBindingTest: SerDeTest<KafkaServerBinding>() {

    override fun objectClass() = KafkaServerBinding::class.java

    override fun baseObjectJson() = "/json/binding/server/kafka/kafkaServerBinding.json"

    override fun extendedObjectJson() = "/json/binding/server/kafka/kafkaServerBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/binding/server/kafka/kafkaServerBinding - wrongly extended.json"

    override fun build(): KafkaServerBinding {
        return KafkaServerBinding.builder()
                .schemaRegistryUrl("https://my-schema-registry.com")
                .schemaRegistryVendor("confluent")
                .build()
    }

}