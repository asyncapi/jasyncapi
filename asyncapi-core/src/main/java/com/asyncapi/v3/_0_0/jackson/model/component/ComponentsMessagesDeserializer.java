package com.asyncapi.v3._0_0.jackson.model.component;

import com.asyncapi.v3.Reference;
import com.asyncapi.v3._0_0.model.channel.message.Message;
import com.asyncapi.v3.jackson.MapOfReferencesOrObjectsDeserializer;

public class ComponentsMessagesDeserializer extends MapOfReferencesOrObjectsDeserializer<Message> {

    @Override
    public Class<Message> objectTypeClass() {
        return Message.class;
    }

    @Override
    public Class<?> referenceClass() {
        return Reference.class;
    }

}
