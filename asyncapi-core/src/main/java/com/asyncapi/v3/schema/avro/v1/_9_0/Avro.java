package com.asyncapi.v3.schema.avro.v1._9_0;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

/**
 * Apache Avro Schema.
 *
 * @author Pavel Bodiachevskii
 * @version 3.0.0
 * @see <a href="https://avro.apache.org/docs/1.9.0/spec.html">Avro Specification</a>
 */
@Data
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

    public Avro() {
        this.type = AvroType.NULL;
    }

    public Avro(@NotNull String avroType) {
        this.type = avroType;
    }

    public Avro(@NotNull Builder<?, ?> builder) {
        this.type = builder.type;
        this.scale = builder.scale;
        this.precision = builder.precision;
        this.logicalType = builder.logicalType;
        super.metadata = builder.metadata;
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

    public static Builder<?, ?> builder() {

        return new Builder() {

            @NotNull
            @Override
            protected Builder getThis() {
                return this;
            }

            @NotNull
            @Override
            public Avro build() {
                return new Avro(this);
            }

        };

    }

    public static abstract class Builder<AvroSchemaVariant extends Avro, BuilderVariant extends Builder<AvroSchemaVariant, BuilderVariant>> {

        @NotNull
        protected String type = AvroType.NULL;

        @Nullable
        private Integer scale;

        @Nullable
        private Integer precision;

        @Nullable
        private String logicalType;

        @Nullable
        protected Map<String, Object> metadata;

        @NotNull
        public BuilderVariant type(@NotNull String type) {
            this.type = type;
            return getThis();
        }

        @NotNull
        public BuilderVariant scale(@Nullable Integer scale) {
            this.scale = scale;
            return getThis();
        }

        @NotNull
        public BuilderVariant precision(@Nullable Integer precision) {
            this.precision = precision;
            return getThis();
        }

        @NotNull
        public BuilderVariant logicalType(@Nullable String logicalType) {
            this.logicalType = logicalType;
            return getThis();
        }

        @NotNull
        public BuilderVariant metadata(@Nullable Map<String, Object> metadata) {
            this.metadata = metadata;
            return getThis();
        }

        @NotNull
        protected abstract BuilderVariant getThis();

        @NotNull
        public abstract AvroSchemaVariant build();

    }

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
