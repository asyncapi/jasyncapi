package com.asyncapi.v3._0_0.jackson.model.operation.reply;

import com.asyncapi.schemas.asyncapi.Reference;
import com.asyncapi.v3._0_0.model.operation.reply.OperationReplyAddress;
import com.asyncapi.serde.ReferenceOrObjectDeserializer;

/**
 * Serializes operation reply address
 * @author Pavel Bodiachevskii
 */
public class OperationReplyAddressDeserializer extends ReferenceOrObjectDeserializer<OperationReplyAddress> {

    @Override
    public Class<OperationReplyAddress> objectTypeClass() {
        return OperationReplyAddress.class;
    }

    public Class<?> referenceClass() {
        return Reference.class;
    }

}
