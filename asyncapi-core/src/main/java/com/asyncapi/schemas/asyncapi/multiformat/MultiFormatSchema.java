package com.asyncapi.schemas.asyncapi.multiformat;

import com.asyncapi.schemas.asyncapi.ExtendableObject;
import com.asyncapi.schemas.asyncapi.Reference;
import com.asyncapi.schemas.asyncapi.AsyncAPISchema;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.EqualsAndHashCode;
import org.jetbrains.annotations.NotNull;

/**
 * The Multi Format Schema Object represents a schema definition. It differs from the {@link AsyncAPISchema} in that it supports
 * multiple schema formats or languages (e.g., JSON Schema, Avro, etc.).
 *
 * @param <Schema> schema to use
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v3.0.0#multiFormatSchemaObject">Multi Format Schema</a>
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v3.0.0#schemaObject">Schema</a>
 * @author Pavel Bodiachevskii
 * @version 3.0.0
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        defaultImpl = AsyncAPIFormatSchema.class,
        property = "schemaFormat",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = JsonFormatSchema.class, names = {
                "application/schema+json;version=draft-07",
                "application/schema+yaml;version=draft-07"
        }),
        @JsonSubTypes.Type(value = OpenAPIFormatSchema.class, names = {
                "application/vnd.oai.openapi;version=3.0.0",
                "application/vnd.oai.openapi+json;version=3.0.0",
                "application/vnd.oai.openapi+yaml;version=3.0.0",
                "application/vnd.oai.openapi;version=3.0.1",
                "application/vnd.oai.openapi+json;version=3.0.1",
                "application/vnd.oai.openapi+yaml;version=3.0.1",
                "application/vnd.oai.openapi;version=3.0.2",
                "application/vnd.oai.openapi+json;version=3.0.2",
                "application/vnd.oai.openapi+yaml;version=3.0.2",
                "application/vnd.oai.openapi;version=3.0.3",
                "application/vnd.oai.openapi+json;version=3.0.3",
                "application/vnd.oai.openapi+yaml;version=3.0.3"
        }),
        @JsonSubTypes.Type(value = AsyncAPIFormatSchema.class, names = {
                "application/vnd.aai.asyncapi;version=2.0.0",
                "application/vnd.aai.asyncapi+json;version=2.0.0",
                "application/vnd.aai.asyncapi+yaml;version=2.0.0",
                "application/vnd.aai.asyncapi;version=2.1.0",
                "application/vnd.aai.asyncapi+json;version=2.1.0",
                "application/vnd.aai.asyncapi+yaml;version=2.1.0",
                "application/vnd.aai.asyncapi;version=2.2.0",
                "application/vnd.aai.asyncapi+json;version=2.2.0",
                "application/vnd.aai.asyncapi+yaml;version=2.2.0",
                "application/vnd.aai.asyncapi;version=2.3.0",
                "application/vnd.aai.asyncapi+json;version=2.3.0",
                "application/vnd.aai.asyncapi+yaml;version=2.3.0",
                "application/vnd.aai.asyncapi;version=2.4.0",
                "application/vnd.aai.asyncapi+json;version=2.4.0",
                "application/vnd.aai.asyncapi+yaml;version=2.4.0",
                "application/vnd.aai.asyncapi;version=2.5.0",
                "application/vnd.aai.asyncapi+json;version=2.5.0",
                "application/vnd.aai.asyncapi+yaml;version=2.5.0",
                "application/vnd.aai.asyncapi;version=2.6.0",
                "application/vnd.aai.asyncapi+json;version=2.6.0",
                "application/vnd.aai.asyncapi+yaml;version=2.6.0",
                "application/vnd.aai.asyncapi;version=3.0.0",
                "application/vnd.aai.asyncapi+json;version=3.0.0",
                "application/vnd.aai.asyncapi+yaml;version=3.0.0"
        }),
        @JsonSubTypes.Type(value = AvroFormatSchema.class, names = {
                "application/vnd.apache.avro;version=1.9.0",
                "application/vnd.apache.avro+json;version=1.9.0",
                "application/vnd.apache.avro+yaml;version=1.9.0",
                "application/vnd.apache.avro;version=1.9.1",
                "application/vnd.apache.avro+json;version=1.9.1",
                "application/vnd.apache.avro+yaml;version=1.9.1",
                "application/vnd.apache.avro;version=1.9.2",
                "application/vnd.apache.avro+json;version=1.9.2",
                "application/vnd.apache.avro+yaml;version=1.9.2",
                "application/vnd.apache.avro;version=1.10.0",
                "application/vnd.apache.avro+json;version=1.10.0",
                "application/vnd.apache.avro+yaml;version=1.10.0",
                "application/vnd.apache.avro;version=1.10.1",
                "application/vnd.apache.avro+json;version=1.10.1",
                "application/vnd.apache.avro+yaml;version=1.10.1",
                "application/vnd.apache.avro;version=1.10.2",
                "application/vnd.apache.avro+json;version=1.10.2",
                "application/vnd.apache.avro+yaml;version=1.10.2",
                "application/vnd.apache.avro;version=1.11.0",
                "application/vnd.apache.avro+json;version=1.11.0",
                "application/vnd.apache.avro+yaml;version=1.11.0",
                "application/vnd.apache.avro;version=1.11.1",
                "application/vnd.apache.avro+json;version=1.11.1",
                "application/vnd.apache.avro+yaml;version=1.11.1"
        })
})
@EqualsAndHashCode(callSuper = true)
public class MultiFormatSchema<Schema> extends ExtendableObject {

    public MultiFormatSchema(@NotNull Schema schema) {
        this.schemaFormat = "application/vnd.aai.asyncapi+json;version=3.0.0";
        this.schema = schema;
    }

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public MultiFormatSchema(
            @JsonProperty("schemaFormat") @NotNull String schemaFormat,
            @JsonProperty("schema") @NotNull Schema schema
    ) {
        this.schemaFormat = schemaFormat;
        this.schema = schema;
    }

    /**
     * <b>Required</b>.
     * <p>
     * A string containing the name of the schema format that is used to define the information.
     * <p>
     * If schemaFormat is missing, it MUST default to application/vnd.aai.asyncapi+json;version={{asyncapi}}
     * where {{asyncapi}} matches the {@link com.asyncapi.v3._0_0.model.AsyncAPI#getAsyncapi()} version string.
     * <p>
     * In such a case, this would make the Multi Format Schema Object equivalent to the {@link AsyncAPISchema}.
     * <p>
     * When using {@link Reference} within the {@link #getSchema()}, the schemaFormat of the resource being referenced MUST match
     * the schemaFormat of the {@link #getSchema()} that contains the initial reference.
     * <p>
     * For example, if you reference Avro schema, then schemaFormat of referencing resource and the resource being reference MUST match.
     * <p>
     * <p>
     * Check out the supported schema formats table for more information.
     * Custom values are allowed but their implementation is OPTIONAL.
     * A custom value MUST NOT refer to one of the schema formats listed in the table.
     * <p>
     * <p>
     * When using {@link Reference} within the {@link #getSchema()}, the schemaFormat of the referenced resource MUST
     * match the schemaFormat of the schema containing the reference.
     *
     * @see <a href="https://www.asyncapi.com/docs/reference/specification/v3.0.0#multiFormatSchemaFormatTable">Schema formats table</a>
     */
    @NotNull
    @JsonProperty("schemaFormat")
    private String schemaFormat;

    public void setSchemaFormat(@NotNull String schemaFormat) {
        this.schemaFormat = schemaFormat;
    }

    @NotNull
    public String getSchemaFormat() {
        return schemaFormat;
    }

    /**
     * <b>Required</b>.
     * <p>
     * Definition of the message payload.
     * <p>
     * It can be of any type but defaults to {@link AsyncAPISchema}.
     * <p>
     * It MUST match the schema format defined in {@link #getSchemaFormat()}, including the encoding type. E.g., Avro should be
     * inlined as either a YAML or JSON object instead of as a string to be parsed as YAML or JSON. Non-JSON-based
     * schemas (e.g., Protobuf or XSD) MUST be inlined as a string.
     */
    @NotNull
    @JsonProperty("schema")
    private Schema schema;

    public void setSchema(@NotNull Schema schema) {
        this.schema = schema;
    }

    @NotNull
    public Schema getSchema() {
        return schema;
    }

}
