package com.asyncapi.v2._6_0.jackson.model.component;

import com.asyncapi.v2._6_0.model.Reference;
import com.asyncapi.v2.jackson.MapOfReferencesOrObjectsDeserializer;
import com.asyncapi.v2._6_0.model.channel.message.Message;

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
