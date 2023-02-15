package com.asyncapi.v2._0_0.binding.solace;

import com.asyncapi.v2._0_0.binding.MessageBinding;
import lombok.*;

/**
 * Describes Solace message binding.
 *
 * Contains information about the message representation in Solace PubSub+ Broker.
 * This object MUST NOT contain any properties. Its name is reserved for future use.
 *
 * @version 0.2.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/solace#message-binding-object">Solace message binding</a>
 * @author Dennis Brinley
 */
@Data
@Builder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SolaceMessageBinding extends MessageBinding {
}
