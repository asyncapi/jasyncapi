package com.asyncapi.bindings.redis;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

public abstract class RedisTest {

    @Nested
    @DisplayName("unknown version")
    class UnknownVersion {

        @Nested
        @DisplayName("channel")
        class Channel extends com.asyncapi.bindings.redis.unknownversion.channel.RedisChannelBindingTest {}

        @Nested
        @DisplayName("message")
        class Message extends com.asyncapi.bindings.redis.unknownversion.message.RedisMessageBindingTest {}

        @Nested
        @DisplayName("operation")
        class Operation extends com.asyncapi.bindings.redis.unknownversion.operation.RedisOperationBindingTest {}

        @Nested
        @DisplayName("server")
        class Server extends com.asyncapi.bindings.redis.unknownversion.server.RedisServerBindingTest {}

    }

    @Nested
    @DisplayName("without version")
    class WithoutVersion {

        @Nested
        @DisplayName("channel")
        class Channel extends com.asyncapi.bindings.redis.withoutversion.channel.RedisChannelBindingTest {}

        @Nested
        @DisplayName("message")
        class Message extends com.asyncapi.bindings.redis.withoutversion.message.RedisMessageBindingTest {}

        @Nested
        @DisplayName("operation")
        class Operation extends com.asyncapi.bindings.redis.withoutversion.operation.RedisOperationBindingTest {}

        @Nested
        @DisplayName("server")
        class Server extends com.asyncapi.bindings.redis.withoutversion.server.RedisServerBindingTest {}

    }

    @Nested
    @DisplayName("latest")
    class Latest {

        @Nested
        @DisplayName("channel")
        class Channel extends com.asyncapi.bindings.redis.latest.channel.RedisChannelBindingTest {}

        @Nested
        @DisplayName("message")
        class Message extends com.asyncapi.bindings.redis.latest.message.RedisMessageBindingTest {}

        @Nested
        @DisplayName("operation")
        class Operation extends com.asyncapi.bindings.redis.latest.operation.RedisOperationBindingTest {}

        @Nested
        @DisplayName("server")
        class Server extends com.asyncapi.bindings.redis.latest.server.RedisServerBindingTest {}

    }

    @Nested
    @DisplayName("0.1.0")
    class V0_1_0 {

        @Nested
        @DisplayName("channel")
        class Channel extends com.asyncapi.bindings.redis.v0._1_0.channel.RedisChannelBindingTest {}

        @Nested
        @DisplayName("message")
        class Message extends com.asyncapi.bindings.redis.v0._1_0.message.RedisMessageBindingTest {}

        @Nested
        @DisplayName("operation")
        class Operation extends com.asyncapi.bindings.redis.v0._1_0.operation.RedisOperationBindingTest {}

        @Nested
        @DisplayName("server")
        class Server extends com.asyncapi.bindings.redis.v0._1_0.server.RedisServerBindingTest {}

    }

}
