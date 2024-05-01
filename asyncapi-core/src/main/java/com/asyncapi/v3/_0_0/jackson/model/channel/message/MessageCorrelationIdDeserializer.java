package com.asyncapi.v3._0_0.jackson.model.channel.message;

import com.asyncapi.schemas.Reference;
import com.asyncapi.v3._0_0.model.channel.message.CorrelationId;
import com.asyncapi.v3.jackson.ReferenceOrObjectDeserializer;

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

    public Class<?> referenceClass() {
        return Reference.class;
    }

}
