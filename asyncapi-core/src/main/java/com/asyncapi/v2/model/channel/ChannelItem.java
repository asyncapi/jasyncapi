package com.asyncapi.v2.model.channel;

import com.asyncapi.v2.binding.ChannelBinding;
import com.asyncapi.v2.binding.ChannelBindingsDeserializer;
import com.asyncapi.v2.jackson.ChannelParametersDeserializer;
import com.asyncapi.v2.model.channel.operation.Operation;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
public class ChannelItem<HeadersType, CorrelationIdType> {

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
    private Operation<HeadersType, CorrelationIdType> subscribe;

    /**
     * A definition of the PUBLISH operation.
     */
    @CheckForNull
    private Operation<HeadersType, CorrelationIdType> publish;

    /**
     * A map of the parameters included in the channel name.
     * It SHOULD be present only when using channels with expressions (as defined by RFC 6570 section 2.2).
     *
     * This map MUST contain all the parameters used in the parent channel name.
     *
     * MUST BE:
     * <ul>
     *     <li>{@link com.asyncapi.v2.model.Reference}</li>
     *     <li>{@link com.asyncapi.v2.model.channel.Parameter}</li>
     * </ul>
     */
    @CheckForNull
    @JsonDeserialize(using = ChannelParametersDeserializer.class)
    private Map<String, Object> parameters;

    /**
     * A map where the keys describe the name of the protocol and the values describe protocol-specific definitions for the channel.
     */
    @CheckForNull
    @JsonDeserialize(using = ChannelBindingsDeserializer.class)
    private Map<String, ? extends ChannelBinding> bindings;

}
