package com.asyncapi.v3._0_0.jackson.model.component;

import com.asyncapi.schemas.asyncapi.Reference;
import com.asyncapi.v3._0_0.model.operation.Operation;
import com.asyncapi.v3.jackson.MapOfReferencesOrObjectsDeserializer;

public class ComponentsOperationsDeserializer extends MapOfReferencesOrObjectsDeserializer<Operation> {

    @Override
    public Class<Operation> objectTypeClass() {
        return Operation.class;
    }

    @Override
    public Class<?> referenceClass() {
        return Reference.class;
    }

}
