package com.asyncapi.schemas.multiformat.xml

import com.asyncapi.schemas.asyncapi.Reference
import com.asyncapi.schemas.asyncapi.multiformat.XMLFormatSchema
import com.asyncapi.v3.ClasspathUtils
import com.asyncapi.v3._0_0.model.AsyncAPI
import com.asyncapi.v3._0_0.model.channel.message.Message
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import org.junit.jupiter.api.Test

class XmlFormatSchemaTest {

    private val objectMapper = ObjectMapper(YAMLFactory())
        .setSerializationInclusion(JsonInclude.Include.NON_NULL)

    @Test
    fun `should parse a spec where the schemaFormat is application xml and the schema is referenced from an external xml schema file`() {
        val specFilePath = "/examples/v3.0.0/xml/simple-referenced-schema.yaml"
        val asyncAPI = parse(specFilePath)

        val payload = (asyncAPI?.components?.messages?.get("UserSignedUp") as? Message)?.payload

        assert(payload is XMLFormatSchema)
        payload as XMLFormatSchema

        assert(payload.schemaFormat == "application/xml")
        assert(payload.schema is Reference)

        assert((payload.schema as Reference).ref == "/path/to/schema.xml")
    }

    @Test
    fun `should parse a spec where the schemaFormat is application xml and the schema is specified as an inline string`() {
        val specFilePath = "/examples/v3.0.0/xml/simple-string-schema.yaml"
        val asyncAPI = parse(specFilePath)

        val payload = (asyncAPI?.components?.messages?.get("UserSignedUp") as? Message)?.payload

        assert(payload is XMLFormatSchema)
        payload as XMLFormatSchema

        assert(payload.schemaFormat == "application/xml")
        assert(payload.schema is String)

        assert((payload.schema as String).contains("<xs:schema"))
    }

    private fun parse(specPath: String): AsyncAPI? {
        return objectMapper.readValue(
            ClasspathUtils.readAsString(specPath),
            AsyncAPI::class.java
        )
    }
}