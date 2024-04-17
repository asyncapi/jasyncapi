package com.asyncapi.v3.schema.avro

import com.asyncapi.v3.ClasspathUtils
import com.asyncapi.v3.schema.avro.v1._9_0.Avro
import com.asyncapi.v3.schema.avro.v1._9_0.AvroUnion
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
                Arguments.of("/json/v3/schema/avro/ApplicationEvent.avsc", Avro::class.java, AvroSchemasProvider().applicationEventTest()),
                Arguments.of("/json/v3/schema/avro/DocumentInfo.avsc", Avro::class.java, AvroSchemasProvider().documentInfo()),
                Arguments.of("/json/v3/schema/avro/foo.Bar.avsc", Avro::class.java,  AvroSchemasProvider().fooBar()),
                Arguments.of("/json/v3/schema/avro/full_record_v1.avsc", Avro::class.java,  AvroSchemasProvider().fullRecordV1()),
                Arguments.of("/json/v3/schema/avro/full_record_v2.avsc", Avro::class.java,  AvroSchemasProvider().fullRecordV2()),
                Arguments.of("/json/v3/schema/avro/logical-uuid.avsc", Avro::class.java,  AvroSchemasProvider().logicalUUID()),
                Arguments.of("/json/v3/schema/avro/logical_types_with_multiple_fields.avsc", Avro::class.java,  AvroSchemasProvider().logicalTypesWithMultipleFields()),
                Arguments.of("/json/v3/schema/avro/MyResponse.avsc", Avro::class.java,  AvroSchemasProvider().myResponse()),
                Arguments.of("/json/v3/schema/avro/regression_error_field_in_record.avsc", Avro::class.java,  AvroSchemasProvider().regressionErrorFieldInRecord()),
                Arguments.of("/json/v3/schema/avro/schema-location.json", Avro::class.java,  AvroSchemasProvider().schemaLocation()),
                Arguments.of("/json/v3/schema/avro/schema-location-read.json", Avro::class.java,  AvroSchemasProvider().schemaLocationRead()),
                Arguments.of("/json/v3/schema/avro/schema-location-write.json", Avro::class.java,  AvroSchemasProvider().schemaLocationWrite()),
                Arguments.of("/json/v3/schema/avro/SchemaBuilder.avsc", Avro::class.java,  AvroSchemasProvider().schemaBuilder()),
                Arguments.of("/json/v3/schema/avro/simple_record.avsc", Avro::class.java,  AvroSchemasProvider().simpleRecord()),
                Arguments.of("/json/v3/schema/avro/TestRecordWithLogicalTypes.avsc", Avro::class.java,  AvroSchemasProvider().testRecordWithLogicalTypes()),
                Arguments.of("/json/v3/schema/avro/TestRecordWithMapsAndArrays.avsc", Avro::class.java,  AvroSchemasProvider().testRecordWithMapsAndArrays()),
                Arguments.of("/json/v3/schema/avro/TestUnionRecord.avsc", AvroUnion::class.java,  AvroSchemasProvider().testUnionRecord()),
                Arguments.of("/json/v3/schema/avro/union_and_fixed_fields.avsc", Avro::class.java,  AvroSchemasProvider().unionAndFixedFields()),
            )
        }

    }

}