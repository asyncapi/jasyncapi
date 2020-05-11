package com.asyncapi.v2.model.channel;

import lombok.*;

import javax.annotation.Nonnull;
import java.util.Map;

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
    @Nonnull
    @NonNull
    private String description;

    /**
     * Definition of the parameter.
     *
     * TODO: clarify SchemaObject
     */
    @Nonnull
    @NonNull
    private Map<String, Object> schema;

    /**
     * A runtime expression that specifies the location of the parameter value.
     *
     * Even when a definition for the target field exists, it MUST NOT be used to validate this parameter but,
     * instead, the schema property MUST be used.
     */
    @Nonnull
    @NonNull
    private String location;

}
