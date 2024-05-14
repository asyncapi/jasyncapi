package com.asyncapi.bindings.sns.v0._1_0.channel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

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
public class SNSChannelPolicyStatement {

    /**
     * The SNS rule to allow or deny actions.
     */
    @NotNull
    private SNSChannelPolicyStatementEffect effect;

    /**
     * The AWS account or resource ARN that this statement applies to.
     */
    @NotNull
    private Object principal;

    /**
     * The SNS permission being allowed or denied e.g. sns:Publish.
     */
    @NotNull
    private Object action;

}
