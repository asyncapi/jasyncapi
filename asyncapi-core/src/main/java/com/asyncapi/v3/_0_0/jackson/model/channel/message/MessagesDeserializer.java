package com.asyncapi.v3._0_0.jackson.model.channel.message;

import com.asyncapi.Reference;
import com.asyncapi.v3._0_0.model.channel.message.Message;
import com.asyncapi.v3.jackson.MapOfReferencesOrObjectsDeserializer;

/**
 * Serializes {@link Message} variables map.
 *
 * @version 3.0.0
 * @author Pavel Bodiachevskii
 */
public class MessagesDeserializer extends MapOfReferencesOrObjectsDeserializer<Message> {

    @Override
    public Class<Message> objectTypeClass() {
        return Message.class;
    }

    @Override
    public Class<?> referenceClass() {
        return Reference.class;
    }

}
