package com.asyncapi.v2.model.channel.message;

import lombok.*;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

/**
 * An object that specifies an identifier at design time that can used for message tracing and correlation.
 *
 * For specifying and computing the location of a Correlation ID, a runtime expression is used.
 *
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CorrelationId {

    /**
     * An optional description of the identifier. CommonMark syntax can be used for rich text representation.
     */
    @CheckForNull
    private String description;

    /**
     * REQUIRED.
     *
     * A runtime expression that specifies the location of the correlation ID.
     */
    @Nonnull
    @NonNull
    private String location;

}
