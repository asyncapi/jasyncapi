package com.asyncapi.v2._6_0.model.channel;

import com.asyncapi.v2._6_0.jackson.binding.channel.ChannelBindingsDeserializer;
import com.asyncapi.v2._6_0.jackson.model.channel.ChannelParametersDeserializer;
import com.asyncapi.v2._6_0.model.channel.operation.Operation;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.CheckForNull;
import java.util.List;
import java.util.Map;

/**
 * Describes the operations available on a single channel.
 *
 * @version 2.6.0
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v2.6.0#channelItemObject">ChannelItem</a>
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChannelItem {

    /**
     * Allows for a referenced definition of this channel item. The referenced structure MUST be in the form of a {@link com.asyncapi.v2._6_0.model.channel.ChannelItem} Object.
     * In case a Channel Item Object field appears both in the defined object and the referenced object, the behavior is undefined.
     * Resolution is done as defined by the <a href="https://tools.ietf.org/html/draft-pbryan-zyp-json-ref-03">JSON Reference</a>.
     * <p>
     * Deprecated: Usage of the $ref property has been deprecated.
     */
    @CheckForNull
    @JsonProperty("$ref")
    private String ref;

    /**
     * An optional description of this channel item. <a href="https://spec.commonmark.org/">CommonMark syntax</a> can be used for rich text representation.
     */
    @CheckForNull
    private String description;

    /**
     * The servers on which this channel is available, specified as an optional unordered list of names (string keys) of {@link com.asyncapi.v2._6_0.model.server.Server} Objects defined in the {@link com.asyncapi.v2._6_0.model.server.Server} Object (a map).
     * If servers is absent or empty then this channel must be available on all servers defined in the Servers Object.
     */
    @CheckForNull
    private List<String> servers;

    /**
     * A definition of the SUBSCRIBE operation, which defines the messages produced by the application and sent to the channel.
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
     * It SHOULD be present only when using channels with expressions (as defined by <a href="https://tools.ietf.org/html/rfc6570#section-2.2">RFC 6570 section 2.2</a>).
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link com.asyncapi.v2._6_0.model.Reference}</li>
     *     <li>{@link com.asyncapi.v2._6_0.model.channel.Parameter}</li>
     * </ul>
     */
    @CheckForNull
    @JsonDeserialize(using = ChannelParametersDeserializer.class)
    private Map<String, Object> parameters;

    /**
     * A map where the keys describe the name of the protocol and the values describe protocol-specific definitions for the channel.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link com.asyncapi.v2._6_0.model.Reference}</li>
     *     <li>{@link com.asyncapi.v2._6_0.binding.channel.ChannelBinding}</li>
     * </ul>
     */
    @CheckForNull
    @JsonDeserialize(using = ChannelBindingsDeserializer.class)
    private Map<String, Object> bindings;

}
