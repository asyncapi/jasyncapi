package com.asyncapi.bindings.stomp.v0._1_0.operation;

import com.asyncapi.bindings.stomp.v0._1_0.STOMPBindingProvider;
import com.asyncapi.v3.SerDeTest;
import org.jetbrains.annotations.NotNull;

public abstract class STOMPOperationBindingTest extends SerDeTest<STOMPOperationBinding> {

    @NotNull
    @Override
    protected Class<STOMPOperationBinding> objectClass() {
        return STOMPOperationBinding.class;
    }

    @NotNull
    @Override
    protected String baseObjectJson() {
        return "/bindings/default implementation/0.1.0/operation/binding.json";
    }

    @NotNull
    @Override
    protected String extendedObjectJson() {
        return "/bindings/default implementation/0.1.0/operation/binding - extended.json";
    }

    @NotNull
    @Override
    protected String wronglyExtendedObjectJson() {
        return "/bindings/default implementation/0.1.0/operation/binding - wrongly extended.json";
    }

    @NotNull
    @Override
    public STOMPOperationBinding build() {
        return STOMPBindingProvider.operation();
    }

}
