package com.asyncapi.v2._6_0.jackson.model.component;

import com.asyncapi.v2._6_0.jackson.MapOfReferencesOrObjectsDeserializer;
import com.asyncapi.v2._6_0.model.channel.message.CorrelationId;
import com.asyncapi.v2._6_0.model.channel.operation.OperationTrait;

public class ComponentsOperationTraitsDeserializer extends MapOfReferencesOrObjectsDeserializer<OperationTrait> {

    @Override
    public Class<OperationTrait> objectTypeClass() {
        return OperationTrait.class;
    }

}
