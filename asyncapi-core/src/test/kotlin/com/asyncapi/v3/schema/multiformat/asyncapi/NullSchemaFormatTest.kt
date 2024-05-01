package com.asyncapi.v3.schema.multiformat.asyncapi

import com.asyncapi.v3.schema.json.*
import com.asyncapi.schemas.multiformat.AsyncAPIFormatSchema
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

abstract class NullSchemaFormatTest: AsyncAPIFormatSchemaTest() {

    @ArgumentsSource(Json::class)
    @ParameterizedTest(name = "Read: {0}")
    override fun parseJson(
        asyncAPIFormatSchemaToCompareWithFilePath: String,
        asyncAPIFormatSchema: AsyncAPIFormatSchema
    ) {
        compareSchemas(asyncAPIFormatSchemaToCompareWithFilePath, asyncAPIFormatSchema)
    }

    @ArgumentsSource(Yaml::class)
    @ParameterizedTest(name = "Read: {0}")
    override fun parseYaml(
        asyncAPIFormatSchemaToCompareWithFilePath: String,
        asyncAPIFormatSchema: AsyncAPIFormatSchema
    ) {
        compareSchemas(asyncAPIFormatSchemaToCompareWithFilePath, asyncAPIFormatSchema)
    }

    class Json: ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
            return Stream.of(
                Arguments.of(
                    "/json/v3/schema/multiformat/schemaFormat is null/arrays.schema.json",
                    AsyncAPIFormatSchema(
                        "application/vnd.aai.asyncapi+json;version=3.0.0",
                        ArraysSchemaTest().asyncAPISchema()
                    )
                ),
                Arguments.of(
                    "/json/v3/schema/multiformat/schemaFormat is null/complex-object.schema.json",
                    AsyncAPIFormatSchema(
                        "application/vnd.aai.asyncapi+json;version=3.0.0",
                        ComplexObjectTest().asyncAPISchema()
                    )
                ),
                Arguments.of(
                    "/json/v3/schema/multiformat/schemaFormat is null/conditional-validation-if-else.schema.json",
                    AsyncAPIFormatSchema(
                        "application/vnd.aai.asyncapi+json;version=3.0.0",
                        ConditionalValidationIfElse().asyncAPISchema()
                    )
                ),
                Arguments.of(
                    "/json/v3/schema/multiformat/schemaFormat is null/draft-07-core-schema-meta-schema.json",
                    AsyncAPIFormatSchema(
                        "application/vnd.aai.asyncapi+json;version=3.0.0",
                        Draft07CoreSchemaMetaSchemaTest().asyncAPISchema()
                    )
                ),
                Arguments.of(
                    "/json/v3/schema/multiformat/schemaFormat is null/enumerated-values.schema.json",
                    AsyncAPIFormatSchema(
                        "application/vnd.aai.asyncapi+json;version=3.0.0",
                        EnumeratedValuesTest().asyncAPISchema()
                    )
                ),
                Arguments.of(
                    "/json/v3/schema/multiformat/schemaFormat is null/person.schema.json",
                    AsyncAPIFormatSchema(
                        "application/vnd.aai.asyncapi+json;version=3.0.0",
                        PersonTest().asyncAPISchema()
                    )
                ),
                Arguments.of(
                    "/json/v3/schema/multiformat/schemaFormat is null/regex-pattern.schema.json",
                    AsyncAPIFormatSchema(
                        "application/vnd.aai.asyncapi+json;version=3.0.0",
                        RegexPatternTest().asyncAPISchema()
                    )
                )
            )
        }

    }

    class Yaml: ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
            return Stream.of(
                Arguments.of(
                    "/json/v3/schema/multiformat/schemaFormat is null/arrays.schema.yaml",
                    AsyncAPIFormatSchema(
                        "application/vnd.aai.asyncapi+json;version=3.0.0",
                        ArraysSchemaTest().asyncAPISchema()
                    )
                ),
                Arguments.of(
                    "/json/v3/schema/multiformat/schemaFormat is null/complex-object.schema.yaml",
                    AsyncAPIFormatSchema(
                        "application/vnd.aai.asyncapi+json;version=3.0.0",
                        ComplexObjectTest().asyncAPISchema()
                    )
                ),
                Arguments.of(
                    "/json/v3/schema/multiformat/schemaFormat is null/conditional-validation-if-else.schema.yaml",
                    AsyncAPIFormatSchema(
                        "application/vnd.aai.asyncapi+json;version=3.0.0",
                        ConditionalValidationIfElse().asyncAPISchema()
                    )
                ),
                Arguments.of(
                    "/json/v3/schema/multiformat/schemaFormat is null/draft-07-core-schema-meta-schema.yaml",
                    AsyncAPIFormatSchema(
                        "application/vnd.aai.asyncapi+json;version=3.0.0",
                        Draft07CoreSchemaMetaSchemaTest().asyncAPISchema()
                    )
                ),
                Arguments.of(
                    "/json/v3/schema/multiformat/schemaFormat is null/enumerated-values.schema.yaml",
                    AsyncAPIFormatSchema(
                        "application/vnd.aai.asyncapi+json;version=3.0.0",
                        EnumeratedValuesTest().asyncAPISchema()
                    )
                ),
                Arguments.of(
                    "/json/v3/schema/multiformat/schemaFormat is null/person.schema.yaml",
                    AsyncAPIFormatSchema(
                        "application/vnd.aai.asyncapi+json;version=3.0.0",
                        PersonTest().asyncAPISchema()
                    )
                ),
                Arguments.of(
                    "/json/v3/schema/multiformat/schemaFormat is null/regex-pattern.schema.yaml",
                    AsyncAPIFormatSchema(
                        "application/vnd.aai.asyncapi+json;version=3.0.0",
                        RegexPatternTest().asyncAPISchema()
                    )
                )
            )
        }

    }

}