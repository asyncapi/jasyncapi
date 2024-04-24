package com.asyncapi.bindings.stomp;

import com.asyncapi.bindings.stomp._1_0.channel.STOMPChannelBindingTest;
import com.asyncapi.bindings.stomp._1_0.message.STOMPMessageBindingTest;
import com.asyncapi.bindings.stomp._1_0.operation.STOMPOperationBindingTest;
import com.asyncapi.bindings.stomp._1_0.server.STOMPServerBindingTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

public abstract class STOMPTest {

    @Nested
    @DisplayName("unknown version")
    class UnknownVersion {

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
        class Channel extends STOMPChannelBindingTest {}

        @Nested
        @DisplayName("message")
        class Message extends STOMPMessageBindingTest {}

        @Nested
        @DisplayName("operation")
        class Operation extends STOMPOperationBindingTest {}

        @Nested
        @DisplayName("server")
        class Server extends STOMPServerBindingTest {}

    }

}
