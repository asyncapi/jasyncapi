package com.asyncapi.v2.binding.message.amqp;

import com.asyncapi.v2.binding.message.MessageBinding;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.annotation.CheckForNull;

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
public class AMQPMessageBinding extends MessageBinding {

    /**
     * A MIME encoding for the message content.
     */
    @CheckForNull
    private String contentEncoding;

    /**
     * Application-specific message type.
     */
    @CheckForNull
    private String messageType;

    /**
     * The version of this binding. If omitted, "latest" MUST be assumed.
     */
    @CheckForNull
    @Builder.Default
    private String bindingVersion = "0.2.0";

}
