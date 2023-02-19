package com.asyncapi.v2._6_0.jackson.model.channel;

import com.asyncapi.v2._6_0.model.Reference;
import com.asyncapi.v2._6_0.model.channel.Parameter;
import com.asyncapi.v2.jackson.MapOfReferencesOrObjectsDeserializer;

/**
 * Serializes channel parameters map.
 *
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
