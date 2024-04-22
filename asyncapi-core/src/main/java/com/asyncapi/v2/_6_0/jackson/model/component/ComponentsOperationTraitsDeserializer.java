package com.asyncapi.v2._6_0.jackson.model.component;

import com.asyncapi.Reference;
import com.asyncapi.v2._6_0.model.channel.operation.OperationTrait;
import com.asyncapi.v2.jackson.MapOfReferencesOrObjectsDeserializer;

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
