package com.asyncapi.bindings.kafka.v0._3_0.operation;

import com.asyncapi.schemas.asyncapi.AsyncAPISchema;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;

/**
 * Describes Kafka operation binding.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/kafka#operation-binding-object">Kafka operation binding</a>
 * @see <a href="https://kafka.apache.org">Kafka</a>
 * @author Pavel Bodiachevskii
 * @version 0.3.0
 * @since 1.0.0-RC2
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class KafkaOperationBinding extends com.asyncapi.bindings.kafka.KafkaOperationBinding {

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

    @Override
    public String getBindingVersion() {
        return "0.3.0";
    }

    @Override
    public void setBindingVersion(@Nullable String bindingVersion) {
        super.setBindingVersion("0.3.0");
    }

}
