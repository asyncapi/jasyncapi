package com.asyncapi.v3.binding.server.kafka

import com.asyncapi.v3.SerDeTest
import com.asyncapi.bindings.kafka.v0._4_0.server.KafkaServerBinding

/**
 * @version 3.0.0
 * @author Pavel Bodiachevskii
 */
class KafkaServerBindingTest: SerDeTest<KafkaServerBinding>() {

    override fun objectClass() = KafkaServerBinding::class.java

    override fun baseObjectJson() = "/json/v3/binding/server/kafka/kafkaServerBinding.json"

    override fun extendedObjectJson() = "/json/v3/binding/server/kafka/kafkaServerBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v3/binding/server/kafka/kafkaServerBinding - wrongly extended.json"

    override fun build(): KafkaServerBinding {
        return KafkaServerBinding.builder()
                .schemaRegistryUrl("https://my-schema-registry.com")
                .schemaRegistryVendor("confluent")
                .build()
    }

}