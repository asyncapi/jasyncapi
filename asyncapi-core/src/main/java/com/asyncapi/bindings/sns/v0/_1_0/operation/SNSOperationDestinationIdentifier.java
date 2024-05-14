package com.asyncapi.bindings.sns.v0._1_0.operation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;

/**
 * Describes SNS operation destination identifier.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/sns#operation-binding-object">SNS operation binding</a>
 * @see <a href="https://aws.amazon.com/sns/">Amazon SNS</a>
 * @author Pavel Bodiachevskii
 * @version 0.1.0
 * @since 1.0.0-RC2
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SNSOperationDestinationIdentifier {

    /**
     * The endpoint is a URL.
     */
    @Nullable
    private String url;

    /**
     * The endpoint is an email address.
     */
    @Nullable
    private String email;

    /**
     * The endpoint is a phone number.
     */
    @Nullable
    private String phone;

    /**
     * The target is an ARN.
     * <p>
     * For example, for SQS, the identifier may be an ARN, which will be of the form: arn:aws:sqs:{region}:{account-id}:{queueName}
     */
    @Nullable
    private String arn;

    /**
     * The endpoint is identified by a name, which corresponds to an identifying
     * field called <code>name</code> of a binding for that protocol on this publish Operation Object.
     * <p>
     * For example, if the protocol is 'sqs' then the name refers to the name field sqs binding.
     * <p>
     * We don't use $ref because we are referring, not including.
     */
    @Nullable
    private String name;

}
