package com.asyncapi.v3._0_0.jackson.model.component;

import com.asyncapi.schemas.asyncapi.Reference;
import com.asyncapi.serde.MapOfReferencesOrObjectsDeserializer;
import com.asyncapi.schemas.asyncapi.security.v3.SecurityScheme;

public class ComponentsSecuritySchemesDeserializer extends MapOfReferencesOrObjectsDeserializer<SecurityScheme> {

    @Override
    public Class<SecurityScheme> objectTypeClass() {
        return SecurityScheme.class;
    }

    @Override
    public Class<?> referenceClass() {
        return Reference.class;
    }

}
