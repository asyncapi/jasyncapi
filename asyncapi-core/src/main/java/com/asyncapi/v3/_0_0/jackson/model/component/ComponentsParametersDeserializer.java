package com.asyncapi.v3._0_0.jackson.model.component;

import com.asyncapi.schemas.asyncapi.Reference;
import com.asyncapi.v3._0_0.model.channel.Parameter;
import com.asyncapi.v3.jackson.MapOfReferencesOrObjectsDeserializer;

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
