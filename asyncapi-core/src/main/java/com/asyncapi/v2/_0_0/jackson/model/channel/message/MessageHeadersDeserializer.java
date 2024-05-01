package com.asyncapi.v2._0_0.jackson.model.channel.message;

import com.asyncapi.schemas.Reference;
import com.asyncapi.v2.schema.Schema;
import com.asyncapi.v2.jackson.ReferenceOrObjectDeserializer;

/**
 * Serializes message traits list.
 *
 * @author Pavel Bodiachevskii
 */
public class MessageHeadersDeserializer extends ReferenceOrObjectDeserializer<Schema> {

    @Override
    public Class<Schema> objectTypeClass() {
        return Schema.class;
    }

    public Class<?> referenceClass() {
        return Reference.class;
    }

}
