package com.asyncapi.v2._0_0.jackson.model.channel.message;

import com.asyncapi.schemas.asyncapi.AsyncAPISchema;
import com.asyncapi.v2.jackson.ObjectDeserializer;

/**
 * Serializes message traits list.
 *
 * @author Pavel Bodiachevskii
 */
public class MessagePayloadDeserializer extends ObjectDeserializer<AsyncAPISchema> {

    @Override
    public Class<AsyncAPISchema> objectTypeClass() {
        return AsyncAPISchema.class;
    }

}
