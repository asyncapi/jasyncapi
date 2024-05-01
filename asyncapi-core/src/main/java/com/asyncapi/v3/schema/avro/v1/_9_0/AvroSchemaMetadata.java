package com.asyncapi.v3.schema.avro.v1._9_0;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

/**
 * Avro Schema metadata
 */
@Data
@JsonIgnoreProperties({"metadata"})
public class AvroSchemaMetadata {

    public AvroSchemaMetadata() {}

    public AvroSchemaMetadata(@Nullable Map<String, Object> metadata) {
        this.metadata = metadata;
    }

    @Nullable
    @JsonAnyGetter
    protected Map<String, Object> metadata;

    @JsonAnySetter
    protected final void readMetadata(String name, Object value) {
        if (metadata == null) {
            metadata = new HashMap<>();
        }

        metadata.put(name, value);
    }

}
