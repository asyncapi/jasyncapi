package com.asyncapi.v3;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

/**
 * A simple object to allow referencing other components in the specification, internally and externally.
 * <p>
 * The Reference Object is defined by <a href="https://tools.ietf.org/html/draft-pbryan-zyp-json-ref-03">JSON Reference</a> and follows the same structure, behavior and rules.
 * A JSON Reference SHALL only be used to refer to a schema that is formatted in either JSON or YAML.
 * In the case of a YAML-formatted Schema, the JSON Reference SHALL be applied to the JSON representation of
 * that schema. The JSON representation SHALL be made by applying the conversion described <a href="https://www.asyncapi.com/docs/reference/specification/v2.6.0#format">here</a>.
 * <p>
 * For this specification, reference resolution is done as defined by the JSON Reference specification and not by
 * the JSON Schema specification.
 * <p>
 * This object cannot be extended with additional properties and any properties added SHALL be ignored.
 *
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v3.0.0#referenceObject">Reference</a>
 * @author Pavel Bodiachevskii
 * @version 3.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reference {

    /**
     * <b>Required</b>.
     * <p>
     * The reference string.
     */
    @NotNull
    @JsonProperty(value = "$ref")
    private String ref = "";

}
