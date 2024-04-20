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
 * Avro Enum Schema
 *
 * @see <a href="https://avro.apache.org/docs/1.9.0/spec.html#Enums">Enums</a>
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class AvroSchemaEnum extends AvroSchema {

    public AvroSchemaEnum() {
        super(AvroSchemaType.ENUM);
    }

    public AvroSchemaEnum(
            @NotNull String name,
            @Nullable String namespace,
            @Nullable String doc,
            @NotNull List<@NotNull String> symbols,
            @Nullable List<@NotNull String> aliases,
            @Nullable Object defaultValue,
            @Nullable Map<String, Object> metadata
    ) {
        super(AvroSchemaType.ENUM);

        this.name = name;
        this.namespace = namespace;
        this.doc = doc;
        this.symbols = symbols;
        this.aliases = aliases;
        this.defaultValue = defaultValue;
        this.metadata = metadata;
    }

    public AvroSchemaEnum(@NotNull Builder builder) {
        super(AvroSchemaType.ENUM);

        this.name = builder.name;
        this.namespace = builder.namespace;
        this.doc = builder.doc;
        this.symbols = builder.symbols;
        this.aliases = builder.aliases;
        this.defaultValue = builder.defaultValue;
        this.metadata = builder.metadata;
    }

    @NotNull
    @JsonProperty("name")
    private String name = "";

    @Nullable
    @JsonProperty("namespace")
    private String namespace;

    /**
     * A JSON string providing documentation to the user of this schema (optional).
     */
    @Nullable
    @JsonProperty("doc")
    private String doc;

    /**
     *  A JSON array, listing symbols, as JSON strings (required).
     * <p>
     *  All symbols in an enum must be unique; duplicates are prohibited.
     * <p>
     *  Every symbol must match the regular expression [A-Za-z_][A-Za-z0-9_]* (the same requirement as for <a href="https://avro.apache.org/docs/1.9.0/spec.html#names">names</a>).
     */
    @NotNull
    @JsonProperty("symbols")
    private List<@NotNull String> symbols = Collections.emptyList();

    /**
     * A JSON array of strings, providing alternate names for this record (optional).
     */
    @Nullable
    @JsonProperty("aliases")
    private List<@NotNull String> aliases;

    /**
     * A default value for this enumeration, used during resolution when the reader encounters a symbol
     * from the writer that isn't defined in the reader's schema (optional).
     * <p>
     * The value provided here must be a JSON string that's a member of the symbols array.
     * <p>
     * See documentation on schema resolution for how this gets used.
     */
    @Nullable
    @JsonProperty("default")
    @JsonDeserialize(using = AvroTypeDeserializer.class)
    private Object defaultValue;

    @NotNull
    @Override
    public String getType() {
        return AvroSchemaType.ENUM;
    }

    public void setType(@NotNull String type) {
        super.setType(AvroSchemaType.ENUM);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends AvroSchema.Builder<AvroSchemaEnum, Builder> {

        @NotNull
        private String name = "";

        @Nullable
        private String namespace;

        @Nullable
        private String doc;

        @NotNull
        private List<@NotNull String> symbols = Collections.emptyList();

        @Nullable
        private List<@NotNull String> aliases;

        @Nullable
        private Object defaultValue;

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
        public Builder doc(@Nullable String doc) {
            this.doc = doc;
            return this;
        }

        @NotNull
        public Builder symbols(@NotNull List<@NotNull String> symbols) {
            this.symbols = symbols;
            return this;
        }

        @NotNull
        public Builder aliases(@NotNull List<@NotNull String> aliases) {
            this.aliases = aliases;
            return this;
        }

        @NotNull
        public Builder defaultValue(@Nullable Object defaultValue) {
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
        public AvroSchemaEnum build() {
            return new AvroSchemaEnum(this);
        }

    }

}
