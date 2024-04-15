package com.asyncapi.v3.schema.avro;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"metadata"})
public class AvroMetadata {

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
