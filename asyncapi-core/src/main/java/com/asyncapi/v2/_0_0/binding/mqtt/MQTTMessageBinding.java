package com.asyncapi.v2._0_0.binding.mqtt;

import com.asyncapi.v2._0_0.binding.MessageBinding;
import lombok.*;

import javax.annotation.CheckForNull;
import javax.annotation.Nullable;

/**
 * Describes MQTT message binding.
 *
 * Contains information about the message representation in MQTT.
 *
 * @version 0.1.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/mqtt#message-binding-object">MQTT message binding</a>
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class MQTTMessageBinding extends MessageBinding {

    /**
     * The version of this binding. If omitted, "latest" MUST be assumed.
     */
    @Nullable
    @CheckForNull
    private String bindingVersion;

}
