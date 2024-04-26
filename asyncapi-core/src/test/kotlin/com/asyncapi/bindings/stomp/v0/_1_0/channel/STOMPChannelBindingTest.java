package com.asyncapi.bindings.stomp.v0._1_0.channel;

import com.asyncapi.bindings.stomp.v0._1_0.STOMPBindingProvider;
import com.asyncapi.v3.SerDeTest;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Nested;

@Nested
public abstract class STOMPChannelBindingTest extends SerDeTest<STOMPChannelBinding> {

    @NotNull
    @Override
    protected Class<STOMPChannelBinding> objectClass() {
        return STOMPChannelBinding.class;
    }

    @NotNull
    @Override
    protected String baseObjectJson() {
        return "/bindings/default implementation/0.1.0/channel/binding.json";
    }

    @NotNull
    @Override
    protected String extendedObjectJson() {
        return "/bindings/default implementation/0.1.0/channel/binding - extended.json";
    }

    @NotNull
    @Override
    protected String wronglyExtendedObjectJson() {
        return "/bindings/default implementation/0.1.0/channel/binding - wrongly extended.json";
    }

    @NotNull
    @Override
    public STOMPChannelBinding build() {
        return STOMPBindingProvider.channel();
    }

}