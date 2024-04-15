package com.asyncapi.v3.schema.avro

class AvroSchemasProvider {

    fun applicationEventTest(): AvroRecordSchema {
        return AvroRecordSchema.recordBuilder()
            .name("ApplicationEvent")
            .namespace("model")
            .doc("")
            .fields(listOf(
                AvroRecordFieldSchema.builder()
                    .name("applicationId")
                    .type(AvroSchemaType.STRING)
                    .doc("Application ID")
                    .build(),
                AvroRecordFieldSchema.builder()
                    .name("status")
                    .type(AvroSchemaType.STRING)
                    .doc("Application Status")
                    .build(),
                AvroRecordFieldSchema.builder()
                    .name("documents")
                    // TODO: union type
                    .type(listOf(
                        AvroSchemaType.NULL,
                        AvroArraySchema("model.DocumentInfo")
                    ))
                    .doc("")
                    .defaultValue(null)
                    .build()
            ))
            .build()
    }

    fun documentInfo(): AvroRecordSchema {
        return AvroRecordSchema.recordBuilder()
            .name("DocumentInfo")
            .namespace("model")
            .doc("")
            .fields(listOf(
                AvroRecordFieldSchema.builder()
                    .name("documentId")
                    .type(AvroSchemaType.STRING)
                    .doc("Document ID")
                    .build(),
                AvroRecordFieldSchema.builder()
                    .name("filePath")
                    .type(AvroSchemaType.STRING)
                    .doc("Document Path")
                    .build()
            ))
            .build()
    }

    fun fooBar(): AvroRecordSchema {
        return AvroRecordSchema.recordBuilder()
            .name("Bar")
            .namespace("foo")
            .fields(listOf(
                AvroRecordFieldSchema.builder()
                    .name("title")
                    .type(AvroSchemaType.STRING)
                    .build(),
                AvroRecordFieldSchema.builder()
                    .name("created_at")
                    // TODO: union type
                    .type(listOf(
                        AvroSchemaType.NULL,
                        AvroSchema.builder()
                            .type(AvroSchemaType.LONG)
                            .logicalType(AvroSchema.LogicalType.TIMESTAMP_MILLIS)
                            .build()
                    ))
                    .build()
            ))
            .build()
    }

    fun fullRecordV1(): AvroRecordSchema {
        return AvroRecordSchema.recordBuilder()
            .name("FullRecordV1")
            .namespace("org.apache.avro.specific.test")
            .doc("Test schema changes: this is the 'old' schema the SpecificRecord expects to see")
            .fields(listOf(
                AvroRecordFieldSchema.builder()
                    .name("b")
                    .type(AvroSchemaType.BOOLEAN)
                    .build(),
                AvroRecordFieldSchema.builder()
                    .name("i32")
                    .type(AvroSchemaType.INT)
                    .build(),
                AvroRecordFieldSchema.builder()
                    .name("i64")
                    .type(AvroSchemaType.LONG)
                    .build(),
                AvroRecordFieldSchema.builder()
                    .name("f32")
                    .type(AvroSchemaType.FLOAT)
                    .build(),
                AvroRecordFieldSchema.builder()
                    .name("f64")
                    .type(AvroSchemaType.DOUBLE)
                    .build(),
                AvroRecordFieldSchema.builder()
                    .name("s")
                    // TODO: union type
                    .type(listOf(
                        AvroSchemaType.NULL, AvroSchemaType.STRING
                    ))
                    .build(),
                AvroRecordFieldSchema.builder()
                    .name("h")
                    // TODO: union type
                    .type(listOf(
                        AvroSchemaType.NULL, AvroSchemaType.STRING
                    ))
                    .build()
            ))
            .build()
    }

