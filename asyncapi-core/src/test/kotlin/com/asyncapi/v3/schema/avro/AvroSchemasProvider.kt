package com.asyncapi.v3.schema.avro

import com.asyncapi.v3.schema.avro.v1._9_0.*
import com.asyncapi.v3.schema.avro.v1._9_0.Avro.LogicalType

class AvroSchemasProvider {

    fun applicationEventTest(): AvroRecord {
        return AvroRecord.recordBuilder()
            .name("ApplicationEvent")
            .namespace("model")
            .doc("")
            .fields(listOf(
                AvroRecordField.builder()
                    .name("applicationId")
                    .type(AvroType.STRING)
                    .doc("Application ID")
                    .build(),
                AvroRecordField.builder()
                    .name("status")
                    .type(AvroType.STRING)
                    .doc("Application Status")
                    .build(),
                AvroRecordField.builder()
                    .name("documents")
                    .type(AvroUnion(
                        AvroType.NULL,
                        AvroArray("model.DocumentInfo")
                    ))
                    .doc("")
                    .defaultValue(null)
                    .build()
            ))
            .build()
    }

    fun documentInfo(): AvroRecord {
        return AvroRecord.recordBuilder()
            .name("DocumentInfo")
            .namespace("model")
            .doc("")
            .fields(listOf(
                AvroRecordField.builder()
                    .name("documentId")
                    .type(AvroType.STRING)
                    .doc("Document ID")
                    .build(),
                AvroRecordField.builder()
                    .name("filePath")
                    .type(AvroType.STRING)
                    .doc("Document Path")
                    .build()
            ))
            .build()
    }

    fun fooBar(): AvroRecord {
        return AvroRecord.recordBuilder()
            .name("Bar")
            .namespace("foo")
            .fields(listOf(
                AvroRecordField.builder()
                    .name("title")
                    .type(AvroType.STRING)
                    .build(),
                AvroRecordField.builder()
                    .name("created_at")
                    .type(AvroUnion(
                        AvroType.NULL,
                        Avro.builder()
                            .type(AvroType.LONG)
                            .logicalType(Avro.LogicalType.TIMESTAMP_MILLIS)
                            .build()
                    ))
                    .build()
            ))
            .build()
    }

    fun fullRecordV1(): AvroRecord {
        return AvroRecord.recordBuilder()
            .name("FullRecordV1")
            .namespace("org.apache.avro.specific.test")
            .doc("Test schema changes: this is the 'old' schema the SpecificRecord expects to see")
            .fields(listOf(
                AvroRecordField.builder()
                    .name("b")
                    .type(AvroType.BOOLEAN)
                    .build(),
                AvroRecordField.builder()
                    .name("i32")
                    .type(AvroType.INT)
                    .build(),
                AvroRecordField.builder()
                    .name("i64")
                    .type(AvroType.LONG)
                    .build(),
                AvroRecordField.builder()
                    .name("f32")
                    .type(AvroType.FLOAT)
                    .build(),
                AvroRecordField.builder()
                    .name("f64")
                    .type(AvroType.DOUBLE)
                    .build(),
                AvroRecordField.builder()
                    .name("s")
                    .type(AvroUnion(
                        AvroType.NULL, AvroType.STRING
                    ))
                    .build(),
                AvroRecordField.builder()
                    .name("h")
                    .type(AvroUnion(
                        AvroType.NULL, AvroType.STRING
                    ))
                    .build()
            ))
            .build()
    }

