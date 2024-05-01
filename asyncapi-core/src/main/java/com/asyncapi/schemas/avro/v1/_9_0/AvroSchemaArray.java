package com.asyncapi.schemas.avro.v1._9_0;

import com.asyncapi.schemas.avro.v1._9_0.jackson.AvroTypeDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Avro Array Schema
 *
 * @see <a href="https://avro.apache.org/docs/1.9.0/spec.html#Arrays">Arrays</a>
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class AvroSchemaArray extends AvroSchema {

    public AvroSchemaArray() {
        super(AvroSchemaType.ARRAY);
    }

    public AvroSchemaArray(@NotNull Object items) {
        super(AvroSchemaType.ARRAY);
        this.items = items;
    }

    public AvroSchemaArray(
            @NotNull Object items,
            @Nullable List<Object> defaultValue,
            @Nullable Map<String, Object> metadata
    ) {
        super(AvroSchemaType.ARRAY);
        this.items = items;
        this.defaultValue = defaultValue;
        this.metadata = metadata;
    }

    public AvroSchemaArray(@NotNull Builder builder) {
        super(AvroSchemaType.ARRAY);

        this.items = builder.items;
        this.defaultValue = builder.defaultValue;
        this.metadata = builder.metadata;
    }

    /**
     * The schema of the array's items.
     */
    @NotNull
    @JsonProperty("items")
    @JsonDeserialize(using = AvroTypeDeserializer.class)
    private Object items;

    @Nullable
    @JsonProperty("default")
    private List<Object> defaultValue;

    @NotNull
    @Override
    public String getType() {
        return AvroSchemaType.ARRAY;
    }

    public void setType(@NotNull String type) {
        super.setType(AvroSchemaType.ARRAY);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends AvroSchema.Builder<AvroSchemaArray, Builder> {

        @NotNull
        private Object items = Collections.emptyList();

        @Nullable
        private List<Object> defaultValue;

        @NotNull
        public Builder items(@NotNull Object items) {
            this.items = items;
            return this;
        }

        @NotNull
        public Builder defaultValue(@NotNull List<Object> defaultValue) {
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
        public AvroSchemaArray build() {
            return new AvroSchemaArray(this);
        }

    }

}
