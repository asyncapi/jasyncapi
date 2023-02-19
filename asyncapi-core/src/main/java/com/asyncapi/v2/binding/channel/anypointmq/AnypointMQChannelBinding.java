package com.asyncapi.v2.binding.channel.anypointmq;

import com.asyncapi.v2.binding.channel.ChannelBinding;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;

/**
 * Describes Anypoint MQ channel binding.
 *
 * @version 0.0.1
 * @see <a href="https://github.com/asyncapi/bindings/blob/master/anypointmq/README.md#channel-binding-object">Anypoint MQ channel binding</a>
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AnypointMQChannelBinding extends ChannelBinding {

    /**
     * OPTIONAL, defaults to the channel name.
     * <p>
     * The destination (queue or exchange) name for this channel. SHOULD only be specified if the channel name differs
     * from the actual destination name, such as when the channel name is not a valid destination name in Anypoint MQ.
     */
    @Nullable
    private String destination;

    /**
     * OPTIONAL, defaults to queue.
     * <p>
     * The type of destination, which MUST be either exchange or queue or fifo-queue.
     * SHOULD be specified to document the messaging model (publish/subscribe, point-to-point, strict message ordering)
     * supported by this channel.
     */
    @Nullable
    private String destinationType;

    /**
     * OPTIONAL, defaults to latest. The version of this binding.
     */
    @Nullable
    @Builder.Default
    private String bindingVersion = "0.0.1";

}
