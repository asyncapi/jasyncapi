package com.asyncapi.schemas.serde.asyncapi.security.v3;

import com.asyncapi.schemas.asyncapi.Reference;
import com.asyncapi.serde.ListOfReferencesOrObjectsDeserializer;
import com.asyncapi.schemas.asyncapi.security.v3.SecurityScheme;

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
