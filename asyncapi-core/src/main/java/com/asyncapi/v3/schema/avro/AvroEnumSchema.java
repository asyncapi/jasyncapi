package com.asyncapi.v3.schema.avro;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.List;

/**
 * Avro Enum Schema
 *
 * @see <a href="https://avro.apache.org/docs/1.9.0/spec.html#Enums">Enums</a>
 */
public class AvroEnumSchema {

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
    private String doc;

    /**
     *  A JSON array, listing symbols, as JSON strings (required).
     * <p>
     *  All symbols in an enum must be unique; duplicates are prohibited.
     * <p>
     *  Every symbol must match the regular expression [A-Za-z_][A-Za-z0-9_]* (the same requirement as for <a href="https://avro.apache.org/docs/1.9.0/spec.html#names">names</a>).
     */
    @NotNull
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
    private String defaultValue;

}
