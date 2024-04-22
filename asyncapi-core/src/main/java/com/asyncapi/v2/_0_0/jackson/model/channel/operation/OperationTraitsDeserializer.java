package com.asyncapi.v2._0_0.jackson.model.channel.operation;

import com.asyncapi.Reference;
import com.asyncapi.v2._0_0.model.channel.operation.OperationTrait;
import com.asyncapi.v2.jackson.ListOfReferencesOrObjectsDeserializer;

/**
 * Serializes operation traits list.
 *
 * @author Pavel Bodiachevskii
 */
public class OperationTraitsDeserializer extends ListOfReferencesOrObjectsDeserializer<OperationTrait> {

    @Override
    public Class<OperationTrait> objectTypeClass() {
        return OperationTrait.class;
    }

    @Override
    public Class<?> referenceClass() {
        return Reference.class;
    }

}
