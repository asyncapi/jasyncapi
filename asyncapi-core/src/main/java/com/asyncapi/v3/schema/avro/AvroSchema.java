package com.asyncapi.v3.schema.avro;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

/**
 * Apache Avro Schema.
 *
 * @author Pavel Bodiachevskii
 * @version 3.0.0
 * @see <a href="https://avro.apache.org/docs/1.9.0/spec.html">Avro Specification</a>
 */
@Data
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "type",
        visible = true
)
@JsonSubTypes.Type(value = AvroSchema.class, names = {
        "null", "boolean", "int", "long", "float", "double", "bytes", "string"
})
public class AvroSchema {

    /**
     * Avro Schema type.
     */
    @NotNull
    private AvroSchemaType type;

}
