package com.asyncapi.bindings.sns.v0._1_0.operation;

import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.List;

/**
 * Describes SNS operation binding.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/sns#operation-binding-object">SNS operation binding</a>
 * @see <a href="https://aws.amazon.com/sns/">Amazon SNS</a>
 * @author Pavel Bodiachevskii
 * @version 0.1.0
 * @since 1.0.0-RC2
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SNSOperationBinding extends com.asyncapi.bindings.sns.SNSOperationBinding {

    /**
     * Often we can assume that the SNS Topic is the channel name-we provide this field in case the you need to
     * supply the ARN, or the Topic name is not the channel name in the AsyncAPI document.
     */
    @Nullable
    private SNSOperationDestinationIdentifier topic;

    /**
     * The protocols that listen to this topic and their endpoints.
     */
    @NotNull
    @Builder.Default
    @javax.validation.constraints.Size(min = 1)
    private List<@NotNull SNSOperationConsumer> consumers = Collections.emptyList();

    /**
     * Policy for retries to HTTP. The field is the default for HTTP receivers of the SNS Topic
     * which may be overridden by a specific consumer.
     */
    @Nullable
    private Object deliveryPolicy;

    @Override
    public String getBindingVersion() {
        return "0.1.0";
    }

    @Override
    public void setBindingVersion(@Nullable String bindingVersion) {
        super.setBindingVersion("0.1.0");
    }

}
