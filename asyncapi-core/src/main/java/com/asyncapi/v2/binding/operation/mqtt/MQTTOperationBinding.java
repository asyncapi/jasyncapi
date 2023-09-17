package com.asyncapi.v2.binding.operation.mqtt;

import com.asyncapi.v2.binding.operation.OperationBinding;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;

/**
 * Describes MQTT operation binding.
 * <p>
 * Contains information about the operation representation in MQTT.
 *
 * @version 0.1.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/mqtt#operation-binding-object">MQTT operation binding</a>
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class MQTTOperationBinding extends OperationBinding {

    /**
     * Defines how hard the broker/client will try to ensure that a message is received.
     * Its value MUST be either 0, 1 or 2.
     * <p>
     * Applies to: publish, subscribe
     */
    @Nullable
    private Integer qos;

    /**
     * Whether the broker should retain the message or not.
     * <p>
     * Applies to: publish, subscribe
     */
    @Nullable
    private Boolean retain;

    /**
     * The version of this binding. If omitted, "latest" MUST be assumed.
     * <p>
     * Applies to: publish, subscribe
     */
    @Nullable
    @Builder.Default
    private String bindingVersion = "0.1.0";

}
