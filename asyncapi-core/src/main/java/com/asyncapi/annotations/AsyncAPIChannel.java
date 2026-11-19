package com.asyncapi.annotations;

import com.asyncapi.bindings.ChannelBinding;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.METHOD;

/**
 * Describes a shared communication channel.
 *
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v3.0.0#channelObject">Channel</a>
 * @author Pavel Bodiachevskii <pavelbodyachevskiy@gmail.com>
 * @version 3.0.0
 */
@Inherited
@Target({METHOD, ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface AsyncAPIChannel {

    /**
     * An optional string representation of this channel's address
     * <p>
     * The address is typically the:
     * <ul>
     *     <li>topic name</li>
     *     <li>routing key</li>
     *     <li>event type</li>
     *     <li>path</li>
     * </ul>
     * <p>
     * When null or absent, it MUST be interpreted as unknown.
     * This is useful when the address is generated dynamically at runtime or can't be known upfront.
     * <p>
     * It MAY contain Channel Address Expressions like {@code {userId}}
     * <p>
     * Query parameters and fragments SHALL NOT be used, instead use {@link ChannelBinding} to define them.
     *
     * @see <a href="https://www.asyncapi.com/docs/reference/specification/v3.0.0#channelBindingsObject">Channel bindings</a>
     * @see <a href="https://www.asyncapi.com/docs/reference/specification/v3.0.0#channelAddressExpressions">Channel Address Expressions</a>
     */
    String address() default "";

    /**
     * A human-friendly title for the channel.
     */
    String title() default "";

    /**
     * An optional description of this channel. <a href="https://spec.commonmark.org/">CommonMark syntax</a> can be used for rich text representation.
     */
    String description() default "";

}
