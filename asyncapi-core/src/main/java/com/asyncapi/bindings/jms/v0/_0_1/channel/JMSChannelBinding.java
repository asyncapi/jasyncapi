package com.asyncapi.bindings.jms.v0._0_1.channel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.jetbrains.annotations.Nullable;

/**
 * This class MUST NOT contain any properties. Its name is reserved for future use.
 * <p>
 * Describes JMS channel binding.
 *
 * @version 0.1.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/jms#channel-binding-object">JMS channel binding</a>
 * @author Pavel Bodiachevskii
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
