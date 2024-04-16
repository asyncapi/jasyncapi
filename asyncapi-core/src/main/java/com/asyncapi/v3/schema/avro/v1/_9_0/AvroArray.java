package com.asyncapi.v3.schema.avro.v1._9_0;

import com.asyncapi.v3.schema.avro.v1._9_0.jackson.AvroTypeDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
public class AvroArray extends Avro {

    public AvroArray() {
        super(AvroType.ARRAY);
    }

    public AvroArray(@NotNull Object items) {
        super(AvroType.ARRAY);
        this.items = items;
    }

    @Builder(builderMethodName = "arrayBuilder")
    public AvroArray(
            @NotNull Object items,
            @Nullable List<Object> defaultValue
    ) {
        super(AvroType.ARRAY);
        this.items = items;
        this.defaultValue = defaultValue;
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
    public AvroType getType() {
        return AvroType.ARRAY;
    }

    public void setType(@NotNull AvroType type) {
        super.setType(AvroType.ARRAY);
    }

}
