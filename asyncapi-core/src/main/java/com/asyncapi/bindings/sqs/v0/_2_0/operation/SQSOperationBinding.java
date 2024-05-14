package com.asyncapi.bindings.sqs.v0._2_0.operation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.List;

/**
 * Describes SQS operation binding.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/sqs#operation-binding-object">SQS operation binding</a>
 * @see <a href="https://aws.amazon.com/sqs/">Amazon SQS</a>
 * @author Pavel Bodiachevskii
 * @version 0.2.0
 * @since 1.0.0-RC2
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SQSOperationBinding extends com.asyncapi.bindings.sqs.SQSOperationBinding {

    /**
     * Queue objects that are either the endpoint for an SNS Operation Binding Object,
     * or the deadLetterQueue of the SQS Operation Binding Object.
     */
    @NotNull
    @Builder.Default
    private List<@NotNull SQSOperationQueue> queues = Collections.emptyList();

    @Override
    public String getBindingVersion() {
        return "0.2.0";
    }

    @Override
    public void setBindingVersion(@Nullable String bindingVersion) {
        super.setBindingVersion("0.2.0");
    }

}
