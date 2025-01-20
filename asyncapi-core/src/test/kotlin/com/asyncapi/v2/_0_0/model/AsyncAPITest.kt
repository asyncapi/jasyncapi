package com.asyncapi.v2._0_0.model

import com.asyncapi.v2.SerDeTest
import com.asyncapi.v2._0_0.model.channel.ChannelItemTest
import com.asyncapi.v2._0_0.model.component.ComponentsTest
import com.asyncapi.v2._0_0.model.info.InfoTest
import com.asyncapi.v2._0_0.model.server.ServerTest

/**
 * @author Pavel Bodiachevskii
 */
class AsyncAPITest: SerDeTest<AsyncAPI>() {

    override fun objectClass() = AsyncAPI::class.java

    override fun baseObjectJson() = "/json/v2/2.0.0/model/asyncapi.json"

    override fun extendedObjectJson() = "/json/v2/2.0.0/model/asyncapi - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v2/2.0.0/model/asyncapi - wrongly extended.json"

    override fun build(): AsyncAPI {
        return AsyncAPI(
                "2.0.0",
                "https://www.asyncapi.com",
                "application/json",
                InfoTest().build(),
                mapOf(
                        Pair("stage", ServerTest().build())
                ),
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
