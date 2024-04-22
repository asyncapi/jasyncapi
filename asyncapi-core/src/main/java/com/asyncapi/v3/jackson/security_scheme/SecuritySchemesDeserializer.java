package com.asyncapi.v3.jackson.security_scheme;

import com.asyncapi.Reference;
import com.asyncapi.v3.jackson.ListOfReferencesOrObjectsDeserializer;
import com.asyncapi.v3.security_scheme.SecurityScheme;

/**
 * Deserializes security schemes.
 *
 * @author Pavel Bodiachevskii
 */
public class SecuritySchemesDeserializer extends ListOfReferencesOrObjectsDeserializer<SecurityScheme> {

    @Override
    public Class<SecurityScheme> objectTypeClass() {
        return SecurityScheme.class;
    }

    @Override
    public Class<?> referenceClass() {
        return Reference.class;
    }

}
