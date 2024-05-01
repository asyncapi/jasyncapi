package com.asyncapi.v2._6_0.model.channel.message

import com.asyncapi.v2.ClasspathUtils
import com.asyncapi.schemas.AsyncAPISchema
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

class MessageWithArrayPayloadTest {
    private val objectMapper = ObjectMapper()

    @Test
    @DisplayName("Test array items property is parsed as a schema object")
    fun testArrayItemsPropertyIsParsedAsSchemaObjectWhenItIsASingleJsonSchema() {
        val model = ClasspathUtils.readAsString("/json/v2/2.6.0/model/channel/message/messageWithArrayPayloadJsonSchema.json")
        val schema = objectMapper.readValue(model, Message::class.java).payload as AsyncAPISchema
        assertTrue(
            schema.items is AsyncAPISchema
        )
    }

    @Test
    @DisplayName("Test array items property is parsed as list of schemas")
    fun testArrayItemsPropertyIsParsedAsArrayListOfSchemasWhenItIsAnArrayOfSchemas() {
        val model = ClasspathUtils.readAsString("/json/v2/2.6.0/model/channel/message/messageWithArrayPayloadArrayOfSchemas.json")
        val schema = objectMapper.readValue(model, Message::class.java).payload as AsyncAPISchema
        assertTrue(schema.items is ArrayList<*> && (schema.items as ArrayList<*>).all { it is AsyncAPISchema })
    }
}