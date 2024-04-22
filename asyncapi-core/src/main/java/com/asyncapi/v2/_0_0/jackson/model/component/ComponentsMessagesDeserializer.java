package com.asyncapi.v2._0_0.jackson.model.component;

import com.asyncapi.Reference;
import com.asyncapi.v2._0_0.model.channel.message.Message;
import com.asyncapi.v2.jackson.MapOfReferencesOrObjectsDeserializer;

/**
 * Serializes component security schemes map.
 *
 * @author Pavel Bodiachevskii
 */
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