    fun fullRecordV2(): AvroRecordSchema {
        return AvroRecordSchema.recordBuilder()
            .name("FullRecordV2")
            .namespace("org.apache.avro.specific.test")
            .doc("Test schema changes: this is the 'new' schema actually used to write data")
            .fields(listOf(
                AvroRecordFieldSchema.builder()
                    .name("b")
                    .type(AvroSchemaType.BOOLEAN)
                    .build(),
                AvroRecordFieldSchema.builder()
                    .name("i64")
                    .type(AvroSchemaType.INT)
                    .build(),
                AvroRecordFieldSchema.builder()
                    .name("i32")
                    .type(AvroSchemaType.INT)
                    .build(),
                AvroRecordFieldSchema.builder()
                    .name("f64")
                    .type(AvroSchemaType.LONG)
                    .build(),
                AvroRecordFieldSchema.builder()
                    .name("f32")
                    // TODO: union type
                    .type(listOf(
                        AvroSchemaType.FLOAT, AvroSchemaType.NULL
                    ))
                    .build(),
                AvroRecordFieldSchema.builder()
                    .name("newfield")
                    .type(AvroSchemaType.STRING)
                    .build(),
                AvroRecordFieldSchema.builder()
                    .name("h")
                    .type(AvroSchemaType.BYTES)
                    .build(),
                AvroRecordFieldSchema.builder()
                    .name("myMap")
                    .type(AvroMapSchema(AvroSchemaType.STRING))
                    .build()
            ))
            .build()
    }

    fun logicalUUID(): AvroRecordSchema {
        return AvroRecordSchema.recordBuilder()
            .name("Action")
            .namespace("schema.common")
            .fields(listOf(
                AvroRecordFieldSchema.builder()
                    .name("name")
                    .type(AvroSchemaType.STRING)
                    .build(),
                AvroRecordFieldSchema.builder()
                    .name("guid")
                    .type(AvroSchema.builder()
                        .type(AvroSchemaType.STRING)
                        .logicalType(AvroSchema.LogicalType.UUID)
                        .build()
                    )
                    .build(),
                AvroRecordFieldSchema.builder()
                    .name("time")
                    .type(AvroSchema.builder()
                        .type(AvroSchemaType.LONG)
                        .logicalType(AvroSchema.LogicalType.TIMESTAMP_MILLIS)
                        .build()
                    )
                    .build(),
                AvroRecordFieldSchema.builder()
                    .name("requestId")
                    // TODO: union type
                    .type(listOf(
                        AvroSchemaType.NULL, AvroSchemaType.STRING
                    ))
                    .build()
            ))
            .build()
    }

    fun logicalTypesWithMultipleFields(): AvroRecordSchema {
        return AvroRecordSchema.recordBuilder()
            .name("Action")
            .namespace("schema.common")
            .fields(listOf(
                AvroRecordFieldSchema.builder()
                    .name("name")
                    .type(AvroSchemaType.STRING)
                    .build(),
                AvroRecordFieldSchema.builder()
                    .name("uuid")
                    .type(AvroSchemaType.STRING)
                    .build(),
                AvroRecordFieldSchema.builder()
                    .name("time")
                    .type(AvroSchema.builder()
                        .type(AvroSchemaType.LONG)
                        .logicalType(AvroSchema.LogicalType.TIMESTAMP_MILLIS)
                        .build()
                    )
                    .build(),
                AvroRecordFieldSchema.builder()
                    .name("requestId")
                    // TODO: union type
                    .type(listOf(
                        AvroSchemaType.NULL, AvroSchemaType.STRING
                    ))
                    .build()
            ))
            .build()
    }

    fun myResponse(): AvroRecordSchema {
        return AvroRecordSchema.recordBuilder()
            .name("MyResponse")
            .namespace("model")
            .doc("")
            .fields(listOf(
                AvroRecordFieldSchema.builder()
                    .name("isSuccessful")
                    .doc("Indicator for successful or unsuccessful call")
                    .type(AvroSchemaType.BOOLEAN)
                    .build()
            ))
            .build()
    }

    fun regressionErrorFieldInRecord(): AvroRecordSchema {
        return AvroRecordSchema.recordBuilder()
            .name("RecordWithErrorField")
            .namespace("org.apache.avro.specific.test")
            .doc("With custom coders in Avro 1.9, previously successful records with error fields now fail to compile.")
            .fields(listOf(
                AvroRecordFieldSchema.builder()
                    .name("s")
                    // TODO: union type
                    .type(listOf(
                        AvroSchemaType.NULL, AvroSchemaType.STRING
                    ))
                    .defaultValue(null)
                    .build(),
                AvroRecordFieldSchema.builder()
                    .name("e")
                    // TODO: union type
                    .type(listOf(
                        AvroSchemaType.NULL, AvroRecordSchema.recordBuilder()
                            .type(AvroSchemaType.ERROR)
                            .name("TestError")
                            .fields(listOf(
                                AvroRecordFieldSchema.builder()
                                    .name("message")
                                    .type(AvroSchemaType.STRING)
                                    .build()
                            ))
                            .build()
                    ))
                    .defaultValue(null)
                    .build()
            ))
            .build()
    }

