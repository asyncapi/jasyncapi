package com.asyncapi.v2._0_0.jackson.model.channel.message;

import com.asyncapi.schemas.asyncapi.Reference;
import com.asyncapi.v2._0_0.model.channel.message.MessageTrait;
import com.asyncapi.serde.ListOfReferencesOrObjectsDeserializer;

/**
 * Serializes message traits list.
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
