package com.asyncapi.v2._6_0.jackson.model.component;

import com.asyncapi.v2._6_0.jackson.MapOfReferencesOrObjectsDeserializer;
import com.asyncapi.v2._6_0.model.server.Server;

public class ComponentsServersDeserializer extends MapOfReferencesOrObjectsDeserializer<Server> {

    @Override
    public Class<Server> objectTypeClass() {
        return Server.class;
    }

}
