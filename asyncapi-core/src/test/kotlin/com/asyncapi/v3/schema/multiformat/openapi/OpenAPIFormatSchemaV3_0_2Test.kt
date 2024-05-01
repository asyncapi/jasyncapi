package com.asyncapi.v3.schema.multiformat.openapi

import com.asyncapi.schemas.multiformat.OpenAPIFormatSchema
import com.asyncapi.v3.schema.openapi.v3._0_0.SchemaTest
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

abstract class OpenAPIFormatSchemaV3_0_2Test: OpenAPIFormatSchemaTest() {

    @ArgumentsSource(JsonFormat::class)
    @ParameterizedTest(name = "Read: {0}")
    override fun parseJson(
        openAPIFormatSchemaToCompareWithFilePath: String,
        openAPIFormatSchema: OpenAPIFormatSchema
    ) {
        compareSchemas(openAPIFormatSchemaToCompareWithFilePath, openAPIFormatSchema)
    }

    @ArgumentsSource(YamlFormat::class)
    @ParameterizedTest(name = "Read: {0}")
    override fun parseYaml(
        openAPIFormatSchemaToCompareWithFilePath: String,
        openAPIFormatSchema: OpenAPIFormatSchema
    ) {
        compareSchemas(openAPIFormatSchemaToCompareWithFilePath, openAPIFormatSchema)
    }

    class JsonFormat: ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
            return Stream.of(
                Arguments.of("/json/v3/schema/multiformat/openapi/3.0.2/vnd.oai.openapi/schema.json",
                    OpenAPIFormatSchema(
                        "application/vnd.oai.openapi;version=3.0.2",
                        SchemaTest().openAPISchema()
                    )
                ),
                Arguments.of("/json/v3/schema/multiformat/openapi/3.0.2/vnd.oai.openapi+json/schema.json",
                    OpenAPIFormatSchema(
                        "application/vnd.oai.openapi+json;version=3.0.2",
                        SchemaTest().openAPISchema()
                    )
                )
            )
        }

    }

    class YamlFormat: ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
            return Stream.of(
                Arguments.of("/json/v3/schema/multiformat/openapi/3.0.2/vnd.oai.openapi/schema.yaml",
                    OpenAPIFormatSchema(
                        "application/vnd.oai.openapi;version=3.0.2",
                        SchemaTest().openAPISchema()
                    )
                ),
                Arguments.of("/json/v3/schema/multiformat/openapi/3.0.2/vnd.oai.openapi+yaml/schema.yaml",
                    OpenAPIFormatSchema(
                        "application/vnd.oai.openapi+yaml;version=3.0.2",
                        SchemaTest().openAPISchema()
                    )
                )
            )
        }

    }

}