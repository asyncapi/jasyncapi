package com.asyncapi.v3._0_0.jackson.model.channel.message;

import com.asyncapi.v3.Reference;
import com.asyncapi.v3._0_0.model.channel.message.MessageTrait;
import com.asyncapi.v3.jackson.ListOfReferencesOrObjectsDeserializer;

/**
 * Deserializes message traits.
 *
 * @author Pavel Bodiachevskii
 */
public class MessageTraitsDeserializer extends ListOfReferencesOrObjectsDeserializer<MessageTrait> {

    @Override
    public Class<MessageTrait> objectTypeClass() {
        return MessageTrait.class;
    }

    @Override
    public Class<?> referenceClass() {
        return Reference.class;
    }

}
