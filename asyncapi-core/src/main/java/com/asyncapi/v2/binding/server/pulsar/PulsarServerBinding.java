package com.asyncapi.v2.binding.server.pulsar;

import com.asyncapi.v2.binding.server.ServerBinding;
import lombok.*;

import javax.annotation.CheckForNull;

/**
 * Describes Pulsar server binding.
 *
 * @version 0.1.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/pulsar#server-binding-object">Redis server binding</a>
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PulsarServerBinding extends ServerBinding {

    /**
     * The pulsar tenant. If omitted, "public" MUST be assumed.
     */
    @CheckForNull
    @Builder.Default
    private String tenant = "public";

    /**
     * The version of this binding.
     */
    @CheckForNull
    @Builder.Default
    private String bindingVersion = "0.1.0";

}
