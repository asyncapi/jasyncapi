package com.asyncapi.bindings.jms.v0._0_1.server;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

/**
 * Describes JMS server property.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/jms#server-binding-object">JMS server binding</a>
 * @see <a href="https://www.oracle.com/java/technologies/java-message-service.html">Java Message Service</a>
 * @author Pavel Bodiachevskii
 * @version 0.0.1
 * @since 1.0.0-RC2
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JMSServerProperty {

    /**
     * The name of a property
     */
    @NotNull
    private String name;

    /**
     * The value of a property
     *
     * MUST BE:
     * <ul>
     *     <li>string</li>
     *     <li>boolean</li>
     *     <li>number</li>
     *     <li>null</li>
     * </ul>
     */
    @NotNull
    private Object value;

}
