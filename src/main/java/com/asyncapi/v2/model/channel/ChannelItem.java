package com.asyncapi.v2.model.channel;

import com.asyncapi.v2.model.channel.operation.Operation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.CheckForNull;
import java.util.Map;

/**
 * Describes the operations available on a single channel.
 *
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChannelItem {

    /**
     * Allows for an external definition of this channel item.
     * The referenced structure MUST be in the format of a Channel Item Object.
     * If there are conflicts between the referenced definition and this Channel Item's definition, the behavior is undefined.
     */
    @CheckForNull
    private String $ref;

    /**
     * An optional description of this channel item. CommonMark syntax can be used for rich text representation.
     */
    @CheckForNull
    private String description;

    /**
     * A definition of the SUBSCRIBE operation.
     */
    @CheckForNull
    private Operation subscribe;

    /**
     * A definition of the PUBLISH operation.
     */
    @CheckForNull
    private Operation publish;

    /**
     * A map of the parameters included in the channel name.
     * It SHOULD be present only when using channels with expressions (as defined by RFC 6570 section 2.2).
     *
     * This map MUST contain all the parameters used in the parent channel name.
     *
     * TODO: Parameter Object | Reference Object
     */
    @CheckForNull
    private Map<String, Parameter> parameters;

    /**
     * A map where the keys describe the name of the protocol and the values describe protocol-specific definitions for the channel.
     *
     * TODO: https://www.asyncapi.com/docs/specifications/2.0.0/#channelBindingsObject
     */
    @CheckForNull
    private Map<String, Map<String, Object>> bindings;

}
