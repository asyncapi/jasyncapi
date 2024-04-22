package com.asyncapi.v3._0_0.jackson.model.component;

import com.asyncapi.Reference;
import com.asyncapi.v3._0_0.model.channel.Channel;
import com.asyncapi.v3.jackson.MapOfReferencesOrObjectsDeserializer;

public class ComponentsChannelsDeserializer extends MapOfReferencesOrObjectsDeserializer<Channel> {

    @Override
    public Class<Channel> objectTypeClass() {
        return Channel.class;
    }

    @Override
    public Class<?> referenceClass() {
        return Reference.class;
    }

}
