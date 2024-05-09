package com.asyncapi.v3._0_0.jackson.model;

import com.asyncapi.schemas.asyncapi.Reference;
import com.asyncapi.v3._0_0.model.ExternalDocumentation;
import com.asyncapi.v3.jackson.ReferenceOrObjectDeserializer;

/**
 * Deserializes external documentation.
 *
 * @author Pavel Bodiachevskii
 */
public class ExternalDocumentationDeserializer extends ReferenceOrObjectDeserializer<ExternalDocumentation> {

    @Override
    public Class<ExternalDocumentation> objectTypeClass() {
        return ExternalDocumentation.class;
    }

    public Class<?> referenceClass() {
        return Reference.class;
    }

}
