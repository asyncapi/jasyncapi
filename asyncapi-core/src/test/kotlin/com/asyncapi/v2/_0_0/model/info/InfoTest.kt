package com.asyncapi.v2._0_0.model.info

import com.asyncapi.v2.SerDeTest

/**
 * @author Pavel Bodiachevskii
 */
class InfoTest: SerDeTest<Info>() {

    override fun objectClass() = Info::class.java

    override fun baseObjectJson() = "/json/2.0.0/model/info/info.json"

    override fun extendedObjectJson() = "/json/2.0.0/model/info/info - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/2.0.0/model/info/info - wrongly extended.json"

    override fun build(): Info {
        return Info(
                "AsyncApi sample",
                "2.0",
                "short description",
                "https://www.asyncapi.com/about/",
                ContactTest().build(),
                LicenseTest().build()
        )
    }

}
