package com.asyncapi.v3._0_0.jackson.model.component;

import com.asyncapi.schemas.asyncapi.Reference;
import com.asyncapi.v3._0_0.model.server.Server;
import com.asyncapi.serde.MapOfReferencesOrObjectsDeserializer;

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
