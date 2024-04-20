package com.asyncapi.v3.schema.avro

import com.asyncapi.v3.schema.avro.v1._9_0.*
import com.asyncapi.v3.schema.avro.v1._9_0.AvroSchemaLogicalType
import com.asyncapi.v3.schema.avro.v1._9_0.AvroSchemaType

class AvroSchemasProvider {

    fun applicationEventTest(): AvroSchemaRecord {
        return AvroSchemaRecord.builder()
            .name("ApplicationEvent")
            .namespace("model")
            .doc("")
            .fields(listOf(
                AvroSchemaRecordField.builder()
                    .name("applicationId")
                    .type(AvroSchemaType.STRING)
                    .doc("Application ID")
                    .build(),
                AvroSchemaRecordField.builder()
                    .name("status")
                    .type(AvroSchemaType.STRING)
                    .doc("Application Status")
                    .build(),
                AvroSchemaRecordField.builder()
                    .name("documents")
                    .type(
                        AvroSchemaUnion(
                            AvroSchemaType.NULL,
                            AvroSchemaArray("model.DocumentInfo")
                        )
                    )
                    .doc("")
                    .defaultValue(null)
                    .build()
            ))
            .build()
    }

    fun documentInfo(): AvroSchemaRecord {
        return AvroSchemaRecord.builder()
            .name("DocumentInfo")
            .namespace("model")
            .doc("")
            .fields(listOf(
                AvroSchemaRecordField.builder()
                    .name("documentId")
                    .type(AvroSchemaType.STRING)
                    .doc("Document ID")
                    .build(),
                AvroSchemaRecordField.builder()
                    .name("filePath")
                    .type(AvroSchemaType.STRING)
                    .doc("Document Path")
                    .build()
            ))
            .build()
    }

    fun fooBar(): AvroSchemaRecord {
        return AvroSchemaRecord.builder()
            .name("Bar")
            .namespace("foo")
            .fields(listOf(
                AvroSchemaRecordField.builder()
                    .name("title")
                    .type(AvroSchemaType.STRING)
                    .build(),
                AvroSchemaRecordField.builder()
                    .name("created_at")
                    .type(
                        AvroSchemaUnion(
                            AvroSchemaType.NULL,
                            AvroSchema.builder()
                                .type(AvroSchemaType.LONG)
                                .logicalType(AvroSchemaLogicalType.TIMESTAMP_MILLIS)
                                .build()
                        )
                    )
                    .build()
            ))
            .build()
    }

    fun fullRecordV1(): AvroSchemaRecord {
        return AvroSchemaRecord.builder()
            .name("FullRecordV1")
            .namespace("org.apache.avro.specific.test")
            .doc("Test schema changes: this is the 'old' schema the SpecificRecord expects to see")
            .fields(listOf(
                AvroSchemaRecordField.builder()
                    .name("b")
                    .type(AvroSchemaType.BOOLEAN)
                    .build(),
                AvroSchemaRecordField.builder()
                    .name("i32")
                    .type(AvroSchemaType.INT)
                    .build(),
                AvroSchemaRecordField.builder()
                    .name("i64")
                    .type(AvroSchemaType.LONG)
                    .build(),
                AvroSchemaRecordField.builder()
                    .name("f32")
                    .type(AvroSchemaType.FLOAT)
                    .build(),
                AvroSchemaRecordField.builder()
                    .name("f64")
                    .type(AvroSchemaType.DOUBLE)
                    .build(),
                AvroSchemaRecordField.builder()
                    .name("s")
                    .type(
                        AvroSchemaUnion(
                            AvroSchemaType.NULL, AvroSchemaType.STRING
                        )
                    )
                    .build(),
                AvroSchemaRecordField.builder()
                    .name("h")
                    .type(
                        AvroSchemaUnion(
                            AvroSchemaType.NULL, AvroSchemaType.STRING
                        )
                    )
                    .build()
            ))
            .build()
    }

