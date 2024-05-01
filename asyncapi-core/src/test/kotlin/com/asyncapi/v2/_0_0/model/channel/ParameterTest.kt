package com.asyncapi.v2._0_0.model.channel

import com.asyncapi.v2.SerDeTest
import com.asyncapi.schemas.AsyncAPISchema

/**
 * @author Pavel Bodiachevskii
 */
class ParameterTest: SerDeTest<Parameter>() {

    override fun objectClass() = Parameter::class.java

    override fun baseObjectJson() = "/json/v2/2.0.0/model/channel/parameter.json"

    override fun extendedObjectJson() = "/json/v2/2.0.0/model/channel/parameter - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v2/2.0.0/model/channel/parameter - wrongly extended.json"

    override fun build(): Parameter {
        return Parameter.builder()
                .description("Id of the user.")
                .location("\$message.payload#/user/id")
                .schema(AsyncAPISchema.builder().type("string").build())
                .build()
    }

}
