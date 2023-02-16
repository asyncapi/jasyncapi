package com.asyncapi.v2.binding.message.ibmmq;

import com.asyncapi.v2.binding.message.MessageBinding;
import lombok.*;

import javax.annotation.CheckForNull;

/**
 * Describes IBM MQ message binding.
 * <p>
 * This object contains information about the message representation in IBM MQ.
 *
 * @version 0.1.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/ibmmq#message-binding-object">IBM MQ message binding</a>
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class IBMMQMessageBinding extends MessageBinding {

    /**
     * The type of the message.
     * <p>
     * MUST be either string, jms or binary
     */
    @CheckForNull
    private String type;

    /**
     * Defines the IBM MQ message headers to include with this message. More than one header can be specified as a comma
     * separated list. Supporting information on IBM MQ message formats can be found on this <a href="https://www.ibm.com/support/knowledgecenter/SSFKSJ_latest/com.ibm.mq.ref.dev.doc/q097520_.html">page</a> in the IBM MQ Knowledge Center.
     * <p>
     * OPTIONAL if type = binary
     * <p>
     * headers MUST NOT be specified if type = string or jms
     */
    @CheckForNull
    private String headers;

    /**
     * Provides additional information for application developers: describes the message type or format.
     * <p>
     * The description field of the IBM MQ message binding object MAY include CommonMark markdown formatting.
     * A minimum markdown syntax as described by <a href="https://spec.commonmark.org/0.27/">CommonMark 0.27</a> is assumed.
     */
    @CheckForNull
    private String description;

    /**
     * The recommended setting the client should use for the TTL (Time-To-Live) of the message.
     * This is a period of time expressed in milliseconds and set by the application that puts the message.
     * expiry values are API dependant e.g., MQI and JMS use different units of time and default values for unlimited.
     * General information on IBM MQ message expiry can be found on this <a href="https://www.ibm.com/support/knowledgecenter/en/SSFKSJ_latest/com.ibm.mq.ref.dev.doc/q097490_.html">page</a> in the IBM MQ Knowledge Center.
     * <p>
     * expiry value MUST be either zero (unlimited) or greater than zero.
     */
    @CheckForNull
    private Integer expiry;

    /**
     * The version of this binding.
     */
    @CheckForNull
    @Builder.Default
    private String bindingVersion = "0.1.0";

}
