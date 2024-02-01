package com.asyncapi.v3.schema;

import com.asyncapi.v3.ExtendableObject;
import lombok.*;
import org.jetbrains.annotations.NotNull;

/**
 * The Multi Format Schema Object represents a schema definition. It differs from the {@link Schema} in that it supports
 * multiple schema formats or languages (e.g., JSON Schema, Avro, etc.).
 *
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v3.0.0#multiFormatSchemaObject">Multi Format Schema</a>
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v3.0.0#schemaObject">Schema</a>
 * @author Pavel Bodiachevskii
 * @version 3.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class MultiFormatSchema extends ExtendableObject {

    /**
     * <b>Required</b>.
     * <p>
     * A string containing the name of the schema format that is used to define the information.
     * <p>
     * If schemaFormat is missing, it MUST default to application/vnd.aai.asyncapi+json;version={{asyncapi}}
     * where {{asyncapi}} matches the {@link com.asyncapi.v3._0_0.model.AsyncAPI#getAsyncapi()} version string.
     * <p>
     * In such a case, this would make the Multi Format Schema Object equivalent to the {@link Schema}.
     * <p>
     * When using {@link com.asyncapi.v3.Reference} within the {@link #getSchema()}, the schemaFormat of the resource being referenced MUST match
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
     * When using {@link com.asyncapi.v3.Reference} within the {@link #getSchema()}, the schemaFormat of the referenced resource MUST
     * match the schemaFormat of the schema containing the reference.
     *
     * @see <a href="https://www.asyncapi.com/docs/reference/specification/v3.0.0#multiFormatSchemaFormatTable">Schema formats table</a>
     */
    @NotNull
    private String schemaFormat;

    /**
     * <b>Required</b>.
     * <p>
     * Definition of the message payload.
     * <p>
     * It can be of any type but defaults to {@link Schema}.
     * <p>
     * It MUST match the schema format defined in {@link #getSchemaFormat()}, including the encoding type. E.g., Avro should be
     * inlined as either a YAML or JSON object instead of as a string to be parsed as YAML or JSON. Non-JSON-based
     * schemas (e.g., Protobuf or XSD) MUST be inlined as a string.
     */
    @NotNull
    private Object schema;

}
