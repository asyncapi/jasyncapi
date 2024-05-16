package com.asyncapi.bindings.sns.v0._1_0.channel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * By default, we assume an unordered SNS topic. This field allows configuration of a FIFO SNS Topic.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/sns#channel-binding-object">SNS channel binding</a>
 * @see <a href="https://aws.amazon.com/sns/">Amazon SNS</a>
 * @author Pavel Bodiachevskii
 * @version 0.1.0
 * @since 1.0.0-RC2
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SNSChannelOrdering {

    /**
     * Defines the type of SNS Topic.
     */
    @NotNull
    private SNSChannelOrderingType type;

    /**
     * True to turn on de-duplication of messages for a channel.
     */
    @Nullable
    private Boolean contentBasedDeduplication;

}
