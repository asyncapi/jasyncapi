package com.asyncapi.v2._0_0.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Nonnull;

/**
 * A simple object to allow referencing other components in the specification, internally and externally.
 *
 * The Reference Object is defined by JSON Reference and follows the same structure, behavior and rules.
 * A JSON Reference SHALL only be used to refer to a schema that is formatted in either JSON or YAML.
 * In the case of a YAML-formatted Schema, the JSON Reference SHALL be applied to the JSON representation of
 * that schema. The JSON representation SHALL be made by applying the conversion described here.
 *
 * For this specification, reference resolution is done as defined by the JSON Reference specification and not by
 * the JSON Schema specification.
 *
 * @version 2.0.0
 * @see <a href="https://www.asyncapi.com/docs/specifications/2.0.0/#referenceObject">Reference</a>
 * @author Pavel Bodiachevskii
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reference {

    /**
     * Required.
     *
     * The reference string.
     */
    @Nonnull
    @JsonProperty(value = "$ref")
    private String ref;

}
