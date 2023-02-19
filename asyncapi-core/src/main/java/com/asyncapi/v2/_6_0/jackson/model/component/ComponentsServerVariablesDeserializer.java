package com.asyncapi.v2._6_0.jackson.model.component;

import com.asyncapi.v2.jackson.MapOfReferencesOrObjectsDeserializer;
import com.asyncapi.v2._6_0.model.server.ServerVariable;

public class ComponentsServerVariablesDeserializer extends MapOfReferencesOrObjectsDeserializer<ServerVariable> {

    @Override
    public Class<ServerVariable> objectTypeClass() {
        return ServerVariable.class;
    }

}
