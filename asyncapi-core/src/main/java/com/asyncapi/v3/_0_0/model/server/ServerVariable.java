package com.asyncapi.v3._0_0.model.server;

import com.asyncapi.lsp.TextDocumentCompletion;
import com.asyncapi.schemas.asyncapi.ExtendableObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * An object representing a Server Variable for server URL template substitution.
 *
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v3.0.0#serverVariableObject">ServerVariable</a>
 * @author Pavel Bodiachevskii
 * @version 3.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ServerVariable extends ExtendableObject {

    /**
     * An enumeration of string values to be used if the substitution options are from a limited set.
     */
    @Nullable
    @JsonProperty(value = "enum")
    @TextDocumentCompletion(
            detail = "List<String>",
            documentation = "Enumeration of string values for the variable\n\n" +
                    "An enumeration of string values to be used if the substitution options are from a limited set."
    )
    private List<String> enumValues;

    /**
     * The default value to use for substitution, and to send, if an alternate value is not supplied.
     */
    @Nullable
    @JsonProperty("default")
    @TextDocumentCompletion(
            detail = "String",
            documentation = "Default value for the variable\n\n" +
                    "The default value to use for substitution, and to send, if an alternate value is not supplied."
    )
    private String defaultValue;

    /**
     * An optional description for the server variable. <a href="https://spec.commonmark.org/">CommonMark syntax</a> MAY be used for rich text representation.
     */
    @Nullable
    @TextDocumentCompletion(
            detail = "String",
            documentation = "Description of the server variable\n\n" +
                    "An optional description for the server variable. CommonMark syntax MAY be used for rich text representation."
    )
    private String description;

    /**
     * An array of examples of the server variable.
     */
    @Nullable
    @TextDocumentCompletion(
            detail = "List<String>",
            documentation = "Examples of the server variable\n\n" +
                    "An array of examples of the server variable."
    )
    private List<String> examples;

}
