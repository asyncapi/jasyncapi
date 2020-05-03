package com.asyncapi.v2.binding.kafka;

import com.asyncapi.v2.binding.MessageBinding;
import lombok.*;

import javax.annotation.CheckForNull;
import javax.annotation.Nullable;

/**
 * This class MUST NOT contain any properties. Its name is reserved for future use.
 *
 * This class defines how to describe Kafka message binding.
 *
 * TODO: wait https://github.com/asyncapi/bindings/issues/22
 *
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class KafkaMessageBinding extends MessageBinding {

    /**
     * The message key.
     */
    @Nullable
    @CheckForNull
    private String key;

    /**
     * The version of this binding. If omitted, "latest" MUST be assumed.
     */
    @Nullable
    @CheckForNull
    private String bindingVersion;

}
