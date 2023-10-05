package com.asyncapi.v3._0_0.jackson.model;

import com.asyncapi.v3.Reference;
import com.asyncapi.v3._0_0.model.Tag;
import com.asyncapi.v3.jackson.ListOfReferencesOrObjectsDeserializer;

/**
 * Deserializes tags.
 *
 * @author Pavel Bodiachevskii
 */
public class TagsDeserializer extends ListOfReferencesOrObjectsDeserializer<Tag> {

    @Override
    public Class<Tag> objectTypeClass() {
        return Tag.class;
    }

    @Override
    public Class<?> referenceClass() {
        return Reference.class;
    }

}
