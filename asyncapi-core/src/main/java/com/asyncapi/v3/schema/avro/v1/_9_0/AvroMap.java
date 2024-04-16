package com.asyncapi.v3.schema.avro.v1._9_0;

import com.asyncapi.v3.schema.avro.v1._9_0.jackson.AvroTypeDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

/**
 * @see <a href="https://avro.apache.org/docs/1.9.0/spec.html#Maps">Maps</a>
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class AvroMap extends Avro {

    public AvroMap() {
        super(AvroType.MAP);
    }

    public AvroMap(@NotNull Object values) {
        this.values = values;
    }

    @Builder(builderMethodName = "mapBuilder")
    public AvroMap(
            @NotNull Object values,
            @Nullable Map<String, Object> defaultValue,
            @Nullable Map<String, Object> metadata
    ) {
        this.values = values;
        this.defaultValue = defaultValue;
        this.metadata = metadata;
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
    public AvroType getType() {
        return AvroType.MAP;
    }

    public void setType(@NotNull AvroType type) {
        super.setType(AvroType.MAP);
    }

}
