package com.asyncapi.bindings.websockets.v0._1_0.channel;

import com.asyncapi.schemas.asyncapi.AsyncAPISchema;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

/**
 * Describes WebSockets channel binding.
 * <p>
 * When using WebSockets, the channel represents the connection.
 * <p>
 * Unlike other protocols that support multiple virtual channels (topics, routing keys, etc.) per connection,
 * WebSockets doesn't support virtual channels or, put it another way, there's only one channel and its characteristics
 * are strongly related to the protocol used for the handshake, i.e., HTTP.
 *
 * @version 0.1.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/websockets#channel-binding-object">WebSockets channel binding</a>
 * @author Pavel Bodiachevskii
 */
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonClassDescription("Describes WebSockets channel binding.")
public class WebSocketsChannelBinding extends com.asyncapi.bindings.websockets.WebSocketsChannelBinding {

    public WebSocketsChannelBinding() {
        this.setBindingVersion("0.1.0");
    }

    public WebSocketsChannelBinding(@NotNull WebSocketsChannelBindingBuilder webSocketsChannelBindingBuilder) {
        this.method = webSocketsChannelBindingBuilder.method;
        this.query = webSocketsChannelBindingBuilder.query;
        this.headers = webSocketsChannelBindingBuilder.headers;
        this.setBindingVersion("0.1.0");
        this.extensionFields = webSocketsChannelBindingBuilder.extensionFields;
    }

    /**
     * The HTTP method to use when establishing the connection.
     * <p>
     * Its value <b>MUST</b> be either GET or POST.
     */
    @Nullable
    @JsonProperty("method")
    @JsonPropertyDescription("The HTTP method to use when establishing the connection. Its value MUST be either GET or POST.")
    private WebSocketsChannelMethod method;

    /**
     * A Schema object containing the definitions for each query parameter.
     * <p>
     * This schema <b>MUST</b> be of type object and have a properties key.
     */
    @Nullable
    @JsonProperty("query")
    @JsonPropertyDescription("A Schema object containing the definitions for each query parameter. This schema MUST be of type object and have a properties key.")
    private AsyncAPISchema query;

    /**
     * A Schema object containing the definitions of the HTTP headers to use when establishing the connection.
     * <p>
     * This schema <b>MUST</b> be of type object and have a properties key.
     */
    @Nullable
    @JsonProperty("headers")
    @JsonPropertyDescription("A Schema object containing the definitions of the HTTP headers to use when establishing the connection. This schema MUST be of type object and have a properties key.")
    private AsyncAPISchema headers;

    @Override
    public String getBindingVersion() {
        return "0.1.0";
    }

    @Override
    public void setBindingVersion(@Nullable String bindingVersion) {
        super.setBindingVersion("0.1.0");
    }

    public static WebSocketsChannelBindingBuilder builder() {
        return new WebSocketsChannelBindingBuilder();
    }

    public static class WebSocketsChannelBindingBuilder {

        @Nullable
        private WebSocketsChannelMethod method;

        @Nullable
        private AsyncAPISchema query;

        @Nullable
        private AsyncAPISchema headers;

        @Nullable
        private Map<String, Object> extensionFields;

        @NotNull
        public WebSocketsChannelBindingBuilder method(@Nullable WebSocketsChannelMethod method) {
            this.method = method;
            return this;
        }

        @NotNull
        public WebSocketsChannelBindingBuilder query(@Nullable AsyncAPISchema query) {
            this.query = query;
            return this;
        }

        @NotNull
        public WebSocketsChannelBindingBuilder headers(@Nullable AsyncAPISchema headers) {
            this.headers = headers;
            return this;
        }

        @NotNull
        public WebSocketsChannelBindingBuilder extensionFields(@Nullable Map<String, Object> extensionFields) {
            this.extensionFields = extensionFields;
            return this;
        }

        public WebSocketsChannelBinding build() {
            return new WebSocketsChannelBinding(this);
        }

    }

}
