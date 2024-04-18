package com.asyncapi.v3.schema.avro.v1._9_0;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AvroSchemaLogicalType {

    @JsonProperty("decimal")
    public static final String DECIMAL = "decimal";

    @JsonProperty("big-decimal")
    public static final String BIG_DECIMAL = "big-decimal";

    @JsonProperty("uuid")
    public static final String UUID = "uuid";

    @JsonProperty("date")
    public static final String DATE = "date";

    @JsonProperty("time-millis")
    public static final String TIME_MILLIS = "time-millis";

    @JsonProperty("time-micros")
    public static final String TIME_MICROS = "time-micros";

    @JsonProperty("timestamp-millis")
    public static final String TIMESTAMP_MILLIS = "timestamp-millis";

    @JsonProperty("timestamp-micros")
    public static final String TIMESTAMP_MICROS = "timestamp-micros";

    @JsonProperty("duration")
    public static final String DURATION = "duration";

}
