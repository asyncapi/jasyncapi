package com.asyncapi.v2._0_0.model.channel

import com.asyncapi.v2.SerDeTest
import com.asyncapi.v2._0_0.model.schema.Schema

/**
 * @author Pavel Bodiachevskii
 */
class ParameterTest: SerDeTest<Parameter>() {

    override fun objectClass() = Parameter::class.java

    override fun baseObjectJson() = "/json/2.0.0/model/channel/parameter.json"

    override fun extendedObjectJson() = "/json/2.0.0/model/channel/parameter - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/2.0.0/model/channel/parameter - wrongly extended.json"

    override fun build(): Parameter {
        return Parameter.builder()
                .description("Id of the user.")
                .location("\$message.payload#/user/id")
                .schema(Schema.builder().type("string").build())
                .build()
    }

}
