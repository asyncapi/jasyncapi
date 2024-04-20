package com.asyncapi.v3.schema.multiformat;

import com.asyncapi.v3.schema.AsyncAPISchema;
import com.asyncapi.v3.schema.openapi.v3._0_0.OpenAPISchema;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import org.jetbrains.annotations.NotNull;

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
public class OpenAPIFormatSchema extends MultiFormatSchema<OpenAPISchema> {

    public OpenAPIFormatSchema(@NotNull OpenAPISchema schema) {
        super("application/vnd.oai.openapi+json;version=3.0.0", schema);
    }

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public OpenAPIFormatSchema(
            @JsonProperty("schemaFormat") @NotNull String schemaFormat,
            @JsonProperty("schema") @NotNull OpenAPISchema schema
    ) {
        super(schemaFormat, schema);
    }

    @Override
    public void setSchema(@NotNull OpenAPISchema schema) {
        super.setSchema(schema);
    }

    @NotNull
    public OpenAPISchema getSchema() {
        return super.getSchema();
    }

}
