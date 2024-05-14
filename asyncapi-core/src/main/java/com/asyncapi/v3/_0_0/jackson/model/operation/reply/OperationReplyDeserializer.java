package com.asyncapi.v3._0_0.jackson.model.operation.reply;

import com.asyncapi.schemas.asyncapi.Reference;
import com.asyncapi.v3._0_0.model.operation.reply.OperationReply;
import com.asyncapi.serde.ReferenceOrObjectDeserializer;

/**
 * Serializes operation reply
 * @author Pavel Bodiachevskii
 */
public class OperationReplyDeserializer extends ReferenceOrObjectDeserializer<OperationReply> {

    @Override
    public Class<OperationReply> objectTypeClass() {
        return OperationReply.class;
    }

    public Class<?> referenceClass() {
        return Reference.class;
    }

}
