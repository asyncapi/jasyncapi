package com.asyncapi.bindings.ibmmq.v0._1_0.channel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;

/**
 * Describes IBM MQ channel topic properties.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/ibmmq#channel-binding-object">IBM MQ channel binding</a>
 * @see <a href="https://www.ibm.com/products/mq">IBM MQ</a>
 * @author Pavel Bodiachevskii
 * @version 0.1.0
 * @since 1.0.0-RC2
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class IBMMQChannelTopicProperties {

    /**
     * The value of the IBM MQ topic string to be used.
     * <p>
     * OPTIONAL
     * Note: if specified, SHALL override AsyncAPI channel name.
     * <p>
     * MUST NOT exceed 10240 characters in length. MAY coexist with topic.objectName
     */
    @Nullable
    @javax.validation.constraints.Max(
            value = 10240,
            message = "Maximum length of topic string must be lower or equals to 10240"
    )
    @JsonProperty("string")
    @JsonPropertyDescription("The value of the IBM MQ topic string to be used.")
    private String string;

    /**
     * The name of the IBM MQ topic object.
     * <p>
     * OPTIONAL
     * Note: if specified, SHALL override AsyncAPI channel name.
     * <p>
     * MUST NOT exceed 48 characters in length. MAY coexist with topic.string
     */
    @Nullable
    @javax.validation.constraints.Max(
            value = 48,
            message = "Maximum length of topic name must be lower or equals to 48"
    )
    @JsonProperty("objectName")
    @JsonPropertyDescription("The name of the IBM MQ topic object.")
    private String objectName;

    /**
     * Defines if the subscription may be durable.
     */
    @Nullable
    @Builder.Default
    @JsonProperty(value = "durablePermitted", defaultValue = "true")
    @JsonPropertyDescription("Defines if the subscription may be durable.")
    private Boolean durablePermitted = true;

    /**
     * Defines if the last message published will be made available to new subscriptions.
     */
    @Nullable
    @Builder.Default
    @JsonProperty(value = "lastMsgRetained", defaultValue = "false")
    @JsonPropertyDescription("Defines if the last message published will be made available to new subscriptions.")
    private Boolean lastMsgRetained = false;

}
