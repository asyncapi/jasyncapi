package com.asyncapi.bindings.redis.withoutversion.message;

import com.asyncapi.bindings.redis.v0._1_0.RedisBindingProvider;
import com.asyncapi.bindings.redis.v0._1_0.message.RedisMessageBinding;
import com.asyncapi.v3.SerDeTest;
import org.jetbrains.annotations.NotNull;

public abstract class RedisMessageBindingTest extends SerDeTest<RedisMessageBinding> {

    @NotNull
    @Override
    protected Class<RedisMessageBinding> objectClass() {
        return RedisMessageBinding.class;
    }

    @NotNull
    @Override
    protected String baseObjectJson() {
        return "/bindings/default implementation/without version/message/binding.json";
    }

    @NotNull
    @Override
    protected String extendedObjectJson() {
        return "/bindings/default implementation/without version/message/binding - extended.json";
    }

    @NotNull
    @Override
    protected String wronglyExtendedObjectJson() {
        return "/bindings/default implementation/without version/message/binding - wrongly extended.json";
    }

    @NotNull
    @Override
    public RedisMessageBinding build() {
        return RedisBindingProvider.message();
    }

}
