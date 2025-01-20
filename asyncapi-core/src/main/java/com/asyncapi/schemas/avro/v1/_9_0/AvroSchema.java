package com.asyncapi.schemas.avro.v1._9_0;

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
        defaultImpl = AvroSchemaUnion.class,
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = AvroSchema.class, names = {
                AvroSchemaType.NULL, AvroSchemaType.BOOLEAN, AvroSchemaType.INT, AvroSchemaType.LONG,
                AvroSchemaType.FLOAT, AvroSchemaType.DOUBLE, AvroSchemaType.BYTES, AvroSchemaType.STRING
        }),
        @JsonSubTypes.Type(value = AvroSchemaRecord.class, names = {AvroSchemaType.RECORD, AvroSchemaType.ERROR}),
        @JsonSubTypes.Type(value = AvroSchemaArray.class, name = AvroSchemaType.ARRAY),
        @JsonSubTypes.Type(value = AvroSchemaMap.class, name = AvroSchemaType.MAP),
        @JsonSubTypes.Type(value = AvroSchemaEnum.class, name = AvroSchemaType.ENUM),
        @JsonSubTypes.Type(value = AvroSchemaFixed.class, name = AvroSchemaType.FIXED),
})
public class AvroSchema extends AvroSchemaMetadata {

    public AvroSchema() {
        this.type = AvroSchemaType.NULL;
    }

    public AvroSchema(@NotNull String avroType) {
        this.type = avroType;
    }

    public AvroSchema(@NotNull Builder<?, ?> builder) {
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
    @JsonProperty("type")
    private String type;

    /**
     * A JSON integer representing the scale (optional).
     * <p>
     * If not specified the scale is 0.
     */
    @Nullable
    @JsonProperty("scale")
    private Integer scale;

    /*
        Type: bytes, fixed, decimal
     */

    /**
     * A JSON integer representing the (maximum) precision of decimals stored in this type (required).
     */
    @Nullable
    @JsonProperty("precision")
    private Integer precision;

    /**
     * A logical type is an Avro primitive or complex type with extra attributes to represent a derived type.
     * <p>
     * The attribute logicalType must always be present for a logical type, and is a string with the name of one
     * of the logical types listed later in this section. Other attributes may be defined for particular logical types.
     * <p>
     * <p>
     * A logical type is always serialized using its underlying Avro type so that values are encoded in exactly the same
     * way as the equivalent Avro type that does not have a logicalType attribute. Language implementations may choose to
     * represent logical types with an appropriate native type, although this is not required.
     * <p>
     * Language implementations must ignore unknown logical types when reading, and should use the underlying Avro type.
     * <p>
     * If a logical type is invalid, for example a decimal with scale greater than its precision, then implementations
     * should ignore the logical type and use the underlying Avro type.
     *
     * @see <a href="https://avro.apache.org/docs/1.9.0/spec.html#Logical+Types">Logical Types</a>
     */
    @Nullable
    @JsonProperty("logicalType")
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
            public AvroSchema build() {
                return new AvroSchema(this);
            }

        };

    }

    public static abstract class Builder<AvroSchemaVariant extends AvroSchema, BuilderVariant extends Builder<AvroSchemaVariant, BuilderVariant>> {

        @NotNull
        protected String type = AvroSchemaType.NULL;

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

}