    fun fullRecordV2(): AvroSchemaRecord {
        return AvroSchemaRecord.builder()
            .name("FullRecordV2")
            .namespace("org.apache.avro.specific.test")
            .doc("Test schema changes: this is the 'new' schema actually used to write data")
            .fields(listOf(
                AvroSchemaRecordField.builder()
                    .name("b")
                    .type(AvroSchemaType.BOOLEAN)
                    .build(),
                AvroSchemaRecordField.builder()
                    .name("i64")
                    .type(AvroSchemaType.INT)
                    .build(),
                AvroSchemaRecordField.builder()
                    .name("i32")
                    .type(AvroSchemaType.INT)
                    .build(),
                AvroSchemaRecordField.builder()
                    .name("f64")
                    .type(AvroSchemaType.LONG)
                    .build(),
                AvroSchemaRecordField.builder()
                    .name("f32")
                    .type(
                        AvroSchemaUnion(
                            AvroSchemaType.FLOAT, AvroSchemaType.NULL
                        )
                    )
                    .build(),
                AvroSchemaRecordField.builder()
                    .name("newfield")
                    .type(AvroSchemaType.STRING)
                    .build(),
                AvroSchemaRecordField.builder()
                    .name("h")
                    .type(AvroSchemaType.BYTES)
                    .build(),
                AvroSchemaRecordField.builder()
                    .name("myMap")
                    .type(AvroSchemaMap(AvroSchemaType.STRING))
                    .build()
            ))
            .build()
    }

    fun logicalUUID(): AvroSchemaRecord {
        return AvroSchemaRecord.builder()
            .name("Action")
            .namespace("schema.common")
            .fields(listOf(
                AvroSchemaRecordField.builder()
                    .name("name")
                    .type(AvroSchemaType.STRING)
                    .build(),
                AvroSchemaRecordField.builder()
                    .name("guid")
                    .type(
                        AvroSchema.builder()
                        .type(AvroSchemaType.STRING)
                        .logicalType(AvroSchemaLogicalType.UUID)
                        .build()
                    )
                    .build(),
                AvroSchemaRecordField.builder()
                    .name("time")
                    .type(
                        AvroSchema.builder()
                        .type(AvroSchemaType.LONG)
                        .logicalType(AvroSchemaLogicalType.TIMESTAMP_MILLIS)
                        .build()
                    )
                    .build(),
                AvroSchemaRecordField.builder()
                    .name("requestId")
                    .type(
                        AvroSchemaUnion(
                            AvroSchemaType.NULL, AvroSchemaType.STRING
                        )
                    )
                    .build()
            ))
            .build()
    }

    fun logicalTypesWithMultipleFields(): AvroSchemaRecord {
        return AvroSchemaRecord.builder()
            .name("Action")
            .namespace("schema.common")
            .fields(listOf(
                AvroSchemaRecordField.builder()
                    .name("name")
                    .type(AvroSchemaType.STRING)
                    .build(),
                AvroSchemaRecordField.builder()
                    .name("uuid")
                    .type(AvroSchemaType.STRING)
                    .build(),
                AvroSchemaRecordField.builder()
                    .name("time")
                    .type(
                        AvroSchema.builder()
                        .type(AvroSchemaType.LONG)
                        .logicalType(AvroSchemaLogicalType.TIMESTAMP_MILLIS)
                        .build()
                    )
                    .build(),
                AvroSchemaRecordField.builder()
                    .name("requestId")
                    .type(
                        AvroSchemaUnion(
                            AvroSchemaType.NULL, AvroSchemaType.STRING
                        )
                    )
                    .build()
            ))
            .build()
    }

    fun myResponse(): AvroSchemaRecord {
        return AvroSchemaRecord.builder()
            .name("MyResponse")
            .namespace("model")
            .doc("")
            .fields(listOf(
                AvroSchemaRecordField.builder()
                    .name("isSuccessful")
                    .doc("Indicator for successful or unsuccessful call")
                    .type(AvroSchemaType.BOOLEAN)
                    .build()
            ))
            .build()
    }

