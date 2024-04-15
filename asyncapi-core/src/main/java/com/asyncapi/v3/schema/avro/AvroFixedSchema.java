package com.asyncapi.v3.schema.avro;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * @see <a href="https://avro.apache.org/docs/1.9.0/spec.html#Arrays">Arrays</a>
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class AvroFixedSchema extends AvroSchema {

    public AvroFixedSchema() {
        super(AvroSchemaType.FIXED);
    }

    @Builder(builderMethodName = "fixedBuilder")
    public AvroFixedSchema(
            @NotNull String name,
            @Nullable String namespace,
            @Nullable List<@NotNull String> aliases,
            @NotNull Integer size
    ) {
        super(AvroSchemaType.FIXED);

        this.name = name;
        this.namespace = namespace;
        this.aliases = aliases;
        this.size = size;
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
