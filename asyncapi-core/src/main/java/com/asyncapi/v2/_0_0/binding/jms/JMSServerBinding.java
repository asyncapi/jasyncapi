package com.asyncapi.v2._0_0.binding.jms;

import com.asyncapi.v2._0_0.binding.ServerBinding;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * This class MUST NOT contain any properties. Its name is reserved for future use.
 *
 * Describes JMS server binding.
 *
 * @version 0.1.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/jms#server-binding-object">JMS server binding</a>
 * @author Pavel Bodiachevskii
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class JMSServerBinding extends ServerBinding {
}
