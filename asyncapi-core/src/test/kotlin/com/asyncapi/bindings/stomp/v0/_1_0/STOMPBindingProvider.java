package com.asyncapi.bindings.stomp.v0._1_0;

import com.asyncapi.bindings.stomp.v0._1_0.channel.STOMPChannelBinding;
import com.asyncapi.bindings.stomp.v0._1_0.message.STOMPMessageBinding;
import com.asyncapi.bindings.stomp.v0._1_0.operation.STOMPOperationBinding;
import com.asyncapi.bindings.stomp.v0._1_0.server.STOMPServerBinding;

public class STOMPBindingProvider {

    public static STOMPChannelBinding channel() {
        return new STOMPChannelBinding();
    }

    public static STOMPMessageBinding message() {
        return new STOMPMessageBinding();
    }

    public static STOMPOperationBinding operation() {
        return new STOMPOperationBinding();
    }

    public static STOMPServerBinding server() {
        return new STOMPServerBinding();
    }

}
