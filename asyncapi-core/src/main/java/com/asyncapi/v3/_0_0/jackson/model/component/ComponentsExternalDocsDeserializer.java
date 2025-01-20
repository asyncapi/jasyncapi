package com.asyncapi.v3._0_0.jackson.model.component;

import com.asyncapi.schemas.asyncapi.Reference;
import com.asyncapi.v3._0_0.model.ExternalDocumentation;
import com.asyncapi.serde.MapOfReferencesOrObjectsDeserializer;

public class ComponentsExternalDocsDeserializer extends MapOfReferencesOrObjectsDeserializer<ExternalDocumentation> {

    @Override
    public Class<ExternalDocumentation> objectTypeClass() {
        return ExternalDocumentation.class;
    }

    @Override
    public Class<?> referenceClass() {
        return Reference.class;
    }

}
