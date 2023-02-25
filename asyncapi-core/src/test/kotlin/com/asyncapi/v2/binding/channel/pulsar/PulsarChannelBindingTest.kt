package com.asyncapi.v2.binding.channel.pulsar

import com.asyncapi.v2.SerDeTest

class PulsarChannelBindingTest: SerDeTest<PulsarChannelBinding>() {

    override fun objectClass() = PulsarChannelBinding::class.java

    override fun baseObjectJson() = "/json/2.6.0/binding/channel/pulsar/pulsarChannelBinding.json"

    override fun extendedObjectJson() = "/json/2.6.0/binding/channel/pulsar/pulsarChannelBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/2.6.0/binding/channel/pulsar/pulsarChannelBinding - wrongly extended.json"

    override fun build(): PulsarChannelBinding {
        return PulsarChannelBinding.builder()
                .namespace("staging")
                .persistence("persistent")
                .compaction(1000)
                .geoReplication(listOf("us-east1", "us-west1"))
                .retention(PulsarChannelBinding.RetentionDefinition.builder()
                        .time(7)
                        .size(1000)
                        .build()
                )
                .ttl(360)
                .deduplication(false)
                .build()
    }

}