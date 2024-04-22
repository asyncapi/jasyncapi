package com.asyncapi.v2.binding.channel.googlepubsub

import com.asyncapi.v2.SerDeTest
import com.asyncapi.bindings.googlepubsub.v0._1_0.channel.GooglePubSubChannelBinding
import com.asyncapi.bindings.googlepubsub.v0._1_0.channel.GooglePubSubChannelMessageStoragePolicy
import com.asyncapi.bindings.googlepubsub.v0._1_0.channel.GooglePubSubChannelSchemaSettings

class GooglePubSubChannelBindingTest: SerDeTest<GooglePubSubChannelBinding>() {

    override fun objectClass() = GooglePubSubChannelBinding::class.java

    override fun baseObjectJson() = "/json/v2/binding/channel/googlepubsub/googlePubSubChannelBinding.json"

    override fun extendedObjectJson() = "/json/v2/binding/channel/googlepubsub/googlePubSubChannelBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v2/binding/channel/googlepubsub/googlePubSubChannelBinding - wrongly extended.json"

    override fun build(): GooglePubSubChannelBinding {
       return GooglePubSubChannelBinding.builder()
               .topic("projects/your-project/topics/topic-proto-schema")
               .messageRetentionDuration("86400s")
               .messageStoragePolicy(GooglePubSubChannelMessageStoragePolicy(
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
               .schemaSettings(GooglePubSubChannelSchemaSettings.builder()
                       .encoding("binary")
                       .name("projects/your-project/schemas/message-proto")
                       .build()
               )
               .build()
   }

}