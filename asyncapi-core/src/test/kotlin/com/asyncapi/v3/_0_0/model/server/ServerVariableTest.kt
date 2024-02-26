package com.asyncapi.v3._0_0.model.server

import com.asyncapi.v3.SerDeTest

/**
 * @version 3.0.0
 * @author Pavel Bodiachevskii
 */
class ServerVariableTest: SerDeTest<ServerVariable>() {

    override fun objectClass() = ServerVariable::class.java

    override fun baseObjectJson() = "/json/v3/3.0.0/model/server/serverVariable.json"

    override fun extendedObjectJson() = "/json/v3/3.0.0/model/server/serverVariable - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v3/3.0.0/model/server/serverVariable - wrongly extended.json"

    override fun build(): ServerVariable {
        return ServerVariable.builder()
                .enumValues(listOf("8883", "8884"))
                .description("To which port connect")
                .defaultValue("8883")
                .examples(listOf("8883", "8884"))
                .build()
    }

}
