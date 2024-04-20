package com.asyncapi.v3.schema.avro.v1._9_0;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

/**
 * Apache Avro Schema types.
 *
 * @author Pavel Bodiachevskii
 * @version 3.0.0
 * @see <a href="https://avro.apache.org/docs/1.9.0/spec.html#schema_primitive">Avro Schema Primitive Types</a>
 * @see <a href="https://avro.apache.org/docs/1.9.0/spec.html#schema_complex">Avro Schema Complex Types</a>
 */
public class AvroSchemaType {

    /*
        Primitive Types.
     */

    @JsonProperty("null")
    @JsonPropertyDescription("no value")
    public static final String NULL = "null";

    @JsonProperty("boolean")
    @JsonPropertyDescription("a binary value")
    public static final String BOOLEAN = "boolean";

    @JsonProperty("int")
    @JsonPropertyDescription("32-bit signed integer")
    public static final String INT = "int";

    @JsonProperty("long")
    @JsonPropertyDescription("64-bit signed integer")
    public static final String LONG = "long";

    @JsonProperty("float")
    @JsonPropertyDescription("single precision (32-bit) IEEE 754 floating-point number")
    public static final String FLOAT = "float";

    @JsonProperty("double")
    @JsonPropertyDescription("double precision (64-bit) IEEE 754 floating-point number")
    public static final String DOUBLE = "double";

    @JsonProperty("bytes")
    @JsonPropertyDescription("sequence of 8-bit unsigned bytes")
    public static final String BYTES = "bytes";

    @JsonProperty("string")
    @JsonPropertyDescription("unicode character sequence")
    public static final String STRING = "string";

    /*
        Complex Types.
     */

    @JsonProperty("record")
    public static final String RECORD = "record";

    @JsonProperty("error")
    public static final String ERROR = "error";

    @JsonProperty("enum")
    public static final String ENUM = "enum";

    @JsonProperty("array")
    public static final String ARRAY = "array";

    @JsonProperty("map")
    public static final String MAP = "map";

    @JsonProperty("unions")
    public static final String UNIONS = "unions";

    @JsonProperty("fixed")
    public static final String FIXED = "fixed";

}
