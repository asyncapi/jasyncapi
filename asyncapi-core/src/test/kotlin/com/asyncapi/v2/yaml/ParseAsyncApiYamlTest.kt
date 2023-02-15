package com.asyncapi.v2.yaml

import com.asyncapi.v2.ClasspathUtils
import com.asyncapi.v2.binding.kafka.KafkaMessageBinding
import com.asyncapi.v2.model.AsyncAPI
import com.asyncapi.v2.model.channel.message.Message
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test


class ParseAsyncApiYamlTest {


    private val objectMapper = ObjectMapper(YAMLFactory())

    @Test
    @DisplayName("parse yaml with oneOf Message")
    fun testParseOneOfOperationMessage() {
        val result = objectMapper.readValue(
                ClasspathUtils.readAsString("/yaml/model/testOperationOneOf.yaml"),
                AsyncAPI::class.java
        )
        Assertions.assertEquals(2, (result.channels.get("test-topic-1")?.subscribe?.message as Collection<*>).size)

    }

    @Test
    @DisplayName("parse yaml with kafka binding")
    fun testParseKeyOfKafkaMessageBinding() {
        val result = objectMapper.readValue(
                ClasspathUtils.readAsString("/yaml/model/testKafkaBindingsKey.yaml"),
                AsyncAPI::class.java
        )
        Assertions.assertNotNull(((result.components?.messages?.get("test-event-1") as Message)?.bindings?.get("kafka") as KafkaMessageBinding).key)

    }
}



