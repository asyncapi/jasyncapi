package com.asyncapi.v3.schema.avro;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;

/**
 * @see <a href="https://avro.apache.org/docs/1.9.0/spec.html#Maps">Maps</a>
 */
public class AvroMapSchema extends AvroSchema {

    public AvroMapSchema() {
        super(AvroSchemaType.MAP);
    }

    @NotNull
    @JsonProperty("values")
    private String values;

}
