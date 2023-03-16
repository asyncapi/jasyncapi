package com.asyncapi.v2._6_0.jackson.model.channel.message;

import com.asyncapi.v2._6_0.model.Reference;
import com.asyncapi.v2._6_0.model.channel.message.Message;
import com.asyncapi.v2.jackson.ListOfReferencesOrObjectsDeserializer;

/**
 * Serializes messages list.
 *
 * @author Pavel Bodiachevskii
 */
public class MessagesDeserializer extends ListOfReferencesOrObjectsDeserializer<Message> {

    @Override
    public Class<Message> objectTypeClass() {
        return Message.class;
    }

    @Override
    public Class<?> referenceClass() {
        return Reference.class;
    }

}
