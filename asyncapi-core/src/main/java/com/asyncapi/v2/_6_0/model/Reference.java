package com.asyncapi.v2._6_0.model;

import com.asyncapi.v2.ChannelBindingValue;
import com.asyncapi.v2.CorrelationIdValue;
import com.asyncapi.v2.MessageBindingValue;
import com.asyncapi.v2.MessageTraitValue;
import com.asyncapi.v2.MessageValue;
import com.asyncapi.v2.OperationBindingValue;
import com.asyncapi.v2.OperationTraitValue;
import com.asyncapi.v2.ParameterValue;
import com.asyncapi.v2.SchemaValue;
import com.asyncapi.v2.SecuritySchemeValue;
import com.asyncapi.v2.ServerBindingValue;
import com.asyncapi.v2.ServerValue;
import com.asyncapi.v2.ServerVariableValue;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
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
 *
 * @version 2.6.0
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v2.6.0#referenceObject">Reference</a>
 * @author Pavel Bodiachevskii
 */
@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Reference implements ChannelBindingValue, CorrelationIdValue, MessageValue, MessageBindingValue, MessageTraitValue, OperationBindingValue, OperationTraitValue, ParameterValue, SchemaValue, SecuritySchemeValue, ServerValue, ServerBindingValue, ServerVariableValue {

    /**
     * Required.
     * <p>
     * The reference string.
     */
    @NotNull
    @JsonProperty(value = "$ref")
    private String ref;

}
