package com.asyncapi.v2._6_0.jackson.model.component;

import com.asyncapi.schemas.asyncapi.Reference;
import com.asyncapi.v2._6_0.model.server.Server;
import com.asyncapi.v2.jackson.MapOfReferencesOrObjectsDeserializer;

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
