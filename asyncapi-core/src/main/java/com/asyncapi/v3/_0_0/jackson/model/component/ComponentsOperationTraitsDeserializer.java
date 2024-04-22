package com.asyncapi.v3._0_0.jackson.model.component;

import com.asyncapi.Reference;
import com.asyncapi.v3._0_0.model.operation.OperationTrait;
import com.asyncapi.v3.jackson.MapOfReferencesOrObjectsDeserializer;

public class ComponentsOperationTraitsDeserializer extends MapOfReferencesOrObjectsDeserializer<OperationTrait> {

    @Override
    public Class<OperationTrait> objectTypeClass() {
        return OperationTrait.class;
    }

    @Override
    public Class<?> referenceClass() {
        return Reference.class;
    }

}
