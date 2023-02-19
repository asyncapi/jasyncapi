package com.asyncapi.v2._0_0.model.channel.message;

import com.asyncapi.v2._0_0.jackson.model.channel.message.MessageCorrelationIdDeserializer;
import com.asyncapi.v2._0_0.jackson.model.channel.message.MessageHeadersDeserializer;
import com.asyncapi.v2._0_0.jackson.model.channel.message.MessagePayloadDeserializer;
import com.asyncapi.v2._0_0.jackson.model.channel.message.MessageTraitsDeserializer;
import com.asyncapi.v2._0_0.model.Reference;
import com.asyncapi.v2._0_0.model.schema.Schema;
import com.asyncapi.v2._0_0.model.ExternalDocumentation;
import com.asyncapi.v2._0_0.model.Tag;
import com.asyncapi.v2.jackson.binding.message.MessageBindingsDeserializer;
import com.asyncapi.v2.binding.message.MessageBinding;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.CheckForNull;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * Describes a message received on a given channel and operation.
 *
 * @version 2.0.0
 * @see <a href="https://www.asyncapi.com/docs/specifications/2.0.0/#messageObject">Message</a>
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    /**
     * Schema definition of the application headers. Schema MUST be of type "object".
     * It MUST NOT define the protocol headers.
     *
     * MUST BE:
     * <ul>
     *     <li>{@link Schema}</li>
     *     <li>{@link Reference}</li>
     * </ul>
     */
    @CheckForNull
    @JsonDeserialize(using = MessageHeadersDeserializer.class)
    private Object headers;

    /**
     * Definition of the message payload. It can be of any type but defaults to Schema object.
     *
     * WILL BE:
     * <ul>
     *     <li>{@link Schema}</li>
     *     <li>{@link com.fasterxml.jackson.databind.JsonNode}</li>
     * </ul>
     */
    @CheckForNull
    @JsonDeserialize(using = MessagePayloadDeserializer.class)
    private Object payload;

    /**
     * Definition of the correlation ID used for message tracing or matching.
     *
     * MUST BE:
     * <ul>
     *     {@link CorrelationId}
     *     {@link Reference}
     * </ul>
     */
    @CheckForNull
    @JsonDeserialize(using = MessageCorrelationIdDeserializer.class)
    private Object correlationId;

    /**
     * TODO: clarify
     * A string containing the name of the schema format used to define the message payload. If omitted,
     * implementations should parse the payload as a Schema object. Check out the supported schema formats
     * table for more information. Custom values are allowed but their implementation is OPTIONAL.
     *
     * A custom value MUST NOT refer to one of the schema formats listed in the table.
     */
    @CheckForNull
    @JsonProperty
    private String schemaFormat;

    /**
     * The content type to use when encoding/decoding a message's payload. The value MUST be a specific
     * media type (e.g. application/json). When omitted, the value MUST be the one specified on the
     * defaultContentType field.
     */
    @CheckForNull
    @JsonProperty
    private String contentType;

    /**
     * A machine-friendly name for the message.
     */
    @CheckForNull
    @JsonProperty
    private String name;

    /**
     * A human-friendly title for the message.
     */
    @CheckForNull
    @JsonProperty
    private String title;

    /**
     * A short summary of what the message is about.
     */
    @CheckForNull
    @JsonProperty
    private String summary;

    /**
     * A verbose explanation of the message. CommonMark syntax can be used for rich text representation.
     */
    @CheckForNull
    @JsonProperty
    private String description;

    /**
     * A list of tags for API documentation control. Tags can be used for logical grouping of messages.
     */
    @CheckForNull
    @JsonProperty
    private List<Tag> tags;

    /**
     * Additional external documentation for this message.
     */
    @CheckForNull
    @JsonProperty
    private ExternalDocumentation externalDocs;

    /**
     * A map where the keys describe the name of the protocol and the values describe protocol-specific definitions
     * for the message.
     */
    @CheckForNull
    @JsonDeserialize(using = MessageBindingsDeserializer.class)
    private Map<String, ? extends MessageBinding> bindings;

    /**
     * An array of key/value pairs where keys MUST be either <b></b>headers</b> and/or <b>payload</b>.
     * <br>
     * Values MUST contain examples
     * that validate against the {@link #headers} or {@link #payload} fields, respectively.
     */
    @CheckForNull
    @JsonProperty
    private List<Map<String, Object>> examples;

    /**
     * A list of traits to apply to the message object. Traits MUST be merged into the message object using the JSON
     * Merge Patch algorithm in the same order they are defined here. The resulting object MUST be a valid Message
     *
     * MUST BE:
     * <ul>
     *     <li>{@link Reference}</li>
     *     <li>{@link MessageTrait}</li>
     * </ul>
     */
    @CheckForNull
    @JsonDeserialize(using = MessageTraitsDeserializer.class)
    private List<Object> traits;

    @JsonAnyGetter
    @JsonAnySetter
    @Builder.Default
    protected Map<String, String> extensionFields = new HashMap<String, String>();

}
