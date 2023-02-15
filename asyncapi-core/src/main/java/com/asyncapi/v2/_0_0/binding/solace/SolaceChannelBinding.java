package com.asyncapi.v2._0_0.binding.solace;

import com.asyncapi.v2._0_0.binding.ChannelBinding;
import lombok.*;

/**
 * Describes Solace channel binding.
 *
 * Contains information about the channel representation in Solace PubSub+ Broker.
 * This object MUST NOT contain any properties. Its name is reserved for future use.
 *
 * @version 0.2.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/solace#channel-binding-object">Solace channel binding</a>
 * @author Dennis Brinley
 */
@Data
@Builder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SolaceChannelBinding extends ChannelBinding {
}
