package com.asyncapi.v2.binding.channel.pulsar

import com.asyncapi.v2.SerDeTest

class PulsarChannelBindingTest: SerDeTest<PulsarChannelBinding>() {

    override fun objectClass() = PulsarChannelBinding::class.java

    override fun baseObjectJson() = "/json/binding/channel/pulsar/pulsarChannelBinding.json"

    override fun extendedObjectJson() = "/json/binding/channel/pulsar/pulsarChannelBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/binding/channel/pulsar/pulsarChannelBinding - wrongly extended.json"

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