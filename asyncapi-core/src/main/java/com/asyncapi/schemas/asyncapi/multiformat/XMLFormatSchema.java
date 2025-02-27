package com.asyncapi.schemas.asyncapi.multiformat;

import com.asyncapi.schemas.asyncapi.AsyncAPISchema;
import com.asyncapi.schemas.asyncapi.Reference;
import com.asyncapi.schemas.xml.XMLSchemaDeserializer;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.EqualsAndHashCode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * The XML Format Schema Object represents a schema definition. It differs from the {@link AsyncAPISchema} in that it supports
 * multiple schema formats or languages (e.g., JSON Schema, Avro, XML, etc.).
 *
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v3.0.0#multiFormatSchemaObject">Multi Format Schema</a>
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v3.0.0#schemaObject">Schema</a>
 */
@EqualsAndHashCode(callSuper = true)
public class XMLFormatSchema extends MultiFormatSchema<Object> {

    public XMLFormatSchema(@NotNull @JsonDeserialize(using = XMLSchemaDeserializer.class) Object schema) {
        super("application/xml", schema);
    }

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public XMLFormatSchema(
            @JsonProperty("schemaFormat") @Nullable String schemaFormat,
            @JsonProperty("schema") @NotNull @JsonDeserialize(using = XMLSchemaDeserializer.class) Object schema
    ) {
        super(schemaFormat(schemaFormat), schema);
    }

    /**
     * Schema <b>MUST</b> be one of:
     * <ul>
     *     <li>{@link Reference}</li>
     * </ul>
     *
     * @param schema XML Schema or Reference
     */
    @Override
    public void setSchema(@NotNull Object schema) {
        super.setSchema(schema);
    }

    /**
     * Schema:
     * <ul>
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
            return "application/xml";
        }
        return schemaFormat;
    }
}
