package com.asyncapi.v3._0_0.jackson.model.component;

import com.asyncapi.schemas.Reference;
import com.asyncapi.v3._0_0.model.server.Server;
import com.asyncapi.v3.jackson.MapOfReferencesOrObjectsDeserializer;

public class ComponentsServersDeserializer extends MapOfReferencesOrObjectsDeserializer<Server> {

    @Override
    public Class<Server> objectTypeClass() {
        return Server.class;
    }

    @Override
    public Class<?> referenceClass() {
        return Reference.class;
    }

}