    fun regressionErrorFieldInRecord(): AvroSchemaRecord {
        return AvroSchemaRecord.builder()
            .name("RecordWithErrorField")
            .namespace("org.apache.avro.specific.test")
            .doc("With custom coders in Avro 1.9, previously successful records with error fields now fail to compile.")
            .fields(listOf(
                AvroSchemaRecordField.builder()
                    .name("s")
                    .type(
                        AvroSchemaUnion(
                            AvroSchemaType.NULL, AvroSchemaType.STRING
                        )
                    )
                    .defaultValue(null)
                    .build(),
                AvroSchemaRecordField.builder()
                    .name("e")
                    .type(
                        AvroSchemaUnion(
                            AvroSchemaType.NULL, AvroSchemaRecord.builder()
                                .type(AvroSchemaType.ERROR)
                                .name("TestError")
                                .fields(
                                    listOf(
                                        AvroSchemaRecordField.builder()
                                            .name("message")
                                            .type(AvroSchemaType.STRING)
                                            .build()
                                    )
                                )
                                .build()
                        )
                    )
                    .defaultValue(null)
                    .build()
            ))
            .build()
    }

    fun schemaLocation(): AvroSchemaRecord {
        val lat = AvroSchemaRecordField.builder()
            .name("lat")
            .type(AvroSchemaType.FLOAT)
            .build()
        lat.metadata = mapOf(Pair("field-id", 1))

        val long = AvroSchemaRecordField.builder()
            .name("long")
            .type(listOf(AvroSchemaType.NULL, AvroSchemaType.FLOAT))
            .defaultValue(null)
            .build()
        long.metadata = mapOf(Pair("field-id", 2))

        return AvroSchemaRecord.builder()
            .name("r7")
            .fields(listOf(lat, long))
            .build()
    }

    fun schemaLocationRead(): AvroSchemaRecord {
        return AvroSchemaRecord.builder()
            .name("table")
            .fields(listOf(
                AvroSchemaRecordField.builder()
                    .name("location")
                    .type(
                        AvroSchemaUnion(
                            AvroSchemaType.NULL, AvroSchemaMap.builder()
                                .values(
                                    AvroSchemaUnion(
                                        AvroSchemaType.NULL,
                                        AvroSchemaRecord.builder()
                                            .name("r7")
                                            .fields(
                                                listOf(
                                                    AvroSchemaRecordField.builder()
                                                        .name("lat")
                                                        .type(AvroSchemaType.FLOAT)
                                                        .metadata(mapOf(Pair("field-id", 1)))
                                                        .build(),
                                                    AvroSchemaRecordField.builder()
                                                        .name("long_r2")
                                                        .type(AvroSchemaUnion(AvroSchemaType.NULL, AvroSchemaType.FLOAT))
                                                        .defaultValue(null)
                                                        .metadata(mapOf(Pair("field-id", 2)))
                                                        .build()
                                                )
                                            )
                                            .build()
                                    )
                                )
                                .metadata(
                                    mapOf(
                                        Pair("key-id", 6),
                                        Pair("value-id", 7)
                                    )
                                )
                                .build()
                        )
                    )
                    .defaultValue(null)
                    .metadata(mapOf(Pair("field-id", 5)))
                    .build()
            ))
            .build()
    }

    fun schemaLocationWrite(): AvroSchemaRecord {
        return AvroSchemaRecord.builder()
            .name("table")
            .fields(listOf(
                AvroSchemaRecordField.builder()
                    .name("location")
                    .type(
                        AvroSchemaUnion(
                            AvroSchemaType.NULL, AvroSchemaMap.builder()
                                .values(
                                    AvroSchemaUnion(
                                        AvroSchemaType.NULL,
                                        AvroSchemaRecord.builder()
                                            .name("r7")
                                            .fields(
                                                listOf(
                                                    AvroSchemaRecordField.builder()
                                                        .name("lat")
                                                        .type(AvroSchemaType.FLOAT)
                                                        .metadata(mapOf(Pair("field-id", 1)))
                                                        .build(),
                                                    AvroSchemaRecordField.builder()
                                                        .name("long")
                                                        .type(AvroSchemaUnion(AvroSchemaType.NULL, AvroSchemaType.FLOAT))
                                                        .defaultValue(null)
                                                        .metadata(mapOf(Pair("field-id", 2)))
                                                        .build()
                                                )
                                            )
                                            .build()
                                    )
                                )
                                .metadata(
                                    mapOf(
                                        Pair("key-id", 6),
                                        Pair("value-id", 7)
                                    )
                                )
                                .build()
                        )
                    )
                    .defaultValue(null)
                    .metadata(mapOf(Pair("field-id", 5)))
                    .build()
            ))
            .build()
    }

