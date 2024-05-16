package com.asyncapi.v3._0_0.jackson.model.component;

import com.asyncapi.schemas.asyncapi.Reference;
import com.asyncapi.v3._0_0.model.channel.message.CorrelationId;
import com.asyncapi.serde.MapOfReferencesOrObjectsDeserializer;

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
