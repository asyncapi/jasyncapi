package com.asyncapi.schemas.unknownkeys

import com.asyncapi.bindings.kafka.v0._6_0.message.KafkaMessageBinding
import com.asyncapi.schemas.asyncapi.AsyncAPISchema
import com.asyncapi.schemas.asyncapi.security.v3.oauth2.OAuth2SecurityScheme
import com.asyncapi.schemas.asyncapi.security.v3.oauth2.flow.ClientCredentialsOAuthFlow
import com.asyncapi.schemas.asyncapi.security.v3.oauth2.flow.OAuthFlow
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * Two things a document must survive being read and written with: an OAuth flow without a refresh URL, and a schema
 * key the Schema Object does not model.
 */
@DisplayName("unknown schema keys and optional OAuth fields")
class UnknownKeysAndOptionalFieldsTest {

    private val json = ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL)

    @Test
    @DisplayName("an OAuth flow read without refreshUrl is written without one (v3)")
    fun `v3 flow without refreshUrl`() {
        val original = """{"tokenUrl":"https://idp.example.com/token","availableScopes":{"kafka":"Kafka access"}}"""

        val flow = json.readValue(original, ClientCredentialsOAuthFlow::class.java)

        Assertions.assertNull(flow.refreshUrl)
        Assertions.assertEquals(json.readTree(original), json.valueToTree(flow))
    }

    @Test
    @DisplayName("a flow built without refreshUrl has none, and one given keeps it")
    fun `built flows`() {
        Assertions.assertNull(OAuthFlow().refreshUrl)
        Assertions.assertNull(OAuthFlow.builder().build().refreshUrl)
        Assertions.assertNull(ClientCredentialsOAuthFlow().refreshUrl)
        Assertions.assertFalse(json.valueToTree<com.fasterxml.jackson.databind.JsonNode>(OAuthFlow.builder().build()).has("refreshUrl"))

        val withOne = """{"refreshUrl":"https://idp.example.com/refresh","tokenUrl":"https://idp.example.com/token","availableScopes":{}}"""
        Assertions.assertEquals(json.readTree(withOne), json.valueToTree(json.readValue(withOne, ClientCredentialsOAuthFlow::class.java)))
    }

    @Test
    @DisplayName("an oauth2 scheme with a client-credentials flow round-trips without an empty refreshUrl")
    fun `v3 scheme round trip`() {
        val original = """
            {"type":"oauth2","flows":{"clientCredentials":{"tokenUrl":"https://idp.example.com/token","availableScopes":{}}},
             "scopes":["kafka"],"x-kurkik-kafka":{"security":"SASL_OAUTHBEARER"}}
        """.trimIndent()

        val scheme = json.readValue(original, OAuth2SecurityScheme::class.java)

        Assertions.assertEquals(json.readTree(original), json.valueToTree(scheme))
    }

    @Test
    @DisplayName("an OAuth flow read without refreshUrl is written without one (v2)")
    fun `v2 flow without refreshUrl`() {
        val original = """{"tokenUrl":"https://idp.example.com/token","scopes":{}}"""

        val flow = json.readValue(original, com.asyncapi.schemas.asyncapi.security.v2.oauth2.flow.ClientCredentialsOAuthFlow::class.java)

        Assertions.assertNull(flow.refreshUrl)
        Assertions.assertEquals(json.readTree(original), json.valueToTree(flow))
    }

    @Test
    @DisplayName("a schema keeps keys it does not model, in the order read, x-* included")
    fun `schema keeps unknown keys`() {
        val original = """
            {"type":"record","name":"Key","namespace":"com.example","fields":[{"name":"id","type":"string"}],
             "x-kurkik-note":"kept","futureKeyword":{"nested":[1,2]}}
        """.trimIndent()

        val schema = json.readValue(original, AsyncAPISchema::class.java)

        Assertions.assertEquals(listOf("name", "namespace", "fields", "x-kurkik-note", "futureKeyword"), schema.extensionFields!!.keys.toList())
        Assertions.assertEquals(json.readTree(original), json.valueToTree(schema))
    }

    @Test
    @DisplayName("an inline Avro key in a Kafka 0.6.0 message binding keeps its fields")
    fun `inline avro key`() {
        val original = """
            {"bindingVersion":"0.6.0","key":{"type":"record","name":"Key","fields":[{"name":"id","type":"string"}]}}
        """.trimIndent()

        val binding = json.readValue(original, KafkaMessageBinding::class.java)

        Assertions.assertEquals(json.readTree(original), json.valueToTree(binding))
    }

    @Test
    @DisplayName("a nested schema keeps its unknown keys too")
    fun `nested unknown keys`() {
        val original = """{"type":"object","properties":{"id":{"type":"string","x-sensitive":true,"logicalType":"uuid"}}}"""

        Assertions.assertEquals(json.readTree(original), json.valueToTree(json.readValue(original, AsyncAPISchema::class.java)))
    }
}
