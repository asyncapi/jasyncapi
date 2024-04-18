package com.asyncapi.v3.schema.avro.v1._9_0;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;

/**
 * @see <a href="https://avro.apache.org/docs/1.9.0/spec.html#Arrays">Arrays</a>
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class AvroFixed extends Avro {

    public AvroFixed() {
        super(AvroType.FIXED);
    }

    public AvroFixed(
            @NotNull String name,
            @Nullable String namespace,
            @Nullable List<@NotNull String> aliases,
            @NotNull Integer size,
            @Nullable Map<String, Object> metadata
    ) {
        super(AvroType.FIXED);

        this.name = name;
        this.namespace = namespace;
        this.aliases = aliases;
        this.size = size;
        this.metadata = metadata;
    }

    public AvroFixed(@NotNull Builder builder) {
        super(AvroType.FIXED);

        this.name = builder.name;
        this.namespace = builder.namespace;
        this.aliases = builder.aliases;
        this.size = builder.size;
        this.metadata = builder.metadata;
    }

    @NotNull
    @JsonProperty("name")
    private String name;

    /**
     * A JSON string that qualifies the name.
     */
    @Nullable
    @JsonProperty("namespace")
    private String namespace;

    /**
     * A JSON array of strings, providing alternate names for this record (optional).
     */
    @Nullable
    private List<@NotNull String> aliases;

    /**
     * An integer, specifying the number of bytes per value (required).
     */
    @NotNull
    private Integer size;

    @NotNull
    @Override
    public String getType() {
        return AvroType.FIXED;
    }

    public void setType(@NotNull String type) {
        super.setType(AvroType.FIXED);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends Avro.Builder<AvroFixed, Builder> {

        @NotNull
        private String name = "";

        @Nullable
        private String namespace;

        @Nullable
        private List<@NotNull String> aliases;

        @NotNull
        private Integer size = 0;

        @NotNull
        public Builder name(@NotNull String name) {
            this.name = name;
            return this;
        }

        @NotNull
        public Builder namespace(@Nullable String namespace) {
            this.namespace = namespace;
            return this;
        }

        @NotNull
        public Builder aliases(@NotNull List<@NotNull String> aliases) {
            this.aliases = aliases;
            return this;
        }

        @NotNull
        public Builder size(@NotNull Integer size) {
            this.size = size;
            return this;
        }

        @NotNull
        @Override
        protected Builder getThis() {
            return this;
        }

        @NotNull
        @Override
        public AvroFixed build() {
            return new AvroFixed(this);
        }

    }

}
