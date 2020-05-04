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
     *
     * @see <a href="https://www.asyncapi.com/docs/specifications/2.0.0/#schemaObject">Schema object</a>
     */
    @Nullable
    @CheckForNull
    private Object groupId;

    /**
     * Id of the consumer inside a consumer group.
     *
     * @see <a href="https://www.asyncapi.com/docs/specifications/2.0.0/#schemaObject">Schema object</a>
     */
    @Nullable
    @CheckForNull
    private Object clientId;

    /**
     * The version of this binding. If omitted, "latest" MUST be assumed.
     */
    @Nullable
    @CheckForNull
    private String bindingVersion;

}
