package com.asyncapi.bindings.stomp.latest.operation;

import com.asyncapi.bindings.stomp._1_0.STOMPBindingProvider;
import com.asyncapi.bindings.stomp.v0._1_0.operation.STOMPOperationBinding;
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
        return "/bindings/stomp/latest/operation/binding.json";
    }

    @NotNull
    @Override
    protected String extendedObjectJson() {
        return "/bindings/stomp/latest/operation/binding - extended.json";
    }

    @NotNull
    @Override
    protected String wronglyExtendedObjectJson() {
        return "/bindings/stomp/latest/operation/binding - wrongly extended.json";
    }

    @NotNull
    @Override
    public STOMPOperationBinding build() {
        return STOMPBindingProvider.operation();
    }

}
