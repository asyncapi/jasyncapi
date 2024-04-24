package com.asyncapi.bindings.stomp.v0._1_0.message;

import com.asyncapi.bindings.stomp.v0._1_0.STOMPBindingProvider;
import com.asyncapi.v3.SerDeTest;
import org.jetbrains.annotations.NotNull;

public abstract class STOMPMessageBindingTest extends SerDeTest<STOMPMessageBinding> {

    @NotNull
    @Override
    protected Class<STOMPMessageBinding> objectClass() {
        return STOMPMessageBinding.class;
    }

    @NotNull
    @Override
    protected String baseObjectJson() {
        return "/bindings/default implementation/0.1.0/message/binding.json";
    }

    @NotNull
    @Override
    protected String extendedObjectJson() {
        return "/bindings/default implementation/0.1.0/message/binding - extended.json";
    }

    @NotNull
    @Override
    protected String wronglyExtendedObjectJson() {
        return "/bindings/default implementation/0.1.0/message/binding - wrongly extended.json";
    }

    @NotNull
    @Override
    public STOMPMessageBinding build() {
        return STOMPBindingProvider.message();
    }

}
