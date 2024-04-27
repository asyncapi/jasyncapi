package com.asyncapi.bindings.jms.v0._0_1.server;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

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
