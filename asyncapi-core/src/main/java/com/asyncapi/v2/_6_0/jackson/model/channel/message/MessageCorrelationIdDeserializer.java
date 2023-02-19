package com.asyncapi.v2._6_0.jackson.model.channel.message;

import com.asyncapi.v2._6_0.model.channel.message.CorrelationId;
import com.asyncapi.v2.jackson.ReferenceOrObjectDeserializer;

/**
 * Serializes message correlation id.
 *
 * @author Pavel Bodiachevskii
 */
public class MessageCorrelationIdDeserializer extends ReferenceOrObjectDeserializer<CorrelationId> {

    @Override
    public Class<CorrelationId> objectTypeClass() {
        return CorrelationId.class;
    }

}
