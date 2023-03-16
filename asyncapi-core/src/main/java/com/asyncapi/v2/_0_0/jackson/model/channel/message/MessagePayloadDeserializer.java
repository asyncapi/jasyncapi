package com.asyncapi.v2._0_0.jackson.model.channel.message;

import com.asyncapi.v2.schema.Schema;
import com.asyncapi.v2.jackson.ObjectDeserializer;

/**
 * Serializes message traits list.
 *
 * @author Pavel Bodiachevskii
 */
public class MessagePayloadDeserializer extends ObjectDeserializer<Schema> {

    @Override
    public Class<Schema> objectTypeClass() {
        return Schema.class;
    }

}
