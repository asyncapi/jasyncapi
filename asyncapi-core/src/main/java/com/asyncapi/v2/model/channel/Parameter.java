package com.asyncapi.v2.model.channel;

import com.asyncapi.v2.model.schema.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.CheckForNull;

/**
 * Describes a parameter included in a channel name.
 *
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
    @CheckForNull
    private String description;

    /**
     * Definition of the parameter.
     */
    @CheckForNull
    private Schema schema;

    /**
     * A runtime expression that specifies the location of the parameter value.
     *
     * Even when a definition for the target field exists, it MUST NOT be used to validate this parameter but,
     * instead, the schema property MUST be used.
     */
    @CheckForNull
    private String location;

}
