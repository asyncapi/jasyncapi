package com.asyncapi.v2._6_0.jackson.model.component;

import com.asyncapi.v2.Reference;
import com.asyncapi.v2.schema.Schema;
import com.asyncapi.v2.jackson.MapOfReferencesOrObjectsDeserializer;

public class ComponentsSchemasDeserializer extends MapOfReferencesOrObjectsDeserializer<Schema> {

    @Override
    public Class<Schema> objectTypeClass() {
        return Schema.class;
    }

    @Override
    public Class<?> referenceClass() {
        return Reference.class;
    }

}
