package com.asyncapi.v2._6_0.model.channel

import com.asyncapi.schemas.Reference
import com.asyncapi.v2.SerDeTest
import com.asyncapi.v2.schema.Schema

class ParameterWithReferenceToSchemaTest: SerDeTest<Parameter>() {

    override fun objectClass() = Parameter::class.java

    override fun baseObjectJson() = "/json/v2/2.6.0/model/channel/parameter with reference to schema.json"

    override fun extendedObjectJson() = "/json/v2/2.6.0/model/channel/parameter with reference to schema - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v2/2.6.0/model/channel/parameter with reference to schema - wrongly extended.json"

    override fun build(): Parameter {
        return Parameter.builder()
                .description("Id of the user.")
                .location("\$message.payload#/user/id")
                .schema(Reference("#/components/schemas/userId"))
                .build()
    }

}

class ParameterWithSchemaTest: SerDeTest<Parameter>() {

    override fun objectClass() = Parameter::class.java

    override fun baseObjectJson() = "/json/v2/2.6.0/model/channel/parameter with schema.json"

    override fun extendedObjectJson() = "/json/v2/2.6.0/model/channel/parameter with schema - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v2/2.6.0/model/channel/parameter with schema - wrongly extended.json"

    override fun build(): Parameter {
        return Parameter.builder()
                .description("Id of the user.")
                .location("\$message.payload#/user/id")
                .schema(Schema.builder().type("string").build())
                .build()
    }

}