package com.asyncapi.v3.schema.avro.v1._9_0;

import com.asyncapi.v3.schema.avro.v1._9_0.jackson.AvroTypeDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.Map;

/**
 * Avro Map Schema
 *
 * @see <a href="https://avro.apache.org/docs/1.9.0/spec.html#Maps">Maps</a>
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class AvroSchemaMap extends AvroSchema {

    public AvroSchemaMap() {
        super(AvroSchemaType.MAP);
    }

    public AvroSchemaMap(@NotNull Object values) {
        super(AvroSchemaType.MAP);

        this.values = values;
    }

    public AvroSchemaMap(
            @NotNull Object values,
            @Nullable Map<String, Object> defaultValue,
            @Nullable Map<String, Object> metadata
    ) {
        super(AvroSchemaType.MAP);

        this.values = values;
        this.defaultValue = defaultValue;
        this.metadata = metadata;
    }

    public AvroSchemaMap(@NotNull Builder builder) {
        super(AvroSchemaType.MAP);

        this.values = builder.values;
        this.defaultValue = builder.defaultValue;
        this.metadata = builder.metadata;
    }

    @NotNull
    @JsonProperty("values")
    @JsonDeserialize(using = AvroTypeDeserializer.class)
    private Object values;

    @Nullable
    @JsonProperty("default")
    private Map<String, Object> defaultValue;

    @NotNull
    @Override
    public String getType() {
        return AvroSchemaType.MAP;
    }

    public void setType(@NotNull String type) {
        super.setType(AvroSchemaType.MAP);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends AvroSchema.Builder<AvroSchemaMap, Builder> {

        @NotNull
        private Object values = Collections.<String, Object>emptyMap();

        @Nullable
        private Map<String, Object> defaultValue;

        @NotNull
        public Builder values(@NotNull Object values) {
            this.values = values;
            return this;
        }

        @NotNull
        public Builder defaultValue(@Nullable Map<String, Object> defaultValue) {
            this.defaultValue = defaultValue;
            return this;
        }

        @NotNull
        @Override
        protected Builder getThis() {
            return this;
        }

        @NotNull
        @Override
        public AvroSchemaMap build() {
            return new AvroSchemaMap(this);
        }

    }

}
