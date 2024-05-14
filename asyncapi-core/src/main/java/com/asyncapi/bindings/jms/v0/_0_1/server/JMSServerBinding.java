package com.asyncapi.bindings.jms.v0._0_1.server;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Describes JMS server binding.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/jms#server-binding-object">JMS server binding</a>
 * @see <a href="https://www.oracle.com/java/technologies/java-message-service.html">Java Message Service</a>
 * @author Pavel Bodiachevskii
 * @version 0.0.1
 * @since 1.0.0-RC2
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class JMSServerBinding extends com.asyncapi.bindings.jms.JMSServerBinding {

    /**
     * The classname of the ConnectionFactory implementation for the JMS Provider.
     */
    @NotNull
    @JsonProperty("jmsConnectionFactory")
    private String jmsConnectionFactory = "";

    /**
     * Additional properties to set on the JMS ConnectionFactory implementation for the JMS Provider.
     */
    @Nullable
    @JsonProperty("properties")
    private List<@NotNull JMSServerProperty> properties;

    /**
     * A client identifier for applications that use this JMS connection factory.
     * <p>
     * If the Client ID Policy is set to 'Restricted' (the default),
     * then configuring a Client ID on the ConnectionFactory prevents more than one JMS client from
     * using a connection from this factory.
     */
    @Nullable
    @JsonProperty("clientID")
    private String clientID;

    @Override
    public String getBindingVersion() {
        return "0.0.1";
    }

    @Override
    public void setBindingVersion(@Nullable String bindingVersion) {
        super.setBindingVersion("0.0.1");
    }

}
