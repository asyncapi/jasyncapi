package com.asyncapi.v3.schema.multiformat.asyncapi

import com.asyncapi.schemas.json.*
import com.asyncapi.schemas.multiformat.AsyncAPIFormatSchema
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

abstract class AsyncAPIFormatSchemaV2_3_0Test: AsyncAPIFormatSchemaTest() {

    @ArgumentsSource(JsonFormat::class)
    @ParameterizedTest(name = "Read: {0}")
    override fun parseJson(
        asyncAPIFormatSchemaToCompareWithFilePath: String,
        asyncAPIFormatSchema: AsyncAPIFormatSchema
    ) {
        compareSchemas(asyncAPIFormatSchemaToCompareWithFilePath, asyncAPIFormatSchema)
    }

    @ArgumentsSource(YamlFormat::class)
    @ParameterizedTest(name = "Read: {0}")
    override fun parseYaml(
        asyncAPIFormatSchemaToCompareWithFilePath: String,
        asyncAPIFormatSchema: AsyncAPIFormatSchema
    ) {
        compareSchemas(asyncAPIFormatSchemaToCompareWithFilePath, asyncAPIFormatSchema)
    }

    class JsonFormat: ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
            return Stream.of(
                Arguments.of(
                    "/json/v3/schema/multiformat/asyncapi/2.3.0/vnd.aai.asyncapi+json/arrays.schema.json",
                    AsyncAPIFormatSchema(
                        "application/vnd.aai.asyncapi+json;version=2.3.0",
                        ArraysSchemaTest().asyncAPISchema()
                    )
                ),
                Arguments.of(
                    "/json/v3/schema/multiformat/asyncapi/2.3.0/vnd.aai.asyncapi+json/complex-object.schema.json",
                    AsyncAPIFormatSchema(
                        "application/vnd.aai.asyncapi+json;version=2.3.0",
                        ComplexObjectTest().asyncAPISchema()
                    )
                ),
                Arguments.of(
                    "/json/v3/schema/multiformat/asyncapi/2.3.0/vnd.aai.asyncapi+json/conditional-validation-if-else.schema.json",
                    AsyncAPIFormatSchema(
                        "application/vnd.aai.asyncapi+json;version=2.3.0",
                        ConditionalValidationIfElse().asyncAPISchema()
                    )
                ),
                Arguments.of(
                    "/json/v3/schema/multiformat/asyncapi/2.3.0/vnd.aai.asyncapi+json/draft-07-core-schema-meta-schema.json",
                    AsyncAPIFormatSchema(
                        "application/vnd.aai.asyncapi+json;version=2.3.0",
                        Draft07CoreSchemaMetaSchemaTest().asyncAPISchema()
                    )
                ),
                Arguments.of(
                    "/json/v3/schema/multiformat/asyncapi/2.3.0/vnd.aai.asyncapi+json/enumerated-values.schema.json",
                    AsyncAPIFormatSchema(
                        "application/vnd.aai.asyncapi+json;version=2.3.0",
                        EnumeratedValuesTest().asyncAPISchema()
                    )
                ),
                Arguments.of(
                    "/json/v3/schema/multiformat/asyncapi/2.3.0/vnd.aai.asyncapi+json/person.schema.json",
                    AsyncAPIFormatSchema(
                        "application/vnd.aai.asyncapi+json;version=2.3.0",
                        PersonTest().asyncAPISchema()
                    )
                ),
                Arguments.of(
                    "/json/v3/schema/multiformat/asyncapi/2.3.0/vnd.aai.asyncapi+json/regex-pattern.schema.json",
                    AsyncAPIFormatSchema(
                        "application/vnd.aai.asyncapi+json;version=2.3.0",
                        RegexPatternTest().asyncAPISchema()
                    )
                ),
                //
                Arguments.of(
                    "/json/v3/schema/multiformat/asyncapi/2.3.0/vnd.aai.asyncapi/arrays.schema.json",
                    AsyncAPIFormatSchema(
                        "application/vnd.aai.asyncapi;version=2.3.0",
                        ArraysSchemaTest().asyncAPISchema()
                    )
                ),
                Arguments.of(
                    "/json/v3/schema/multiformat/asyncapi/2.3.0/vnd.aai.asyncapi/complex-object.schema.json",
                    AsyncAPIFormatSchema(
                        "application/vnd.aai.asyncapi;version=2.3.0",
                        ComplexObjectTest().asyncAPISchema()
                    )
                ),
                Arguments.of(
                    "/json/v3/schema/multiformat/asyncapi/2.3.0/vnd.aai.asyncapi/conditional-validation-if-else.schema.json",
                    AsyncAPIFormatSchema(
                        "application/vnd.aai.asyncapi;version=2.3.0",
                        ConditionalValidationIfElse().asyncAPISchema()
                    )
                ),
                Arguments.of(
                    "/json/v3/schema/multiformat/asyncapi/2.3.0/vnd.aai.asyncapi/draft-07-core-schema-meta-schema.json",
                    AsyncAPIFormatSchema(
                        "application/vnd.aai.asyncapi;version=2.3.0",
                        Draft07CoreSchemaMetaSchemaTest().asyncAPISchema()
                    )
                ),
                Arguments.of(
                    "/json/v3/schema/multiformat/asyncapi/2.3.0/vnd.aai.asyncapi/enumerated-values.schema.json",
                    AsyncAPIFormatSchema(
                        "application/vnd.aai.asyncapi;version=2.3.0",
                        EnumeratedValuesTest().asyncAPISchema()
                    )
                ),
                Arguments.of(
                    "/json/v3/schema/multiformat/asyncapi/2.3.0/vnd.aai.asyncapi/person.schema.json",
                    AsyncAPIFormatSchema(
                        "application/vnd.aai.asyncapi;version=2.3.0",
                        PersonTest().asyncAPISchema()
                    )
                ),
                Arguments.of(
                    "/json/v3/schema/multiformat/asyncapi/2.3.0/vnd.aai.asyncapi/regex-pattern.schema.json",
                    AsyncAPIFormatSchema(
                        "application/vnd.aai.asyncapi;version=2.3.0",
                        RegexPatternTest().asyncAPISchema()
                    )
                )
            )
        }

    }

    class YamlFormat: ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
            return Stream.of(
                Arguments.of(
                    "/json/v3/schema/multiformat/asyncapi/2.3.0/vnd.aai.asyncapi+yaml/arrays.schema.yaml",
                    AsyncAPIFormatSchema(
                        "application/vnd.aai.asyncapi+yaml;version=2.3.0",
                        ArraysSchemaTest().asyncAPISchema()
                    )
                ),
                Arguments.of(
                    "/json/v3/schema/multiformat/asyncapi/2.3.0/vnd.aai.asyncapi+yaml/complex-object.schema.yaml",
                    AsyncAPIFormatSchema(
                        "application/vnd.aai.asyncapi+yaml;version=2.3.0",
                        ComplexObjectTest().asyncAPISchema()
                    )
                ),
                Arguments.of(
                    "/json/v3/schema/multiformat/asyncapi/2.3.0/vnd.aai.asyncapi+yaml/conditional-validation-if-else.schema.yaml",
                    AsyncAPIFormatSchema(
                        "application/vnd.aai.asyncapi+yaml;version=2.3.0",
                        ConditionalValidationIfElse().asyncAPISchema()
                    )
                ),
                Arguments.of(
                    "/json/v3/schema/multiformat/asyncapi/2.3.0/vnd.aai.asyncapi+yaml/draft-07-core-schema-meta-schema.yaml",
                    AsyncAPIFormatSchema(
                        "application/vnd.aai.asyncapi+yaml;version=2.3.0",
                        Draft07CoreSchemaMetaSchemaTest().asyncAPISchema()
                    )
                ),
                Arguments.of(
                    "/json/v3/schema/multiformat/asyncapi/2.3.0/vnd.aai.asyncapi+yaml/enumerated-values.schema.yaml",
                    AsyncAPIFormatSchema(
                        "application/vnd.aai.asyncapi+yaml;version=2.3.0",
                        EnumeratedValuesTest().asyncAPISchema()
                    )
                ),
                Arguments.of(
                    "/json/v3/schema/multiformat/asyncapi/2.3.0/vnd.aai.asyncapi+yaml/person.schema.yaml",
                    AsyncAPIFormatSchema(
                        "application/vnd.aai.asyncapi+yaml;version=2.3.0",
                        PersonTest().asyncAPISchema()
                    )
                ),
                Arguments.of(
                    "/json/v3/schema/multiformat/asyncapi/2.3.0/vnd.aai.asyncapi+yaml/regex-pattern.schema.yaml",
                    AsyncAPIFormatSchema(
                        "application/vnd.aai.asyncapi+yaml;version=2.3.0",
                        RegexPatternTest().asyncAPISchema()
                    )
                ),
                //
                Arguments.of(
                    "/json/v3/schema/multiformat/asyncapi/2.3.0/vnd.aai.asyncapi/arrays.schema.yaml",
                    AsyncAPIFormatSchema(
                        "application/vnd.aai.asyncapi;version=2.3.0",
                        ArraysSchemaTest().asyncAPISchema()
                    )
                ),
                Arguments.of(
                    "/json/v3/schema/multiformat/asyncapi/2.3.0/vnd.aai.asyncapi/complex-object.schema.yaml",
                    AsyncAPIFormatSchema(
                        "application/vnd.aai.asyncapi;version=2.3.0",
                        ComplexObjectTest().asyncAPISchema()
                    )
                ),
                Arguments.of(
                    "/json/v3/schema/multiformat/asyncapi/2.3.0/vnd.aai.asyncapi/conditional-validation-if-else.schema.yaml",
                    AsyncAPIFormatSchema(
                        "application/vnd.aai.asyncapi;version=2.3.0",
                        ConditionalValidationIfElse().asyncAPISchema()
                    )
                ),
                Arguments.of(
                    "/json/v3/schema/multiformat/asyncapi/2.3.0/vnd.aai.asyncapi/draft-07-core-schema-meta-schema.yaml",
                    AsyncAPIFormatSchema(
                        "application/vnd.aai.asyncapi;version=2.3.0",
                        Draft07CoreSchemaMetaSchemaTest().asyncAPISchema()
                    )
                ),
                Arguments.of(
                    "/json/v3/schema/multiformat/asyncapi/2.3.0/vnd.aai.asyncapi/enumerated-values.schema.yaml",
                    AsyncAPIFormatSchema(
                        "application/vnd.aai.asyncapi;version=2.3.0",
                        EnumeratedValuesTest().asyncAPISchema()
                    )
                ),
                Arguments.of(
                    "/json/v3/schema/multiformat/asyncapi/2.3.0/vnd.aai.asyncapi/person.schema.yaml",
                    AsyncAPIFormatSchema(
                        "application/vnd.aai.asyncapi;version=2.3.0",
                        PersonTest().asyncAPISchema()
                    )
                ),
                Arguments.of(
                    "/json/v3/schema/multiformat/asyncapi/2.3.0/vnd.aai.asyncapi/regex-pattern.schema.yaml",
                    AsyncAPIFormatSchema(
                        "application/vnd.aai.asyncapi;version=2.3.0",
                        RegexPatternTest().asyncAPISchema()
                    )
                )
            )
        }

    }

}