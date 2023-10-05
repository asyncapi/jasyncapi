package com.asyncapi.v2._6_0.model.server

import com.asyncapi.v2.SerDeTest

/**
 * @version 2.6.0
 * @author Pavel Bodiachevskii
 */
class ServerVariableTest: SerDeTest<ServerVariable>() {

    override fun objectClass() = ServerVariable::class.java

    override fun baseObjectJson() = "/json/v2/2.6.0/model/server/serverVariable.json"

    override fun extendedObjectJson() = "/json/v2/2.6.0/model/server/serverVariable - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v2/2.6.0/model/server/serverVariable - wrongly extended.json"

    override fun build(): ServerVariable {
        return ServerVariable.builder()
                .enumValues(listOf("8883", "8884"))
                .description("To which port connect")
                .defaultValue("8883")
                .examples(listOf("8883", "8884"))
                .build()
    }

}
