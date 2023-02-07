package com.asyncapi.v2._6_0.model.server;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.CheckForNull;
import java.util.List;

/**
 * An object representing a Server Variable for server URL template substitution.
 *
 * @version 2.6.0
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v2.6.0#serverVariableObject">ServerVariable</a>
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServerVariable {

    /**
     * An enumeration of string values to be used if the substitution options are from a limited set.
     */
    @CheckForNull
    @JsonProperty(value = "enum")
    private List<String> enumValues;

    /**
     * The default value to use for substitution, and to send, if an alternate value is not supplied.
     */
    @CheckForNull
    @JsonProperty("default")
    private String defaultValue;

    /**
     * An optional description for the server variable. <a href="https://spec.commonmark.org/">CommonMark syntax</a> MAY be used for rich text representation.
     */
    @CheckForNull
    private String description;

    /**
     * An array of examples of the server variable.
     */
    @CheckForNull
    private List<String> examples;

}
