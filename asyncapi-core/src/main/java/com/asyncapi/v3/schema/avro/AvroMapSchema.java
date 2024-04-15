package com.asyncapi.v3.schema.avro;

import com.asyncapi.v3.schema.avro.jackson.AvroRecordFieldSchemaTypeDeserializer;
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
public class AvroMapSchema extends AvroSchema {

    public AvroMapSchema() {
        super(AvroSchemaType.MAP);
    }

    public AvroMapSchema(@NotNull Object values) {
        this.values = values;
    }

    @Builder(builderMethodName = "mapBuilder")
    public AvroMapSchema(@NotNull Object values, @Nullable Map<String, Object> metadata) {
        this.values = values;
        this.metadata = metadata;
    }

    @NotNull
    @JsonProperty("values")
    @JsonDeserialize(using = AvroRecordFieldSchemaTypeDeserializer.class)
    private Object values;

    @NotNull
    @Override
    public AvroSchemaType getType() {
        return AvroSchemaType.MAP;
    }

    public void setType(@NotNull AvroSchemaType type) {
        super.setType(AvroSchemaType.MAP);
    }

}
