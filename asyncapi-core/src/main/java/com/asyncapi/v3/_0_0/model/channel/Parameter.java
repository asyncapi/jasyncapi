package com.asyncapi.v3._0_0.model.channel;

import com.asyncapi.lsp.TextDocumentCompletion;
import com.asyncapi.schemas.asyncapi.ExtendableObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Describes a parameter included in a channel address.
 *
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v3.0.0#parameterObject">Parameter</a>
 * @author Pavel Bodiachevskii
 * @version 3.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Parameter extends ExtendableObject {

    /**
     * An optional description for the parameter. <a href="https://spec.commonmark.org/">CommonMark syntax</a> MAY be used for rich text representation.
     */
    @Nullable
    @TextDocumentCompletion(
            detail = "String",
            documentation = "Description of the parameter\n\n" +
                    "An optional description for the parameter. CommonMark syntax MAY be used for rich text representation."
    )
    private String description;

    /**
     * The default value to use for substitution, and to send, if an alternate value is not supplied.
     */
    @Nullable
    @JsonProperty("default")
    @TextDocumentCompletion(
            detail = "String",
            documentation = "Default value for the parameter\n\n" +
                    "The default value to use for substitution, and to send, if an alternate value is not supplied."
    )
    private String defaultValue;

    /**
     * An enumeration of string values to be used if the substitution options are from a limited set.
     */
    @Nullable
    @JsonProperty("enum")
    @TextDocumentCompletion(
            detail = "List<String>",
            documentation = "Enumeration of string values for the parameter\n\n" +
                    "An enumeration of string values to be used if the substitution options are from a limited set."
    )
    private List<String> enumValues;

    /**
     * An array of examples of the parameter value.
     */
    @Nullable
    @TextDocumentCompletion(
            detail = "List<String>",
            documentation = "Examples of the parameter value\n\n" +
                    "An array of examples of the parameter value."
    )
    private List<String> examples;

    /**
     * A runtime expression that specifies the location of the parameter value.
     *
     * @see <a href="https://www.asyncapi.com/docs/reference/specification/v3.0.0#runtimeExpression">Runtime Expression</a>
     */
    @Nullable
    @TextDocumentCompletion(
            detail = "String",
            documentation = "Location of the parameter value\n\n" +
                    "A runtime expression that specifies the location of the parameter value."
    )
    private String location;

}
