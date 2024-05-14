package com.asyncapi.v2._6_0.jackson.model.channel.message;

import com.asyncapi.schemas.asyncapi.AsyncAPISchema;
import com.asyncapi.schemas.asyncapi.Reference;
import com.asyncapi.serde.ReferenceOrObjectDeserializer;

/**
 * Serializes message traits list.
 *
 * @author Pavel Bodiachevskii
 */
public class MessageHeadersDeserializer extends ReferenceOrObjectDeserializer<AsyncAPISchema> {

    @Override
    public Class<AsyncAPISchema> objectTypeClass() {
        return AsyncAPISchema.class;
    }

    public Class<?> referenceClass() {
        return Reference.class;
    }

}
