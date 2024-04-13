package com.asyncapi.v3.schema.avro;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * @see <a href="https://avro.apache.org/docs/1.9.0/spec.html#Arrays">Arrays</a>
 */
public class AvroFixedSchema extends AvroSchema {

    public AvroFixedSchema() {
        super(AvroSchemaType.FIXED);
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

}
