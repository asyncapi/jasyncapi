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
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Avro.class, names = {
                "null", "boolean", "int", "long", "float", "double", "bytes", "string"
        }),
        @JsonSubTypes.Type(value = AvroRecord.class, names = {"record", "error"}),
        @JsonSubTypes.Type(value = AvroArray.class, name = "array"),
        @JsonSubTypes.Type(value = AvroMap.class, name = "map"),
        @JsonSubTypes.Type(value = AvroEnum.class, name = "enum"),
        @JsonSubTypes.Type(value = AvroFixed.class, name = "fixed"),
})
public class Avro extends AvroMetadata {

    public Avro(@NotNull AvroType avroType) {
        this.type = avroType;
    }

    /**
     * Avro Schema type.
     */
    @NotNull
    private AvroType type;

    @Nullable
    private Integer scale;

    /*
        Type: bytes, fixed
     */

    @Nullable
    private Integer precision;

    @Nullable
    private LogicalType logicalType;

    public enum LogicalType {

        @JsonProperty("decimal")
        DECIMAL,

        @JsonProperty("uuid")
        UUID,

        @JsonProperty("date")
        DATE,

        @JsonProperty("time-millis")
        TIME_MILLIS,

        @JsonProperty("time-micros")
        TIME_MICROS,

        @JsonProperty("timestamp-millis")
        TIMESTAMP_MILLIS,

        @JsonProperty("timestamp-micros")
        TIMESTAMP_MICROS,

        @JsonProperty("duration")
        DURATION

    }

}
