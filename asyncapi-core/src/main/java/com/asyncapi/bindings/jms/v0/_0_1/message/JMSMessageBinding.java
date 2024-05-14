package com.asyncapi.bindings.jms.v0._0_1.message;

import com.asyncapi.schemas.asyncapi.AsyncAPISchema;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.jetbrains.annotations.Nullable;

/**
 * Describes JMS message binding.
 *
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
public class JMSMessageBinding extends com.asyncapi.bindings.jms.JMSMessageBinding {

    /**
     * A Schema object containing the definitions for JMS headers (protocol headers).
     * <p>
     * This schema <b>MUST</b> be of type 'object' and have a 'properties' key.
     * <p>
     * Examples of JMS protocol headers are 'JMSMessageID', 'JMSTimestamp', and 'JMSCorrelationID'.
     */
    @Nullable
    @JsonProperty("headers")
    public AsyncAPISchema headers;

    @Override
    public String getBindingVersion() {
        return "0.0.1";
    }

    @Override
    public void setBindingVersion(@Nullable String bindingVersion) {
        super.setBindingVersion("0.0.1");
    }

}
