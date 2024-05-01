package com.asyncapi.schemas.multiformat;

import com.asyncapi.schemas.AsyncAPISchema;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class AsyncAPIFormatSchema extends MultiFormatSchema<AsyncAPISchema> {

    public AsyncAPIFormatSchema(@NotNull AsyncAPISchema schema) {
        super(schema);
    }

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public AsyncAPIFormatSchema(
            @JsonProperty("schemaFormat") @Nullable String schemaFormat,
            @JsonProperty("schema") @NotNull AsyncAPISchema schema
    ) {
        super(schemaFormat(schemaFormat), schema);
    }

    @Override
    public void setSchema(@NotNull AsyncAPISchema schema) {
        super.setSchema(schema);
    }

    @NotNull
    public AsyncAPISchema getSchema() {
        return super.getSchema();
    }

    @NotNull
    private static String schemaFormat(@Nullable String schemaFormat) {
        if (schemaFormat == null || schemaFormat.isEmpty()) {
            return "application/vnd.aai.asyncapi+json;version=3.0.0";
        }

        return schemaFormat;
    }

}
