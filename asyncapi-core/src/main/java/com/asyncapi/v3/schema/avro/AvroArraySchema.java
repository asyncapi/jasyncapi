package com.asyncapi.v3.schema.avro;

import com.asyncapi.v3.schema.avro.jackson.AvroRecordFieldSchemaTypeDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.jetbrains.annotations.NotNull;

/**
 * @see <a href="https://avro.apache.org/docs/1.9.0/spec.html#Arrays">Arrays</a>
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class AvroArraySchema extends AvroSchema {

    public AvroArraySchema() {
        super(AvroSchemaType.ARRAY);
    }

    @Builder(builderMethodName = "arrayBuilder")
    public AvroArraySchema(
            @NotNull Object items
    ) {
        super(AvroSchemaType.ARRAY);
        this.items = items;
    }

    @NotNull
    @JsonProperty("items")
    @JsonDeserialize(using = AvroRecordFieldSchemaTypeDeserializer.class)
    private Object items;

    @NotNull
    @Override
    public AvroSchemaType getType() {
        return AvroSchemaType.ARRAY;
    }

    public void setType(@NotNull AvroSchemaType type) {
        super.setType(AvroSchemaType.ARRAY);
    }

}
