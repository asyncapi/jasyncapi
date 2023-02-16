package com.asyncapi.v2._0_0.model.channel;

import com.asyncapi.v2.jackson.binding.channel.ChannelBindingsDeserializer;
import com.asyncapi.v2.binding.channel.ChannelBinding;
import com.asyncapi.v2._0_0.jackson.ChannelParametersDeserializer;
import com.asyncapi.v2._0_0.model.Reference;
import com.asyncapi.v2._0_0.model.channel.operation.Operation;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.CheckForNull;
import java.util.HashMap;
import java.util.Map;

/**
 * Describes the operations available on a single channel.
 *
 * @version 2.0.0
 * @see <a href="https://www.asyncapi.com/docs/specifications/2.0.0/#channelItemObject">ChannelItem</a>
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
    @JsonProperty
    @CheckForNull
    private String $ref;

    /**
     * An optional description of this channel item. CommonMark syntax can be used for rich text representation.
     */
    @JsonProperty
    @CheckForNull
    private String description;

    /**
     * A definition of the SUBSCRIBE operation.
     */
    @JsonProperty
    @CheckForNull
    private Operation subscribe;

    /**
     * A definition of the PUBLISH operation.
     */
    @JsonProperty
    @CheckForNull
    private Operation publish;

    /**
     * A map of the parameters included in the channel name.
     * It SHOULD be present only when using channels with expressions (as defined by RFC 6570 section 2.2).
     *
     * This map MUST contain all the parameters used in the parent channel name.
     *
     * MUST BE:
     * <ul>
     *     <li>{@link Reference}</li>
     *     <li>{@link Parameter}</li>
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

    /**
     * Extension fields in the form x-extension-field-name for the exposed API.
     */
    @JsonAnySetter
    @JsonAnyGetter
    @CheckForNull
    @Builder.Default
    protected Map<String, String> extensionFields = new HashMap<String, String>();
}
