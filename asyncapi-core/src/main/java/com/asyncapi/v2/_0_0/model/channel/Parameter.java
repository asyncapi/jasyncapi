package com.asyncapi.v2._0_0.model.channel;

import com.asyncapi.schemas.ExtendableObject;
import com.asyncapi.schemas.AsyncAPISchema;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;

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
@EqualsAndHashCode(callSuper = true)
public class Parameter extends ExtendableObject {

    /**
     * A verbose explanation of the parameter. CommonMark syntax can be used for rich text representation.
     */
    @JsonProperty
    @Nullable
    private String description;

    /**
     * Definition of the parameter.
     */
    @JsonProperty
    @Nullable
    private AsyncAPISchema schema;

    /**
     * A runtime expression that specifies the location of the parameter value.
     * <p>
     * Even when a definition for the target field exists, it MUST NOT be used to validate this parameter but,
     * instead, the schema property MUST be used.
     */
    @JsonProperty
    @Nullable
    private String location;

}
