package com.asyncapi.bindings.websockets;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

public abstract class WebSocketsTest {

    @Nested
    @DisplayName("unknown version")
    class UnknownVersion {

        @Nested
        @DisplayName("channel")
        class Channel extends com.asyncapi.bindings.websockets.unknownversion.channel.WebSocketsChannelBindingTest {}

        @Nested
        @DisplayName("message")
        class Message extends com.asyncapi.bindings.websockets.unknownversion.message.WebSocketsMessageBindingTest {}

        @Nested
        @DisplayName("operation")
        class Operation extends com.asyncapi.bindings.websockets.unknownversion.operation.WebSocketsOperationBindingTest {}

        @Nested
        @DisplayName("server")
        class Server extends com.asyncapi.bindings.websockets.unknownversion.server.WebSocketsServerBindingTest {}

    }

    @Nested
    @DisplayName("without version")
    class WithoutVersion {

        @Nested
        @DisplayName("channel")
        class Channel extends com.asyncapi.bindings.websockets.withoutversion.channel.WebSocketsChannelBindingTest {}

        @Nested
        @DisplayName("message")
        class Message extends com.asyncapi.bindings.websockets.withoutversion.message.WebSocketsMessageBindingTest {}

        @Nested
        @DisplayName("operation")
        class Operation extends com.asyncapi.bindings.websockets.withoutversion.operation.WebSocketsOperationBindingTest {}

        @Nested
        @DisplayName("server")
        class Server extends com.asyncapi.bindings.websockets.withoutversion.server.WebSocketsServerBindingTest {}

    }

    @Nested
    @DisplayName("latest")
    class Latest {

        @Nested
        @DisplayName("channel")
        class Channel extends com.asyncapi.bindings.websockets.latest.channel.WebSocketsChannelBindingTest {}

        @Nested
        @DisplayName("message")
        class Message extends com.asyncapi.bindings.websockets.latest.message.WebSocketsMessageBindingTest {}

        @Nested
        @DisplayName("operation")
        class Operation extends com.asyncapi.bindings.websockets.latest.operation.WebSocketsOperationBindingTest {}

        @Nested
        @DisplayName("server")
        class Server extends com.asyncapi.bindings.websockets.latest.server.WebSocketsServerBindingTest {}

    }

    @Nested
    @DisplayName("0.1.0")
    class V0_1_0 {

        @Nested
        @DisplayName("channel")
        class Channel extends com.asyncapi.bindings.websockets.v0._1_0.channel.WebSocketsChannelBindingTest {}

        @Nested
        @DisplayName("message")
        class Message extends com.asyncapi.bindings.websockets.v0._1_0.message.WebSocketsMessageBindingTest {}

        @Nested
        @DisplayName("operation")
        class Operation extends com.asyncapi.bindings.websockets.v0._1_0.operation.WebSocketsOperationBindingTest {}

        @Nested
        @DisplayName("server")
        class Server extends com.asyncapi.bindings.websockets.v0._1_0.server.WebSocketsServerBindingTest {}

    }

}
