package com.asyncapi.v2.binding.channel.pulsar

import com.asyncapi.v2.SerDeTest
import com.asyncapi.bindings.pulsar.v0._1_0.channel.PulsarChannelBinding
import com.asyncapi.bindings.pulsar.v0._1_0.channel.PulsarChannelPersistence
import com.asyncapi.bindings.pulsar.v0._1_0.channel.PulsarChannelRetentionDefinition

class PulsarChannelBindingTest: SerDeTest<PulsarChannelBinding>() {

    override fun objectClass() = PulsarChannelBinding::class.java

    override fun baseObjectJson() = "/json/v2/binding/channel/pulsar/pulsarChannelBinding.json"

    override fun extendedObjectJson() = "/json/v2/binding/channel/pulsar/pulsarChannelBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v2/binding/channel/pulsar/pulsarChannelBinding - wrongly extended.json"

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