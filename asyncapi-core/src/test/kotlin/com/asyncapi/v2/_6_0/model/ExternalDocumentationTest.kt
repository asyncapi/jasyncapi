package com.asyncapi.v2._6_0.model

import com.asyncapi.v2.SerDeTest

/**
 * @author Pavel Bodiachevskii
 */
class ExternalDocumentationTest: SerDeTest<ExternalDocumentation>() {

    override fun objectClass() = ExternalDocumentation::class.java

    override fun baseObjectJson() = "/json/2.6.0/model/externalDocumentation.json"

    override fun extendedObjectJson() = "/json/2.6.0/model/externalDocumentation - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/2.6.0/model/externalDocumentation - wrongly extended.json"

    override fun build(): ExternalDocumentation {
        return ExternalDocumentation(
                "Find more info here",
                "https://example.com"
        )
    }

}
