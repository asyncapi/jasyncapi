package com.asyncapi.bindings.ibmmq.v0._1_0.message;

import com.asyncapi.bindings.MessageBinding;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.*;
import org.jetbrains.annotations.Nullable;

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
@JsonClassDescription("Describes IBM MQ message binding.")
public class IBMMQMessageBinding extends com.asyncapi.bindings.ibmmq.IBMMQMessageBinding {

    /**
     * The type of the message.
     * <p>
     * MUST be either string, jms or binary
     */
    @Nullable
    @Builder.Default
    @JsonProperty(value = "type", defaultValue = "string")
    @JsonPropertyDescription("The type of the message.")
    private IBMMQMessageType type = IBMMQMessageType.STRING;

    /**
     * Defines the IBM MQ message headers to include with this message. More than one header can be specified as a comma
     * separated list. Supporting information on IBM MQ message formats can be found on this <a href="https://www.ibm.com/support/knowledgecenter/SSFKSJ_latest/com.ibm.mq.ref.dev.doc/q097520_.html">page</a> in the IBM MQ Knowledge Center.
     * <p>
     * OPTIONAL if type = binary
     * <p>
     * headers MUST NOT be specified if type = string or jms
     */
    @Nullable
    @JsonProperty("headers")
    @JsonPropertyDescription("Defines the IBM MQ message headers to include with this message. More than one header can be specified as a comma separated list.")
    private String headers;

    /**
     * Provides additional information for application developers: describes the message type or format.
     * <p>
     * The description field of the IBM MQ message binding object MAY include CommonMark markdown formatting.
     * A minimum markdown syntax as described by <a href="https://spec.commonmark.org/0.27/">CommonMark 0.27</a> is assumed.
     */
    @Nullable
    @JsonProperty("description")
    @JsonPropertyDescription("Provides additional information for application developers: describes the message type or format.")
    private String description;

    /**
     * The recommended setting the client should use for the TTL (Time-To-Live) of the message.
     * This is a period of time expressed in milliseconds and set by the application that puts the message.
     * expiry values are API dependant e.g., MQI and JMS use different units of time and default values for unlimited.
     * General information on IBM MQ message expiry can be found on this <a href="https://www.ibm.com/support/knowledgecenter/en/SSFKSJ_latest/com.ibm.mq.ref.dev.doc/q097490_.html">page</a> in the IBM MQ Knowledge Center.
     * <p>
     * expiry value MUST be either zero (unlimited) or greater than zero.
     */
    @Nullable
    @Builder.Default
    @javax.validation.constraints.Min(
            value = 0,
            message = "Expiry must be greater or equals to 0"
    )
    @JsonProperty(value = "expiry", defaultValue = "0")
    @JsonPropertyDescription("The recommended setting the client should use for the TTL (Time-To-Live) of the message. This is a period of time expressed in milliseconds and set by the application that puts the message. 'expiry' values are API dependant e.g., MQI and JMS use different units of time and default values for 'unlimited'. General information on IBM MQ message expiry can be found on this [page](https://www.ibm.com/docs/en/ibm-mq/9.2?topic=mqmd-expiry-mqlong) in the IBM MQ Knowledge Center.")
    private Integer expiry = 0;

    @Override
    public String getBindingVersion() {
        return "0.1.0";
    }

    @Override
    public void setBindingVersion(@Nullable String bindingVersion) {
        super.setBindingVersion("0.1.0");
    }

}
