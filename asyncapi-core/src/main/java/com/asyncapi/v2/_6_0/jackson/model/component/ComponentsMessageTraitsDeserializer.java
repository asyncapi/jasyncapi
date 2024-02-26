package com.asyncapi.v2._6_0.jackson.model.component;

import com.asyncapi.v2.Reference;
import com.asyncapi.v2._6_0.model.channel.message.MessageTrait;
import com.asyncapi.v2.jackson.MapOfReferencesOrObjectsDeserializer;

public class ComponentsMessageTraitsDeserializer extends MapOfReferencesOrObjectsDeserializer<MessageTrait> {

    @Override
    public Class<MessageTrait> objectTypeClass() {
        return MessageTrait.class;
    }

    @Override
    public Class<?> referenceClass() {
        return Reference.class;
    }

}
