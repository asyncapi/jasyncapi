package com.asyncapi.v2._0_0.model.server

import com.asyncapi.v2.ClasspathUtils
import com.asyncapi.v2.SerDeTest
import com.asyncapi.v2._6_0.model.server.ServerVariable
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * @author Pavel Bodiachevskii
 */
class ServerVariableTest: SerDeTest<ServerVariable>() {

    override fun objectClass() = ServerVariable::class.java

    override fun baseObjectJson() = "/json/2.0.0/model/server/serverVariable.json"

    override fun extendedObjectJson() = "/json/2.0.0/model/server/serverVariable - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/2.0.0/model/server/serverVariable - wrongly extended.json"

    override fun build(): ServerVariable {
        return ServerVariable.builder()
                .enumValues(listOf("8883", "8884"))
                .description("To which port connect")
                .defaultValue("8883")
                .examples(listOf("8883", "8884"))
                .build()
    }

}
