package com.asyncapi.v2._6_0.jackson.model.component;

import com.asyncapi.Reference;
import com.asyncapi.v2._6_0.model.server.ServerVariable;
import com.asyncapi.v2.jackson.MapOfReferencesOrObjectsDeserializer;

public class ComponentsServerVariablesDeserializer extends MapOfReferencesOrObjectsDeserializer<ServerVariable> {

    @Override
    public Class<ServerVariable> objectTypeClass() {
        return ServerVariable.class;
    }

    @Override
    public Class<?> referenceClass() {
        return Reference.class;
    }

}
