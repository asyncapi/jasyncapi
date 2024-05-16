package com.asyncapi.bindings.jms.v0._0_1.channel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;

/**
 * Describes JMS channel binding.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/jms#channel-binding-object">JMS channel binding</a>
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
public class JMSChannelBinding extends com.asyncapi.bindings.jms.JMSChannelBinding {

    /**
     * The destination (queue) name for this channel.
     * <p>
     * <b>SHOULD</b> only be specified if the channel name differs from the actual destination name,
     * such as when the channel name is not a valid destination name according to the JMS Provider.
     * <p>
     * Defaults to the channel name.
     */
    @Nullable
    @JsonProperty("destination")
    private String destination;

    @Nullable
    @JsonProperty("destinationType")
    private JMSChannelDestinationType destinationType;

    @Override
    public String getBindingVersion() {
        return "0.0.1";
    }

    @Override
    public void setBindingVersion(@Nullable String bindingVersion) {
        super.setBindingVersion("0.0.1");
    }

}
