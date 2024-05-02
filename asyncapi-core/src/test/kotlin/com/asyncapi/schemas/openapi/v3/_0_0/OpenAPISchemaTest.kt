package com.asyncapi.schemas.openapi.v3._0_0

import com.asyncapi.v3.ClasspathUtils
import com.asyncapi.schemas.SchemaProvider
import com.asyncapi.schemas.openapi.v3._0_0.properties.*
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class OpenAPISchemaTest {

    private val objectMapper: ObjectMapper = ObjectMapper()
            .setSerializationInclusion(JsonInclude.Include.NON_NULL)

    @Nested
    inner class XMLTest {

        @ArgumentsSource(XMLs::class)
        @ParameterizedTest(name = "Read: {0}")
        fun read(xmlToRead: String, xmlToCheck: XML) {
            val xmlString = ClasspathUtils.readAsString(xmlToRead)
            val xml = objectMapper.readValue(xmlString, XML::class.java)

            Assertions.assertEquals(xml, xmlToCheck)
        }

    }

    @Nested
    inner class DiscriminatorTest {

        @ArgumentsSource(Discriminators::class)
        @ParameterizedTest(name = "Read: {0}")
        fun read(discriminatorToRead: String, discriminatorToCheck: Discriminator) {
            val discriminatorString = ClasspathUtils.readAsString(discriminatorToRead)
            val discriminator = objectMapper.readValue(discriminatorString, Discriminator::class.java)

            Assertions.assertEquals(discriminator, discriminatorToCheck)
        }

    }

    @Nested
    inner class ExternalDocumentationTest {

        @ArgumentsSource(ExternalDocumentations::class)
        @ParameterizedTest(name = "Read: {0}")
        fun read(discriminatorToRead: String, externalDocumentationToCheck: ExternalDocumentation) {
            val externalDocumentationString = ClasspathUtils.readAsString(discriminatorToRead)
            val externalDocumentation = objectMapper.readValue(externalDocumentationString, ExternalDocumentation::class.java)

            Assertions.assertEquals(externalDocumentation, externalDocumentationToCheck)
        }

    }

    @Nested
    inner class SchemaTest {

        @ArgumentsSource(Schemas::class)
        @ParameterizedTest(name = "Read: {0}")
        fun read(schemaToRead: String, schemaToCheck: SchemaProvider) {
            val externalDocumentationString = ClasspathUtils.readAsString(schemaToRead)
            val externalDocumentation = objectMapper.readValue(externalDocumentationString, OpenAPISchema::class.java)

            Assertions.assertEquals(externalDocumentation, schemaToCheck.openAPISchema())
        }

    }

    class XMLs: ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
            val extendedXML = XML(
                "animal", "http://example.com/schema/sample", "sample", true, true
            )
            extendedXML.extensions = mapOf(Pair("x-extension-property", "value"))

            return Stream.of(
                    Arguments.of("/json/v3/schema/openapi/xml.json", extendedXML),
                    Arguments.of("/json/v3/schema/openapi/xml-attribute.json", XML.builder().attribute(true).build()),
                    Arguments.of("/json/v3/schema/openapi/xml-name-replacement.json", XML.builder().name("animal").build()),
                    Arguments.of("/json/v3/schema/openapi/xml-prefix-and-namespace.json", XML.builder()
                            .namespace("http://example.com/schema/sample")
                            .prefix("sample").build()
                    ),
                    Arguments.of("/json/v3/schema/openapi/xml-wrapped.json", XML.builder().wrapped(true).build()),
            )
        }

    }

    class Discriminators: ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
            return Stream.of(
                    Arguments.of("/json/v3/schema/openapi/discriminator.json", Discriminator.builder()
                            .propertyName("pet_type")
                            .mapping(mapOf(
                                    Pair("dog", "#/components/schemas/Dog"),
                                    Pair("monster", "https://gigantic-server.com/schemas/Monster/schema.json"),
                            )).build()
                    ),
                    Arguments.of("/json/v3/schema/openapi/discriminator-propertyname.json", Discriminator.builder().propertyName("pet_type").build()),
            )
        }

    }

    class ExternalDocumentations: ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
            val extendedExternalDocumentation = ExternalDocumentation("Find more info here", "https://example.com")
            extendedExternalDocumentation.extensions = mapOf(Pair("x-extension-property", "value"))

            return Stream.of(
                Arguments.of("/json/v3/schema/openapi/externaldocumentation.json", extendedExternalDocumentation),
                Arguments.of("/json/v3/schema/openapi/externaldocumentation-url.json", ExternalDocumentation(
                    null, "https://example.com"
                )),
            )
        }

    }

    class Schemas: ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
            return Stream.of(
                Arguments.of("/json/v3/schema/openapi/schema.json", SchemaTest()),
                Arguments.of("/json/v3/schema/openapi/properties/array.json", ExampleEnumDefaultArrayTest()),
                Arguments.of("/json/v3/schema/openapi/properties/null.json", ExampleEnumDefaultNullTest()),
            )
        }

    }

}