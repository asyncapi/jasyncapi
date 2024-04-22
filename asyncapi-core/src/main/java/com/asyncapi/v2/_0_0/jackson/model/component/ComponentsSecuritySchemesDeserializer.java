package com.asyncapi.v2._0_0.jackson.model.component;

import com.asyncapi.Reference;
import com.asyncapi.v2.jackson.MapOfReferencesOrObjectsDeserializer;
import com.asyncapi.v2.security_scheme.SecurityScheme;

/**
 * Serializes component security schemes map.
 *
 * @author Pavel Bodiachevskii
 */
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
