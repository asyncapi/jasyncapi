package com.asyncapi.v2._6_0.jackson.model.component;

import com.asyncapi.schemas.Reference;
import com.asyncapi.schemas.AsyncAPISchema;
import com.asyncapi.v2.jackson.MapOfReferencesOrObjectsDeserializer;

public class ComponentsSchemasDeserializer extends MapOfReferencesOrObjectsDeserializer<AsyncAPISchema> {

    @Override
    public Class<AsyncAPISchema> objectTypeClass() {
        return AsyncAPISchema.class;
    }

    @Override
    public Class<?> referenceClass() {
        return Reference.class;
    }

}
