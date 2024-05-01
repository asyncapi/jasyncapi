package com.asyncapi.v3.schema.multiformat;

import com.asyncapi.schemas.Reference;
import com.asyncapi.v3.schema.AsyncAPISchema;
import com.asyncapi.v3.schema.avro.v1._9_0.jackson.AvroSchemaDeserializer;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.EqualsAndHashCode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * The Multi Format Schema Object represents a schema definition. It differs from the {@link AsyncAPISchema} in that it supports
 * multiple schema formats or languages (e.g., JSON Schema, Avro, etc.).
 *
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v3.0.0#multiFormatSchemaObject">Multi Format Schema</a>
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v3.0.0#schemaObject">Schema</a>
 * @author Pavel Bodiachevskii
 * @version 3.0.0
 */
@EqualsAndHashCode(callSuper = true)
public class AvroFormatSchema extends MultiFormatSchema<Object> {

    public AvroFormatSchema(@NotNull @JsonDeserialize(using = AvroSchemaDeserializer.class) Object schema) {
        super("application/vnd.apache.avro;version=1.9.0", schema);
    }

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public AvroFormatSchema(
            @JsonProperty("schemaFormat") @Nullable String schemaFormat,
            @JsonProperty("schema") @NotNull @JsonDeserialize(using = AvroSchemaDeserializer.class) Object schema
    ) {
        super(schemaFormat(schemaFormat), schema);
    }

    /**
     * Schema <b>MUST</b> be one of:
     * <ul>
     *     <li>{@link com.asyncapi.v3.schema.avro.v1._9_0.AvroSchema}</li>
     *     <li>{@link com.asyncapi.v3.schema.avro.v1._9_0.AvroSchemaUnion}</li>
     *     <li>{@link Reference}</li>
     * </ul>
     *
     * @param schema Avro Schema or Reference
     */
    @Override
    public void setSchema(@NotNull Object schema) {
        super.setSchema(schema);
    }

    /**
     * Schema:
     * <ul>
     *     <li>{@link com.asyncapi.v3.schema.avro.v1._9_0.AvroSchema}</li>
     *     <li>{@link com.asyncapi.v3.schema.avro.v1._9_0.AvroSchemaUnion}</li>
     *     <li>{@link Reference}</li>
     * </ul>
     */
    @NotNull
    public Object getSchema() {
        return super.getSchema();
    }

    @NotNull
    private static String schemaFormat(@Nullable String schemaFormat) {
        if (schemaFormat == null || schemaFormat.isEmpty()) {
            return "application/vnd.apache.avro;version=1.9.0";
        }

        return schemaFormat;
    }

}
