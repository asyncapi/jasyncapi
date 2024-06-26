package com.asyncapi.bindings.amqp.v0._1_0.message;

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
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/amqp#message-binding-object">AMQP message binding</a>
 * @see <a href="https://www.amqp.org">AMQP</a>
 * @author Pavel Bodiachevskii
 * @version 0.1.0
 * @since 1.0.0-RC2
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonClassDescription("Describes AMQP 0-9-1 message binding.")
public class AMQPMessageBinding extends com.asyncapi.bindings.amqp.AMQPMessageBinding {

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

    @Override
    public String getBindingVersion() {
        return "0.1.0";
    }

    @Override
    public void setBindingVersion(@Nullable String bindingVersion) {
        super.setBindingVersion("0.1.0");
    }

}
