package com.asyncapi.bindings.redis.unknownversion.operation;

import com.asyncapi.bindings.redis.v0._1_0.RedisBindingProvider;
import com.asyncapi.bindings.redis.v0._1_0.operation.RedisOperationBinding;
import com.asyncapi.v3.SerDeTest;
import org.jetbrains.annotations.NotNull;

public abstract class RedisOperationBindingTest extends SerDeTest<RedisOperationBinding> {

    @NotNull
    @Override
    protected Class<RedisOperationBinding> objectClass() {
        return RedisOperationBinding.class;
    }

    @NotNull
    @Override
    protected String baseObjectJson() {
        return "/bindings/default implementation/unknown version/operation/binding.json";
    }

    @NotNull
    @Override
    protected String extendedObjectJson() {
        return "/bindings/default implementation/unknown version/operation/binding - extended.json";
    }

    @NotNull
    @Override
    protected String wronglyExtendedObjectJson() {
        return "/bindings/default implementation/unknown version/operation/binding - wrongly extended.json";
    }

    @NotNull
    @Override
    public RedisOperationBinding build() {
        return RedisBindingProvider.operation();
    }

}