    fun fullRecordV2(): AvroRecord {
        return AvroRecord.recordBuilder()
            .name("FullRecordV2")
            .namespace("org.apache.avro.specific.test")
            .doc("Test schema changes: this is the 'new' schema actually used to write data")
            .fields(listOf(
                AvroRecordField.builder()
                    .name("b")
                    .type(AvroType.BOOLEAN)
                    .build(),
                AvroRecordField.builder()
                    .name("i64")
                    .type(AvroType.INT)
                    .build(),
                AvroRecordField.builder()
                    .name("i32")
                    .type(AvroType.INT)
                    .build(),
                AvroRecordField.builder()
                    .name("f64")
                    .type(AvroType.LONG)
                    .build(),
                AvroRecordField.builder()
                    .name("f32")
                    .type(AvroUnion(
                        AvroType.FLOAT, AvroType.NULL
                    ))
                    .build(),
                AvroRecordField.builder()
                    .name("newfield")
                    .type(AvroType.STRING)
                    .build(),
                AvroRecordField.builder()
                    .name("h")
                    .type(AvroType.BYTES)
                    .build(),
                AvroRecordField.builder()
                    .name("myMap")
                    .type(AvroMap(AvroType.STRING))
                    .build()
            ))
            .build()
    }

    fun logicalUUID(): AvroRecord {
        return AvroRecord.recordBuilder()
            .name("Action")
            .namespace("schema.common")
            .fields(listOf(
                AvroRecordField.builder()
                    .name("name")
                    .type(AvroType.STRING)
                    .build(),
                AvroRecordField.builder()
                    .name("guid")
                    .type(
                        Avro.builder()
                        .type(AvroType.STRING)
                        .logicalType(Avro.LogicalType.UUID)
                        .build()
                    )
                    .build(),
                AvroRecordField.builder()
                    .name("time")
                    .type(
                        Avro.builder()
                        .type(AvroType.LONG)
                        .logicalType(Avro.LogicalType.TIMESTAMP_MILLIS)
                        .build()
                    )
                    .build(),
                AvroRecordField.builder()
                    .name("requestId")
                    .type(AvroUnion(
                        AvroType.NULL, AvroType.STRING
                    ))
                    .build()
            ))
            .build()
    }

    fun logicalTypesWithMultipleFields(): AvroRecord {
        return AvroRecord.recordBuilder()
            .name("Action")
            .namespace("schema.common")
            .fields(listOf(
                AvroRecordField.builder()
                    .name("name")
                    .type(AvroType.STRING)
                    .build(),
                AvroRecordField.builder()
                    .name("uuid")
                    .type(AvroType.STRING)
                    .build(),
                AvroRecordField.builder()
                    .name("time")
                    .type(
                        Avro.builder()
                        .type(AvroType.LONG)
                        .logicalType(Avro.LogicalType.TIMESTAMP_MILLIS)
                        .build()
                    )
                    .build(),
                AvroRecordField.builder()
                    .name("requestId")
                    .type(AvroUnion(
                        AvroType.NULL, AvroType.STRING
                    ))
                    .build()
            ))
            .build()
    }

    fun myResponse(): AvroRecord {
        return AvroRecord.recordBuilder()
            .name("MyResponse")
            .namespace("model")
            .doc("")
            .fields(listOf(
                AvroRecordField.builder()
                    .name("isSuccessful")
                    .doc("Indicator for successful or unsuccessful call")
                    .type(AvroType.BOOLEAN)
                    .build()
            ))
            .build()
    }

    fun regressionErrorFieldInRecord(): AvroRecord {
        return AvroRecord.recordBuilder()
            .name("RecordWithErrorField")
            .namespace("org.apache.avro.specific.test")
            .doc("With custom coders in Avro 1.9, previously successful records with error fields now fail to compile.")
            .fields(listOf(
                AvroRecordField.builder()
                    .name("s")
                    .type(AvroUnion(
                        AvroType.NULL, AvroType.STRING
                    ))
                    .defaultValue(null)
                    .build(),
                AvroRecordField.builder()
                    .name("e")
                    .type(AvroUnion(
                        AvroType.NULL, AvroRecord.recordBuilder()
                            .type(AvroType.ERROR)
                            .name("TestError")
                            .fields(listOf(
                                AvroRecordField.builder()
                                    .name("message")
                                    .type(AvroType.STRING)
                                    .build()
                            ))
                            .build()
                    ))
                    .defaultValue(null)
                    .build()
            ))
            .build()
    }

