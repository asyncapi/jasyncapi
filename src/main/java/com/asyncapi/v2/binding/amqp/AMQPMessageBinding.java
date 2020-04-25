package com.asyncapi.v2.binding.amqp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.CheckForNull;
import javax.annotation.Nullable;

/**
 * This class MUST NOT contain any properties. Its name is reserved for future use.
 *
 * This class defines how to describe AMQP 0-9-1 message binding.
 *
 * @author Pavel Bodiachevskii
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AMQPMessageBinding {

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
