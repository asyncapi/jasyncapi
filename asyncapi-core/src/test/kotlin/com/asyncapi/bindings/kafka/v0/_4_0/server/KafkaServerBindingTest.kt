package com.asyncapi.bindings.kafka.v0._4_0.server

import com.asyncapi.v3.SerDeTest

/**
 * @version 3.0.0
 * @author Pavel Bodiachevskii
 */
class KafkaServerBindingTest: SerDeTest<KafkaServerBinding>() {

    override fun objectClass() = KafkaServerBinding::class.java

    override fun baseObjectJson() = "/bindings/kafka/server/kafkaServerBinding.json"

    override fun extendedObjectJson() = "/bindings/kafka/server/kafkaServerBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/bindings/kafka/server/kafkaServerBinding - wrongly extended.json"

    override fun build(): KafkaServerBinding {
        return KafkaServerBinding.builder()
                .schemaRegistryUrl("https://my-schema-registry.com")
                .schemaRegistryVendor("confluent")
                .build()
    }

}