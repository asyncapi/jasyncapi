package com.asyncapi.v2._6_0.model.channel;

import com.asyncapi.v2._6_0.jackson.model.schema.SchemaDeserializer;
import com.asyncapi.v2._6_0.model.schema.Schema;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.CheckForNull;

/**
 * Describes a parameter included in a channel name.
 *
 * @version 2.6.0
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v2.6.0#parameterObject">Parameter</a>
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Parameter {

    /**
     * A verbose explanation of the parameter. <a href="https://spec.commonmark.org/">CommonMark syntax</a> can be used for rich text representation.
     */
    @CheckForNull
    private String description;

    /**
     * Definition of the parameter.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link com.asyncapi.v2._6_0.model.Reference}</li>
     *     <li>{@link com.asyncapi.v2._6_0.model.schema.Schema}</li>
     * </ul>
     */
    @CheckForNull
    @JsonDeserialize(using = SchemaDeserializer.class)
    private Object schema;

    /**
     * A <a href="https://www.asyncapi.com/docs/reference/specification/v2.6.0#runtimeExpression">runtime expression</a> that specifies the location of the parameter value.
     * <p>
     * Even when a definition for the target field exists, it MUST NOT be used to validate this parameter but, instead,
     * the schema property MUST be used.
     */
    @CheckForNull
    private String location;

}
