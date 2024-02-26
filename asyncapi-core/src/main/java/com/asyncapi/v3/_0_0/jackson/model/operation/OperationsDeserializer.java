package com.asyncapi.v3._0_0.jackson.model.operation;

import com.asyncapi.v3.Reference;
import com.asyncapi.v3._0_0.model.operation.Operation;
import com.asyncapi.v3.jackson.MapOfReferencesOrObjectsDeserializer;

/**
 * Serializes component operations map.
 *
 * @author Pavel Bodiachevskii
 */
public class OperationsDeserializer extends MapOfReferencesOrObjectsDeserializer<Operation> {

    @Override
    public Class<Operation> objectTypeClass() {
        return Operation.class;
    }

    @Override
    public Class<?> referenceClass() {
        return Reference.class;
    }

}
