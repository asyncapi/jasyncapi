package com.asyncapi.v3._0_0.jackson.model.channel;

import com.asyncapi.Reference;
import com.asyncapi.v3._0_0.model.channel.Parameter;
import com.asyncapi.v3.jackson.MapOfReferencesOrObjectsDeserializer;

/**
 * Serializes {@link com.asyncapi.v3._0_0.model.channel.Parameter} variables map.
 *
 * @version 3.0.0
 * @author Pavel Bodiachevskii
 */
public class ChannelParametersDeserializer extends MapOfReferencesOrObjectsDeserializer<Parameter> {

    @Override
    public Class<Parameter> objectTypeClass() {
        return Parameter.class;
    }

    @Override
    public Class<?> referenceClass() {
        return Reference.class;
    }

}
