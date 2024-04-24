package com.asyncapi.bindings.redis.v0._1_0;


import com.asyncapi.bindings.redis.v0._1_0.channel.RedisChannelBinding;
import com.asyncapi.bindings.redis.v0._1_0.message.RedisMessageBinding;
import com.asyncapi.bindings.redis.v0._1_0.operation.RedisOperationBinding;
import com.asyncapi.bindings.redis.v0._1_0.server.RedisServerBinding;

public class RedisBindingProvider {

    public static RedisChannelBinding channel() {
        return new RedisChannelBinding();
    }

    public static RedisMessageBinding message() {
        return new RedisMessageBinding();
    }

    public static RedisOperationBinding operation() {
        return new RedisOperationBinding();
    }

    public static RedisServerBinding server() {
        return new RedisServerBinding();
    }

}