    fun schemaBuilder(): AvroSchemaRecord {
        return AvroSchemaRecord.builder()
            .name("recordAll")
            .fields(listOf(
                AvroSchemaRecordField.builder()
                    .name("requiredBoolean")
                    .type(AvroSchemaType.BOOLEAN)
                    .build(),
                AvroSchemaRecordField.builder()
                    .name("requiredBooleanWithDefault")
                    .type(AvroSchemaType.BOOLEAN)
                    .defaultValue(true)
                    .build(),
                AvroSchemaRecordField.builder()
                    .name("optionalBoolean")
                    .type(
                        AvroSchemaUnion(
                            AvroSchemaType.NULL,
                            AvroSchemaType.BOOLEAN
                        )
                    )
                    .defaultValue(null)
                    .build(),
                AvroSchemaRecordField.builder()
                    .name("optionalBooleanWithDefault")
                    .type(
                        AvroSchemaUnion(
                            AvroSchemaType.BOOLEAN,
                            AvroSchemaType.NULL
                        )
                    )
                    .defaultValue(true)
                    .build(),
                AvroSchemaRecordField.builder()
                    .name("requiredInt")
                    .type(AvroSchemaType.INT)
                    .build(),
                AvroSchemaRecordField.builder()
                    .name("optionalInt")
                    .type(
                        AvroSchemaUnion(
                            AvroSchemaType.NULL,
                            AvroSchemaType.INT
                        )
                    )
                    .defaultValue(null)
                    .build(),
                AvroSchemaRecordField.builder()
                    .name("optionalIntWithDefault")
                    .type(
                        AvroSchemaUnion(
                            AvroSchemaType.INT,
                            AvroSchemaType.NULL
                        )
                    )
                    .defaultValue(1)
                    .build(),
                AvroSchemaRecordField.builder()
                    .name("requiredLong")
                    .type(AvroSchemaType.LONG)
                    .build(),
                AvroSchemaRecordField.builder()
                    .name("optionalLong")
                    .type(
                        AvroSchemaUnion(
                            AvroSchemaType.NULL,
                            AvroSchemaType.LONG
                        )
                    )
                    .defaultValue(null)
                    .build(),
                AvroSchemaRecordField.builder()
                    .name("optionalLongWithDefault")
                    .type(
                        AvroSchemaUnion(
                            AvroSchemaType.LONG,
                            AvroSchemaType.NULL
                        )
                    )
                    .defaultValue(1)
                    .build(),
                AvroSchemaRecordField.builder()
                    .name("requiredFloat")
                    .type(AvroSchemaType.FLOAT)
                    .build(),
                AvroSchemaRecordField.builder()
                    .name("optionalFloat")
                    .type(
                        AvroSchemaUnion(
                            AvroSchemaType.NULL,
                            AvroSchemaType.FLOAT
                        )
                    )
                    .defaultValue(null)
                    .build(),
                AvroSchemaRecordField.builder()
                    .name("optionalFloatWithDefault")
                    .type(
                        AvroSchemaUnion(
                            AvroSchemaType.FLOAT,
                            AvroSchemaType.NULL
                        )
                    )
                    .defaultValue(1.0)
                    .build(),
                AvroSchemaRecordField.builder()
                    .name("requiredDouble")
                    .type(AvroSchemaType.DOUBLE)
                    .build(),
                AvroSchemaRecordField.builder()
                    .name("optionalDouble")
                    .type(
                        AvroSchemaUnion(
                            AvroSchemaType.NULL,
                            AvroSchemaType.DOUBLE
                        )
                    )
                    .defaultValue(null)
                    .build(),
                AvroSchemaRecordField.builder()
                    .name("optionalDoubleWithDefault")
                    .type(
                        AvroSchemaUnion(
                            AvroSchemaType.DOUBLE,
                            AvroSchemaType.NULL
                        )
                    )
                    .defaultValue(1.0)
                    .build(),
                AvroSchemaRecordField.builder()
                    .name("requiredBytes")
                    .type(AvroSchemaType.BYTES)
                    .build(),
                AvroSchemaRecordField.builder()
                    .name("optionalBytes")
                    .type(
                        AvroSchemaUnion(
                            AvroSchemaType.NULL,
                            AvroSchemaType.BYTES
                        )
                    )
                    .defaultValue(null)
                    .build(),
                AvroSchemaRecordField.builder()
                    .name("optionalBytesWithDefault")
                    .type(
                        AvroSchemaUnion(
                            AvroSchemaType.BYTES,
                            AvroSchemaType.NULL
                        )
                    )
                    .defaultValue("A")
                    .build(),
                AvroSchemaRecordField.builder()
                    .name("requiredString")
                    .type(AvroSchemaType.STRING)
                    .build(),
                AvroSchemaRecordField.builder()
                    .name("optionalString")
                    .type(
                        AvroSchemaUnion(
                            AvroSchemaType.NULL,
                            AvroSchemaType.STRING
                        )
                    )
                    .defaultValue(null)
                    .build(),
                AvroSchemaRecordField.builder()
                    .name("optionalStringWithDefault")
                    .type(
                        AvroSchemaUnion(
                            AvroSchemaType.STRING,
                            AvroSchemaType.NULL
                        )
                    )
                    .defaultValue("a")
                    .build(),
                AvroSchemaRecordField.builder()
                    .name("requiredRecord")
                    .type(
                        AvroSchemaRecord.builder()
                        .name("nestedRequiredRecord")
                        .fields(listOf(
                            AvroSchemaRecordField.builder()
                            .name("nestedRequiredBoolean")
                            .type(AvroSchemaType.BOOLEAN)
                            .build())
                        )
                        .build()
                    )
                    .build(),
                AvroSchemaRecordField.builder()
                    .name("optionalRecord")
                    .type(
                        AvroSchemaUnion(
                            AvroSchemaType.NULL, AvroSchemaRecord.builder()
                                .name("nestedOptionalRecord")
                                .fields(
                                    listOf(
                                        AvroSchemaRecordField.builder()
                                            .name("nestedRequiredBoolean")
                                            .type(AvroSchemaType.BOOLEAN)
                                            .build()
                                    )
                                )
                                .build()
                        )
                    )
                    .defaultValue(null)
                    .build(),
                AvroSchemaRecordField.builder()
                    .name("optionalRecordWithDefault")
                    .type(
                        AvroSchemaUnion(
                            AvroSchemaRecord.builder()
                                .name("nestedOptionalRecordWithDefault")
                                .fields(
                                    listOf(
                                        AvroSchemaRecordField.builder()
                                            .name("nestedRequiredBoolean")
                                            .type(AvroSchemaType.BOOLEAN)
                                            .build()
                                    )
                                )
                                .build(), AvroSchemaType.NULL
                        )
                    )
                    .defaultValue(mapOf(Pair("nestedRequiredBoolean", true)))
                    .build(),
                AvroSchemaRecordField.builder()
                    .name("requiredEnum")
                    .type(
                        AvroSchemaEnum.builder()
                        .name("requiredEnum")
                        .symbols(listOf("a", "b"))
                        .build()
                    )
                    .build(),
                AvroSchemaRecordField.builder()
                    .name("optionalEnum")
                    .type(
                        AvroSchemaUnion(
                            AvroSchemaType.NULL, AvroSchemaEnum.builder()
                                .name("optionalEnum")
                                .symbols(listOf("a", "b"))
                                .build()
                        )
                    )
                    .defaultValue(null)
                    .build(),
                AvroSchemaRecordField.builder()
                    .name("optionalEnumWithDefault")
                    .type(
                        AvroSchemaUnion(
                            AvroSchemaEnum.builder()
                                .name("optionalEnumWithDefault")
                                .symbols(listOf("a", "b"))
                                .build(),
                            AvroSchemaType.NULL,
                        )
                    )
                    .defaultValue("b")
                    .build(),
                AvroSchemaRecordField.builder()
                    .name("requiredArray")
                    .type(
                        AvroSchemaArray.builder()
                        .items(AvroSchemaType.STRING)
                        .build()
                    )
                    .build(),
                AvroSchemaRecordField.builder()
                    .name("optionalArray")
                    .type(
                        AvroSchemaUnion(
                            AvroSchemaType.NULL, AvroSchemaArray.builder()
                                .items(AvroSchemaType.STRING)
                                .build()
                        )
                    )
                    .defaultValue(null)
                    .build(),
                AvroSchemaRecordField.builder()
                    .name("optionalArrayWithDefault")
                    .type(
                        AvroSchemaUnion(
                            AvroSchemaArray.builder()
                                .items(AvroSchemaType.STRING)
                                .build(), AvroSchemaType.NULL
                        )
                    )
                    .defaultValue(listOf("a"))
                    .build(),
                AvroSchemaRecordField.builder()
                    .name("requiredMap")
                    .type(
                        AvroSchemaMap.builder()
                        .values(AvroSchemaType.STRING)
                        .build()
                    )
                    .build(),
                AvroSchemaRecordField.builder()
                    .name("optionalMap")
                    .type(
                        AvroSchemaUnion(
                            AvroSchemaType.NULL, AvroSchemaMap.builder()
                                .values(AvroSchemaType.STRING)
                                .build()
                        )
                    )
                    .defaultValue(null)
                    .build(),
                AvroSchemaRecordField.builder()
                    .name("optionalMapWithDefault")
                    .type(
                        AvroSchemaUnion(
                            AvroSchemaMap.builder()
                                .values(AvroSchemaType.STRING)
                                .build(), AvroSchemaType.NULL
                        )
                    )
                    .defaultValue(mapOf(Pair("a", "b")))
                    .build(),
                AvroSchemaRecordField.builder()
                    .name("requiredFixed")
                    .type(
                        AvroSchemaFixed.builder()
                        .name("requiredFixed")
                        .size(1)
                        .build()
                    )
                    .build(),
                AvroSchemaRecordField.builder()
                    .name("optionalFixed")
                    .type(
                        AvroSchemaUnion(
                            AvroSchemaType.NULL, AvroSchemaFixed.builder()
                                .name("optionalFixed")
                                .size(1)
                                .build()
                        )
                    )
                    .defaultValue(null)
                    .build(),
                AvroSchemaRecordField.builder()
                    .name("optionalFixedWithDefault")
                    .type(
                        AvroSchemaUnion(
                            AvroSchemaFixed.builder()
                                .name("optionalFixedWithDefault")
                                .size(1)
                                .build(), AvroSchemaType.NULL
                        )
                    )
                    .defaultValue("A")
                    .build(),
                AvroSchemaRecordField.builder()
                    .name("unionType")
                    .type(listOf(AvroSchemaType.LONG, AvroSchemaType.NULL))
                    .build(),
                AvroSchemaRecordField.builder()
                    .name("unionBooleanWithDefault")
                    .type(listOf(AvroSchemaType.BOOLEAN, AvroSchemaType.INT))
                    .defaultValue(true)
                    .build(),
                AvroSchemaRecordField.builder()
                    .name("unionIntWithDefault")
                    .type(listOf(AvroSchemaType.INT, AvroSchemaType.NULL))
                    .defaultValue(1)
                    .build(),
                AvroSchemaRecordField.builder()
                    .name("unionLongWithDefault")
                    .type(listOf(AvroSchemaType.LONG, AvroSchemaType.INT))
                    .defaultValue(1)
                    .build(),
                AvroSchemaRecordField.builder()
                    .name("unionFloatWithDefault")
                    .type(listOf(AvroSchemaType.FLOAT, AvroSchemaType.INT))
                    .defaultValue(1.0)
                    .build(),
                AvroSchemaRecordField.builder()
                    .name("unionDoubleWithDefault")
                    .type(listOf(AvroSchemaType.DOUBLE, AvroSchemaType.INT))
                    .defaultValue(1.0)
                    .build(),
                AvroSchemaRecordField.builder()
                    .name("unionBytesWithDefault")
                    .type(listOf(AvroSchemaType.BYTES, AvroSchemaType.INT))
                    .defaultValue("A")
                    .build(),
                AvroSchemaRecordField.builder()
                    .name("unionStringWithDefault")
                    .type(listOf(AvroSchemaType.STRING, AvroSchemaType.INT))
                    .defaultValue("a")
                    .build(),
                AvroSchemaRecordField.builder()
                    .name("unionRecordWithDefault")
                    .type(listOf(
                        AvroSchemaRecord.builder()
                        .name("nestedUnionRecordWithDefault")
                        .fields(listOf(
                            AvroSchemaRecordField.builder()
                                .name("nestedRequiredBoolean")
                                .type(AvroSchemaType.BOOLEAN)
                                .build()
                        ))
                        .build(), AvroSchemaType.INT
                    ))
                    .defaultValue(mapOf(Pair("nestedRequiredBoolean", true)))
                    .build(),
                AvroSchemaRecordField.builder()
                    .name("unionEnumWithDefault")
                    .type(listOf(
                        AvroSchemaEnum.builder()
                        .name("nestedUnionEnumWithDefault")
                        .symbols(listOf("a", "b"))
                        .build(), AvroSchemaType.INT
                    ))
                    .defaultValue("b")
                    .build(),
                AvroSchemaRecordField.builder()
                    .name("unionArrayWithDefault")
                    .type(listOf(
                        AvroSchemaArray.builder()
                        .items(AvroSchemaType.STRING)
                        .build(), AvroSchemaType.INT
                    ))
                    .defaultValue(listOf("a"))
                    .build(),
                AvroSchemaRecordField.builder()
                    .name("unionMapWithDefault")
                    .type(listOf(
                        AvroSchemaMap.builder()
                        .values(AvroSchemaType.STRING)
                        .build(), AvroSchemaType.INT
                    ))
                    .defaultValue(mapOf(Pair("a", "b")))
                    .build(),
                AvroSchemaRecordField.builder()
                    .name("unionFixedWithDefault")
                    .type(listOf(
                        AvroSchemaFixed.builder()
                        .name("nestedUnionFixedWithDefault")
                        .size(1)
                        .build(), AvroSchemaType.INT
                    ))
                    .defaultValue("A")
                    .build(),
            ))
            .build()
    }

