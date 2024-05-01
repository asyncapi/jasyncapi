package com.asyncapi.v2._6_0.jackson.model.schema;

import com.asyncapi.schemas.Reference;
import com.asyncapi.schemas.AsyncAPISchema;
import com.asyncapi.v2.jackson.ReferenceOrObjectDeserializer;

/**
 * Serializes component servers map.
 *
 * @author Pavel Bodiachevskii
 */
public class SchemaDeserializer extends ReferenceOrObjectDeserializer<AsyncAPISchema> {

    @Override
    public Class<AsyncAPISchema> objectTypeClass() {
        return AsyncAPISchema.class;
    }

    public Class<?> referenceClass() {
        return Reference.class;
    }

}
