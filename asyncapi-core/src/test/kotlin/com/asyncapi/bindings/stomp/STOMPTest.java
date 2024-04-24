package com.asyncapi.bindings.stomp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

public abstract class STOMPTest {

    @Nested
    @DisplayName("unknown version")
    class UnknownVersion {

        @Nested
        @DisplayName("channel")
        class Channel extends com.asyncapi.bindings.stomp.unknownversion.channel.STOMPChannelBindingTest {}

        @Nested
        @DisplayName("message")
        class Message extends com.asyncapi.bindings.stomp.unknownversion.message.STOMPMessageBindingTest {}

        @Nested
        @DisplayName("operation")
        class Operation extends com.asyncapi.bindings.stomp.unknownversion.operation.STOMPOperationBindingTest {}

        @Nested
        @DisplayName("server")
        class Server extends com.asyncapi.bindings.stomp.unknownversion.server.STOMPServerBindingTest {}

    }

    @Nested
    @DisplayName("without version")
    class WithoutVersion {

        @Nested
        @DisplayName("channel")
        class Channel extends com.asyncapi.bindings.stomp.withoutversion.channel.STOMPChannelBindingTest {}

        @Nested
        @DisplayName("message")
        class Message extends com.asyncapi.bindings.stomp.withoutversion.message.STOMPMessageBindingTest {}

        @Nested
        @DisplayName("operation")
        class Operation extends com.asyncapi.bindings.stomp.withoutversion.operation.STOMPOperationBindingTest {}

        @Nested
        @DisplayName("server")
        class Server extends com.asyncapi.bindings.stomp.withoutversion.server.STOMPServerBindingTest {}

    }

    @Nested
    @DisplayName("latest")
    class Latest {

        @Nested
        @DisplayName("channel")
        class Channel extends com.asyncapi.bindings.stomp.latest.channel.STOMPChannelBindingTest {}

        @Nested
        @DisplayName("message")
        class Message extends com.asyncapi.bindings.stomp.latest.message.STOMPMessageBindingTest {}

        @Nested
        @DisplayName("operation")
        class Operation extends com.asyncapi.bindings.stomp.latest.operation.STOMPOperationBindingTest {}

        @Nested
        @DisplayName("server")
        class Server extends com.asyncapi.bindings.stomp.latest.server.STOMPServerBindingTest {}

    }

    @Nested
    @DisplayName("0.1.0")
    class V0_1_0 {

        @Nested
        @DisplayName("channel")
        class Channel extends com.asyncapi.bindings.stomp.v0._1_0.channel.STOMPChannelBindingTest {}

        @Nested
        @DisplayName("message")
        class Message extends com.asyncapi.bindings.stomp.v0._1_0.message.STOMPMessageBindingTest {}

        @Nested
        @DisplayName("operation")
        class Operation extends com.asyncapi.bindings.stomp.v0._1_0.operation.STOMPOperationBindingTest {}

        @Nested
        @DisplayName("server")
        class Server extends com.asyncapi.bindings.stomp.v0._1_0.server.STOMPServerBindingTest {}

    }

}
