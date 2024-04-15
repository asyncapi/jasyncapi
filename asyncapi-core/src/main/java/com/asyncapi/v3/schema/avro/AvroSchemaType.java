package com.asyncapi.v3.schema.avro;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import org.jetbrains.annotations.NotNull;

/**
 * Apache Avro Schema types.
 *
 * @author Pavel Bodiachevskii
 * @version 3.0.0
 * @see <a href="https://avro.apache.org/docs/1.9.0/spec.html#schema_primitive">Avro Schema Primitive Types</a>
 * @see <a href="https://avro.apache.org/docs/1.9.0/spec.html#schema_complex">Avro Schema Complex Types</a>
 */
public enum AvroSchemaType {

    /*
        Primitive Types.
     */

    @JsonProperty("null")
    @JsonPropertyDescription("no value")
    NULL,

    @JsonProperty("boolean")
    @JsonPropertyDescription("a binary value")
    BOOLEAN,

    @JsonProperty("int")
    @JsonPropertyDescription("32-bit signed integer")
    INT,

    @JsonProperty("long")
    @JsonPropertyDescription("64-bit signed integer")
    LONG,

    @JsonProperty("float")
    @JsonPropertyDescription("single precision (32-bit) IEEE 754 floating-point number")
    FLOAT,

    @JsonProperty("double")
    @JsonPropertyDescription("double precision (64-bit) IEEE 754 floating-point number")
    DOUBLE,

    @JsonProperty("bytes")
    @JsonPropertyDescription("sequence of 8-bit unsigned bytes")
    BYTES,

    @JsonProperty("string")
    @JsonPropertyDescription("unicode character sequence")
    STRING,

    /*
        Complex Types.
     */

    @JsonProperty("record")
    RECORD,

    @JsonProperty("error")
    ERROR,

    @JsonProperty("enum")
    ENUM,

    @JsonProperty("array")
    ARRAY,

    @JsonProperty("map")
    MAP,

    @JsonProperty("unions")
    UNIONS,

    @JsonProperty("fixed")
    FIXED;

}
