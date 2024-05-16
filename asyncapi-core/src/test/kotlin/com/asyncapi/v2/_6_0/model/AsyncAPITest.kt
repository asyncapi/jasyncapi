package com.asyncapi.v2._6_0.model

import com.asyncapi.schemas.asyncapi.Reference
import com.asyncapi.v2.SerDeTest
import com.asyncapi.v2._6_0.model.channel.ChannelItemTest
import com.asyncapi.v2._6_0.model.component.ComponentsTest
import com.asyncapi.v2._6_0.model.info.InfoTest
import com.asyncapi.v2._6_0.model.server.ServerTest

/**
 * @author Pavel Bodiachevskii
 */
class AsyncAPITest: SerDeTest<AsyncAPI>() {

    override fun objectClass() = AsyncAPI::class.java

    override fun baseObjectJson() = "/json/v2/2.6.0/model/asyncapi.json"

    override fun extendedObjectJson() = "/json/v2/2.6.0/model/asyncapi - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v2/2.6.0/model/asyncapi - wrongly extended.json"

    override fun build(): AsyncAPI {
        return AsyncAPI(
                "2.6.0",
                "https://www.asyncapi.com",
                InfoTest().build(),
                mapOf(
                        Pair("stage", ServerTest().build()),
                        Pair("stage-2",
                            Reference("#/components/servers/stage-2")
                        )
                ),
                "application/json",
                mapOf(
                        Pair("messages", ChannelItemTest().build())
                ),
                ComponentsTest().build(),
                listOf(
                        TagTest().build()
                ),
                ExternalDocumentationTest().build()
        )
    }

}
