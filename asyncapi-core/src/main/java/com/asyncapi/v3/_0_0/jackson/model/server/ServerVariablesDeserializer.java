package com.asyncapi.v3._0_0.jackson.model.server;

import com.asyncapi.v3.Reference;
import com.asyncapi.v3._0_0.model.server.ServerVariable;
import com.asyncapi.v3.jackson.MapOfReferencesOrObjectsDeserializer;

/**
 * Serializes {@link com.asyncapi.v3._0_0.model.server.Server} variables map.
 *
 * @version 3.0.0
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