    fun simpleRecord(): AvroSchemaRecord {
        return AvroSchemaRecord.builder()
            .name("SimpleRecord")
            .fields(listOf(
                AvroSchemaRecordField.builder()
                    .type(AvroSchemaType.INT)
                    .name("value")
                    .build(),
                AvroSchemaRecordField.builder()
                    .type(
                        AvroSchemaUnion(
                            AvroSchemaType.NULL,
                            AvroSchemaType.INT
                        )
                    )
                    .name("nullableValue")
                    .doc("doc")
                    .build()
            ))
            .build()
    }

    fun testRecordWithLogicalTypes(): AvroSchemaRecord {
        return AvroSchemaRecord.builder()
            .name("TestRecordWithLogicalTypes")
            .doc("Schema for TestRecordWithLogicalTypes and TestRecordWithoutLogicalTypes, see TestSpecificLogicalTypes")
            .namespace("org.apache.avro.specific")
            .fields(listOf(
                AvroSchemaRecordField.builder()
                    .type(AvroSchemaType.BOOLEAN)
                    .name("b")
                    .build(),
                AvroSchemaRecordField.builder()
                    .type(AvroSchemaType.INT)
                    .name("i32")
                    .build(),
                AvroSchemaRecordField.builder()
                    .type(AvroSchemaType.LONG)
                    .name("i64")
                    .build(),
                AvroSchemaRecordField.builder()
                    .type(AvroSchemaType.FLOAT)
                    .name("f32")
                    .build(),
                AvroSchemaRecordField.builder()
                    .type(AvroSchemaType.DOUBLE)
                    .name("f64")
                    .build(),
                AvroSchemaRecordField.builder()
                    .type(
                        AvroSchemaUnion(
                            AvroSchemaType.NULL,
                            AvroSchemaType.STRING
                        )
                    )
                    .name("s")
                    .defaultValue(null)
                    .build(),
                AvroSchemaRecordField.builder()
                    .type(
                        AvroSchema.builder()
                        .type(AvroSchemaType.INT)
                        .logicalType(AvroSchemaLogicalType.DATE)
                        .build()
                    )
                    .name("d")
                    .build(),
                AvroSchemaRecordField.builder()
                    .type(
                        AvroSchema.builder()
                        .type(AvroSchemaType.INT)
                        .logicalType(AvroSchemaLogicalType.TIME_MILLIS)
                        .build()
                    )
                    .name("t")
                    .build(),
                AvroSchemaRecordField.builder()
                    .type(
                        AvroSchema.builder()
                        .type(AvroSchemaType.LONG)
                        .logicalType(AvroSchemaLogicalType.TIMESTAMP_MILLIS)
                        .build()
                    )
                    .name("ts")
                    .build(),
                AvroSchemaRecordField.builder()
                    .type(
                        AvroSchema.builder()
                        .type(AvroSchemaType.BYTES)
                        .logicalType(AvroSchemaLogicalType.BIG_DECIMAL)
                        .build()
                    )
                    .name("bd")
                    .build(),
            ))
            .build()
    }

