package com.asyncapi.v2.binding.message.googlepubsub

import com.asyncapi.v2.SerDeTest

class GooglePubSubMessageBindingTest: SerDeTest<GooglePubSubMessageBinding>() {

    override fun objectClass() = GooglePubSubMessageBinding::class.java

    override fun baseObjectJson() = "/json/binding/message/googlepubsub/googlePubSubMessageBinding.json"

    override fun extendedObjectJson() = "/json/binding/message/googlepubsub/googlePubSubMessageBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/binding/message/googlepubsub/googlePubSubMessageBinding - wrongly extended.json"

    override fun build(): GooglePubSubMessageBinding {
        return GooglePubSubMessageBinding.builder()
                .schema(GooglePubSubMessageBinding.SchemaDefinition(
                        "projects/your-project/schemas/message-avro",
                        "avro"
                ))
                .build()
    }

}