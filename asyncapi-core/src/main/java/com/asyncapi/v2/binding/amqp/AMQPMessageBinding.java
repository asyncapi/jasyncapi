package com.asyncapi.v2.binding.amqp;

import com.asyncapi.v2.binding.MessageBinding;
import lombok.*;

import javax.annotation.CheckForNull;
import javax.annotation.Nullable;

/**
 * This class defines how to describe AMQP 0-9-1 message binding.
 *
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
