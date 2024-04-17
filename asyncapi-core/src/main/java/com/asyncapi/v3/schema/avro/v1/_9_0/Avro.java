package com.asyncapi.v3.schema.avro.v1._9_0;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Apache Avro Schema.
 *
 * @author Pavel Bodiachevskii
 * @version 3.0.0
 * @see <a href="https://avro.apache.org/docs/1.9.0/spec.html">Avro Specification</a>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "type",
        defaultImpl = AvroUnion.class,
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Avro.class, names = {
                AvroType.NULL, AvroType.BOOLEAN, AvroType.INT, AvroType.LONG,
                AvroType.FLOAT, AvroType.DOUBLE, AvroType.BYTES, AvroType.STRING
        }),
        @JsonSubTypes.Type(value = AvroRecord.class, names = {AvroType.RECORD, AvroType.ERROR}),
        @JsonSubTypes.Type(value = AvroArray.class, name = AvroType.ARRAY),
        @JsonSubTypes.Type(value = AvroMap.class, name = AvroType.MAP),
        @JsonSubTypes.Type(value = AvroEnum.class, name = AvroType.ENUM),
        @JsonSubTypes.Type(value = AvroFixed.class, name = AvroType.FIXED),
})
public class Avro extends AvroMetadata {

    public Avro(@NotNull String avroType) {
        this.type = avroType;
    }

    /**
     * Avro Schema type.
     */
    @NotNull
    private String type;

    @Nullable
    private Integer scale;

    /*
        Type: bytes, fixed
     */

    @Nullable
    private Integer precision;

    @Nullable
    private String logicalType;

    public static class LogicalType {

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

}