    fun schemaLocation(): AvroRecord {
        val lat = AvroRecordField.builder()
            .name("lat")
            .type(AvroType.FLOAT)
            .build()
        lat.metadata = mapOf(Pair("field-id", 1))

        val long = AvroRecordField.builder()
            .name("long")
            .type(listOf(AvroType.NULL, AvroType.FLOAT))
            .defaultValue(null)
            .build()
        long.metadata = mapOf(Pair("field-id", 2))

        return AvroRecord.recordBuilder()
            .name("r7")
            .fields(listOf(lat, long))
            .build()
    }

    fun schemaLocationRead(): AvroRecord {
        return AvroRecord.recordBuilder()
            .name("table")
            .fields(listOf(
                AvroRecordField.builder()
                    .name("location")
                    .type(AvroUnion(
                        AvroType.NULL, AvroMap.mapBuilder()
                        .values(AvroUnion(
                            AvroType.NULL,
                            AvroRecord.recordBuilder()
                                .name("r7")
                                .fields(listOf(
                                    AvroRecordField.builder()
                                        .name("lat")
                                        .type(AvroType.FLOAT)
                                        .metadata(mapOf(Pair("field-id", 1)))
                                        .build(),
                                    AvroRecordField.builder()
                                        .name("long_r2")
                                        .type(AvroUnion(AvroType.NULL, AvroType.FLOAT))
                                        .defaultValue(null)
                                        .metadata(mapOf(Pair("field-id", 2)))
                                        .build()
                                ))
                                .build()
                        ))
                        .metadata(mapOf(
                            Pair("key-id", 6),
                            Pair("value-id", 7)
                        ))
                        .build())
                    )
                    .defaultValue(null)
                    .metadata(mapOf(Pair("field-id", 5)))
                    .build()
            ))
            .build()
    }

    fun schemaLocationWrite(): AvroRecord {
        return AvroRecord.recordBuilder()
            .name("table")
            .fields(listOf(
                AvroRecordField.builder()
                    .name("location")
                    .type(AvroUnion(
                        AvroType.NULL, AvroMap.mapBuilder()
                        .values(AvroUnion(
                            AvroType.NULL,
                            AvroRecord.recordBuilder()
                                .name("r7")
                                .fields(listOf(
                                    AvroRecordField.builder()
                                        .name("lat")
                                        .type(AvroType.FLOAT)
                                        .metadata(mapOf(Pair("field-id", 1)))
                                        .build(),
                                    AvroRecordField.builder()
                                        .name("long")
                                        .type(AvroUnion(AvroType.NULL, AvroType.FLOAT))
                                        .defaultValue(null)
                                        .metadata(mapOf(Pair("field-id", 2)))
                                        .build()
                                ))
                                .build()
                        ))
                        .metadata(mapOf(
                            Pair("key-id", 6),
                            Pair("value-id", 7)
                        ))
                        .build())
                    )
                    .defaultValue(null)
                    .metadata(mapOf(Pair("field-id", 5)))
                    .build()
            ))
            .build()
    }

