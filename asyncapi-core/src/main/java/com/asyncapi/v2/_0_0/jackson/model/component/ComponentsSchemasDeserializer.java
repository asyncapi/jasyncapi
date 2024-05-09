package com.asyncapi.v2._0_0.jackson.model.component;

import com.asyncapi.schemas.asyncapi.Reference;
import com.asyncapi.schemas.asyncapi.AsyncAPISchema;
import com.asyncapi.v2.jackson.MapOfReferencesOrObjectsDeserializer;

/**
 * Serializes component schemas map.
 *
 * @author Pavel Bodiachevskii
 */
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
