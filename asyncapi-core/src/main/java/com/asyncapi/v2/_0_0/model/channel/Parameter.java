package com.asyncapi.v2._0_0.model.channel;

import com.asyncapi.v2._0_0.model.schema.Schema;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.CheckForNull;

/**
 * Describes a parameter included in a channel name.
 *
 * @version 2.0.0
 * @see <a href="https://www.asyncapi.com/docs/specifications/2.0.0/#parameterObject">Parameter</a>
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Parameter {

    /**
     * A verbose explanation of the parameter. CommonMark syntax can be used for rich text representation.
     */
    @JsonProperty
    @CheckForNull
    private String description;

    /**
     * Definition of the parameter.
     */
    @JsonProperty
    @CheckForNull
    private Schema schema;

    /**
     * A runtime expression that specifies the location of the parameter value.
     *
     * Even when a definition for the target field exists, it MUST NOT be used to validate this parameter but,
     * instead, the schema property MUST be used.
     */
    @JsonProperty
    @CheckForNull
    private String location;

    /**
     * Extension fields in the form x-extension-field-name for the exposed API.
     */
    @JsonAnySetter
    @JsonAnyGetter
    @CheckForNull
    @Builder.Default
    protected Map<String, String> extensionFields = new HashMap<String, String>();
}
