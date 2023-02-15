package com.asyncapi.v2._6_0.jackson.model.component;

import com.asyncapi.v2._6_0.jackson.MapOfReferencesOrObjectsDeserializer;
import com.asyncapi.v2._6_0.model.schema.Schema;

public class ComponentsSchemasDeserializer extends MapOfReferencesOrObjectsDeserializer<Schema> {

    @Override
    public Class<Schema> objectTypeClass() {
        return Schema.class;
    }

}
