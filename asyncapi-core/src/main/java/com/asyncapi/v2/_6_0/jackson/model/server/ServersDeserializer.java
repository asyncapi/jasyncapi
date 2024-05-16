package com.asyncapi.v2._6_0.jackson.model.server;

import com.asyncapi.schemas.asyncapi.Reference;
import com.asyncapi.v2._6_0.model.server.Server;
import com.asyncapi.serde.MapOfReferencesOrObjectsDeserializer;

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
