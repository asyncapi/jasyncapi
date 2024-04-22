package com.asyncapi.v2.binding.message.googlepubsub

import com.asyncapi.v2.SerDeTest
import com.asyncapi.bindings.googlepubsub.v0._1_0.message.GooglePubSubMessageBinding
import com.asyncapi.bindings.googlepubsub.v0._1_0.message.GooglePubSubMessageSchemaDefinition
import com.asyncapi.bindings.googlepubsub.v0._1_0.message.GooglePubSubMessageSchemaDefinitionType

class GooglePubSubMessageBindingTest: SerDeTest<GooglePubSubMessageBinding>() {

    override fun objectClass() = GooglePubSubMessageBinding::class.java

    override fun baseObjectJson() = "/json/v2/binding/message/googlepubsub/googlePubSubMessageBinding.json"

    override fun extendedObjectJson() = "/json/v2/binding/message/googlepubsub/googlePubSubMessageBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v2/binding/message/googlepubsub/googlePubSubMessageBinding - wrongly extended.json"

    override fun build(): GooglePubSubMessageBinding {
        return GooglePubSubMessageBinding.builder()
                .schema(GooglePubSubMessageSchemaDefinition(
                        "projects/your-project/schemas/message-avro",
                        GooglePubSubMessageSchemaDefinitionType.AVRO
                ))
                .build()
    }

}