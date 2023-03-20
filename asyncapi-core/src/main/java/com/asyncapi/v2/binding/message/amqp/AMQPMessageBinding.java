package com.asyncapi.v2.binding.message.amqp;

import com.asyncapi.v2.binding.message.MessageBinding;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;

/**
 * Describes AMQP 0-9-1 message binding.
 * <p>
 * Contains information about the message representation in AMQP.
 *
 * @version 0.2.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/amqp#message-binding-object">AMQP message binding</a>
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonClassDescription("Describes AMQP 0-9-1 message binding.")
public class AMQPMessageBinding extends MessageBinding {

    /**
     * A MIME encoding for the message content.
     */
    @Nullable
    @JsonProperty("contentEncoding")
    @JsonPropertyDescription("A MIME encoding for the message content.")
    private String contentEncoding;

    /**
     * Application-specific message type.
     */
    @Nullable
    @JsonProperty("messageType")
    @JsonPropertyDescription("Application-specific message type.")
    private String messageType;

    /**
     * The version of this binding. If omitted, "latest" MUST be assumed.
     */
    @Nullable
    @Builder.Default
    @JsonProperty(value = "bindingVersion")
    @JsonPropertyDescription("The version of this binding.")
    private String bindingVersion = "0.2.0";

}
