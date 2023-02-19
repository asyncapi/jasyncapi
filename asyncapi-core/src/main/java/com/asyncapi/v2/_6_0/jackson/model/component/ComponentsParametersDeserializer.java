package com.asyncapi.v2._6_0.jackson.model.component;

import com.asyncapi.v2.jackson.MapOfReferencesOrObjectsDeserializer;
import com.asyncapi.v2._6_0.model.channel.Parameter;

public class ComponentsParametersDeserializer extends MapOfReferencesOrObjectsDeserializer<Parameter> {

    @Override
    public Class<Parameter> objectTypeClass() {
        return Parameter.class;
    }

}
