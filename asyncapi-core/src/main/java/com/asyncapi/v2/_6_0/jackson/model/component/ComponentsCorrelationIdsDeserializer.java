package com.asyncapi.v2._6_0.jackson.model.component;

import com.asyncapi.Reference;
import com.asyncapi.v2._6_0.model.channel.message.CorrelationId;
import com.asyncapi.v2.jackson.MapOfReferencesOrObjectsDeserializer;

public class ComponentsCorrelationIdsDeserializer extends MapOfReferencesOrObjectsDeserializer<CorrelationId> {

    @Override
    public Class<CorrelationId> objectTypeClass() {
        return CorrelationId.class;
    }

    @Override
    public Class<?> referenceClass() {
        return Reference.class;
    }

}
