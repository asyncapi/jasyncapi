package com.asyncapi.schemas.multiformat.asyncapi

import com.asyncapi.schemas.json.*
import com.asyncapi.schemas.asyncapi.multiformat.AsyncAPIFormatSchema
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

abstract class AsyncAPIFormatSchemaV3_0_0Test: AsyncAPIFormatSchemaTest() {

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
                    "/schemas/multiformat/asyncapi/3.0.0/vnd.aai.asyncapi+json/arrays.schema.json",
                    AsyncAPIFormatSchema(
                        "application/vnd.aai.asyncapi+json;version=3.0.0",
                        ArraysSchemaTest().asyncAPISchema()
                    )
                ),
                Arguments.of(
                    "/schemas/multiformat/asyncapi/3.0.0/vnd.aai.asyncapi+json/complex-object.schema.json",
                    AsyncAPIFormatSchema(
                        "application/vnd.aai.asyncapi+json;version=3.0.0",
                        ComplexObjectTest().asyncAPISchema()
                    )
                ),
                Arguments.of(
                    "/schemas/multiformat/asyncapi/3.0.0/vnd.aai.asyncapi+json/conditional-validation-if-else.schema.json",
                    AsyncAPIFormatSchema(
                        "application/vnd.aai.asyncapi+json;version=3.0.0",
                        ConditionalValidationIfElse().asyncAPISchema()
                    )
                ),
                Arguments.of(
                    "/schemas/multiformat/asyncapi/3.0.0/vnd.aai.asyncapi+json/draft-07-core-schema-meta-schema.json",
                    AsyncAPIFormatSchema(
                        "application/vnd.aai.asyncapi+json;version=3.0.0",
                        Draft07CoreSchemaMetaSchemaTest().asyncAPISchema()
                    )
                ),
                Arguments.of(
                    "/schemas/multiformat/asyncapi/3.0.0/vnd.aai.asyncapi+json/enumerated-values.schema.json",
                    AsyncAPIFormatSchema(
                        "application/vnd.aai.asyncapi+json;version=3.0.0",
                        EnumeratedValuesTest().asyncAPISchema()
                    )
                ),
                Arguments.of(
                    "/schemas/multiformat/asyncapi/3.0.0/vnd.aai.asyncapi+json/person.schema.json",
                    AsyncAPIFormatSchema(
                        "application/vnd.aai.asyncapi+json;version=3.0.0",
                        PersonTest().asyncAPISchema()
                    )
                ),
                Arguments.of(
                    "/schemas/multiformat/asyncapi/3.0.0/vnd.aai.asyncapi+json/regex-pattern.schema.json",
                    AsyncAPIFormatSchema(
                        "application/vnd.aai.asyncapi+json;version=3.0.0",
                        RegexPatternTest().asyncAPISchema()
                    )
                ),
                //
                Arguments.of(
                    "/schemas/multiformat/asyncapi/3.0.0/vnd.aai.asyncapi/arrays.schema.json",
                    AsyncAPIFormatSchema(
                        "application/vnd.aai.asyncapi;version=3.0.0",
                        ArraysSchemaTest().asyncAPISchema()
                    )
                ),
                Arguments.of(
                    "/schemas/multiformat/asyncapi/3.0.0/vnd.aai.asyncapi/complex-object.schema.json",
                    AsyncAPIFormatSchema(
                        "application/vnd.aai.asyncapi;version=3.0.0",
                        ComplexObjectTest().asyncAPISchema()
                    )
                ),
                Arguments.of(
                    "/schemas/multiformat/asyncapi/3.0.0/vnd.aai.asyncapi/conditional-validation-if-else.schema.json",
                    AsyncAPIFormatSchema(
                        "application/vnd.aai.asyncapi;version=3.0.0",
                        ConditionalValidationIfElse().asyncAPISchema()
                    )
                ),
                Arguments.of(
                    "/schemas/multiformat/asyncapi/3.0.0/vnd.aai.asyncapi/draft-07-core-schema-meta-schema.json",
                    AsyncAPIFormatSchema(
                        "application/vnd.aai.asyncapi;version=3.0.0",
                        Draft07CoreSchemaMetaSchemaTest().asyncAPISchema()
                    )
                ),
                Arguments.of(
                    "/schemas/multiformat/asyncapi/3.0.0/vnd.aai.asyncapi/enumerated-values.schema.json",
                    AsyncAPIFormatSchema(
                        "application/vnd.aai.asyncapi;version=3.0.0",
                        EnumeratedValuesTest().asyncAPISchema()
                    )
                ),
                Arguments.of(
                    "/schemas/multiformat/asyncapi/3.0.0/vnd.aai.asyncapi/person.schema.json",
                    AsyncAPIFormatSchema(
                        "application/vnd.aai.asyncapi;version=3.0.0",
                        PersonTest().asyncAPISchema()
                    )
                ),
                Arguments.of(
                    "/schemas/multiformat/asyncapi/3.0.0/vnd.aai.asyncapi/regex-pattern.schema.json",
                    AsyncAPIFormatSchema(
                        "application/vnd.aai.asyncapi;version=3.0.0",
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
                    "/schemas/multiformat/asyncapi/3.0.0/vnd.aai.asyncapi+yaml/arrays.schema.yaml",
                    AsyncAPIFormatSchema(
                        "application/vnd.aai.asyncapi+yaml;version=3.0.0",
                        ArraysSchemaTest().asyncAPISchema()
                    )
                ),
                Arguments.of(
                    "/schemas/multiformat/asyncapi/3.0.0/vnd.aai.asyncapi+yaml/complex-object.schema.yaml",
                    AsyncAPIFormatSchema(
                        "application/vnd.aai.asyncapi+yaml;version=3.0.0",
                        ComplexObjectTest().asyncAPISchema()
                    )
                ),
                Arguments.of(
                    "/schemas/multiformat/asyncapi/3.0.0/vnd.aai.asyncapi+yaml/conditional-validation-if-else.schema.yaml",
                    AsyncAPIFormatSchema(
                        "application/vnd.aai.asyncapi+yaml;version=3.0.0",
                        ConditionalValidationIfElse().asyncAPISchema()
                    )
                ),
                Arguments.of(
                    "/schemas/multiformat/asyncapi/3.0.0/vnd.aai.asyncapi+yaml/draft-07-core-schema-meta-schema.yaml",
                    AsyncAPIFormatSchema(
                        "application/vnd.aai.asyncapi+yaml;version=3.0.0",
                        Draft07CoreSchemaMetaSchemaTest().asyncAPISchema()
                    )
                ),
                Arguments.of(
                    "/schemas/multiformat/asyncapi/3.0.0/vnd.aai.asyncapi+yaml/enumerated-values.schema.yaml",
                    AsyncAPIFormatSchema(
                        "application/vnd.aai.asyncapi+yaml;version=3.0.0",
                        EnumeratedValuesTest().asyncAPISchema()
                    )
                ),
                Arguments.of(
                    "/schemas/multiformat/asyncapi/3.0.0/vnd.aai.asyncapi+yaml/person.schema.yaml",
                    AsyncAPIFormatSchema(
                        "application/vnd.aai.asyncapi+yaml;version=3.0.0",
                        PersonTest().asyncAPISchema()
                    )
                ),
                Arguments.of(
                    "/schemas/multiformat/asyncapi/3.0.0/vnd.aai.asyncapi+yaml/regex-pattern.schema.yaml",
                    AsyncAPIFormatSchema(
                        "application/vnd.aai.asyncapi+yaml;version=3.0.0",
                        RegexPatternTest().asyncAPISchema()
                    )
                ),
                //
                Arguments.of(
                    "/schemas/multiformat/asyncapi/3.0.0/vnd.aai.asyncapi/arrays.schema.yaml",
                    AsyncAPIFormatSchema(
                        "application/vnd.aai.asyncapi;version=3.0.0",
                        ArraysSchemaTest().asyncAPISchema()
                    )
                ),
                Arguments.of(
                    "/schemas/multiformat/asyncapi/3.0.0/vnd.aai.asyncapi/complex-object.schema.yaml",
                    AsyncAPIFormatSchema(
                        "application/vnd.aai.asyncapi;version=3.0.0",
                        ComplexObjectTest().asyncAPISchema()
                    )
                ),
                Arguments.of(
                    "/schemas/multiformat/asyncapi/3.0.0/vnd.aai.asyncapi/conditional-validation-if-else.schema.yaml",
                    AsyncAPIFormatSchema(
                        "application/vnd.aai.asyncapi;version=3.0.0",
                        ConditionalValidationIfElse().asyncAPISchema()
                    )
                ),
                Arguments.of(
                    "/schemas/multiformat/asyncapi/3.0.0/vnd.aai.asyncapi/draft-07-core-schema-meta-schema.yaml",
                    AsyncAPIFormatSchema(
                        "application/vnd.aai.asyncapi;version=3.0.0",
                        Draft07CoreSchemaMetaSchemaTest().asyncAPISchema()
                    )
                ),
                Arguments.of(
                    "/schemas/multiformat/asyncapi/3.0.0/vnd.aai.asyncapi/enumerated-values.schema.yaml",
                    AsyncAPIFormatSchema(
                        "application/vnd.aai.asyncapi;version=3.0.0",
                        EnumeratedValuesTest().asyncAPISchema()
                    )
                ),
                Arguments.of(
                    "/schemas/multiformat/asyncapi/3.0.0/vnd.aai.asyncapi/person.schema.yaml",
                    AsyncAPIFormatSchema(
                        "application/vnd.aai.asyncapi;version=3.0.0",
                        PersonTest().asyncAPISchema()
                    )
                ),
                Arguments.of(
                    "/schemas/multiformat/asyncapi/3.0.0/vnd.aai.asyncapi/regex-pattern.schema.yaml",
                    AsyncAPIFormatSchema(
                        "application/vnd.aai.asyncapi;version=3.0.0",
                        RegexPatternTest().asyncAPISchema()
                    )
                )
            )
        }

    }

}