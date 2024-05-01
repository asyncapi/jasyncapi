package com.asyncapi.v3._0_0.model.server;

import com.asyncapi.schemas.ExtendableObject;
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
    private List<String> enumValues;

    /**
     * The default value to use for substitution, and to send, if an alternate value is not supplied.
     */
    @Nullable
    @JsonProperty("default")
    private String defaultValue;

    /**
     * An optional description for the server variable. <a href="https://spec.commonmark.org/">CommonMark syntax</a> MAY be used for rich text representation.
     */
    @Nullable
    private String description;

    /**
     * An array of examples of the server variable.
     */
    @Nullable
    private List<String> examples;

}
