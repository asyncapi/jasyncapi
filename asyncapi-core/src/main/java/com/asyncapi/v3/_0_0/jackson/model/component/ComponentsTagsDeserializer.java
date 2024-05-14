package com.asyncapi.v3._0_0.jackson.model.component;

import com.asyncapi.schemas.asyncapi.Reference;
import com.asyncapi.v3._0_0.model.Tag;
import com.asyncapi.serde.MapOfReferencesOrObjectsDeserializer;

public class ComponentsTagsDeserializer extends MapOfReferencesOrObjectsDeserializer<Tag> {

    @Override
    public Class<Tag> objectTypeClass() {
        return Tag.class;
    }

    @Override
    public Class<?> referenceClass() {
        return Reference.class;
    }

}
