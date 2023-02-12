package com.asyncapi.v2._6_0.binding.channel.googlepubsub

import com.asyncapi.v2.ClasspathUtils
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class GooglePubSubChannelBindingTest {

    private val objectMapper = ObjectMapper()

    @Test
    @DisplayName("Compare hand crafted model with parsed json")
    fun compareModelWithParsedJson() {
        val model = ClasspathUtils.readAsString("/json/2.6.0/binding/channel/googlepubsub/googlePubSubChannelBinding.json")

        Assertions.assertEquals(
                objectMapper.readValue(model, GooglePubSubChannelBinding::class.java),
                build()
        )
    }

    companion object {
        @JvmStatic
        fun build(): GooglePubSubChannelBinding {
            return GooglePubSubChannelBinding.builder()
                    .topic("projects/your-project/topics/topic-proto-schema")
                    .messageRetentionDuration("86400s")
                    .messageStoragePolicy(GooglePubSubChannelBinding.MessageStoragePolicy(
                            listOf(
                                    "us-central1",
                                    "us-central2",
                                    "us-east1",
                                    "us-east4",
                                    "us-east5",
                                    "us-east7",
                                    "us-south1",
                                    "us-west1",
                                    "us-west2",
                                    "us-west3",
                                    "us-west4"
                            )
                    ))
                    .schemaSettings(GooglePubSubChannelBinding.SchemaSettings.builder()
                            .encoding("binary")
                            .name("projects/your-project/schemas/message-proto")
                            .build()
                    )
                    .build()
        }
    }

}