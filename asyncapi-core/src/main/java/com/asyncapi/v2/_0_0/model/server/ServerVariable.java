package com.asyncapi.v2._0_0.model.server;

import com.asyncapi.v2.ExtendableObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * An object representing a Server Variable for server URL template substitution.
 *
 * @version 2.0.0
 * @see <a href="https://www.asyncapi.com/docs/specifications/2.0.0/#serverVariableObject">ServerVariable</a>
 * @author Pavel Bodiachevskii
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
     * An optional description for the server variable. CommonMark syntax MAY be used for rich text representation.
     */
    @Nullable
    private String description;

    /**
     * An array of examples of the server variable.
     */
    @Nullable
    private List<String> example;

}
