package com.asyncapi.v2._6_0.binding.message.googlepubsub

import com.asyncapi.v2.ClasspathUtils
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class GooglePubSubMessageBindingTest {

    private val objectMapper = ObjectMapper()

    @Test
    @DisplayName("Compare hand crafted model with parsed json")
    fun compareModelWithParsedJson() {
        val model = ClasspathUtils.readAsString("/json/2.6.0/binding/message/googlepubsub/googlePubSubMessageBinding.json")

        Assertions.assertEquals(
                objectMapper.readValue(model, GooglePubSubMessageBinding::class.java),
                build()
        )
    }

    companion object {
        @JvmStatic
        fun build(): GooglePubSubMessageBinding {
            return GooglePubSubMessageBinding.builder()
                    .schema(GooglePubSubMessageBinding.SchemaDefinition(
                            "projects/your-project/schemas/message-avro",
                            "avro"
                    ))
                    .build()
        }
    }

}