    fun testRecordWithMapsAndArrays(): AvroSchemaRecord {
        return AvroSchemaRecord.builder()
            .name("TestRecordWithMapsAndArrays")
            .namespace("org.apache.avro.specific")
            .fields(listOf(
                AvroSchemaRecordField.builder()
                    .name("arr")
                    .type(
                        AvroSchemaArray.builder()
                        .items(AvroSchemaType.STRING)
                        .defaultValue(emptyList())
                        .build()
                    )
                    .build(),
                AvroSchemaRecordField.builder()
                    .name("map")
                    .type(
                        AvroSchemaMap.builder()
                        .values(AvroSchemaType.LONG)
                        .defaultValue(emptyMap())
                        .build()
                    )
                    .build()
            ))
            .build()
    }

    fun testUnionRecord(): AvroSchemaUnion {
        return AvroSchemaUnion(
            AvroSchemaType.NULL,
            AvroSchemaRecord.builder()
                .name("TestUnionRecord")
                .namespace("org.apache.avro.specific")
                .fields(
                    listOf(
                        AvroSchemaRecordField.builder()
                            .name("amount")
                            .type(
                                AvroSchemaUnion(
                                    AvroSchemaType.NULL,
                                    AvroSchema.builder()
                                        .type(AvroSchemaType.BYTES)
                                        .logicalType(AvroSchemaLogicalType.DECIMAL)
                                        .precision(31)
                                        .scale(8)
                                        .build()
                                )
                            )
                            .defaultValue(null)
                            .build()
                    )
                )
                .build()
        )
    }