    fun schemaBuilder(): AvroRecord {
        return AvroRecord.recordBuilder()
            .name("recordAll")
            .fields(listOf(
                AvroRecordField.builder()
                    .name("requiredBoolean")
                    .type(AvroType.BOOLEAN)
                    .build(),
                AvroRecordField.builder()
                    .name("requiredBooleanWithDefault")
                    .type(AvroType.BOOLEAN)
                    .defaultValue(true)
                    .build(),
                AvroRecordField.builder()
                    .name("optionalBoolean")
                    .type(AvroUnion(AvroType.NULL, AvroType.BOOLEAN))
                    .defaultValue(null)
                    .build(),
                AvroRecordField.builder()
                    .name("optionalBooleanWithDefault")
                    .type(AvroUnion(AvroType.BOOLEAN, AvroType.NULL))
                    .defaultValue(true)
                    .build(),
                AvroRecordField.builder()
                    .name("requiredInt")
                    .type(AvroType.INT)
                    .build(),
                AvroRecordField.builder()
                    .name("optionalInt")
                    .type(AvroUnion(AvroType.NULL, AvroType.INT))
                    .defaultValue(null)
                    .build(),
                AvroRecordField.builder()
                    .name("optionalIntWithDefault")
                    .type(AvroUnion(AvroType.INT, AvroType.NULL))
                    .defaultValue(1)
                    .build(),
                AvroRecordField.builder()
                    .name("requiredLong")
                    .type(AvroType.LONG)
                    .build(),
                AvroRecordField.builder()
                    .name("optionalLong")
                    .type(AvroUnion(AvroType.NULL, AvroType.LONG))
                    .defaultValue(null)
                    .build(),
                AvroRecordField.builder()
                    .name("optionalLongWithDefault")
                    .type(AvroUnion(AvroType.LONG, AvroType.NULL))
                    .defaultValue(1)
                    .build(),
                AvroRecordField.builder()
                    .name("requiredFloat")
                    .type(AvroType.FLOAT)
                    .build(),
                AvroRecordField.builder()
                    .name("optionalFloat")
                    .type(AvroUnion(AvroType.NULL, AvroType.FLOAT))
                    .defaultValue(null)
                    .build(),
                AvroRecordField.builder()
                    .name("optionalFloatWithDefault")
                    .type(AvroUnion(AvroType.FLOAT, AvroType.NULL))
                    .defaultValue(1.0)
                    .build(),
                AvroRecordField.builder()
                    .name("requiredDouble")
                    .type(AvroType.DOUBLE)
                    .build(),
                AvroRecordField.builder()
                    .name("optionalDouble")
                    .type(AvroUnion(AvroType.NULL, AvroType.DOUBLE))
                    .defaultValue(null)
                    .build(),
                AvroRecordField.builder()
                    .name("optionalDoubleWithDefault")
                    .type(AvroUnion(AvroType.DOUBLE, AvroType.NULL))
                    .defaultValue(1.0)
                    .build(),
                AvroRecordField.builder()
                    .name("requiredBytes")
                    .type(AvroType.BYTES)
                    .build(),
                AvroRecordField.builder()
                    .name("optionalBytes")
                    .type(AvroUnion(AvroType.NULL, AvroType.BYTES))
                    .defaultValue(null)
                    .build(),
                AvroRecordField.builder()
                    .name("optionalBytesWithDefault")
                    .type(AvroUnion(AvroType.BYTES, AvroType.NULL))
                    .defaultValue("A")
                    .build(),
                AvroRecordField.builder()
                    .name("requiredString")
                    .type(AvroType.STRING)
                    .build(),
                AvroRecordField.builder()
                    .name("optionalString")
                    .type(AvroUnion(AvroType.NULL, AvroType.STRING))
                    .defaultValue(null)
                    .build(),
                AvroRecordField.builder()
                    .name("optionalStringWithDefault")
                    .type(AvroUnion(AvroType.STRING, AvroType.NULL))
                    .defaultValue("a")
                    .build(),
                AvroRecordField.builder()
                    .name("requiredRecord")
                    .type(
                        AvroRecord.recordBuilder()
                        .name("nestedRequiredRecord")
                        .fields(listOf(
                            AvroRecordField.builder()
                            .name("nestedRequiredBoolean")
                            .type(AvroType.BOOLEAN)
                            .build())
                        )
                        .build()
                    )
                    .build(),
                AvroRecordField.builder()
                    .name("optionalRecord")
                    .type(AvroUnion(
                        AvroType.NULL, AvroRecord.recordBuilder()
                        .name("nestedOptionalRecord")
                        .fields(listOf(
                            AvroRecordField.builder()
                            .name("nestedRequiredBoolean")
                            .type(AvroType.BOOLEAN)
                            .build())
                        )
                        .build()
                    ))
                    .defaultValue(null)
                    .build(),
                AvroRecordField.builder()
                    .name("optionalRecordWithDefault")
                    .type(AvroUnion(
                        AvroRecord.recordBuilder()
                        .name("nestedOptionalRecordWithDefault")
                        .fields(listOf(
                            AvroRecordField.builder()
                            .name("nestedRequiredBoolean")
                            .type(AvroType.BOOLEAN)
                            .build())
                        )
                        .build(), AvroType.NULL
                    ))
                    .defaultValue(mapOf(Pair("nestedRequiredBoolean", true)))
                    .build(),
                AvroRecordField.builder()
                    .name("requiredEnum")
                    .type(
                        AvroEnum.enumBuilder()
                        .name("requiredEnum")
                        .symbols(listOf("a", "b"))
                        .build()
                    )
                    .build(),
                AvroRecordField.builder()
                    .name("optionalEnum")
                    .type(AvroUnion(
                        AvroType.NULL, AvroEnum.enumBuilder()
                        .name("optionalEnum")
                        .symbols(listOf("a", "b"))
                        .build()
                    ))
                    .defaultValue(null)
                    .build(),
                AvroRecordField.builder()
                    .name("optionalEnumWithDefault")
                    .type(AvroUnion(
                        AvroEnum.enumBuilder()
                        .name("optionalEnumWithDefault")
                        .symbols(listOf("a", "b"))
                        .build(), AvroType.NULL,
                    ))
                    .defaultValue("b")
                    .build(),
                AvroRecordField.builder()
                    .name("requiredArray")
                    .type(
                        AvroArray.arrayBuilder()
                        .items(AvroType.STRING)
                        .build()
                    )
                    .build(),
                AvroRecordField.builder()
                    .name("optionalArray")
                    .type(AvroUnion(
                        AvroType.NULL, AvroArray.arrayBuilder()
                        .items(AvroType.STRING)
                        .build()
                    ))
                    .defaultValue(null)
                    .build(),
                AvroRecordField.builder()
                    .name("optionalArrayWithDefault")
                    .type(AvroUnion(
                        AvroArray.arrayBuilder()
                        .items(AvroType.STRING)
                        .build(), AvroType.NULL
                    ))
                    .defaultValue(listOf("a"))
                    .build(),
                AvroRecordField.builder()
                    .name("requiredMap")
                    .type(
                        AvroMap.mapBuilder()
                        .values(AvroType.STRING)
                        .build()
                    )
                    .build(),
                AvroRecordField.builder()
                    .name("optionalMap")
                    .type(AvroUnion(
                        AvroType.NULL, AvroMap.mapBuilder()
                        .values(AvroType.STRING)
                        .build()
                    ))
                    .defaultValue(null)
                    .build(),
                AvroRecordField.builder()
                    .name("optionalMapWithDefault")
                    .type(AvroUnion(
                        AvroMap.mapBuilder()
                        .values(AvroType.STRING)
                        .build(), AvroType.NULL
                    ))
                    .defaultValue(mapOf(Pair("a", "b")))
                    .build(),
                AvroRecordField.builder()
                    .name("requiredFixed")
                    .type(
                        AvroFixed.fixedBuilder()
                        .name("requiredFixed")
                        .size(1)
                        .build()
                    )
                    .build(),
                AvroRecordField.builder()
                    .name("optionalFixed")
                    .type(AvroUnion(
                        AvroType.NULL, AvroFixed.fixedBuilder()
                        .name("optionalFixed")
                        .size(1)
                        .build()
                    ))
                    .defaultValue(null)
                    .build(),
                AvroRecordField.builder()
                    .name("optionalFixedWithDefault")
                    .type(AvroUnion(
                        AvroFixed.fixedBuilder()
                        .name("optionalFixedWithDefault")
                        .size(1)
                        .build(), AvroType.NULL
                    ))
                    .defaultValue("A")
                    .build(),
                AvroRecordField.builder()
                    .name("unionType")
                    .type(listOf(AvroType.LONG, AvroType.NULL))
                    .build(),
                AvroRecordField.builder()
                    .name("unionBooleanWithDefault")
                    .type(listOf(AvroType.BOOLEAN, AvroType.INT))
                    .defaultValue(true)
                    .build(),
                AvroRecordField.builder()
                    .name("unionIntWithDefault")
                    .type(listOf(AvroType.INT, AvroType.NULL))
                    .defaultValue(1)
                    .build(),
                AvroRecordField.builder()
                    .name("unionLongWithDefault")
                    .type(listOf(AvroType.LONG, AvroType.INT))
                    .defaultValue(1)
                    .build(),
                AvroRecordField.builder()
                    .name("unionFloatWithDefault")
                    .type(listOf(AvroType.FLOAT, AvroType.INT))
                    .defaultValue(1.0)
                    .build(),
                AvroRecordField.builder()
                    .name("unionDoubleWithDefault")
                    .type(listOf(AvroType.DOUBLE, AvroType.INT))
                    .defaultValue(1.0)
                    .build(),
                AvroRecordField.builder()
                    .name("unionBytesWithDefault")
                    .type(listOf(AvroType.BYTES, AvroType.INT))
                    .defaultValue("A")
                    .build(),
                AvroRecordField.builder()
                    .name("unionStringWithDefault")
                    .type(listOf(AvroType.STRING, AvroType.INT))
                    .defaultValue("a")
                    .build(),
                AvroRecordField.builder()
                    .name("unionRecordWithDefault")
                    .type(listOf(
                        AvroRecord.recordBuilder()
                        .name("nestedUnionRecordWithDefault")
                        .fields(listOf(
                            AvroRecordField.builder()
                                .name("nestedRequiredBoolean")
                                .type(AvroType.BOOLEAN)
                                .build()
                        ))
                        .build(), AvroType.INT
                    ))
                    .defaultValue(mapOf(Pair("nestedRequiredBoolean", true)))
                    .build(),
                AvroRecordField.builder()
                    .name("unionEnumWithDefault")
                    .type(listOf(
                        AvroEnum.enumBuilder()
                        .name("nestedUnionEnumWithDefault")
                        .symbols(listOf("a", "b"))
                        .build(), AvroType.INT
                    ))
                    .defaultValue("b")
                    .build(),
                AvroRecordField.builder()
                    .name("unionArrayWithDefault")
                    .type(listOf(
                        AvroArray.arrayBuilder()
                        .items(AvroType.STRING)
                        .build(), AvroType.INT
                    ))
                    .defaultValue(listOf("a"))
                    .build(),
                AvroRecordField.builder()
                    .name("unionMapWithDefault")
                    .type(listOf(
                        AvroMap.mapBuilder()
                        .values(AvroType.STRING)
                        .build(), AvroType.INT
                    ))
                    .defaultValue(mapOf(Pair("a", "b")))
                    .build(),
                AvroRecordField.builder()
                    .name("unionFixedWithDefault")
                    .type(listOf(
                        AvroFixed.fixedBuilder()
                        .name("nestedUnionFixedWithDefault")
                        .size(1)
                        .build(), AvroType.INT
                    ))
                    .defaultValue("A")
                    .build(),
            ))
            .build()
    }

