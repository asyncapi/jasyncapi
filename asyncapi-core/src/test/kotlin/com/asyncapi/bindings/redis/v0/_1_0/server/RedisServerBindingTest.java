package com.asyncapi.bindings.redis.v0._1_0.server;

import com.asyncapi.bindings.redis.v0._1_0.RedisBindingProvider;
import com.asyncapi.v3.SerDeTest;
import org.jetbrains.annotations.NotNull;

public abstract class RedisServerBindingTest extends SerDeTest<RedisServerBinding> {

    @NotNull
    @Override
    protected Class<RedisServerBinding> objectClass() {
        return RedisServerBinding.class;
    }

    @NotNull
    @Override
    protected String baseObjectJson() {
        return "/bindings/default implementation/0.1.0/server/binding.json";
    }

    @NotNull
    @Override
    protected String extendedObjectJson() {
        return "/bindings/default implementation/0.1.0/server/binding - extended.json";
    }

    @NotNull
    @Override
    protected String wronglyExtendedObjectJson() {
        return "/bindings/default implementation/0.1.0/server/binding - wrongly extended.json";
    }

    @NotNull
    @Override
    public RedisServerBinding build() {
        return RedisBindingProvider.server();
    }

}
