package com.asyncapi.bindings.stomp.withoutversion.server;

import com.asyncapi.bindings.stomp.v0._1_0.server.STOMPServerBinding;
import com.asyncapi.v3.SerDeTest;
import org.jetbrains.annotations.NotNull;

public abstract class STOMPServerBindingTest extends SerDeTest<STOMPServerBinding> {

    @NotNull
    @Override
    protected Class<STOMPServerBinding> objectClass() {
        return STOMPServerBinding.class;
    }

    @NotNull
    @Override
    protected String baseObjectJson() {
        return "/bindings/default implementation/without version/server/binding.json";
    }

    @NotNull
    @Override
    protected String extendedObjectJson() {
        return "/bindings/default implementation/without version/server/binding - extended.json";
    }

    @NotNull
    @Override
    protected String wronglyExtendedObjectJson() {
        return "/bindings/default implementation/without version/server/binding - wrongly extended.json";
    }

    @NotNull
    @Override
    public STOMPServerBinding build() {
        return new STOMPServerBinding();
    }

}
