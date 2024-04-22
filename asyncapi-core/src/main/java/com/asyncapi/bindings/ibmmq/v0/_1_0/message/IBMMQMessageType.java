package com.asyncapi.bindings.ibmmq.v0._1_0.message;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Describes IBM MQ message type.
 * <p>
 * This object contains information about the message type in IBM MQ.
 *
 * @version 0.1.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/ibmmq#message-binding-object">IBM MQ message binding</a>
 * @author Pavel Bodiachevskii
 */
public enum IBMMQMessageType {

    @JsonProperty("string")
    STRING,

    @JsonProperty("jms")
    JMS,

    @JsonProperty("binary")
    BINARY

}
