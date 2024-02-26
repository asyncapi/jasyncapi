package com.asyncapi.v3.binding.channel.ws;

import com.asyncapi.v3.schema.Schema;
import com.asyncapi.v3.binding.channel.ChannelBinding;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.*;
import org.jetbrains.annotations.Nullable;

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
@JsonClassDescription("Describes WebSockets channel binding.")
public class WebSocketsChannelBinding extends ChannelBinding {

    /**
     * The HTTP method to use when establishing the connection. Its value MUST be either GET or POST.
     */
    @Nullable
    @JsonProperty("method")
    @JsonPropertyDescription("The HTTP method to use when establishing the connection. Its value MUST be either GET or POST.")
    private WebSocketsChannelMethod method;

    /**
     * A Schema object containing the definitions for each query parameter. This schema MUST be of type
     * object and have a properties key.
     */
    @Nullable
    @JsonProperty("query")
    @JsonPropertyDescription("A Schema object containing the definitions for each query parameter. This schema MUST be of type object and have a properties key.")
    private Schema query;

    /**
     * A Schema object containing the definitions of the HTTP headers to use when establishing the connection.
     * This schema MUST be of type object and have a properties key.
     */
    @Nullable
    @JsonProperty("headers")
    @JsonPropertyDescription("A Schema object containing the definitions of the HTTP headers to use when establishing the connection. This schema MUST be of type object and have a properties key.")
    private Schema headers;

    /**
     * The version of this binding. If omitted, "latest" MUST be assumed.
     */
    @Nullable
    @Builder.Default
    @JsonProperty("bindingVersion")
    @JsonPropertyDescription("The version of this binding.")
    private String bindingVersion = "0.1.0";

}
