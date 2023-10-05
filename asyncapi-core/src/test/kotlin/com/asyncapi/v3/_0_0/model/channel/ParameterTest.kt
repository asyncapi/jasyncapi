package com.asyncapi.v3._0_0.model.channel

import com.asyncapi.v3.SerDeTest

/**
 * @version 3.0.0
 * @author Pavel Bodiachevskii
 */
class ParameterTest: SerDeTest<Parameter>() {

    override fun objectClass() = Parameter::class.java

    override fun baseObjectJson() = "/json/v3/3.0.0/model/channel/parameter.json"

    override fun extendedObjectJson() = "/json/v3/3.0.0/model/channel/parameter - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v3/3.0.0/model/channel/parameter - wrongly extended.json"

    override fun build(): Parameter {
        return Parameter.builder()
                .description("Id of the user.")
                .defaultValue("0e822ca6-5311-4d4c-b409-993a1820e689")
                .enumValues(listOf("0e822ca6-5311-4d4c-b409-993a1820e689", "381f5ddc-75c6-4c21-9ec1-3919ed345be9", "70559d88-31a5-4ef2-8c34-7fbd04057ed5", "c6dc0047-a90d-4efa-95e3-a272282934e0"))
                .examples(listOf("0e822ca6-5311-4d4c-b409-993a1820e689", "381f5ddc-75c6-4c21-9ec1-3919ed345be9", "70559d88-31a5-4ef2-8c34-7fbd04057ed5", "c6dc0047-a90d-4efa-95e3-a272282934e0"))
                .location("\$message.payload#/user/id")
                .build()
    }

}
