package com.asyncapi.v3._0_0.jackson.model.component;

import com.asyncapi.schemas.asyncapi.Reference;
import com.asyncapi.v3._0_0.model.operation.reply.OperationReply;
import com.asyncapi.serde.MapOfReferencesOrObjectsDeserializer;

public class ComponentsRepliesDeserializer extends MapOfReferencesOrObjectsDeserializer<OperationReply> {

    @Override
    public Class<OperationReply> objectTypeClass() {
        return OperationReply.class;
    }

    @Override
    public Class<?> referenceClass() {
        return Reference.class;
    }

}
