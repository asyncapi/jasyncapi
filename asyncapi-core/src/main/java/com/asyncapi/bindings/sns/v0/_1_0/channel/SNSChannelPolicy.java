package com.asyncapi.bindings.sns.v0._1_0.channel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;

/**
 * The security policy for the SNS Topic.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/sns#channel-binding-object">SNS channel binding</a>
 * @see <a href="https://aws.amazon.com/sns/">Amazon SNS</a>
 * @author Pavel Bodiachevskii
 * @version 0.1.0
 * @since 1.0.0-RC2
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SNSChannelPolicy {

    /**
     * An array of statement objects, each of which controls a permission for this topic
     */
    @NotNull
    private List<@NotNull SNSChannelPolicyStatement> statements = Collections.emptyList();

}
