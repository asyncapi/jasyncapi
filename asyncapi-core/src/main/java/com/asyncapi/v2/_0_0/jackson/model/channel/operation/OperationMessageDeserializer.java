package com.asyncapi.v2._0_0.jackson.model.channel.operation;

import com.asyncapi.v2._0_0.model.channel.message.Message;
import com.asyncapi.v2.jackson.ReferenceOrObjectDeserializer;

/**
 * Serializes operation message list.
 *
 * @author Pavel Bodiachevskii
 */
public class OperationMessageDeserializer extends ReferenceOrObjectDeserializer<Message> {

    @Override
    public Class<Message> objectTypeClass() {
        return Message.class;
    }

}
