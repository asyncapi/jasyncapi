package com.asyncapi.v2._6_0.jackson.model.server;

import com.asyncapi.v2._6_0.model.Reference;
import com.asyncapi.v2._6_0.model.server.Server;
import com.asyncapi.v2.jackson.MapOfReferencesOrObjectsDeserializer;

/**
 * Serializes component servers map.
 *
 * @author Pavel Bodiachevskii
 */
public class ServersDeserializer extends MapOfReferencesOrObjectsDeserializer<Server> {

    @Override
    public Class<Server> objectTypeClass() {
        return Server.class;
    }

    @Override
    public Class<?> referenceClass() {
        return Reference.class;
    }

}
