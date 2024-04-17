package com.asyncapi.v3.schema.multiformat

import com.asyncapi.v3.schema.multiformat.asyncapi.*
import com.asyncapi.v3.schema.multiformat.avro.*
import com.asyncapi.v3.schema.multiformat.json.JsonFormatSchemaTest
import com.asyncapi.v3.schema.multiformat.openapi.OpenAPIFormatSchemaV3_0_0Test
import com.asyncapi.v3.schema.multiformat.openapi.OpenAPIFormatSchemaV3_0_1Test
import com.asyncapi.v3.schema.multiformat.openapi.OpenAPIFormatSchemaV3_0_2Test
import com.asyncapi.v3.schema.multiformat.openapi.OpenAPIFormatSchemaV3_0_3Test
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested

class MultiFormatSchemaTest {

    @Nested
    inner class AsyncAPISchema {

        @Nested
        @DisplayName("2.0.0")
        inner class V2_0_0: AsyncAPIFormatSchemaV2_0_0Test()

        @Nested
        @DisplayName("2.1.0")
        inner class V2_1_0: AsyncAPIFormatSchemaV2_1_0Test()

        @Nested
        @DisplayName("2.2.0")
        inner class V2_2_0: AsyncAPIFormatSchemaV2_2_0Test()

        @Nested
        @DisplayName("2.3.0")
        inner class V2_3_0: AsyncAPIFormatSchemaV2_3_0Test()

        @Nested
        @DisplayName("2.4.0")
        inner class V2_4_0: AsyncAPIFormatSchemaV2_4_0Test()

        @Nested
        @DisplayName("2.5.0")
        inner class V2_5_0: AsyncAPIFormatSchemaV2_5_0Test()

        @Nested
        @DisplayName("2.6.0")
        inner class V2_6_0: AsyncAPIFormatSchemaV2_6_0Test()

        @Nested
        @DisplayName("3.0.0")
        inner class V3_0_0: AsyncAPIFormatSchemaV3_0_0Test()

        @Nested
        @DisplayName("MultiFormatSchema with empty schemaFormat is AsyncAPI Schema")
        inner class EmptySchemaFormat: EmptySchemaFormatTest()

        @Nested
        @DisplayName("MultiFormatSchema with null schemaFormat is AsyncAPI Schema")
        inner class NullSchemaFormat: NullSchemaFormatTest()

        @Nested
        @DisplayName("MultiFormatSchema without schemaFormat is AsyncAPI Schema")
        inner class WithoutSchemaFormat: WithoutSchemaFormatTest()

    }

    @Nested
    inner class AvroSchema {

        @Nested
        @DisplayName("1.9.0")
        inner class V1_9_0: AvroFormatSchemaV1_9_0Test()

        @Nested
        @DisplayName("1.9.1")
        inner class V1_9_1: AvroFormatSchemaV1_9_1Test()

        @Nested
        @DisplayName("1.9.2")
        inner class V1_9_2: AvroFormatSchemaV1_9_2Test()

        @Nested
        @DisplayName("1.10.0")
        inner class V1_10_0: AvroFormatSchemaV1_10_0Test()

        @Nested
        @DisplayName("1.10.1")
        inner class V1_10_1: AvroFormatSchemaV1_10_1Test()

        @Nested
        @DisplayName("1.10.2")
        inner class V1_10_2: AvroFormatSchemaV1_10_2Test()

        @Nested
        @DisplayName("1.11.0")
        inner class V1_11_0: AvroFormatSchemaV1_11_0Test()

        @Nested
        @DisplayName("1.11.1")
        inner class V1_11_1: AvroFormatSchemaV1_11_1Test()

    }

    @Nested
    inner class JsonSchema {

        @Nested
        @DisplayName("Draft-07")
        inner class Draft07: JsonFormatSchemaTest()

    }

    @Nested
    inner class OpenAPISchema {

        @Nested
        @DisplayName("3.0.0")
        inner class V3_0_0: OpenAPIFormatSchemaV3_0_0Test()

        @Nested
        @DisplayName("3.0.1")
        inner class V3_0_1: OpenAPIFormatSchemaV3_0_1Test()

        @Nested
        @DisplayName("3.0.2")
        inner class V3_0_2: OpenAPIFormatSchemaV3_0_2Test()

        @Nested
        @DisplayName("3.0.3")
        inner class V3_0_3: OpenAPIFormatSchemaV3_0_3Test()

    }

}