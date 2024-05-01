package com.asyncapi.v3._0_0.model

import com.asyncapi.schemas.Reference
import com.asyncapi.v3.SerDeTest
import com.asyncapi.v3._0_0.model.channel.ChannelTest
import com.asyncapi.v3._0_0.model.channel.ChannelTestWithReference
import com.asyncapi.v3._0_0.model.component.ComponentsTest
import com.asyncapi.v3._0_0.model.info.InfoTest
import com.asyncapi.v3._0_0.model.operation.OperationTest
import com.asyncapi.v3._0_0.model.operation.OperationTestWithReference
import com.asyncapi.v3._0_0.model.server.ServerTest
import com.asyncapi.v3._0_0.model.server.ServerTestWithReference

/**
 * @author Pavel Bodiachevskii
 */
class AsyncAPITest: SerDeTest<AsyncAPI>() {

    override fun objectClass() = AsyncAPI::class.java

    override fun baseObjectJson() = "/json/v3/3.0.0/model/asyncapi.json"

    override fun extendedObjectJson() = "/json/v3/3.0.0/model/asyncapi - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v3/3.0.0/model/asyncapi - wrongly extended.json"

    override fun build(): AsyncAPI {
        return AsyncAPI(
                "3.0.0",
                "https://www.asyncapi.com",
                "application/json",
                InfoTest().build(),
                mapOf(
                        Pair("server 1", ServerTest().build()),
                        Pair("server 2", ServerTestWithReference().build()),
                        Pair("server 3",
                            Reference("#/components/servers/server")
                        )
                ),
                mapOf(
                        Pair("channel 1", ChannelTest().build()),
                        Pair("channel 2", ChannelTestWithReference().build()),
                        Pair("channel 3",
                            Reference("#/components/channels/channel")
                        )
                ),
                mapOf(
                        Pair("operation 1", OperationTest().build()),
                        Pair("operation 2", OperationTestWithReference().build()),
                        Pair("operation 3",
                            Reference("#/components/operations/operation")
                        )
                ),
                ComponentsTest().build()
        )
    }

}
