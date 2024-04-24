package com.asyncapi.bindings.redis.unknownversion.channel;

import com.asyncapi.bindings.redis.v0._1_0.RedisBindingProvider;
import com.asyncapi.bindings.redis.v0._1_0.channel.RedisChannelBinding;
import com.asyncapi.v3.SerDeTest;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Nested;

@Nested
public abstract class RedisChannelBindingTest extends SerDeTest<RedisChannelBinding> {

    @NotNull
    @Override
    protected Class<RedisChannelBinding> objectClass() {
        return RedisChannelBinding.class;
    }

    @NotNull
    @Override
    protected String baseObjectJson() {
        return "/bindings/default implementation/unknown version/channel/binding.json";
    }

    @NotNull
    @Override
    protected String extendedObjectJson() {
        return "/bindings/default implementation/unknown version/channel/binding - extended.json";
    }

    @NotNull
    @Override
    protected String wronglyExtendedObjectJson() {
        return "/bindings/default implementation/unknown version/channel/binding - wrongly extended.json";
    }

    @NotNull
    @Override
    public RedisChannelBinding build() {
        return RedisBindingProvider.channel();
    }

}
