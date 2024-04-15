package com.asyncapi.v3.schema.avro

import com.asyncapi.v3.ClasspathUtils
import com.asyncapi.v3.schema.avro.v1._9_0.Avro
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class AvroSchemaTest {

    fun compareSchemas(
        schemaToCheckPath: String,
        schemaToCheck: Avro
    ) {
        val schemaAsJson = ClasspathUtils.readAsString(schemaToCheckPath)
        val schema = objectMapper.readValue(schemaAsJson, Avro::class.java)

        Assertions.assertEquals(schema, schemaToCheck)
    }

    private val objectMapper: ObjectMapper = ObjectMapper(YAMLFactory())
        .setSerializationInclusion(JsonInclude.Include.NON_NULL)
        .findAndRegisterModules()

    @ArgumentsSource(AvroSchemas::class)
    @ParameterizedTest(name = "Read: {0}")
    fun read(schemaToCheckPath: String, avroSchema: Avro) {
        compareSchemas(schemaToCheckPath, avroSchema)
    }

    class AvroSchemas: ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
            return Stream.of(
//                Arguments.of("/json/v3/schema/avro/ApplicationEvent.avsc", AvroSchemasProvider().applicationEventTest()), // TODO: fix - Cannot deserialize value of type `com.asyncapi.v3.schema.avro.v1._9_0.AvroSchemaType` from String "model.DocumentInfo"
                Arguments.of("/json/v3/schema/avro/DocumentInfo.avsc", AvroSchemasProvider().documentInfo()),
                Arguments.of("/json/v3/schema/avro/foo.Bar.avsc", AvroSchemasProvider().fooBar()),
                Arguments.of("/json/v3/schema/avro/full_record_v1.avsc", AvroSchemasProvider().fullRecordV1()),
                Arguments.of("/json/v3/schema/avro/full_record_v2.avsc", AvroSchemasProvider().fullRecordV2()),
                Arguments.of("/json/v3/schema/avro/logical-uuid.avsc", AvroSchemasProvider().logicalUUID()),
                Arguments.of("/json/v3/schema/avro/logical_types_with_multiple_fields.avsc", AvroSchemasProvider().logicalTypesWithMultipleFields()),
                Arguments.of("/json/v3/schema/avro/MyResponse.avsc", AvroSchemasProvider().myResponse()),
                Arguments.of("/json/v3/schema/avro/regression_error_field_in_record.avsc", AvroSchemasProvider().regressionErrorFieldInRecord()),
                Arguments.of("/json/v3/schema/avro/schema-location.json", AvroSchemasProvider().schemaLocation()),
                Arguments.of("/json/v3/schema/avro/schema-location-read.json", AvroSchemasProvider().schemaLocationRead()),
                Arguments.of("/json/v3/schema/avro/schema-location-write.json", AvroSchemasProvider().schemaLocationWrite()),
                Arguments.of("/json/v3/schema/avro/SchemaBuilder.avsc", AvroSchemasProvider().schemaBuilder()),
            )
        }

    }

}