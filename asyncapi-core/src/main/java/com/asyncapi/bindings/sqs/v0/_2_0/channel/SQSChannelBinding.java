package com.asyncapi.bindings.sqs.v0._2_0.channel;

import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Describes SQS channel binding.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/sqs#channel-binding-object">SQS channel binding</a>
 * @see <a href="https://aws.amazon.com/sqs/">SQS</a>
 * @author Pavel Bodiachevskii
 * @version 0.2.0
 * @since 1.0.0-RC2
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SQSChannelBinding extends com.asyncapi.bindings.sqs.SQSChannelBinding {

    /**
     * A definition of the queue that will be used as the channel.
     */
    @NotNull
    private SQSChannelQueue queue = new SQSChannelQueue();

    /**
     * A definition of the queue that will be used for un-processable messages.
     */
    @Nullable
    private SQSChannelQueue deadLetterQueue;

    @Override
    public String getBindingVersion() {
        return "0.2.0";
    }

    @Override
    public void setBindingVersion(@Nullable String bindingVersion) {
        super.setBindingVersion("0.2.0");
    }

}
