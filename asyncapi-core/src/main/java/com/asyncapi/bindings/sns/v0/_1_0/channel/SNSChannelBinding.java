package com.asyncapi.bindings.sns.v0._1_0.channel;

import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

/**
 * Describes SNS channel binding.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/sns#channel-binding-object">SNS channel binding</a>
 * @see <a href="https://aws.amazon.com/sns/">SNS</a>
 * @author Pavel Bodiachevskii
 * @version 0.1.0
 * @since 1.0.0-RC2
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SNSChannelBinding extends com.asyncapi.bindings.sns.SNSChannelBinding {

    /**
     * The name of the topic.
     * <p>
     * Can be different from the channel name to allow flexibility around AWS resource naming limitations.
     */
    @NotNull
    @Builder.Default
    private String name = "";

    /**
     * This field allows configuration of a FIFO SNS Topic.
     */
    @Nullable
    private SNSChannelOrdering ordering;

    /**
     *
     */
    @Nullable
    private SNSChannelPolicy policy;

    /**
     * Key-value pairs that represent AWS tags on the topic.
     */
    @Nullable
    private Map<String, Object> tags;

    @Override
    public String getBindingVersion() {
        return "0.1.0";
    }

    @Override
    public void setBindingVersion(@Nullable String bindingVersion) {
        super.setBindingVersion("0.1.0");
    }

}
