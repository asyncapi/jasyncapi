package com.asyncapi.bindings.jms.v0._0_1.message;

import com.asyncapi.schemas.asyncapi.AsyncAPISchema;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.jetbrains.annotations.Nullable;

/**
 * This class MUST NOT contain any properties. Its name is reserved for future use.
 * <p>
 * Describes JMS message binding.
 *
 * @version 0.1.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/jms#message-binding-object">JMS message binding</a>
 * @author Pavel Bodiachevskii
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
