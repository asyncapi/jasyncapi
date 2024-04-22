package com.asyncapi.v3._0_0.jackson.model.component;

import com.asyncapi.Reference;
import com.asyncapi.v3.jackson.MapOfReferencesOrObjectsDeserializer;
import com.asyncapi.v3.security_scheme.SecurityScheme;

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
