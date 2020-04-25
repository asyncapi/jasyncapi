package com.asyncapi.v2.binding.kafka;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@NoArgsConstructor
@AllArgsConstructor
public class KafkaMessageBinding {

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
