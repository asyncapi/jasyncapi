package com.asyncapi.v2._6_0.jackson.model.component;

import com.asyncapi.v2._6_0.jackson.MapOfReferencesOrObjectsDeserializer;
import com.asyncapi.v2._6_0.model.channel.message.CorrelationId;

public class ComponentsCorrelationIdsDeserializer extends MapOfReferencesOrObjectsDeserializer<CorrelationId> {

    @Override
    public Class<CorrelationId> objectTypeClass() {
        return CorrelationId.class;
    }

}