    fun simpleRecord(): AvroRecord {
        return AvroRecord.recordBuilder()
            .name("SimpleRecord")
            .fields(listOf(
                AvroRecordField.builder()
                    .type(AvroType.INT)
                    .name("value")
                    .build(),
                AvroRecordField.builder()
                    .type(AvroUnion(AvroType.NULL, AvroType.INT))
                    .name("nullableValue")
                    .doc("doc")
                    .build()
            ))
            .build()
    }

    fun testRecordWithLogicalTypes(): AvroRecord {
        return AvroRecord.recordBuilder()
            .name("TestRecordWithLogicalTypes")
            .doc("Schema for TestRecordWithLogicalTypes and TestRecordWithoutLogicalTypes, see TestSpecificLogicalTypes")
            .namespace("org.apache.avro.specific")
            .fields(listOf(
                AvroRecordField.builder()
                    .type(AvroType.BOOLEAN)
                    .name("b")
                    .build(),
                AvroRecordField.builder()
                    .type(AvroType.INT)
                    .name("i32")
                    .build(),
                AvroRecordField.builder()
                    .type(AvroType.LONG)
                    .name("i64")
                    .build(),
                AvroRecordField.builder()
                    .type(AvroType.FLOAT)
                    .name("f32")
                    .build(),
                AvroRecordField.builder()
                    .type(AvroType.DOUBLE)
                    .name("f64")
                    .build(),
                AvroRecordField.builder()
                    .type(AvroUnion(AvroType.NULL, AvroType.STRING))
                    .name("s")
                    .defaultValue(null)
                    .build(),
                AvroRecordField.builder()
                    .type(Avro.builder()
                        .type(AvroType.INT)
                        .logicalType(Avro.LogicalType.DATE)
                        .build()
                    )
                    .name("d")
                    .build(),
                AvroRecordField.builder()
                    .type(Avro.builder()
                        .type(AvroType.INT)
                        .logicalType(Avro.LogicalType.TIME_MILLIS)
                        .build()
                    )
                    .name("t")
                    .build(),
                AvroRecordField.builder()
                    .type(Avro.builder()
                        .type(AvroType.LONG)
                        .logicalType(Avro.LogicalType.TIMESTAMP_MILLIS)
                        .build()
                    )
                    .name("ts")
                    .build(),
                AvroRecordField.builder()
                    .type(Avro.builder()
                        .type(AvroType.BYTES)
                        .logicalType(Avro.LogicalType.BIG_DECIMAL)
                        .build()
                    )
                    .name("bd")
                    .build(),
            ))
            .build()
    }

