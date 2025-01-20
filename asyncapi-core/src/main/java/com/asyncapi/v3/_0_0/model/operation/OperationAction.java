package com.asyncapi.v3._0_0.model.operation;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Describes a specific operation action.
 *
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v3.0.0#operationObject">Operation</a>
 * @author Pavel Bodiachevskii
 * @version 3.0.0
 */
public enum OperationAction {

    /**
     * Use send when it's expected that the application will send a message to the given {@link com.asyncapi.v3._0_0.model.channel.Channel}.
     */
    @JsonProperty("send")
    SEND,

    /**
     * Use receive when the application should expect receiving messages from the given {@link com.asyncapi.v3._0_0.model.channel.Channel}.
     */
    @JsonProperty("receive")
    RECEIVE

}
