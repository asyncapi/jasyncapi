package com.asyncapi.bindings.pulsar.v0._1_0.channel

import com.asyncapi.v3.SerDeTest

class PulsarChannelBindingTest: SerDeTest<PulsarChannelBinding>() {

    override fun objectClass() = PulsarChannelBinding::class.java

    override fun baseObjectJson() = "/bindings/pulsar/channel/pulsarChannelBinding.json"

    override fun extendedObjectJson() = "/bindings/pulsar/channel/pulsarChannelBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/bindings/pulsar/channel/pulsarChannelBinding - wrongly extended.json"

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