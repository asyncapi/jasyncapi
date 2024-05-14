package com.asyncapi.bindings.ibmmq.v0._1_0.channel;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Describes IBM MQ channel queue properties.
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
@JsonClassDescription("Describes IBM MQ channel queue properties.")
public class IBMMQChannelQueueProperties {

    /**
     * Defines the name of the IBM MQ queue associated with the channel.
     * <p>
     * A value MUST be specified. MUST NOT exceed 48 characters in length. MUST be a valid IBM MQ queue name
     */
    @NotNull
    @javax.validation.constraints.NotNull
    @javax.validation.constraints.Size(
            max = 48,
            message = "Name of the IBM MQ queue must be less or equals to 48"
    )
    @Builder.Default
    @JsonProperty("objectName")
    @JsonPropertyDescription("Defines the name of the IBM MQ queue associated with the channel.")
    private String objectName = "";

    /**
     * Defines if the queue is a cluster queue and therefore partitioned. If true, a binding option MAY be specified
     * when accessing the queue. More information on binding options can be found on this page in the IBM MQ Knowledge Center.
     * <p>
     * If false, binding options SHOULD NOT be specified when accessing the queue.
     */
    @Nullable
    @Builder.Default
    @JsonProperty(value = "isPartitioned", defaultValue = "false")
    @JsonPropertyDescription("Defines if the queue is a cluster queue and therefore partitioned. If 'true', a binding option MAY be specified when accessing the queue. More information on binding options can be found on this page in the IBM MQ Knowledge Center.")
    private Boolean isPartitioned = false;

    /**
     * Specifies if it is recommended to open the queue exclusively.
     */
    @Nullable
    @Builder.Default
    @JsonProperty(value = "exclusive", defaultValue = "false")
    @JsonPropertyDescription("Specifies if it is recommended to open the queue exclusively.")
    private Boolean exclusive = false;

}
