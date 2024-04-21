package com.asyncapi.v3._0_0.model.channel;

import com.asyncapi.ExtendableObject;
import com.asyncapi.v3.Reference;
import com.asyncapi.v3._0_0.jackson.model.ExternalDocumentationDeserializer;
import com.asyncapi.v3._0_0.jackson.model.TagsDeserializer;
import com.asyncapi.v3._0_0.jackson.model.channel.message.MessagesDeserializer;
import com.asyncapi.v3._0_0.jackson.model.channel.ChannelParametersDeserializer;
import com.asyncapi.v3._0_0.model.ExternalDocumentation;
import com.asyncapi.v3._0_0.model.Tag;
import com.asyncapi.v3._0_0.model.channel.message.Message;
import com.asyncapi.bindings.ChannelBinding;
import com.asyncapi.v3.jackson.binding.channel.ChannelBindingsDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;

/**
 * Describes a shared communication channel.
 *
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v3.0.0#channelObject">Channel</a>
 * @author Pavel Bodiachevskii
 * @version 3.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Channel extends ExtendableObject {

    /**
     * An optional string representation of this channel's address. The address is typically the "topic name",
     * "routing key", "event type", or "path".
     * <p>
     * When null or absent, it MUST be interpreted as unknown.
     * This is useful when the address is generated dynamically at runtime or can't be known upfront.
     * <p>
     * It MAY contain Channel Address Expressions like {@code {userId}}
     * <p>
     * Query parameters and fragments SHALL NOT be used, instead use {@link ChannelBinding} to define them.
     *
     * @see <a href="https://www.asyncapi.com/docs/reference/specification/v3.0.0#channelBindingsObject">Channel bindings</a>
     * @see <a href="https://www.asyncapi.com/docs/reference/specification/v3.0.0#channelAddressExpressions">Channel Address Expressions</a>
     */
    @Nullable
    private String address;

    /**
     * A human-friendly title for the channel.
     */
    @Nullable
    private String title;

    /**
     * A short summary of the channel.
     */
    @Nullable
    private String summary;

    /**
     * An optional description of this channel. <a href="https://spec.commonmark.org/">CommonMark syntax</a> can be used for rich text representation.
     */
    @Nullable
    private String description;

    /**
     * An array of $ref pointers to the definition of the servers in which this channel is available.
     * <p>
     * If the channel is located in the {@link com.asyncapi.v3._0_0.model.AsyncAPI#getChannels()},
     * it MUST point to a subset of server definitions located in the {@link com.asyncapi.v3._0_0.model.AsyncAPI#getServers()},
     * and MUST NOT point to a subset of server definitions located in the {@link com.asyncapi.v3._0_0.model.AsyncAPI#getComponents()} or anywhere else.
     * <p>
     * If the channel is located in the {@link com.asyncapi.v3._0_0.model.AsyncAPI#getComponents()}, it MAY point to a Server Objects in any location.
     * <p>
     * If servers is absent or empty, this channel MUST be available on all the servers defined in {@link com.asyncapi.v3._0_0.model.AsyncAPI#getServers()}.
     * <p>
     * However, it is RECOMMENDED that parsers (or other software) dereference this property
     * for a better development experience.
     */
    @Nullable
    private List<Reference> servers;

    /**
     * A map of the parameters included in the channel address.
     * <p>
     * It MUST be present only when the address contains Channel Address Expressions like {@code {userId}}.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link Parameter}</li>
     *     <li>{@link Reference}</li>
     * </ul>
     *
     * @see <a href="https://www.asyncapi.com/docs/reference/specification/v3.0.0#channelAddressExpressions">Channel Address Expressions</a>
     */
    @Nullable
    @JsonDeserialize(using = ChannelParametersDeserializer.class)
    private Map<String, Object> parameters;

    /**
     * A map of the messages that will be sent to this channel by any application at any time.
     * <p>
     * Every message sent to this channel MUST be valid against one, and only one, of the {@link Message} defined in this map.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link Message}</li>
     *     <li>{@link Reference}</li>
     * </ul>
     */
    @Nullable
    @JsonDeserialize(using = MessagesDeserializer.class)
    private Map<String, Object> messages;

    /**
     * A map where the keys describe the name of the protocol and the values describe protocol-specific definitions for the channel.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link ChannelBinding}</li>
     *     <li>{@link Reference}</li>
     * </ul>
     */
    @Nullable
    @JsonDeserialize(using = ChannelBindingsDeserializer.class)
    private Map<String, Object> bindings;

    /**
     * A list of tags for logical grouping of channels.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link Tag}</li>
     *     <li>{@link Reference}</li>
     * </ul>
     */
    @Nullable
    @JsonDeserialize(using = TagsDeserializer.class)
    private List<Object> tags;

    /**
     * Additional external documentation for this channel.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link ExternalDocumentation}</li>
     *     <li>{@link Reference}</li>
     * </ul>
     */
    @Nullable
    @JsonDeserialize(using = ExternalDocumentationDeserializer.class)
    private Object externalDocs;

}
