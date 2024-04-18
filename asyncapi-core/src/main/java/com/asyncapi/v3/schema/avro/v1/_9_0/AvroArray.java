package com.asyncapi.v3.schema.avro.v1._9_0;

import com.asyncapi.v3.schema.avro.v1._9_0.jackson.AvroTypeDeserializer;
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
 * @see <a href="https://avro.apache.org/docs/1.9.0/spec.html#Arrays">Arrays</a>
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class AvroArray extends Avro {

    public AvroArray() {
        super(AvroType.ARRAY);
    }

    public AvroArray(@NotNull Object items) {
        super(AvroType.ARRAY);
        this.items = items;
    }

    public AvroArray(
            @NotNull Object items,
            @Nullable List<Object> defaultValue,
            @Nullable Map<String, Object> metadata
    ) {
        super(AvroType.ARRAY);
        this.items = items;
        this.defaultValue = defaultValue;
        this.metadata = metadata;
    }

    public AvroArray(@NotNull Builder builder) {
        super(AvroType.ARRAY);

        this.items = builder.items;
        this.defaultValue = builder.defaultValue;
        this.metadata = builder.metadata;
    }

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
        return AvroType.ARRAY;
    }

    public void setType(@NotNull String type) {
        super.setType(AvroType.ARRAY);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends Avro.Builder<AvroArray, Builder> {

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
        public AvroArray build() {
            return new AvroArray(this);
        }

    }

}
