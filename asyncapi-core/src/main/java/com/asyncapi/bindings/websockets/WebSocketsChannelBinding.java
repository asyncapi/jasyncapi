package com.asyncapi.bindings.websockets;

import com.asyncapi.bindings.ChannelBinding;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Describes WebSockets channel binding.
 * <p>
 * When using WebSockets, the channel represents the connection.
 * <p>
 * Unlike other protocols that support multiple virtual channels (topics, routing keys, etc.) per connection,
 * WebSockets doesn't support virtual channels or, put it another way, there's only one channel and its characteristics
 * are strongly related to the protocol used for the handshake, i.e., HTTP.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/websockets#channel-binding-object">WebSockets channel binding</a>
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/WebSockets_API">MDN WebSockets</a>
 * @author Pavel Bodiachevskii
 * @since 1.0.0-RC2
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        defaultImpl = com.asyncapi.bindings.websockets.v0._1_0.channel.WebSocketsChannelBinding.class,
        property = "bindingVersion",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = com.asyncapi.bindings.websockets.v0._1_0.channel.WebSocketsChannelBinding.class, names = {
                "0.1.0",
                "latest"
        }),
})
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class WebSocketsChannelBinding extends ChannelBinding {}