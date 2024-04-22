package com.asyncapi.bindings.kafka.v0._4_0.operation;

import com.asyncapi.bindings.OperationBinding;
import com.asyncapi.v3.schema.AsyncAPISchema;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.*;
import org.jetbrains.annotations.Nullable;

/**
 * Describes Kafka operation binding.
 * <p>
 * Contains information about the operation representation in Kafka.
 *
 * @version 0.1.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/kafka#operation-binding-object">Kafka operation binding</a>
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
    @JsonProperty("groupId")
    @JsonPropertyDescription("Id of the consumer group.")
    private AsyncAPISchema groupId;

    /**
     * Id of the consumer inside a consumer group.
     */
    @Nullable
    @JsonProperty("clientId")
    @JsonPropertyDescription("Id of the consumer inside a consumer group.")
    private AsyncAPISchema clientId;

    /**
     * The version of this binding. If omitted, "latest" MUST be assumed.
     */
    @Nullable
    @Builder.Default
    private String bindingVersion = "0.4.0";

}
