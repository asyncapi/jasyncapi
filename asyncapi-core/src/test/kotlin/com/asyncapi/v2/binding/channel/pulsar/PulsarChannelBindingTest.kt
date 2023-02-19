package com.asyncapi.v2.binding.channel.pulsar

import com.asyncapi.v2.ClasspathUtils
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class PulsarChannelBindingTest {

    private val objectMapper = ObjectMapper()

    @Test
    @DisplayName("Compare hand crafted model with parsed json")
    fun compareModelWithParsedJson() {
        val model = ClasspathUtils.readAsString("/json/2.6.0/binding/channel/pulsar/pulsarChannelBinding.json")

        Assertions.assertEquals(
                objectMapper.readValue(model, PulsarChannelBinding::class.java),
                build()
        )
    }

    companion object {
        @JvmStatic
        fun build(): PulsarChannelBinding {
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

}