    fun unionAndFixedFields(): AvroSchemaRecord {
        return AvroSchemaRecord.builder()
            .name("UnionAndFixedFields")
            .doc("Schema for UnionAndFixedFields designed to trigger fixed compiler warnings in generated code")
            .namespace("org.apache.avro.specific")
            .fields(listOf(
                AvroSchemaRecordField.builder()
                    .name("u")
                    .type(
                        AvroSchemaUnion(
                            AvroSchemaType.BOOLEAN,
                            AvroSchemaType.INT,
                            AvroSchemaType.LONG,
                            AvroSchemaType.FLOAT,
                            AvroSchemaType.STRING
                        )
                    )
                    .build(),
                AvroSchemaRecordField.builder()
                    .name("l")
                    .type(
                        AvroSchemaUnion(
                            AvroSchemaType.STRING, AvroSchema.builder()
                                .type(AvroSchemaType.LONG)
                                .logicalType(AvroSchemaLogicalType.TIMESTAMP_MILLIS)
                                .build()
                        )
                    )
                    .build(),
                AvroSchemaRecordField.builder()
                    .name("f")
                    .type(
                        AvroSchemaFixed.builder()
                        .name("md5")
                        .size(16)
                        .build()
                    )
                    .build()
            ))
            .build()
    }

}