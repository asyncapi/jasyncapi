package com.asyncapi.v3._0_0.jackson.model.component;

import com.asyncapi.schemas.Reference;
import com.asyncapi.v3._0_0.model.channel.message.MessageTrait;
import com.asyncapi.v3.jackson.MapOfReferencesOrObjectsDeserializer;

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
