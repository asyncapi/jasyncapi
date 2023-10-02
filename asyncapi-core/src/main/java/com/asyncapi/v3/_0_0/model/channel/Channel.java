package com.asyncapi.v3._0_0.model.channel;

import com.asyncapi.v3.ExtendableObject;
import com.asyncapi.v3.Reference;
import com.asyncapi.v3._0_0.jackson.model.ExternalDocumentationDeserializer;
import com.asyncapi.v3._0_0.jackson.model.TagsDeserializer;
import com.asyncapi.v3._0_0.jackson.model.channel.message.MessagesDeserializer;
import com.asyncapi.v3._0_0.jackson.model.channel.ChannelParametersDeserializer;
import com.asyncapi.v3._0_0.model.ExternalDocumentation;
import com.asyncapi.v3._0_0.model.Tag;
import com.asyncapi.v3._0_0.model.channel.message.Message;
import com.asyncapi.v3.binding.channel.ChannelBinding;
import com.asyncapi.v3.jackson.binding.channel.ChannelBindingsDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;

/**
 * Describes a shared communication channel.
 *
 * @version 3.0.0
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v2.6.0#channelItemObject">ChannelItem</a>
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Channel extends ExtendableObject {

    /**
     * An optional string representation of this channel's address. The address is typically the "topic name",
     * "routing key", "event type", or "path". When null or absent, it MUST be interpreted as unknown.
     * This is useful when the address is generated dynamically at runtime or can't be known upfront.
     * <p>
     * It MAY contain Channel Address Expressions.
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
     * An optional description of this channel.
     * <p>
     * CommonMark syntax can be used for rich text representation.
     */
    @Nullable
    private String description;

    /**
     * An array of $ref pointers to the definition of the servers in which this channel is available.
     * <p>
     * If servers is absent or empty, this channel MUST be available on all the servers defined in the Servers Object.
     * Please note the servers property value MUST be an array of Reference Objects and, therefore,
     * MUST NOT contain an array of Server Objects.
     * <p>
     * However, it is RECOMMENDED that parsers (or other software) dereference this property
     * for a better development experience.
     */
    @Nullable
    private List<Reference> servers;

    /**
     * A map of the parameters included in the channel address.
     * <p>
     * It MUST be present only when the address contains Channel Address Expressions.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link Reference}</li>
     *     <li>{@link Parameter}</li>
     * </ul>
     */
    @Nullable
    @JsonDeserialize(using = ChannelParametersDeserializer.class)
    private Map<String, Object> parameters;

    /**
     * A map of the messages that will be sent to this channel by any application at any time.
     * Every message sent to this channel MUST be valid against one, and only one, of the message
     * objects defined in this map.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link Reference}</li>
     *     <li>{@link Message}</li>
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
     *     <li>{@link Reference}</li>
     *     <li>{@link ChannelBinding}</li>
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
     *     <li>{@link Reference}</li>
     *     <li>{@link Tag}</li>
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
     *     <li>{@link Reference}</li>
     *     <li>{@link ExternalDocumentation}</li>
     * </ul>
     */
    @Nullable
    @JsonDeserialize(using = ExternalDocumentationDeserializer.class)
    private Object externalDocs;

}
