package com.asyncapi.v2._6_0.jackson.model.component;

import com.asyncapi.v2._6_0.jackson.MapOfReferencesOrObjectsDeserializer;
import com.asyncapi.v2._6_0.model.channel.message.CorrelationId;
import com.asyncapi.v2._6_0.model.channel.message.MessageTrait;

public class ComponentsMessageTraitsDeserializer extends MapOfReferencesOrObjectsDeserializer<MessageTrait> {

    @Override
    public Class<MessageTrait> objectTypeClass() {
        return MessageTrait.class;
    }

}
