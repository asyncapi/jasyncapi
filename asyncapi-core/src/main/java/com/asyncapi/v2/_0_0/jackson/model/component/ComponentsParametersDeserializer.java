package com.asyncapi.v2._0_0.jackson.model.component;

import com.asyncapi.v2.Reference;
import com.asyncapi.v2._0_0.model.channel.Parameter;
import com.asyncapi.v2.jackson.MapOfReferencesOrObjectsDeserializer;

/**
 * Serializes channel parameters map.
 *
 * @author Pavel Bodiachevskii
 */
public class ComponentsParametersDeserializer extends MapOfReferencesOrObjectsDeserializer<Parameter> {

    @Override
    public Class<Parameter> objectTypeClass() {
        return Parameter.class;
    }

    @Override
    public Class<?> referenceClass() {
        return Reference.class;
    }

}
