package com.asyncapi.bindings.ibmmq.v0._1_0.message;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Describes IBM MQ message type.
 * <p>
 * This object contains information about the message type in IBM MQ.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/ibmmq#message-binding-object">IBM MQ message binding</a>
 * @see <a href="https://www.ibm.com/products/mq">IBM MQ</a>
 * @author Pavel Bodiachevskii
 * @version 0.1.0
 * @since 1.0.0-RC2
 */
public enum IBMMQMessageType {

    @JsonProperty("string")
    STRING,

    @JsonProperty("jms")
    JMS,

    @JsonProperty("binary")
    BINARY

}
