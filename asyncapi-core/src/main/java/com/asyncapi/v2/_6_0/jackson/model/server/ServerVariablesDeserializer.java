package com.asyncapi.v2._6_0.jackson.model.server;

import com.asyncapi.schemas.asyncapi.Reference;
import com.asyncapi.v2._6_0.model.server.ServerVariable;
import com.asyncapi.v2.jackson.MapOfReferencesOrObjectsDeserializer;

/**
 * Serializes {@link com.asyncapi.v2._6_0.model.server.Server} variables map.
 *
 * @version 2.6.0
 * @author Pavel Bodiachevskii
 */
public class ServerVariablesDeserializer extends MapOfReferencesOrObjectsDeserializer<ServerVariable> {

    @Override
    public Class<ServerVariable> objectTypeClass() {
        return ServerVariable.class;
    }

    @Override
    public Class<?> referenceClass() {
        return Reference.class;
    }

}
