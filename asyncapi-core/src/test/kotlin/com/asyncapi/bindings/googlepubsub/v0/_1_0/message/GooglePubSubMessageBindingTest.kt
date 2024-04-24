package com.asyncapi.bindings.googlepubsub.v0._1_0.message

import com.asyncapi.v3.SerDeTest

class GooglePubSubMessageBindingTest: SerDeTest<GooglePubSubMessageBinding>() {

    override fun objectClass() = GooglePubSubMessageBinding::class.java

    override fun baseObjectJson() = "/json/v3/binding/message/googlepubsub/googlePubSubMessageBinding.json"

    override fun extendedObjectJson() = "/json/v3/binding/message/googlepubsub/googlePubSubMessageBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v3/binding/message/googlepubsub/googlePubSubMessageBinding - wrongly extended.json"

    override fun build(): GooglePubSubMessageBinding {
        return GooglePubSubMessageBinding.builder()
                .schema(GooglePubSubMessageSchemaDefinition(
                        "projects/your-project/schemas/message-avro",
                        GooglePubSubMessageSchemaDefinitionType.AVRO
                ))
                .build()
    }

}