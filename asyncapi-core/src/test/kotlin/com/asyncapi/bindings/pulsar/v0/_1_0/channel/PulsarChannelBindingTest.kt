package com.asyncapi.bindings.pulsar.v0._1_0.channel

import com.asyncapi.v3.SerDeTest

class PulsarChannelBindingTest: SerDeTest<PulsarChannelBinding>() {

    override fun objectClass() = PulsarChannelBinding::class.java

    override fun baseObjectJson() = "/json/v3/binding/channel/pulsar/pulsarChannelBinding.json"

    override fun extendedObjectJson() = "/json/v3/binding/channel/pulsar/pulsarChannelBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v3/binding/channel/pulsar/pulsarChannelBinding - wrongly extended.json"

    override fun build(): PulsarChannelBinding {
        return PulsarChannelBinding.builder()
                .namespace("staging")
                .persistence(PulsarChannelPersistence.PERSISTENT)
                .compaction(1000)
                .geoReplication(listOf("us-east1", "us-west1"))
                .retention(PulsarChannelRetentionDefinition.builder()
                        .time(7)
                        .size(1000)
                        .build()
                )
                .ttl(360)
                .deduplication(false)
                .build()
    }

}