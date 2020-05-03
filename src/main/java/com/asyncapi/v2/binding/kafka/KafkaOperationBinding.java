package com.asyncapi.v2.binding.kafka;

import com.asyncapi.v2.binding.OperationBinding;
import lombok.*;

import javax.annotation.CheckForNull;
import javax.annotation.Nullable;

/**
 * This class MUST NOT contain any properties. Its name is reserved for future use.
 *
 * This class defines how to describe Kafka operation binding.
 *
 * TODO: wait https://github.com/asyncapi/bindings/issues/21
 *
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class KafkaOperationBinding extends OperationBinding {

    /**
     * Id of the consumer group.
     */
    @Nullable
    @CheckForNull
    private String groupId;

    /**
     * Id of the consumer inside a consumer group.
     */
    @Nullable
    @CheckForNull
    private String clientId;

    /**
     * The version of this binding. If omitted, "latest" MUST be assumed.
     */
    @Nullable
    @CheckForNull
    private String bindingVersion;

}
