package com.asyncapi.bindings;

import com.asyncapi.bindings.stomp.STOMPTest;
import com.asyncapi.bindings.websockets.WebSocketsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

@DisplayName("Bindings")
public class BindingsTest {

    @Nested
    @DisplayName("STOMP")
    class STOMP extends STOMPTest {}

    @Nested
    @DisplayName("WebSockets")
    class WebSockets extends WebSocketsTest {}

}
