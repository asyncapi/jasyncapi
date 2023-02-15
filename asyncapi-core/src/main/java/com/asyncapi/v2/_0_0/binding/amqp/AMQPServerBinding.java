package com.asyncapi.v2._0_0.binding.amqp;

import com.asyncapi.v2._0_0.binding.ServerBinding;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * This class MUST NOT contain any properties. Its name is reserved for future use.
 *
 * Describes AMQP 0-9-1 server binding.
 *
 * @version 0.2.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/amqp#server-binding-object">AMQP server binding</a>
 * @author Pavel Bodiachevskii
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AMQPServerBinding extends ServerBinding {
}
