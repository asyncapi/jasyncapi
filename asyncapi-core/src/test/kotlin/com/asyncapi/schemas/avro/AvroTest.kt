package com.asyncapi.schemas.avro

import com.asyncapi.v3.ClasspathUtils
import com.asyncapi.schemas.avro.v1._9_0.AvroSchema
import com.asyncapi.schemas.avro.v1._9_0.AvroSchemaUnion
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

class AvroSchemaSchemaTest {

    fun compareSchemas(
        schemaToCheckPath: String,
        clazz: Class<*>,
        schemaToCheck: Any
    ) {
        val schemaAsJson = ClasspathUtils.readAsString(schemaToCheckPath)
        val schema = objectMapper.readValue(schemaAsJson, clazz)

        Assertions.assertEquals(schema, schemaToCheck)
    }

    private val objectMapper: ObjectMapper = ObjectMapper(YAMLFactory())
        .setSerializationInclusion(JsonInclude.Include.NON_NULL)
        .findAndRegisterModules()

    @ArgumentsSource(AvroSchemas::class)
    @ParameterizedTest(name = "Read: {0}")
    fun read(schemaToCheckPath: String, clazz: Class<*>, avroSchema: Any) {
        compareSchemas(schemaToCheckPath, clazz, avroSchema)
    }

    class AvroSchemas: ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
            return Stream.of(
                Arguments.of("/schemas/avro/ApplicationEvent.avsc", AvroSchema::class.java, AvroSchemasProvider().applicationEventTest()),
                Arguments.of("/schemas/avro/DocumentInfo.avsc", AvroSchema::class.java, AvroSchemasProvider().documentInfo()),
                Arguments.of("/schemas/avro/foo.Bar.avsc", AvroSchema::class.java,  AvroSchemasProvider().fooBar()),
                Arguments.of("/schemas/avro/full_record_v1.avsc", AvroSchema::class.java,  AvroSchemasProvider().fullRecordV1()),
                Arguments.of("/schemas/avro/full_record_v2.avsc", AvroSchema::class.java,  AvroSchemasProvider().fullRecordV2()),
                Arguments.of("/schemas/avro/logical-uuid.avsc", AvroSchema::class.java,  AvroSchemasProvider().logicalUUID()),
                Arguments.of("/schemas/avro/logical_types_with_multiple_fields.avsc", AvroSchema::class.java,  AvroSchemasProvider().logicalTypesWithMultipleFields()),
                Arguments.of("/schemas/avro/MyResponse.avsc", AvroSchema::class.java,  AvroSchemasProvider().myResponse()),
                Arguments.of("/schemas/avro/regression_error_field_in_record.avsc", AvroSchema::class.java,  AvroSchemasProvider().regressionErrorFieldInRecord()),
                Arguments.of("/schemas/avro/schema-location.json", AvroSchema::class.java,  AvroSchemasProvider().schemaLocation()),
                Arguments.of("/schemas/avro/schema-location-read.json", AvroSchema::class.java,  AvroSchemasProvider().schemaLocationRead()),
                Arguments.of("/schemas/avro/schema-location-write.json", AvroSchema::class.java,  AvroSchemasProvider().schemaLocationWrite()),
                Arguments.of("/schemas/avro/SchemaBuilder.avsc", AvroSchema::class.java,  AvroSchemasProvider().schemaBuilder()),
                Arguments.of("/schemas/avro/simple_record.avsc", AvroSchema::class.java,  AvroSchemasProvider().simpleRecord()),
                Arguments.of("/schemas/avro/TestRecordWithLogicalTypes.avsc", AvroSchema::class.java,  AvroSchemasProvider().testRecordWithLogicalTypes()),
                Arguments.of("/schemas/avro/TestRecordWithMapsAndArrays.avsc", AvroSchema::class.java,  AvroSchemasProvider().testRecordWithMapsAndArrays()),
                Arguments.of("/schemas/avro/TestUnionRecord.avsc", AvroSchemaUnion::class.java,  AvroSchemasProvider().testUnionRecord()),
                Arguments.of("/schemas/avro/union_and_fixed_fields.avsc", AvroSchema::class.java,  AvroSchemasProvider().unionAndFixedFields()),
            )
        }

    }

}