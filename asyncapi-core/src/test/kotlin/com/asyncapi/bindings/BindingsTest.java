package com.asyncapi.bindings;

import com.asyncapi.bindings.amqp1.AMQP1Test;
import com.asyncapi.bindings.redis.RedisTest;
import com.asyncapi.bindings.stomp.STOMPTest;
import com.asyncapi.bindings.websockets.WebSocketsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

@DisplayName("Bindings")
public class BindingsTest {

    @Nested
    @DisplayName("AMQP1")
    class AMQP1 extends AMQP1Test {}

    @Nested
    @DisplayName("Redis")
    class Redis extends RedisTest {}

    @Nested
    @DisplayName("STOMP")
    class STOMP extends STOMPTest {}

    @Nested
    @DisplayName("WebSockets")
    class WebSockets extends WebSocketsTest {}

}
