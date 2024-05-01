package com.asyncapi.v3.schema.multiformat;

import com.asyncapi.schemas.AsyncAPISchema;
import com.asyncapi.schemas.JsonSchema;
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
public class JsonFormatSchema extends MultiFormatSchema<JsonSchema> {

    public JsonFormatSchema(@NotNull JsonSchema schema) {
        super("application/schema+json;version=draft-07", schema);
    }

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public JsonFormatSchema(
            @JsonProperty("schemaFormat") @NotNull String schemaFormat,
            @JsonProperty("schema") @NotNull JsonSchema schema
    ) {
        super(schemaFormat, schema);
    }

    @Override
    public void setSchema(@NotNull JsonSchema schema) {
        super.setSchema(schema);
    }

    @NotNull
    public JsonSchema getSchema() {
        return super.getSchema();
    }

}
