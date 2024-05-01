package com.asyncapi.v3._0_0.jackson.model.component;

import com.asyncapi.schemas.Reference;
import com.asyncapi.v3._0_0.model.operation.reply.OperationReplyAddress;
import com.asyncapi.v3.jackson.MapOfReferencesOrObjectsDeserializer;

public class ComponentsReplyAddressesDeserializer extends MapOfReferencesOrObjectsDeserializer<OperationReplyAddress> {

    @Override
    public Class<OperationReplyAddress> objectTypeClass() {
        return OperationReplyAddress.class;
    }

    @Override
    public Class<?> referenceClass() {
        return Reference.class;
    }

}
