package com.asyncapi.v2._6_0.binding.message.anypointmq;

import com.asyncapi.v2._6_0.binding.channel.ChannelBinding;
import lombok.*;

import javax.annotation.CheckForNull;

/**
 * Describes Anypoint MQ message binding.
 *
 * @version 0.0.1
 * @see <a href="https://github.com/asyncapi/bindings/blob/master/anypointmq/README.md#channel-binding-object">Anypoint MQ channel binding</a>
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AnypointMQMessageBinding extends ChannelBinding {

    /**
     * OPTIONAL.
     * <p>
     * A Schema object containing the definitions for Anypoint MQ-specific headers (so-called protocol headers).
     * This schema MUST be of type object and have a properties key. Examples of Anypoint MQ protocol headers are
     * messageId and messageGroupId.
     */
    @CheckForNull
    private Object headers;

    /**
     * OPTIONAL, defaults to latest. The version of this binding.
     */
    @CheckForNull
    @Builder.Default
    private String bindingVersion = "0.0.1";

}