    fun schemaLocation(): AvroRecordSchema {
        val lat = AvroRecordFieldSchema.builder()
            .name("lat")
            .type(AvroSchemaType.FLOAT)
            .build()
        lat.metadata = mapOf(Pair("field-id", 1))

        val long = AvroRecordFieldSchema.builder()
            .name("long")
            .type(listOf(AvroSchemaType.NULL, AvroSchemaType.FLOAT))
            .defaultValue(null)
            .build()
        long.metadata = mapOf(Pair("field-id", 2))

        return AvroRecordSchema.recordBuilder()
            .name("r7")
            .fields(listOf(lat, long))
            .build()
    }

    fun schemaLocationRead(): AvroRecordSchema {
        return AvroRecordSchema.recordBuilder()
            .name("table")
            .fields(listOf(
                AvroRecordFieldSchema.builder()
                    .name("location")
                    // TODO: union type
                    .type(listOf(AvroSchemaType.NULL, AvroMapSchema.mapBuilder()
                        // TODO: union type
                        .values(listOf(
                            AvroSchemaType.NULL,
                            AvroRecordSchema.recordBuilder()
                                .name("r7")
                                .fields(listOf(
                                    AvroRecordFieldSchema.builder()
                                        .name("lat")
                                        .type(AvroSchemaType.FLOAT)
                                        .metadata(mapOf(Pair("field-id", 1)))
                                        .build(),
                                    AvroRecordFieldSchema.builder()
                                        .name("long_r2")
                                        // TODO: union type
                                        .type(listOf(AvroSchemaType.NULL, AvroSchemaType.FLOAT))
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

    fun schemaLocationWrite(): AvroRecordSchema {
        return AvroRecordSchema.recordBuilder()
            .name("table")
            .fields(listOf(
                AvroRecordFieldSchema.builder()
                    .name("location")
                    // TODO: union type
                    .type(listOf(AvroSchemaType.NULL, AvroMapSchema.mapBuilder()
                        // TODO: union type
                        .values(listOf(
                            AvroSchemaType.NULL,
                            AvroRecordSchema.recordBuilder()
                                .name("r7")
                                .fields(listOf(
                                    AvroRecordFieldSchema.builder()
                                        .name("lat")
                                        .type(AvroSchemaType.FLOAT)
                                        .metadata(mapOf(Pair("field-id", 1)))
                                        .build(),
                                    AvroRecordFieldSchema.builder()
                                        .name("long")
                                        // TODO: union type
                                        .type(listOf(AvroSchemaType.NULL, AvroSchemaType.FLOAT))
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

    fun schemaBuilder(): AvroRecordSchema {
        return AvroRecordSchema.recordBuilder()
            .name("recordAll")
            .fields(listOf(
                AvroRecordFieldSchema.builder()
                    .name("requiredBoolean")
                    .type(AvroSchemaType.BOOLEAN)
                    .build(),
                AvroRecordFieldSchema.builder()
                    .name("requiredBooleanWithDefault")
                    .type(AvroSchemaType.BOOLEAN)
                    .defaultValue(true)
                    .build(),
                AvroRecordFieldSchema.builder()
                    .name("optionalBoolean")
                    // TODO: union type
                    .type(listOf(AvroSchemaType.NULL, AvroSchemaType.BOOLEAN))
                    .defaultValue(null)
                    .build(),
                AvroRecordFieldSchema.builder()
                    .name("optionalBooleanWithDefault")
                    // TODO: union type
                    .type(listOf(AvroSchemaType.BOOLEAN, AvroSchemaType.NULL))
                    .defaultValue(true)
                    .build(),
                AvroRecordFieldSchema.builder()
                    .name("requiredInt")
                    .type(AvroSchemaType.INT)
                    .build(),
                AvroRecordFieldSchema.builder()
                    .name("optionalInt")
                    // TODO: union type
                    .type(listOf(AvroSchemaType.NULL, AvroSchemaType.INT))
                    .defaultValue(null)
                    .build(),
                AvroRecordFieldSchema.builder()
                    .name("optionalIntWithDefault")
                    // TODO: union type
                    .type(listOf(AvroSchemaType.INT, AvroSchemaType.NULL))
                    .defaultValue(1)
                    .build(),
                AvroRecordFieldSchema.builder()
                    .name("requiredLong")
                    .type(AvroSchemaType.LONG)
                    .build(),
                AvroRecordFieldSchema.builder()
                    .name("optionalLong")
                    // TODO: union type
                    .type(listOf(AvroSchemaType.NULL, AvroSchemaType.LONG))
                    .defaultValue(null)
                    .build(),
                AvroRecordFieldSchema.builder()
                    .name("optionalLongWithDefault")
                    // TODO: union type
                    .type(listOf(AvroSchemaType.LONG, AvroSchemaType.NULL))
                    .defaultValue(1)
                    .build(),
                AvroRecordFieldSchema.builder()
                    .name("requiredFloat")
                    .type(AvroSchemaType.FLOAT)
                    .build(),
                AvroRecordFieldSchema.builder()
                    .name("optionalFloat")
                    // TODO: union type
                    .type(listOf(AvroSchemaType.NULL, AvroSchemaType.FLOAT))
                    .defaultValue(null)
                    .build(),
                AvroRecordFieldSchema.builder()
                    .name("optionalFloatWithDefault")
                    // TODO: union type
                    .type(listOf(AvroSchemaType.FLOAT, AvroSchemaType.NULL))
                    .defaultValue(1.0)
                    .build(),
                AvroRecordFieldSchema.builder()
                    .name("requiredDouble")
                    .type(AvroSchemaType.DOUBLE)
                    .build(),
                AvroRecordFieldSchema.builder()
                    .name("optionalDouble")
                    // TODO: union type
                    .type(listOf(AvroSchemaType.NULL, AvroSchemaType.DOUBLE))
                    .defaultValue(null)
                    .build(),
                AvroRecordFieldSchema.builder()
                    .name("optionalDoubleWithDefault")
                    // TODO: union type
                    .type(listOf(AvroSchemaType.DOUBLE, AvroSchemaType.NULL))
                    .defaultValue(1.0)
                    .build(),
                AvroRecordFieldSchema.builder()
                    .name("requiredBytes")
                    .type(AvroSchemaType.BYTES)
                    .build(),
                AvroRecordFieldSchema.builder()
                    .name("optionalBytes")
                    // TODO: union type
                    .type(listOf(AvroSchemaType.NULL, AvroSchemaType.BYTES))
                    .defaultValue(null)
                    .build(),
                AvroRecordFieldSchema.builder()
                    .name("optionalBytesWithDefault")
                    // TODO: union type
                    .type(listOf(AvroSchemaType.BYTES, AvroSchemaType.NULL))
                    .defaultValue("A")
                    .build(),
                AvroRecordFieldSchema.builder()
                    .name("requiredString")
                    .type(AvroSchemaType.STRING)
                    .build(),
                AvroRecordFieldSchema.builder()
                    .name("optionalString")
                    // TODO: union type
                    .type(listOf(AvroSchemaType.NULL, AvroSchemaType.STRING))
                    .defaultValue(null)
                    .build(),
                AvroRecordFieldSchema.builder()
                    .name("optionalStringWithDefault")
                    // TODO: union type
                    .type(listOf(AvroSchemaType.STRING, AvroSchemaType.NULL))
                    .defaultValue("a")
                    .build(),
                AvroRecordFieldSchema.builder()
                    .name("requiredRecord")
                    .type(AvroRecordSchema.recordBuilder()
                        .name("nestedRequiredRecord")
                        .fields(listOf(AvroRecordFieldSchema.builder()
                            .name("nestedRequiredBoolean")
                            .type(AvroSchemaType.BOOLEAN)
                            .build())
                        )
                        .build()
                    )
                    .build(),
                AvroRecordFieldSchema.builder()
                    .name("optionalRecord")
                    // TODO: union type
                    .type(listOf(AvroSchemaType.NULL, AvroRecordSchema.recordBuilder()
                        .name("nestedOptionalRecord")
                        .fields(listOf(AvroRecordFieldSchema.builder()
                            .name("nestedRequiredBoolean")
                            .type(AvroSchemaType.BOOLEAN)
                            .build())
                        )
                        .build()
                    ))
                    .defaultValue(null)
                    .build(),
                AvroRecordFieldSchema.builder()
                    .name("optionalRecordWithDefault")
                    // TODO: union type
                    .type(listOf(AvroRecordSchema.recordBuilder()
                        .name("nestedOptionalRecordWithDefault")
                        .fields(listOf(AvroRecordFieldSchema.builder()
                            .name("nestedRequiredBoolean")
                            .type(AvroSchemaType.BOOLEAN)
                            .build())
                        )
                        .build(), AvroSchemaType.NULL
                    ))
                    .defaultValue(mapOf(Pair("nestedRequiredBoolean", true)))
                    .build(),
                AvroRecordFieldSchema.builder()
                    .name("requiredEnum")
                    .type(AvroEnumSchema.enumBuilder()
                        .name("requiredEnum")
                        .symbols(listOf("a", "b"))
                        .build()
                    )
                    .build(),
                AvroRecordFieldSchema.builder()
                    .name("optionalEnum")
                    // TODO: union type
                    .type(listOf(AvroSchemaType.NULL, AvroEnumSchema.enumBuilder()
                        .name("optionalEnum")
                        .symbols(listOf("a", "b"))
                        .build()
                    ))
                    .defaultValue(null)
                    .build(),
                AvroRecordFieldSchema.builder()
                    .name("optionalEnumWithDefault")
                    // TODO: union type
                    .type(listOf(AvroEnumSchema.enumBuilder()
                        .name("optionalEnumWithDefault")
                        .symbols(listOf("a", "b"))
                        .build(), AvroSchemaType.NULL,
                    ))
                    .defaultValue("b")
                    .build(),
                AvroRecordFieldSchema.builder()
                    .name("requiredArray")
                    .type(AvroArraySchema.arrayBuilder()
                        .items(AvroSchemaType.STRING)
                        .build()
                    )
                    .build(),
                AvroRecordFieldSchema.builder()
                    .name("optionalArray")
                    // TODO: union type
                    .type(listOf(AvroSchemaType.NULL, AvroArraySchema.arrayBuilder()
                        .items(AvroSchemaType.STRING)
                        .build()
                    ))
                    .defaultValue(null)
                    .build(),
                AvroRecordFieldSchema.builder()
                    .name("optionalArrayWithDefault")
                    // TODO: union type
                    .type(listOf(AvroArraySchema.arrayBuilder()
                        .items(AvroSchemaType.STRING)
                        .build(), AvroSchemaType.NULL
                    ))
                    .defaultValue(listOf("a"))
                    .build(),
                AvroRecordFieldSchema.builder()
                    .name("requiredMap")
                    .type(AvroMapSchema.mapBuilder()
                        .values(AvroSchemaType.STRING)
                        .build()
                    )
                    .build(),
                AvroRecordFieldSchema.builder()
                    .name("optionalMap")
                    // TODO: union type
                    .type(listOf(AvroSchemaType.NULL, AvroMapSchema.mapBuilder()
                        .values(AvroSchemaType.STRING)
                        .build()
                    ))
                    .defaultValue(null)
                    .build(),
                AvroRecordFieldSchema.builder()
                    .name("optionalMapWithDefault")
                    // TODO: union type
                    .type(listOf(AvroMapSchema.mapBuilder()
                        .values(AvroSchemaType.STRING)
                        .build(), AvroSchemaType.NULL
                    ))
                    .defaultValue(mapOf(Pair("a", "b")))
                    .build(),
                AvroRecordFieldSchema.builder()
                    .name("requiredFixed")
                    .type(AvroFixedSchema.fixedBuilder()
                        .name("requiredFixed")
                        .size(1)
                        .build()
                    )
                    .build(),
                AvroRecordFieldSchema.builder()
                    .name("optionalFixed")
                    // TODO: union type
                    .type(listOf(AvroSchemaType.NULL, AvroFixedSchema.fixedBuilder()
                        .name("optionalFixed")
                        .size(1)
                        .build()
                    ))
                    .defaultValue(null)
                    .build(),
                AvroRecordFieldSchema.builder()
                    .name("optionalFixedWithDefault")
                    // TODO: union type
                    .type(listOf(AvroFixedSchema.fixedBuilder()
                        .name("optionalFixedWithDefault")
                        .size(1)
                        .build(), AvroSchemaType.NULL
                    ))
                    .defaultValue("A")
                    .build(),
                AvroRecordFieldSchema.builder()
                    .name("unionType")
                    .type(listOf(AvroSchemaType.LONG, AvroSchemaType.NULL))
                    .build(),
                AvroRecordFieldSchema.builder()
                    .name("unionBooleanWithDefault")
                    .type(listOf(AvroSchemaType.BOOLEAN, AvroSchemaType.INT))
                    .defaultValue(true)
                    .build(),
                AvroRecordFieldSchema.builder()
                    .name("unionIntWithDefault")
                    .type(listOf(AvroSchemaType.INT, AvroSchemaType.NULL))
                    .defaultValue(1)
                    .build(),
                AvroRecordFieldSchema.builder()
                    .name("unionLongWithDefault")
                    .type(listOf(AvroSchemaType.LONG, AvroSchemaType.INT))
                    .defaultValue(1)
                    .build(),
                AvroRecordFieldSchema.builder()
                    .name("unionFloatWithDefault")
                    .type(listOf(AvroSchemaType.FLOAT, AvroSchemaType.INT))
                    .defaultValue(1.0)
                    .build(),
                AvroRecordFieldSchema.builder()
                    .name("unionDoubleWithDefault")
                    .type(listOf(AvroSchemaType.DOUBLE, AvroSchemaType.INT))
                    .defaultValue(1.0)
                    .build(),
                AvroRecordFieldSchema.builder()
                    .name("unionBytesWithDefault")
                    .type(listOf(AvroSchemaType.BYTES, AvroSchemaType.INT))
                    .defaultValue("A")
                    .build(),
                AvroRecordFieldSchema.builder()
                    .name("unionStringWithDefault")
                    .type(listOf(AvroSchemaType.STRING, AvroSchemaType.INT))
                    .defaultValue("a")
                    .build(),
                AvroRecordFieldSchema.builder()
                    .name("unionRecordWithDefault")
                    .type(listOf(AvroRecordSchema.recordBuilder()
                        .name("nestedUnionRecordWithDefault")
                        .fields(listOf(
                            AvroRecordFieldSchema.builder()
                                .name("nestedRequiredBoolean")
                                .type(AvroSchemaType.BOOLEAN)
                                .build()
                        ))
                        .build(), AvroSchemaType.INT
                    ))
                    .defaultValue(mapOf(Pair("nestedRequiredBoolean", true)))
                    .build(),
                AvroRecordFieldSchema.builder()
                    .name("unionEnumWithDefault")
                    .type(listOf(AvroEnumSchema.enumBuilder()
                        .name("nestedUnionEnumWithDefault")
                        .symbols(listOf("a", "b"))
                        .build(), AvroSchemaType.INT
                    ))
                    .defaultValue("b")
                    .build(),
                AvroRecordFieldSchema.builder()
                    .name("unionArrayWithDefault")
                    .type(listOf(AvroArraySchema.arrayBuilder()
                        .items(AvroSchemaType.STRING)
                        .build(), AvroSchemaType.INT
                    ))
                    .defaultValue(listOf("a"))
                    .build(),
                AvroRecordFieldSchema.builder()
                    .name("unionMapWithDefault")
                    .type(listOf(AvroMapSchema.mapBuilder()
                        .values(AvroSchemaType.STRING)
                        .build(), AvroSchemaType.INT
                    ))
                    .defaultValue(mapOf(Pair("a", "b")))
                    .build(),
                AvroRecordFieldSchema.builder()
                    .name("unionFixedWithDefault")
                    .type(listOf(AvroFixedSchema.fixedBuilder()
                        .name("nestedUnionFixedWithDefault")
                        .size(1)
                        .build(), AvroSchemaType.INT
                    ))
                    .defaultValue("A")
                    .build(),
            ))
            .build()
    }

}