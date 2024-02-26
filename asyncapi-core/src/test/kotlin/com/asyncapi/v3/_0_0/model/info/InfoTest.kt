package com.asyncapi.v3._0_0.model.info

import com.asyncapi.v3.Reference
import com.asyncapi.v3.SerDeTest
import com.asyncapi.v3._0_0.model.ExternalDocumentationTest
import com.asyncapi.v3._0_0.model.TagTest

/**
 * @author Pavel Bodiachevskii
 */
class InfoTest: SerDeTest<Info>() {

    override fun objectClass() = Info::class.java

    override fun baseObjectJson() = "/json/v3/3.0.0/model/info/info.json"

    override fun extendedObjectJson() = "/json/v3/3.0.0/model/info/info - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v3/3.0.0/model/info/info - wrongly extended.json"

    override fun build(): Info {
        return Info(
                "AsyncApi sample",
                "2.0",
                "short description",
                "https://www.asyncapi.com/about/",
                ContactTest().build(),
                LicenseTest().build(),
                listOf(TagTest().build()),
                ExternalDocumentationTest().build(),
        )
    }

}

class InfoTestWithReferences: SerDeTest<Info>() {

    override fun objectClass() = Info::class.java

    override fun baseObjectJson() = "/json/v3/3.0.0/model/info/info with reference.json"

    override fun extendedObjectJson() = "/json/v3/3.0.0/model/info/info with reference - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v3/3.0.0/model/info/info with reference - wrongly extended.json"

    override fun build(): Info {
        return Info(
                "AsyncApi sample",
                "2.0",
                "short description",
                "https://www.asyncapi.com/about/",
                ContactTest().build(),
                LicenseTest().build(),
                listOf(Reference("#/components/schemas/tag")),
                Reference("#/components/schemas/externalDoc"),
        )
    }

}