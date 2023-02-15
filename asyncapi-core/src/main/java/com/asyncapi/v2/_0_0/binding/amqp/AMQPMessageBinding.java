package com.asyncapi.v2._0_0.binding.amqp;

import com.asyncapi.v2._0_0.binding.MessageBinding;
import lombok.*;

import javax.annotation.CheckForNull;
import javax.annotation.Nullable;

/**
 * Describes AMQP 0-9-1 message binding.
 *
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
    @Nullable
    @CheckForNull
    private String contentEncoding;

    /**
     * Application-specific message type.
     */
    @Nullable
    @CheckForNull
    private String messageType;

    /**
     * The version of this binding. If omitted, "latest" MUST be assumed.
     */
    @Nullable
    @CheckForNull
    private String bindingVersion;

}