    fun testRecordWithMapsAndArrays(): AvroRecord {
        return AvroRecord.recordBuilder()
            .name("TestRecordWithMapsAndArrays")
            .namespace("org.apache.avro.specific")
            .fields(listOf(
                AvroRecordField.builder()
                    .name("arr")
                    .type(AvroArray.arrayBuilder()
                        .items(AvroType.STRING)
                        .defaultValue(emptyList())
                        .build()
                    )
                    .build(),
                AvroRecordField.builder()
                    .name("map")
                    .type(AvroMap.mapBuilder()
                        .values(AvroType.LONG)
                        .defaultValue(emptyMap())
                        .build()
                    )
                    .build()
            ))
            .build()
    }

    fun testUnionRecord(): AvroUnion {
        return AvroUnion(
            AvroType.NULL,
            AvroRecord.recordBuilder()
                .name("TestUnionRecord")
                .namespace("org.apache.avro.specific")
                .fields(listOf(
                    AvroRecordField.builder()
                        .name("amount")
                        .type(AvroUnion(
                            AvroType.NULL,
                            Avro.builder()
                                .type(AvroType.BYTES)
                                .logicalType(Avro.LogicalType.DECIMAL)
                                .precision(31)
                                .scale(8)
                                .build()
                        ))
                        .defaultValue(null)
                        .build()
                ))
                .build()
        )
    }

    fun unionAndFixedFields(): AvroRecord {
        return AvroRecord.recordBuilder()
            .name("UnionAndFixedFields")
            .doc("Schema for UnionAndFixedFields designed to trigger fixed compiler warnings in generated code")
            .namespace("org.apache.avro.specific")
            .fields(listOf(
                AvroRecordField.builder()
                    .name("u")
                    .type(AvroUnion(
                        AvroType.BOOLEAN, AvroType.INT, AvroType.LONG, AvroType.FLOAT, AvroType.STRING
                    ))
                    .build(),
                AvroRecordField.builder()
                    .name("l")
                    .type(AvroUnion(
                        AvroType.STRING, Avro.builder()
                            .type(AvroType.LONG)
                            .logicalType(LogicalType.TIMESTAMP_MILLIS)
                            .build()
                    ))
                    .build(),
                AvroRecordField.builder()
                    .name("f")
                    .type(AvroFixed.fixedBuilder()
                        .name("md5")
                        .size(16)
                        .build()
                    )
                    .build()
            ))
            .build()
    }

}