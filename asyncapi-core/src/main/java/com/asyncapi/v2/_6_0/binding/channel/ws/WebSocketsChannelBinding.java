package com.asyncapi.v2._6_0.binding.channel.ws;

import com.asyncapi.v2._6_0.binding.channel.ChannelBinding;
import lombok.*;

import javax.annotation.CheckForNull;

/**
 * Describes WebSockets channel binding.
 * <p>
 * When using WebSockets, the channel represents the connection. Unlike other protocols that support multiple virtual
 * channels (topics, routing keys, etc.) per connection, WebSockets doesn't support virtual channels or, put it another
 * way, there's only one channel and its characteristics are strongly related to the protocol used for the handshake,
 * i.e., HTTP.
 *
 * @version 0.1.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/websockets#channel-binding-object">WebSockets channel binding</a>
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class WebSocketsChannelBinding extends ChannelBinding {

    /**
     * The HTTP method to use when establishing the connection. Its value MUST be either GET or POST.
     */
    @CheckForNull
    private String method;

    /**
     * TODO: Schema object
     * A Schema object containing the definitions for each query parameter. This schema MUST be of type
     * object and have a properties key.
     *
     * @see <a href="https://www.asyncapi.com/docs/specifications/2.0.0/#schemaObject">Schema object</a>
     */
    @CheckForNull
    private Object query;

    /**
     * TODO: Schema object
     * A Schema object containing the definitions of the HTTP headers to use when establishing the connection.
     * This schema MUST be of type object and have a properties key.
     *
     * @see <a href="https://www.asyncapi.com/docs/specifications/2.0.0/#schemaObject">Schema object</a>
     */
    @CheckForNull
    private Object headers;

    /**
     * The version of this binding. If omitted, "latest" MUST be assumed.
     */
    @CheckForNull
    @Builder.Default
    private String bindingVersion = "0.1.0";

}
